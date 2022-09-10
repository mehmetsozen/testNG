package techproed.myself;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class nutella {
    @Test
            public void test(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    driver.get("https://www.amazon.com");
    WebElement amazon= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    amazon.sendKeys("nutella");
    amazon.submit();
    WebElement amazonPrint=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'] "));
        System.out.println(amazonPrint.getText());
    driver.close();

    }
}
