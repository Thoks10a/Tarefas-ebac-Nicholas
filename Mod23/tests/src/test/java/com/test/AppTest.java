package com.test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
public class AppTest {
    testReceive tr = new testReceive();
    App app = new App();

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test() {
        App app = new App();
        Assert.assertEquals("Teste", app.value);
    }

    @Test
    public void Exercicio() {
        String[] cvalue = app.main();
        String[] value = { "Marta-F", "Maisa-F" };

        Assert.assertArrayEquals(value, cvalue);
    }

}
