package com.decoder.calculatorApp.service;

import org.springframework.stereotype.Service;


@Service
public class CalculatorService {
	public String performCalculation(String operand1, String operand2, String operator) {
		int x = Integer.parseInt(operand1);
		int y = Integer.parseInt(operand2);
		
		int r = 0;
		
		switch(operator) {
			case "+": r = x+y; break;
			case "-": r = x-y; break;
			case "*": r = x*y; break;
			case "/": r = x/y; break;
			default: return "ABC";
		}
		
		return String.valueOf(r);
	}
}
