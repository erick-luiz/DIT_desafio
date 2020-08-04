package com.deliverit.desafio.model.dto;

import org.modelmapper.ModelMapper;

import com.deliverit.desafio.model.Invoice;

public class InvoiceDtoRes extends InvoiceDto {

	private double computedAmount;
	private int lateDays;
	
	public static InvoiceDtoRes from(Invoice invoice) {

		return new ModelMapper().map(invoice, InvoiceDtoRes.class)
		.setLateDays(invoice.getLateDays())
		.setComputedAmount(invoice.getAmount() + invoice.getLateDays() * (invoice.getRate() + 1));
	}
	
	InvoiceDtoRes setComputedAmount(double computedAmount){
		this.computedAmount = computedAmount;
		return this;
	}

	InvoiceDtoRes setLateDays(int lateDays){
		this.lateDays = lateDays;
		return this;
	}
	
	public int getLateDays() {
		return lateDays;
	}
	
	public double getComputedAmount() {
		return computedAmount;
	}

}