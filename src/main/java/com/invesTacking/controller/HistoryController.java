package com.invesTacking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.invesTacking.model.InvestmentTransaction;
import com.invesTacking.model.Profit;
import com.invesTacking.service.HistoryService;

@Controller
public class HistoryController {
	
	@Autowired
	HistoryService service;

	@RequestMapping("/history")
	public ModelAndView transactionHistory(Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int session_User_Id = (int) session.getAttribute("invesUserSession");
		List<InvestmentTransaction> investmentTxnList = service.getInvesTxns(session_User_Id);
		List<Profit> profitList = service.getAllProft(session_User_Id);
		mv.addObject("profitList", profitList);
		mv.addObject("investmentTxnList", investmentTxnList);
		mv.setViewName("history");
		return mv;
	}
}
