package com.deliverit.desafio.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.deliverit.desafio.model.Invoice;

public class InvoiceDtoReq extends InvoiceDto {
	
	@NotNull(message = "{invoice.invalid.due.date}")
	private LocalDate dueDate;
	
	public static InvoiceDtoReq from(Invoice invoice) {
		return new ModelMapper().map(invoice, InvoiceDtoReq.class);
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}