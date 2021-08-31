package com.example.calculator.soap;

import com.example.calculator.soap.lib.CalculatorSoap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.function.BiFunction;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculatorProviderImpl implements CalculatorProvider {
    private final CalculatorSoap calculatorSoap;

    @Override
    public BigInteger add(BigInteger firstNumber, BigInteger secondNumber) {
        return process(firstNumber, secondNumber, calculatorSoap::add);
    }

    @Override
    public BigInteger divide(BigInteger firstNumber, BigInteger secondNumber) {
        return process(firstNumber, secondNumber, calculatorSoap::divide);
    }

    @Override
    public BigInteger multiply(BigInteger firstNumber, BigInteger secondNumber) {
        return process(firstNumber, secondNumber, calculatorSoap::multiply);
    }

    @Override
    public BigInteger subtract(BigInteger firstNumber, BigInteger secondNumber) {
        return process(firstNumber, secondNumber, calculatorSoap::subtract);
    }

    private BigInteger process(BigInteger firstNumber, BigInteger secondNumber, BiFunction<Integer, Integer, Integer> function) {
        final int intA = firstNumber.intValueExact();
        final int intB = secondNumber.intValueExact();
        final int result = function.apply(intA, intB);
        return BigInteger.valueOf(result);
    }
}
