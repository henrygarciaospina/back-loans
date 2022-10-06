package com.loans.apploans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

 public class LoanDto {
    private String id;
    private String nameCredit;
    private String customerId;
    private double amountLoaned;
    private double currentBalance;
    private boolean loanCancelled;
    private LocalDate loanDate;
}
