package com.deliverit.desafio.calculator;

import java.time.Period;
import java.util.Arrays;

import com.deliverit.desafio.model.Invoice;

public final class InvoiceCalculator {
	
	private InvoiceCalculator() {};
	
	public static Invoice processRate(Invoice invoice) {
		if(invoice.isDue()) {
			var lateDays = getLateDays(invoice);
			InvoiceCalculatorRole calculator = getCalculator(lateDays);
			invoice.setRate(calculator.getRate(lateDays));
			invoice.setLateDays(lateDays);
			return invoice; 
		}

		invoice.setRate(0);
		invoice.setLateDays(0);
		return invoice;
	}
	
	private static int getLateDays(Invoice invoice) {
		return Period.between(invoice.getDueDate(), invoice.getPaymentDate()).getDays();
	}

	private static InvoiceCalculatorRole getCalculator(int days) {

		var roles = Arrays.asList(InvoiceCalculatorRole.values());
		roles.sort((r1, r2) ->  r1.getDays() - r2.getDays());
		InvoiceCalculatorRole result = InvoiceCalculatorRole.DEFAULT;

		for(InvoiceCalculatorRole role: roles) {
			if(days > role.getDays()) {
				result = role;
			}
		}
		return result;
	}
}
