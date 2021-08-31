package com.example.calculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BigIntegerDto {
    @JsonProperty(value = "value", required = true)
    private String value;

    @JsonProperty(value = "radix")
    private int radix = 10;
}
