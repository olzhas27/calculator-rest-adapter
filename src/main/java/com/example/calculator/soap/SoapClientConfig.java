package com.example.calculator.soap;

import com.example.calculator.soap.lib.Calculator;
import com.example.calculator.soap.lib.CalculatorSoap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Configuration
public class SoapClientConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CalculatorSoap calculatorSoap(@Value("${calculator.wsdl.url}") String calculatorSoapWsdlUrl) throws URISyntaxException, MalformedURLException {
        final URL wsdlUrl = new URI(calculatorSoapWsdlUrl)
            .toURL();
        final Calculator calculator = new Calculator(wsdlUrl);
        return calculator.getCalculatorSoap();
    }
}
