package com.loans.apploans.controller;

import com.loans.apploans.dto.PaymentDto;
import com.loans.apploans.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")

public class PaymentController {
    @Autowired
    private PaymentService service;
    Logger logger = LoggerFactory.getLogger(PaymentService.class) ;
    @GetMapping
    public ResponseEntity<Flux<?>> getPayments() {
        Flux<?> payments = service.getPayments();
        return ResponseEntity.ok().body(payments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mono<?>> getPayment(@PathVariable String id){
        Mono<?>payment= service.getPayment(id);
        return ResponseEntity.ok().body(payment);
    }
    @GetMapping("/loan/{loanId}")
    public ResponseEntity<Flux<?>> getPaymentsByLoanId(@PathVariable String loanId){
        Flux<?>payments= service.getPaymentsByLoanId(loanId);
        return ResponseEntity.ok().body(payments);
    }
    @PostMapping
    public ResponseEntity<Mono<?>> savePayment(@RequestBody  Mono<PaymentDto> paymentDtoMono){
        Mono<?>payment= service.savePayment(paymentDtoMono);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
    @PutMapping("/{id}")
    public Mono<PaymentDto> updatePayment(@RequestBody  Mono<PaymentDto> paymentDtoMono, @PathVariable String id){
        return service.updatePayment(paymentDtoMono, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<?>> deletePayment(@PathVariable String id)
    {
        Mono<?>payment= service.deletePayment(id);
        return ResponseEntity.ok().body(payment);
    }
}