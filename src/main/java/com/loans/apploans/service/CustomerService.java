package com.loans.apploans.service;

import com.loans.apploans.dto.CustomerDto;
import com.loans.apploans.repository.CustomerRepository;
import com.loans.apploans.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Flux<CustomerDto> getCustomers(){
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<CustomerDto> getCustomer(String id){
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<CustomerDto> saveCustomer(Mono<CustomerDto> customerDtoMono){
        return customerDtoMono.map(AppUtils::dtoToentity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<CustomerDto> updateCustomer(Mono<CustomerDto> customerDtoMono, String id){
        return repository.findById(id)
                .flatMap(c->customerDtoMono.map(AppUtils::dtoToentity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteCustomer(String id){
        return repository.deleteById(id);
    }
}