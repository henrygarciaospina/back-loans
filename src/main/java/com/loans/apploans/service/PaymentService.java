package com.loans.apploans.service;

import com.loans.apploans.dto.LoanDto;
import com.loans.apploans.dto.PaymentDto;
import com.loans.apploans.entity.Loan;
import com.loans.apploans.repository.LoanRepository;
import com.loans.apploans.repository.PaymentRepository;
import com.loans.apploans.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;
    @Autowired
    private LoanRepository loanRepository;


    public Flux<PaymentDto> getPayments(){
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<PaymentDto> getPayment(String id){
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<PaymentDto> savePayment(Mono<PaymentDto> paymentDtoMono){

        paymentDtoMono = this.discountPayment(paymentDtoMono);
        return paymentDtoMono.map(AppUtils::dtoToentity)
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<PaymentDto> updatePayment(Mono<PaymentDto> paymentDtoMono, String id){
        return repository.findById(id)
                .flatMap(c->paymentDtoMono.map(AppUtils::dtoToentity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deletePayment(String id){
        return repository.deleteById(id);
    }

    public Mono<PaymentDto>  discountPayment(Mono<PaymentDto> paymentDtoMono) {
        paymentDtoMono.map(p -> {
            loanRepository.findById(p.getLoanId()).map(l -> {
                l.setCurrentBalance(l.getCurrentBalance() - p.getValuePaid());
                loanRepository.save(l);
                return l;
            });
            return p;
        });
        return paymentDtoMono;
    }
    public Flux<PaymentDto> getPaymentsByLoanId(String loanId){ return  repository.findAllByLoanId(loanId);}

}