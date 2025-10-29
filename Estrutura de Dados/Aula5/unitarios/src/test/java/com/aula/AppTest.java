package com.aula;


import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testSoma() throws Exception {
        calc calc = new calc();
        int simpleValue = 15;
        int simpleValue2 = 5;
        Assert.assertEquals(20, calc.soma(simpleValue, simpleValue2));
    }

    @Test
    public void testSubtracao() throws Exception {
        calc calc = new calc();
        int simpleValue = 15;
        int simpleValue2 = 5;
        Assert.assertEquals(10, calc.subtracao(simpleValue, simpleValue2));
    }
    
    @Test
    public void testMultiplicacao() throws Exception {
        calc calc = new calc();
        int simpleValue = 15;
        int simpleValue2 = 5;
        Assert.assertEquals(75, calc.multiplicacao(simpleValue, simpleValue2));
    }
    
    @Test
    public void testDivisao() throws Exception {
        calc calc = new calc();
        int simpleValue = 15;
        int simpleValue2 = 5;
        Assert.assertEquals(3, calc.divisao(simpleValue, simpleValue2));
    }
}
