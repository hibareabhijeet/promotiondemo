package com.practice.assignement.promotiondemo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromotionServiceTest {

	@Autowired
	private PromotionService service;

	@Test
	void contextLoads() throws Exception {
		assertThat(service).isNotNull();
	}

	@Test
	void calculateTotal_applySingleRule() {
		List<Character> sdu = Arrays.asList('A', 'A', 'A');
//		A,A,A
		int result = service.calculateTotal(sdu);
		assertEquals(130, result);

	}
	
	@Test
	void calculateTotal_applyHybrideRule() {
		List<Character> sdu = Arrays.asList('C','D');
//		C,D
		int result = service.calculateTotal(sdu);
		assertEquals(30, result);
		
	}
	
	@Test
	void calculateTotal_applyRemaining() {
		List<Character> sdu = Arrays.asList('A','B','C');
//		A,B,C
		int result = service.calculateTotal(sdu);
		assertEquals(100, result);
		
	}
	
	@Test
	void calculateTotal_all() {
		List<Character> sdu = Arrays.asList('A','A','A','B','B','B','B','B','C','D');
//		A,A,A,B,B,B,B,B,C,D
		int result = service.calculateTotal(sdu);
		assertEquals(280, result);
		
	}
}
