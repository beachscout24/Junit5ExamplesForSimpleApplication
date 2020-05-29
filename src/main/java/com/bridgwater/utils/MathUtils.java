package com.bridgwater.utils;

import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;

public class MathUtils {

    public Integer add(Integer number1, Integer number2){
        return number1 + number2;
    }

    public Integer subtract(Integer number1, Integer number2){
        return number1 - number2;
    }

    public Integer multiply(Integer number1, Integer number2){
        return number1 * number2;
    }

    public Integer divide(Integer number1, Integer number2) throws ArithmeticException{
        return number1 / number2;
    }

    public BigDecimal computeCircleArea(BigDecimal radius){
        return radius.multiply(radius).multiply(new BigDecimal(Math.PI));
    }

}
