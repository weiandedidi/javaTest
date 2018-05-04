package com.qidi;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private App app = new App();
    /**
     * Rigorous Test :-)
     */
    @Test
    @Ignore
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAbc() {
        app.abc();
        System.out.println("测试方法...");
    }
}
