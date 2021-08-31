package com.example.calculator.soap;

import java.math.BigInteger;

public interface CalculatorProvider {

    BigInteger add(BigInteger firstNumber, BigInteger secondNumber);

    BigInteger divide(BigInteger firstNumber, BigInteger secondNumber);

    BigInteger multiply(BigInteger firstNumber, BigInteger secondNumber);

    BigInteger subtract(BigInteger firstNumber, BigInteger secondNumber);
}
