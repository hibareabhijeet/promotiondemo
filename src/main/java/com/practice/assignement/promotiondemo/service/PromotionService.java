package com.practice.assignement.promotiondemo.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.assignement.promotiondemo.model.Promotion;
import com.practice.assignement.promotiondemo.repo.PromotionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PromotionService {

	private static final Logger log = LoggerFactory.getLogger(PromotionService.class);

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

		return applySingleRule(inputMap) + applyHybrideRule(inputMap) + applyRemaining(inputMap);
	}

	private int applySingleRule(Map<Character, Integer> inputMap) {
		int total = 0;
		List<Promotion> list = repo.findAll().stream().filter(p -> p.getType() == 1).collect(Collectors.toList());
		for (Promotion p : list) {
			if (!inputMap.containsKey(p.getSku().charAt(0))) {
				continue;
			}
			while (inputMap.get(p.getSku().charAt(0)) >= p.getQuantity()) {
				log.info("before : {}", inputMap.get(p.getSku().charAt(0)));
				total += p.getDiscount();
				inputMap.put(p.getSku().charAt(0), inputMap.get(p.getSku().charAt(0)) - p.getQuantity());
				log.info(total + " after : {} ", inputMap.get(p.getSku().charAt(0)));
			}
		}
		return total;
	}

	private int applyHybrideRule(Map<Character, Integer> inputMap) {
		int total = 0;
		List<Promotion> list = repo.findAll().stream().filter(p -> p.getType() == 2).collect(Collectors.toList());
		for (Promotion p : list) {
			while (inputMap.containsKey(p.getSku().charAt(0)) && inputMap.get(p.getSku().charAt(0)) >= 1
					&& inputMap.containsKey(p.getSku1().charAt(0)) && inputMap.get(p.getSku1().charAt(0)) >= 1) {
				log.info("before : {}", inputMap.get(p.getSku().charAt(0)), inputMap.get(p.getSku1().charAt(0)));
				
				total += p.getDiscount();
				inputMap.put(p.getSku().charAt(0), inputMap.get(p.getSku().charAt(0)) - 1);
				inputMap.put(p.getSku1().charAt(0), inputMap.get(p.getSku1().charAt(0)) - 1);
				log.info("after : {}", inputMap.get(p.getSku().charAt(0)), inputMap.get(p.getSku1().charAt(0)));
			}
		}
		return total;
	}

	private int applyRemaining(Map<Character, Integer> inputMap) {
		return inputMap.entrySet().stream().mapToInt(v -> v.getValue() * getMap.get(v.getKey())).sum();
	}
}
