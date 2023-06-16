package com.retailer.customerretailrewards.controller;

import com.retailer.customerretailrewards.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class RewardsController {

   @Autowired
   RewardsService rewardsService;

    @GetMapping("/customers/{customerId}/reward-points")
    public ResponseEntity<Map<String, Integer>> getRewardPointsByCustomerId(@PathVariable("customerId") Long customerId) {

        Map<String, Integer> response = rewardsService.getRewardPointsPerCustomer(customerId);

        return ResponseEntity.ok(response);
    }
}
