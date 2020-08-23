package com.practice.assignement.promotiondemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.assignement.promotiondemo.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

}
