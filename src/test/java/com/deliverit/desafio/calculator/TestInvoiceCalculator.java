package com.deliverit.desafio.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.deliverit.desafio.model.Invoice;

public class TestInvoiceCalculator {

	
	@Test
	public void canCalculeteARate() {

		Invoice invoice = new Invoice();
		invoice.setDueDate(LocalDate.of(2020,01,05));
		invoice.setPaymentDate(LocalDate.of(2020,01,10));
		invoice.setAmount(20.00);
		
		assertThat(invoice.isDue()).isTrue();

		InvoiceCalculator.processRate(invoice);
		
		assertThat(invoice.getLateDays()).isEqualTo(5);
		assertThat(invoice.getRate()).isEqualTo(0.04);
	}
	
	@Test
	public void canNotCalculeteARate() {

		Invoice invoice = new Invoice();
		invoice.setDueDate(LocalDate.of(2020,01,10));
		invoice.setPaymentDate(LocalDate.of(2020,01,10));
		invoice.setAmount(20.00);
		
		assertThat(invoice.isDue()).isFalse();

		InvoiceCalculator.processRate(invoice);
		
		assertThat(invoice.getLateDays()).isEqualTo(0);
		assertThat(invoice.getRate()).isEqualTo(0);
	}
}
