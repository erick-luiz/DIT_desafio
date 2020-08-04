package com.deliverit.desafio.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public abstract class InvoiceDto {

	@NotBlank(message = "{invoice.invalid.name}")
	private String name; 

	@Min(value = 0, message = "{invoice.invalid.amount}")
	private Double amount;

	@NotNull(message = "{invoice.invalid.payment.date}")
	private LocalDate paymentDate;
	
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

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

}