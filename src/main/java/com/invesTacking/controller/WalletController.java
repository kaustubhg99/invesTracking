package com.invesTacking.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.invesTacking.model.Wallet;
import com.invesTacking.service.WalletService;


@Controller
public class WalletController {
	
	@Autowired
	WalletService service;

	@RequestMapping("/wallet")
	public ModelAndView display(Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<Wallet> walletsTransactionList = service.getWalletTxns((int) session.getAttribute("invesUserSession"));
		mv.addObject("walletsTransactionList", walletsTransactionList);
		mv.addObject("walletTxnObj", new Wallet());
		mv.setViewName("wallet");
		return mv;
	}
	
	@RequestMapping("/addBalance")
	public ModelAndView addBalanceToWallet(@ModelAttribute("walletTxnObj") Wallet wallet, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Add balance : "+wallet.getWallet_Amount());
		int session_User_Id = (int) session.getAttribute("invesUserSession");
		List<Wallet> walletsTransactionList = service.getWalletTxns(session_User_Id);
		
		double amount = (walletsTransactionList.get(0).getWallet_Balance())+wallet.getWallet_Amount();
		String sys_Date = getSystemTIme();
		wallet.setUser_Id(session_User_Id);
		wallet.setWallet_action("deposit");
		wallet.setWallet_Balance(amount);
		wallet.setWallet_date(sys_Date);
		service.updateWalletBalance(wallet);
		walletsTransactionList = service.getWalletTxns(session_User_Id);
		mv.addObject("walletsTransactionList", walletsTransactionList);
		mv.addObject("walletTxnObj", new Wallet());
		mv.setViewName("wallet");
		return mv;
	}
	
	@RequestMapping("/withdrawBalance")
	public ModelAndView withdrawBalanceFromWallet(@ModelAttribute("walletTxnObj") Wallet wallet, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int session_User_Id = (int) session.getAttribute("invesUserSession");
		System.out.println("Withdraw balance : "+wallet.getWallet_Amount());
		List<Wallet> walletsTransactionList = service.getWalletTxns(session_User_Id);
		double amount = (walletsTransactionList.get(0).getWallet_Balance())-wallet.getWallet_Amount();
		String sys_Date = getSystemTIme();
		wallet.setUser_Id(session_User_Id);
		wallet.setWallet_action("withdraw");
		wallet.setWallet_Balance(amount);
		wallet.setWallet_date(sys_Date);
		service.updateWalletBalance(wallet);
		walletsTransactionList = service.getWalletTxns(session_User_Id);
		
		mv.addObject("walletsTransactionList", walletsTransactionList);
		mv.addObject("walletTxnObj", new Wallet());
		mv.setViewName("wallet");
		return mv;
	}
	
	private String getSystemTIme() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		
		return dtf.format(now);
	}
}
