package com.example.calculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CalculatorRequestDto {
    @JsonProperty(value = "firstNumber", required = true)
    private BigIntegerDto firstNumber;

    @JsonProperty(value = "secondNumber", required = true)
    private BigIntegerDto secondNumber;
}
