package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day14_SoftAssert {
    @Test
    public void softAssertTest() {
        SoftAssert sa = new SoftAssert();
        System.out.println("Line A");
        sa.assertEquals("Hello","HelloX");
        System.out.println("Line B");
        sa.assertTrue(false);
        System.out.println("Line C");
        sa.assertEquals(1,2);

        sa.assertAll();
    }
}