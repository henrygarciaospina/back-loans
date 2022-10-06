package com.loans.apploans.repository;

import com.loans.apploans.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends ReactiveMongoRepository<Customer, String> {
}
