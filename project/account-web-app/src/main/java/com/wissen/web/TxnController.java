package com.wissen.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wissen.model.Transaction;
import com.wissen.model.TxnRequest;
import com.wissen.service.TxnService;

@Controller
public class TxnController {
	
	@Autowired
	private TxnService txnService;
	
	@RequestMapping (value = "txn.htm", method = RequestMethod.GET)
	public String getTxnPage() {
		//
		
		return "txn-form";
	}
	
	@RequestMapping (value = "txn.htm", method = RequestMethod.POST)
	public ModelAndView doTxn(@ModelAttribute TxnRequest txnRequest) {
		
		boolean res = txnService.transfer(txnRequest.getFromAccNum(), txnRequest.getToAccNum(), txnRequest.getAmount());
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("txn-status");
		mav.addObject("message", res ? "Transaction Successful" : "Transaction Failed");
		
		return mav;
		
	}
	
	@RequestMapping (value = "stmt.htm", method = RequestMethod.GET)
	public ModelAndView viewStmtBase() {
		
		List<Transaction> transactions = new ArrayList<>();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("transactions", transactions);
		
		mav.setViewName("view-stmt");
		
		return mav;
	}
	
	@RequestMapping (value = "stmt.htm", method = RequestMethod.POST)
	public ModelAndView viewStmtByAccNum(@RequestParam String accNum) {
		
		System.out.println("Hello threre");
		
		List<Transaction> transactions = txnService.getTransactionByAccNum(accNum);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("transactions", transactions);
		
		mav.setViewName("view-stmt");
		
		return mav;
	}
	
}
