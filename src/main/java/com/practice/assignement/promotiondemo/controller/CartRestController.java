package com.practice.assignement.promotiondemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.assignement.promotiondemo.service.PromotionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/")
public class CartRestController {
	private static final Logger log = LoggerFactory.getLogger(CartRestController.class);
	
	@Autowired
	PromotionService ps;
	
	@GetMapping(params = "sdu", path="/cart")
	public ResponseEntity<Object> getTotal(@RequestParam List<Character> sdu) {
		log.info("getTotal :{}",sdu );
		sdu.stream().forEach(System.out::println);
//		ps.calculateTotal(sdu)
		return new ResponseEntity<Object>(ps.calculateTotal(sdu),HttpStatus.OK);
	}
}

