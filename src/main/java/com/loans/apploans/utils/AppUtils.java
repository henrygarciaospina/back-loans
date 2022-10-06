package com.loans.apploans.utils;

import com.loans.apploans.dto.CustomerDto;
import com.loans.apploans.dto.LoanDto;
import com.loans.apploans.dto.PaymentDto;
import com.loans.apploans.entity.Customer;
import com.loans.apploans.entity.Loan;
import com.loans.apploans.entity.Payment;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static CustomerDto entityToDto(Customer customer) {
        CustomerDto customerDto=new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public static Customer dtoToentity(CustomerDto customerDto) {
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
    public static LoanDto entityToDto(Loan loan) {
        LoanDto loanDto=new LoanDto();
        BeanUtils.copyProperties(loan, loanDto);
        return loanDto;
    }

    public static Loan dtoToentity(LoanDto loanDto) {
        Loan loan=new Loan();
        BeanUtils.copyProperties(loanDto, loan);
        return loan;
    }

    public static PaymentDto entityToDto(Payment payment) {
        PaymentDto paymentDto=new PaymentDto();
        BeanUtils.copyProperties(payment, paymentDto);
        return paymentDto;
    }

    public static Payment dtoToentity(PaymentDto paymentDto) {
        Payment payment=new Payment();
        BeanUtils.copyProperties(paymentDto, payment);
        return payment;
    }
}
