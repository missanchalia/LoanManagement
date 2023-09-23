package com.management.loan;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Loan {

	// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
	

	public Loan() {
		super();
	}

	public Loan(int loanId, String customerId, String lenderId, double amount, double remainingAmount,
			double penaltyInterest, double interestPercent, Date paymentDate, Date dueDate) {
		super();
		this.loanId = loanId;
		this.customerId = customerId;
		this.lenderId = lenderId;
		this.amount = amount;
		this.remainingAmount = remainingAmount;
		this.penaltyInterest = penaltyInterest;
		this.interestPercent = interestPercent;
		this.paymentDate = paymentDate;
		this.dueDate = dueDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;
	private String customerId;
	private String lenderId;
	private double amount;
	private double remainingAmount;
	private double penaltyInterest;
	private double interestPercent;
	private Date paymentDate;
	private Date dueDate;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getLenderId() {
		return lenderId;
	}

	public void setLenderId(String lenderId) {
		this.lenderId = lenderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public double getPenaltyInterest() {
		return penaltyInterest;
	}

	public void setPenaltyInterest(double penaltyInterest) {
		this.penaltyInterest = penaltyInterest;
	}

	public double getInterestPercent() {
		return interestPercent;
	}

	public void setInterestPercent(double interestPercent) {
		this.interestPercent = interestPercent;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}