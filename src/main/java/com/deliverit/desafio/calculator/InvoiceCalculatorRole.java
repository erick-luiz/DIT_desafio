package com.deliverit.desafio.calculator;

enum InvoiceCalculatorRole {
	
	DEFAULT(-1, 0.00, 0.00),
	MIN_RATE(1, 0.02, 0.001), 
	MEDIUM_RATE(3, 0.03, 0.002), 
	MAX_RATE(5, 0.05, 0.003);

	private int days;
	private double rateForDue;
	private double taxForDay;
	
	InvoiceCalculatorRole(int days, double rate, double taxForDay){
		this.days = days;
		this.rateForDue = rate; 
		this.taxForDay = taxForDay;
	}
	
	public double calculate(double value, int lateDays){
		return (1 + rateForDue + lateDays * taxForDay) * value;
	}
	
	public int getDays() {
		return this.days;
	}
	
	public double getRate(int lateDays) {
		return this.rateForDue + lateDays * this.taxForDay;
	}
}
