package com.practice.webbe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorServiceTest {
    CalculatorService calculatorService;

    @Before
    public void init() {
        this.calculatorService = new CalculatorService();
    }

    @Test
    public void plus() throws Exception {
        //given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService.plus(value1, value2);

        // then
        Assert.assertEquals(15, result);
    }

    @Test
    public void divide() throws Exception {
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result =  calculatorService.divide(
            value1, value2);

        // then
        Assert.assertEquals(2,result);
    }
    @Test
    public void divideExceptionTest() throws Exception {
        // given
        int value1 = 10;
        int value2 = 0;

        try{
            calculatorService.divide(value1, value2);
        }catch (ArithmeticException ae){
            Assert.assertTrue(true);
            return;
        }
        Assert.assertFalse(false);
    }
}