package com.loans.apploans.service;

import com.loans.apploans.dto.LoanDto;
import com.loans.apploans.repository.LoanRepository;
import com.loans.apploans.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    public Flux<LoanDto> getLoans(){
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Flux<LoanDto> getLoandsByCustomerId(String customerId)
    {
        return repository.findAllByCustomerId(customerId);
    }

    public Mono<LoanDto> getLoan(String id){
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<LoanDto> saveLoan(Mono<LoanDto> loanDtoMono){
        return loanDtoMono.map(AppUtils::dtoToentity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<LoanDto> updateLoan(Mono<LoanDto> loanDtoMono, String id){
        return repository.findById(id)
                .flatMap(c->loanDtoMono.map(AppUtils::dtoToentity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteLoan(String id){
        return repository.deleteById(id);
    }
}