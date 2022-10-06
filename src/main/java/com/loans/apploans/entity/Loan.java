package com.loans.apploans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "loans")
/* Préstamo */
public class Loan {
        @Id
        private String id;
        private String nameCredit;
        private String customerId;
        private double amountLoaned;
        private double currentBalance;
        private boolean loanCancelled;
        @CreatedDate
        private LocalDate loanDate;
}