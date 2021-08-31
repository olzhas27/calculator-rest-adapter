package com.example.calculator.service;

import com.example.calculator.dto.BigIntegerDto;
import com.example.calculator.dto.CalculatorRequestDto;

public interface CalculatorService {

    BigIntegerDto add(CalculatorRequestDto requestDto);

    BigIntegerDto divide(CalculatorRequestDto requestDto);

    BigIntegerDto multiply(CalculatorRequestDto requestDto);

    BigIntegerDto subtract(CalculatorRequestDto requestDto);
}
