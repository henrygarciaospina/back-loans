package com.loans.apploans.repository;

import com.loans.apploans.dto.LoanDto;
import com.loans.apploans.entity.Loan;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface LoanRepository  extends ReactiveMongoRepository<Loan, String> {
    Flux<LoanDto> findAllByCustomerId(String customerId);

}