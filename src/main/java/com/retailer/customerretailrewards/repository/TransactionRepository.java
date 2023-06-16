package com.retailer.customerretailrewards.repository;

import com.retailer.customerretailrewards.model.CustomerTransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface TransactionRepository extends JpaRepository<CustomerTransactionDetails, Long> {
    List<CustomerTransactionDetails> findByCustomerId(Long customerId);
}
