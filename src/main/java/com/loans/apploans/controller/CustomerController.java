package com.loans.apploans.controller;

import com.loans.apploans.dto.CustomerDto;
import com.loans.apploans.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")

public class CustomerController {
    @Autowired
    private CustomerService service;
    @GetMapping
    public ResponseEntity<Flux<?>> getCustomers(){
        Flux<?>customers= service.getCustomers();
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<?>> getCustomer(@PathVariable String id){
        Mono<?>customer= service.getCustomer(id);
        return ResponseEntity.ok().body(customer);
    }
    @PostMapping
    public ResponseEntity<Mono<?>> saveCustomer(@RequestBody Mono<CustomerDto> customerDtoMono){
        Mono<?>customer= service.saveCustomer(customerDtoMono);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<?>>  updateCustomer(@RequestBody Mono<CustomerDto> customerDtoMono, @PathVariable String id){
        Mono<?>customer= service.updateCustomer(customerDtoMono, id);
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<?>> deleteCustomer(@PathVariable String id)
    {
        Mono<?>customer= service.deleteCustomer(id);
        return ResponseEntity.ok().body(customer);

    }
}