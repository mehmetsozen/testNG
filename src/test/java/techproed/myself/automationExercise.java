package techproed.myself;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public  class automationExercise{
    @Test
            public static void test() {
        Driver.getDriver().get(ConfigReader.getProperty("autoexercise"));
   WebElement isTrue=Driver.getDriver().findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
   Assert.assertTrue(isTrue.isDisplayed());
   Driver.getDriver().findElement(By.xpath("//a[@href='/login'] ")).click();
   Driver.getDriver().findElement(By.xpath("//input[@name='email'] ")).sendKeys("mehsozen80@gmail.com");
   Driver.getDriver().findElement(By.xpath("//input[@name='password']  ")).sendKeys("abc12345");
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']  ")).click();



    }
}
