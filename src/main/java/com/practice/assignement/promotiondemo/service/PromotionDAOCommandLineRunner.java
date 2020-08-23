package com.practice.assignement.promotiondemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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

	}

}
