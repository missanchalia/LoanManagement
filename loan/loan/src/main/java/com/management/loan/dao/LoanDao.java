package com.management.loan.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.loan.Loan;

@Repository
public interface LoanDao extends JpaRepository<Loan, Integer> {

	List<Loan> findByloanId(int loanId);

	List<Loan> findByCustomerId(String customerId);

	List<Loan> findByLenderId(String lenderId);

	@Query("SELECT SUM(l.remainingAmount) AS totalRemainingAmount, "
			+ "SUM(l.interestPercent) AS totalInterest,SUM(l.penaltyInterest) AS totalPenalty FROM Loan l "
			+ "WHERE l.lenderId = :lenderId GROUP BY l.lenderId")
	Map<String, Double> aggregateLoansByLender(String lenderId);

	@Query("SELECT SUM(l.remainingAmount) AS totalRemainingAmount, "
			+ "SUM(l.interestPercent) AS totalInterest,SUM(l.penaltyInterest) AS totalPenalty FROM Loan l "
			+ "WHERE l.customerId = :customerId GROUP BY l.customerId")
	Map<String, Double> aggregateLoansByCustomer(String customerId);

	@Query("SELECT SUM(l.remainingAmount) AS totalRemainingAmount, "
			+ "SUM(l.interestPercent) AS totalInterest,SUM(l.penaltyInterest) AS totalPenalty FROM Loan l "
			+ "WHERE l.interestPercent = :interestPercent GROUP BY l.interestPercent")
	Map<String, Double> aggregateLoansByInterest(Double interestPercent);

}
