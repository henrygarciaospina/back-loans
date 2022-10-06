package com.loans.apploans.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PaymentDto {
    private String id;
    private String loanId;
    private double valuePaid;
    private LocalDate paymentDate;
}