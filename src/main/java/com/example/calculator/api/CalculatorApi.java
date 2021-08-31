package com.example.calculator.api;

import com.example.calculator.dto.BigIntegerDto;
import com.example.calculator.dto.CalculatorRequestDto;
import com.example.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/calculator")
public class CalculatorApi {
    private final CalculatorService calculatorService;

    @PostMapping("/add")
    public BigIntegerDto add(@RequestBody CalculatorRequestDto requestDto) {
        return calculatorService.add(requestDto);
    }

    @PostMapping("/divide")
    public BigIntegerDto divide(@RequestBody CalculatorRequestDto requestDto) {
        return calculatorService.divide(requestDto);
    }

    @PostMapping("/multiply")
    public BigIntegerDto mulptiply(@RequestBody CalculatorRequestDto requestDto) {
        return calculatorService.multiply(requestDto);
    }

    @PostMapping("/subtract")
    public BigIntegerDto subtract(@RequestBody CalculatorRequestDto requestDto) {
        return calculatorService.subtract(requestDto);
    }
}
