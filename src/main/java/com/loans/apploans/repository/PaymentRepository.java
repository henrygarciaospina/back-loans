package com.loans.apploans.repository;

import com.loans.apploans.dto.LoanDto;
import com.loans.apploans.dto.PaymentDto;
import com.loans.apploans.entity.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PaymentRepository  extends ReactiveMongoRepository<Payment, String> {
    Flux<PaymentDto> findAllByLoanId(String loanId);
}