package com.invesTacking.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.invesTacking.model.Profit;
import com.invesTacking.model.UserDetails;
import com.invesTacking.service.InvestmentService;
import com.invesTacking.service.UserService;

@Controller
public class InvestmentController {
	

	@Autowired
	UserService service;

	@Autowired
	InvestmentService investmentService;
	
	@RequestMapping("/addInves")
	public ModelAndView addNewCrypto(@ModelAttribute("invesObj") UserDetails inves, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int session_User_Id = (int) session.getAttribute("invesUserSession");
		List<UserDetails> userDetailsList = service.getUserDetailsById(session_User_Id);
		
		double wallet_Balance = userDetailsList.get(0).getAcc_Wallet()-(inves.getInves_Market_Cap()*inves.getInves_Holding());
		double investments = userDetailsList.get(0).getAcc_Invested()+(inves.getInves_Market_Cap()*inves.getInves_Holding());
		
		inves.setInves_Date(getSystemTIme());
		inves.setInves_Amount(inves.getInves_Market_Cap()*inves.getInves_Holding());
		inves.setInve_Buying_Amt(inves.getInves_Market_Cap()*inves.getInves_Holding());
		
		System.out.println("===========================");
		inves.setInves_Action("deposit");
		System.out.println("===============================");
		inves.setUser_Id(session_User_Id);
		inves.setAcc_Wallet(wallet_Balance);
		inves.setAcc_Invested(investments);
		investmentService.addNewInves(inves);
		
		userDetailsList = service.getUserDetailsById(session_User_Id);
		mv.addObject("userDetailsList", userDetailsList);
		mv.addObject("userLoginObj",new UserDetails());
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/getInves")
	public ModelAndView showInvestmentDetails(@ModelAttribute("invesObj") UserDetails inves, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int session_User_Id = (int) session.getAttribute("invesUserSession");
		System.out.println("Buying :"+inves.getInves_Name());
		System.out.println(inves.getInves_Name());
		System.out.println(inves.getInves_Market_Cap());
		System.out.println(inves.getInves_Holding());
		System.out.println(inves.getInves_Amount());
		List<UserDetails> userDetailsList = service.getUserDetailsById(session_User_Id);
		
		double amount=0.0;
		double holdings=0.0;
		double buyingAmt = 0.0;
		
		for(UserDetails details : userDetailsList) {
			if(details.getInves_Name().equals(inves.getInves_Name())) {
				amount = (details.getInves_Holding()+inves.getInves_Holding())*inves.getInves_Market_Cap();
				holdings = details.getInves_Holding()+inves.getInves_Holding();
				buyingAmt = details.getInve_Buying_Amt();
				break;
			}
		}
		
		double newBuyingAmt = inves.getInves_Market_Cap()*inves.getInves_Holding();
		double amt = buyingAmt+newBuyingAmt;
		
		double balance = (userDetailsList.get(0).getAcc_Wallet())-(inves.getInves_Market_Cap()*inves.getInves_Holding());
		double investment = (userDetailsList.get(0).getAcc_Invested())+(inves.getInves_Market_Cap()*inves.getInves_Holding());
		double profit = (userDetailsList.get(0).getAcc_Profit());
		inves.setUser_Id(session_User_Id);
		inves.setInves_Amount(round(amount, 2));
		inves.setInves_Holding(holdings);
		inves.setAcc_Wallet(round(balance, 2));
		inves.setAcc_Invested(round(investment, 2));
		inves.setAcc_Profit(profit);
		inves.setInve_Buying_Amt(round(amt, 2));
		inves.setInves_Action("deposite");
		inves.setInves_Date(getSystemTIme());
		
		
		investmentService.updateInvestmentBalance(inves);
		userDetailsList = service.getUserDetailsById(session_User_Id);
		mv.addObject("userDetailsList", userDetailsList);
		mv.addObject("userLoginObj",new UserDetails());
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/sellInves")
	public ModelAndView sellInvestment(@ModelAttribute("invesObj") UserDetails inves, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int session_User_Id = (int) session.getAttribute("invesUserSession");
		System.out.println("Selling : "+inves.getInves_Name());
		System.out.println(inves.getInves_Name());
		System.out.println(inves.getInves_Market_Cap());
		System.out.println(inves.getInves_Holding());
		System.out.println(inves.getInves_Amount());
		List<UserDetails> userDetailsList = service.getUserDetailsById(session_User_Id);
		
		
		double amount=0.0;
		double holdings=0.0;
		double oldHolding = 0.0;
		double buyingAmount = 0.0;
		double oldProfit = 0.0;
		for(UserDetails details : userDetailsList) {
			if(details.getInves_Name().equals(inves.getInves_Name())) {
				amount = (details.getInves_Holding()-inves.getInves_Holding())*inves.getInves_Market_Cap();
				oldHolding = details.getInves_Holding();
				holdings = details.getInves_Holding()-inves.getInves_Holding();
				buyingAmount = details.getInve_Buying_Amt();
				oldProfit = details.getAcc_Profit();
				break;
			}
		}
		
		
		double balance = (userDetailsList.get(0).getAcc_Wallet())+(inves.getInves_Market_Cap()*inves.getInves_Holding());
		double profit = 0.0;
		System.out.println("buying amount== >  "+buyingAmount);
		double someAmount = (buyingAmount / oldHolding) * inves.getInves_Holding();
				profit = oldProfit+(inves.getInves_Market_Cap() * inves.getInves_Holding()) - someAmount;
		System.out.println("some amount== >  "+someAmount);	
		double newBuyingAmount = buyingAmount - someAmount;
		double investment = (userDetailsList.get(0).getAcc_Invested())-newBuyingAmount;
		
		
		 System.out.println("==============> : "+profit);
		 updateProft(inves.getInves_Name(), round(profit,2), session_User_Id);
		inves.setUser_Id(session_User_Id);
		inves.setInves_Amount(round(amount,2));
		inves.setInves_Holding(holdings);
		inves.setAcc_Wallet(round(balance, 2));
		inves.setAcc_Invested(round(investment, 2));
		inves.setAcc_Profit(round(profit,2));
		inves.setInves_Action("withdraw");
		inves.setInves_Date(getSystemTIme());
		inves.setInve_Buying_Amt(round(newBuyingAmount, 2));
		
		
		investmentService.updateInvestmentBalance(inves);
		userDetailsList = service.getUserDetailsById(session_User_Id);
		
		mv.addObject("userDetailsList", userDetailsList);
		mv.addObject("userLoginObj",new UserDetails());
		mv.setViewName("home");
		return mv;
	}
	
	@ModelAttribute("invesMap")
	public Map<Integer, String> investmentsList(){
		return investmentService.getInvesMap();
	}
	
	private void updateProft(String profit_Name, double amount, int user_Id) {
		Profit profit = new Profit(profit_Name, amount, user_Id);
		
		Profit existingProfit = investmentService.checkProfitName(profit_Name, user_Id);
		if(existingProfit==null) {
			investmentService.addProfit(profit);
		}else {
			investmentService.updateProfit(profit);
		}
	}
	
	private String getSystemTIme() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		
		return dtf.format(now);
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
}
