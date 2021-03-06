package com.example.calculatorweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/calculator/")
public class CalculatorWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorWebApplication.class, args);
    }

    // Add Route
    @GetMapping(value = "/add", produces = MediaType.TEXT_PLAIN_VALUE)
    public String addition(@RequestParam Map<String,String> requestParams) {

        double num1=Integer.parseInt(requestParams.get("num1"));
        double num2 = Integer.parseInt(requestParams.get("num2"));
        double sum  = num1+num2;
        return "The sum of "+num1+ " and "+num2 + " is " +sum;
    }

    // Subtract Route
    @PostMapping(value = "/subtract", produces = MediaType.TEXT_PLAIN_VALUE)
    public String subtraction(@RequestParam Map<String,String> requestParams) {

        double num1=Integer.parseInt(requestParams.get("num1"));
        double num2 = Integer.parseInt(requestParams.get("num2"));
        double difference  = num1-num2;
        return "The difference of "+num1+ " and "+num2 + " is " +difference;
    }

    // Multiply Route
    @GetMapping(value = "/multiply", produces = MediaType.TEXT_PLAIN_VALUE)
    public String multiply(@RequestParam Map<String,String> requestParams) {

        double num1=Integer.parseInt(requestParams.get("num1"));
        double num2 = Integer.parseInt(requestParams.get("num2"));
        double product  = num1 * num2;
        return "The product of "+num1+ " and "+num2 + " is " +product;
    }

    // Divide Route
    @GetMapping(value = "/divide", produces = MediaType.TEXT_PLAIN_VALUE)
    public String divide(@RequestParam Map<String,String> requestParams) {

        double num1=Integer.parseInt(requestParams.get("num1"));
        double num2 = Integer.parseInt(requestParams.get("num2"));

        try {
            double quotient = num1 / num2;
            return "The quotient of " + num1 + " and " + num2 + " is " + quotient;
        }
        catch (Exception e){
            return "Math error";
        }
    }

    // Square-root Route
    @GetMapping(value = "/sqrt", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sqrt(@RequestParam Map<String,String> requestParams) {

        int num=Integer.parseInt(requestParams.get("num"));

        double root  = Math.sqrt(num);
        return "The square root of " +num+" is "+root;
    }

    // see the README.md for more info



}


