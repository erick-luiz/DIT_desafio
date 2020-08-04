package com.deliverit.desafio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;

import com.deliverit.desafio.calculator.InvoiceCalculator;
import com.deliverit.desafio.model.dto.InvoiceDtoReq;

@Entity
@Table(name = "INVOICE")
public class Invoice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "INVOICE_ID", nullable = false)
	private long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "AMOUNT", nullable = false)
	private Double amount;

	@Column(name = "DUE_DATE", nullable = false)
	private LocalDate dueDate;

	@Column(name = "PAYMENT_DATE", nullable = false)
	private LocalDate paymentDate;
	
	@Column(name = "LATE_DAYS", nullable = false)
	private int lateDays;
	
	@Column(name = "RATE", nullable = false)
	private double rate;

	public static Invoice from(@Valid InvoiceDtoReq invoiceDto) {
		return InvoiceCalculator.processRate(new ModelMapper().map(invoiceDto, Invoice.class));
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public boolean isDue() {
		return paymentDate.isAfter(dueDate);
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public void setLateDays(int lateDays) {
		this.lateDays = lateDays;
	}

	public int getLateDays() {
		return this.lateDays;
	}
	
	public double getRate() {
		return this.rate;
	}
}
