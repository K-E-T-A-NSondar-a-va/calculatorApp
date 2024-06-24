package com.decoder.calculatorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.decoder.calculatorApp.exception.OperatorException;
import com.decoder.calculatorApp.service.CalculatorService;

@ControllerAdvice
@RestController
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;
	
	@GetMapping("/calculator")
	public ModelAndView showCalcForm() {
		ModelAndView mv = new ModelAndView("calc");
		return mv;
	}
	
	@PostMapping("/calculate")
	public ModelAndView showCalResultPage(@RequestParam("operand1") String s1, @RequestParam("operand2") String s2, @RequestParam("operator") String s3) {
		String result = calculatorService.performCalculation(s1, s2, s3);
		
		if(result.equals("ABC"))
			throw new OperatorException("Entered wrong arithmatic operator");
		
		ModelAndView mv = new ModelAndView("calcResult");
		mv.addObject("output", result);
		return mv;
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmaticException(ArithmeticException exception) {
		ModelAndView mv = new ModelAndView("errorPage");
		String message = "Divide by zero not possible";
		mv.addObject("errorMessage",message);
		return mv;
	}
	
	@ExceptionHandler(OperatorException.class)
	public ModelAndView handleArithmaticException(OperatorException exception) {
		ModelAndView mv = new ModelAndView("errorPage");
		String message = exception.getMessage();
		mv.addObject("errorMessage",message);
		return mv;
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleNumberFormatException(NumberFormatException exception) {
		ModelAndView mv = new ModelAndView("errorPage");
		String message = "Entered wrong number";
		mv.addObject("errorMessage",message);
		return mv;
	}
}
