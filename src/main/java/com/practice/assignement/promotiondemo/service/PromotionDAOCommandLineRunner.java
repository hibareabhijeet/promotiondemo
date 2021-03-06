package com.practice.assignement.promotiondemo.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.practice.assignement.promotiondemo.model.Promotion;
import com.practice.assignement.promotiondemo.repo.PromotionRepository;



@Component
public class PromotionDAOCommandLineRunner implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(PromotionDAOCommandLineRunner.class);
	
	@Autowired
	PromotionRepository ps;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ps.save(new Promotion(1,"A",3,130));
		log.info("3 of A's for 130 created");
		ps.save(new Promotion(1,"B",2,45));
		log.info("2 of B's for 45 created");
		ps.save(new Promotion(2,"C","D",30));
		log.info("C & D for 30 created");
	}
	
	@Bean
	public Map<Character, Integer> getMap(){
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 50);
		map.put('B', 30);
		map.put('C', 20);
		map.put('D', 15);
		return Collections.unmodifiableMap(map);
	}

}
