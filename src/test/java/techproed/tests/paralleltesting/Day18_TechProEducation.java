package techproed.tests.paralleltesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day18_TechProEducation {
    @Test
    public void lmsPageNavigation(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.linkText("LMS Login")).click();
        boolean isLoginDisplayed = driver.findElement(By.xpath("//span[@class='dn-lg']")).isDisplayed();
        Assert.assertTrue(isLoginDisplayed);
        driver.quit();

    }
}