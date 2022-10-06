package com.loans.apploans.controller;

import com.loans.apploans.dto.CustomerDto;
import com.loans.apploans.dto.LoanDto;
import com.loans.apploans.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin("*")

public class LoanController {
    @Autowired
    private LoanService service;

    @GetMapping
    public ResponseEntity<Flux<?>> getLoans() {
        Flux<?> loans = service.getLoans();
        return ResponseEntity.ok().body(loans);
    }
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Flux<?>> getLoandsByCustomerId(@PathVariable String customerId){
        Flux<?>loans= service.getLoandsByCustomerId(customerId);
        return ResponseEntity.ok().body(loans);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mono<?>> getLoan(@PathVariable String id){
        Mono<?>loan= service.getLoan(id);
        return ResponseEntity.ok().body(loan);
    }
    @PostMapping
    public ResponseEntity<Mono<?>> saveLoan(@RequestBody  Mono<LoanDto> loanDtoMono){
        Mono<?>loan= service.saveLoan(loanDtoMono);
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);
    }
    @PutMapping("/{id}")
    public Mono<LoanDto> updateLoan(@RequestBody  Mono<LoanDto> loanDtoMono, @PathVariable String id){
        return service.updateLoan(loanDtoMono, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<?>> deleteLoan(@PathVariable String id)
    {
        Mono<?>loan= service.deleteLoan(id);
        return ResponseEntity.ok().body(loan);
    }
}