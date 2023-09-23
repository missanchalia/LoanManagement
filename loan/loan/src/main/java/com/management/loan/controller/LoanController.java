package com.management.loan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.loan.Loan;
import com.management.loan.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

	@Autowired
	LoanService loanService;

	@GetMapping
	public ResponseEntity<List<Loan>> getAllLoan() {
		return loanService.getAllLoan();
	}

	@PostMapping("/add")
	public ResponseEntity<String> addLoan(@RequestBody Loan loan) {
		return loanService.addLoan(loan);
	}

	@GetMapping("/{loanId}")
	public ResponseEntity<List<Loan>> getLoanById(@PathVariable int loanId) {
		return loanService.getLoanById(loanId);
	}

	@GetMapping("/customerId/{customerId}")
	public ResponseEntity<List<Loan>> getCustomerById(@PathVariable String customerId) {
		return loanService.getCustomerById(customerId);
	}

	@GetMapping("/lenderId/{lenderId}")
	public ResponseEntity<List<Loan>> getLenderById(@PathVariable String lenderId) {
		return loanService.getLenderById(lenderId);
	}

	@GetMapping("/aggregate/lender")
	public ResponseEntity<Map<String, Double>> aggregateLoansByLender(@RequestParam String lenderId) {
		return loanService.aggregateLoansByLender(lenderId);
	}

	@GetMapping("/aggregate/customer")
	public ResponseEntity<Map<String, Double>> aggregateLoansByCustomer(@RequestParam String customerId) {
		return loanService.aggregateLoansByCustomer(customerId);
	}

	@GetMapping("/aggregate/interest")
	public ResponseEntity<Map<String, Double>> aggregateLoansByInterest(@RequestParam Double interestPercent) {
		return loanService.aggregateLoansByInterest(interestPercent);
	}

}