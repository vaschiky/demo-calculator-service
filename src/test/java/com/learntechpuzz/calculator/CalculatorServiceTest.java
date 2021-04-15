package com.learntechpuzz.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.learntechpuzz.calculator.service.CalculatorService;

@SpringBootTest
class CalculatorServiceTest {

	@Autowired
	CalculatorService calculatorService;

	@Test
	public void testAdd() {
		assertThat(calculatorService.add(1, 2)).isEqualTo(4);
	}

}
