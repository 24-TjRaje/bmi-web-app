package com.raje.bmi_calculator.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BmiResult {

    private Float weight;
    private Float height;
    private Float bmi;
    private String status;

}
