package com.learntechpuzz.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learntechpuzz.calculator.service.CalculatorService;

@RestController
public class CalculatorController {

	@Autowired
	CalculatorService calculatorService;

	@GetMapping("/add")
	public int sum(@RequestParam(value = "number1", required = true) int number1,
			@RequestParam(value = "number2", required = true) int number2) {
		return calculatorService.add(number1, number2);
	}
}
