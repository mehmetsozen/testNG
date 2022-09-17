package techproed.tests.listeners;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
public class ListenersTest1 {
    @Test
    public void test1(){
        System.out.println("Test Case 1 -  PASS");
        Assert.assertTrue(true);
    }
    @Test
    public void test2(){
        System.out.println("Test Case 2 - FAIL");
        Assert.assertTrue(false);
    }
    @Test
    public void test3(){
        System.out.println("Test Case 3 - SKIP");
//        Skipping this test case
        throw new SkipException("SKIPPING TEST CASE");
    }
    @Test
    public void test4(){
        System.out.println("Test Case 4 - No Such Element Exception");
        throw new NoSuchElementException("THROWING SO SUCH ELEMENT EXCEPTION");
    }
}