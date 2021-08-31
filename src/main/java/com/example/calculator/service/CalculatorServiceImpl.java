package com.example.calculator.service;

import com.example.calculator.dto.BigIntegerDto;
import com.example.calculator.dto.CalculatorRequestDto;
import com.example.calculator.exception.ValidationException;
import com.example.calculator.soap.CalculatorProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.function.BiFunction;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculatorServiceImpl implements CalculatorService {
    private final CalculatorProvider calculatorProvider;

    @Override
    public BigIntegerDto add(CalculatorRequestDto requestDto) {
        return process(requestDto, calculatorProvider::add);
    }

    @Override
    public BigIntegerDto divide(CalculatorRequestDto requestDto) {
        return process(requestDto,
            (firstNumber, secondNumber) -> {
                if (BigInteger.ZERO.equals(secondNumber)) {
                    throwValidationException("Division by zero");
                }
                return calculatorProvider.divide(firstNumber, secondNumber);
            });
    }

    @Override
    public BigIntegerDto multiply(CalculatorRequestDto requestDto) {
        return process(requestDto, calculatorProvider::multiply);
    }

    @Override
    public BigIntegerDto subtract(CalculatorRequestDto requestDto) {
        return process(requestDto, calculatorProvider::subtract);
    }

    private BigIntegerDto process(CalculatorRequestDto requestDto, BiFunction<BigInteger, BigInteger, BigInteger> function) {
        final BigInteger firstNumber = convertFrom(requestDto.getFirstNumber());
        final BigInteger secondNumber = convertFrom(requestDto.getSecondNumber());
        final BigInteger result = function.apply(firstNumber, secondNumber);
        return convertTo(result, requestDto.getFirstNumber().getRadix());
    }

    private BigInteger convertFrom(BigIntegerDto bigIntegerDto) {
        BigInteger result = new BigInteger(bigIntegerDto.getValue(), bigIntegerDto.getRadix());
        try {
            result.intValueExact();
        } catch (ArithmeticException e) {
            throwValidationException("Couldn't convert to int value: '" + bigIntegerDto.getValue() + "'");
        }
        return result;
    }

    private void throwValidationException(String validationMessage) {
        log.info("Validation exception: '{}'", validationMessage);
        throw new ValidationException(validationMessage);
    }

    private BigIntegerDto convertTo(BigInteger bigInteger, int radix) {
        return new BigIntegerDto()
            .setValue(bigInteger.toString(radix))
            .setRadix(radix);
    }
}
