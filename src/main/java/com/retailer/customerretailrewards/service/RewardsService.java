package com.retailer.customerretailrewards.service;

import com.retailer.customerretailrewards.model.CustomerTransactionDetails;
import com.retailer.customerretailrewards.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardsService {
    @Autowired
    TransactionRepository transactionRepository;
        public Integer calculateRewards(CustomerTransactionDetails transactionDetails) {
            int rewardPoints = 0;
            double amount = transactionDetails.getTransactionAmount();

            if (amount > 100) {
                rewardPoints += 2 * (amount - 100);
            }

            if (amount > 50) {
                rewardPoints += (amount > 100) ? 50 : (amount - 50);
            }

            return rewardPoints;
        }
    public Map<String, Integer> getRewardPointsPerCustomer (Long customerId) {

            List<CustomerTransactionDetails> transactionDetails = transactionRepository.findByCustomerId(customerId);

        Map<String, Integer> rewardPointsPerMonth = new LinkedHashMap<>();
        int totalRewardPoints = 0;

        for (CustomerTransactionDetails transaction : transactionDetails) {
            int rewardPoints = calculateRewards(transaction);
            String month = transaction.getTransactionDate().getMonth().toString();

            rewardPointsPerMonth.put(month, rewardPointsPerMonth.getOrDefault(month, 0) + rewardPoints);

           totalRewardPoints += rewardPoints;
        }

        Map<String, Integer> response = new LinkedHashMap<>();
        response.putAll(rewardPointsPerMonth);
        response.put("total", totalRewardPoints);

        return response;


    }
}
