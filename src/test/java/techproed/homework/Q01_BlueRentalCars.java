package techproed.homework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.tests.smoketest.HomePage;
import techproed.tests.smoketest.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import javax.swing.*;
import java.io.IOException;
import java.security.Key;
import java.time.Duration;


public class Q01_BlueRentalCars {
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void blueCarTest() throws InterruptedException, IOException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("app_customer_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("app_customer_password"));
        loginPage.loginButton.click();
        Select select = new Select(homePage.selectACar);
        select.selectByValue("8");

        Driver.getDriver().findElement(By.xpath("//input[@name='pickUpLocation']")).sendKeys("Orlando");
        Driver.getDriver().findElement(By.xpath("//input[@name='dropOfLocation']")).sendKeys("Miami");
        Driver.getDriver().findElement(By.xpath("//input[@name='pickUpDate']")).sendKeys("09-16-2028");

        Driver.getDriver().findElement(By.xpath("//input[@name='pickUpTime']")).sendKeys("09:00P");
        Driver.getDriver().findElement(By.xpath("//input[@name='dropOffDate']")).sendKeys("09-23-2028");
        Driver.getDriver().findElement(By.xpath("//input[@name='dropOffTime']")).sendKeys("09:00P");
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        ReusableMethods.waitFor(2);
        Actions action = new Actions(Driver.getDriver());

        WebElement cardClick = Driver.getDriver().findElement(By.xpath("//input[@name='cardNo']"));

        action.doubleClick(cardClick).doubleClick().sendKeys("4242424242424242").build().perform();
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("4242424242424242");
        ReusableMethods.waitFor(2);


        Driver.getDriver().findElement(By.xpath("//input[@name='nameOnCard']")).sendKeys("Mehmet Sakarya");
        //Thread.sleep(3000);
        WebElement expireDate = Driver.getDriver().findElement(By.xpath("//input[@name='expireDate']"));
        action.doubleClick(expireDate).doubleClick().sendKeys("10/28").build().perform();
        //expireDate.sendKeys("1028");
        WebElement cvc = Driver.getDriver().findElement(By.xpath("//input[@name='cvc']"));
        action.doubleClick(cvc).doubleClick().sendKeys("108").build().perform();
        ReusableMethods.waitFor(2);
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        ReusableMethods.waitFor(2);
        checkBox.click();
        Driver.getDriver().findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        ReusableMethods.getScreenshot("RentalCars ");

        System.out.println("Reservation Created Successfully");


    }

}
