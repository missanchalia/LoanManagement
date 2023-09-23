package com.management.loan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.management.loan.Loan;
import com.management.loan.dao.LoanDao;

@Service
public class LoanService {

	private static final Logger logger = LoggerFactory.getLogger(LoanService.class);

	@Autowired
	LoanDao loanDao;

	public ResponseEntity<List<Loan>> getAllLoan() {
		try {
			return new ResponseEntity<>(loanDao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addLoan(Loan loan) {
		if (loan.getPaymentDate().after(loan.getDueDate())) {
			// Log an alert message indicating that the loan is overdue
			logger.warn("Loan is overdue. Payment Date: {}, Due Date: {}", loan.getPaymentDate(), loan.getDueDate());
			return new ResponseEntity<>("Payment Date cannot be after Due Date", HttpStatus.NOT_ACCEPTABLE);

		} else {
			try {
				loanDao.save(loan);
				return new ResponseEntity<>("success", HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<List<Loan>> getLoanById(int loanId) {
		try {
			return new ResponseEntity<>(loanDao.findByloanId(loanId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Loan>> getCustomerById(String customerId) {
		try {
			return new ResponseEntity<>(loanDao.findByCustomerId(customerId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Loan>> getLenderById(String lenderId) {
		try {
			return new ResponseEntity<>(loanDao.findByLenderId(lenderId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Map<String, Double>> aggregateLoansByLender(String lenderId) {
		try {
			return new ResponseEntity<>(loanDao.aggregateLoansByLender(lenderId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new HashMap<>(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Map<String, Double>> aggregateLoansByCustomer(String customerId) {
		try {
			return new ResponseEntity<>(loanDao.aggregateLoansByCustomer(customerId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new HashMap<>(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Map<String, Double>> aggregateLoansByInterest(Double interestPercent) {
		try {
			return new ResponseEntity<>(loanDao.aggregateLoansByInterest(interestPercent), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new HashMap<>(), HttpStatus.BAD_REQUEST);
		}
	}

}
