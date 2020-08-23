package com.practice.assignement.promotiondemo.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.assignement.promotiondemo.model.Promotion;
import com.practice.assignement.promotiondemo.repo.PromotionRepository;

@Service
public class PromotionService {

	@Autowired
	private PromotionRepository repo;

	@Autowired
	private Map<Character, Integer> getMap;

	public int calculateTotal(List<Character> sdu) {
		Map<Character, Integer> inputMap = new ConcurrentHashMap<>();
		
		for (Character c : sdu) {
			if (inputMap.containsKey(c)) {
				inputMap.put(c, inputMap.get(c) + 1);
			} else {
				inputMap.put(c, 1);
			}
		}
		
		return applySingleRule(inputMap) ;
	}

	private int applySingleRule(Map<Character, Integer> inputMap) {
		int total = 0;
		List<Promotion> list = repo.findAll().stream().filter(p -> p.getType() == 1).collect(Collectors.toList());
		for (Promotion p : list) {
			if(!inputMap.containsKey(p.getSku().charAt(0))) {
				continue;
			}
			while (inputMap.get(p.getSku().charAt(0)) >= p.getQuantity()) {
				System.out.println("before : " + inputMap.get(p.getSku().charAt(0)));
				total += p.getDiscount();
				inputMap.put(p.getSku().charAt(0), inputMap.get(p.getSku().charAt(0)) - p.getQuantity());
				System.out.println(total + " after : " + inputMap.get(p.getSku().charAt(0)));
			}
		}
		return total;
	}
}
