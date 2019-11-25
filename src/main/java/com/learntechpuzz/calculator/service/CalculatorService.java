package com.learntechpuzz.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int add(int number1, int number2) {
		return number1 + number2;
	}
}
