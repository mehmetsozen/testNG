package techproed.tests.smoketest.login;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.tests.smoketest.HomePage;
import techproed.tests.smoketest.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;
import java.io.IOException;

public class Day16_NegativeLogin {
    HomePage homePage;
    LoginPage loginPage;
    Faker faker;

    @Test
    public void loginScreenErrorMessages() throws IOException {
        //        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //        click on login button
        homePage = new HomePage();
        loginPage = new LoginPage();
        faker = new Faker();
//        clicking home login button
        homePage.homeLoginButton.click();
//        type email, password, and click login button
        loginPage.username.sendKeys(faker.internet().emailAddress());
        loginPage.password.sendKeys(faker.internet().password());
        loginPage.loginButton.click();
        /*
        loginPage.invalidCredentialsError element pops up and it takes time to be visible(less than a sec)
        and implicit wait can not handle the wait
        so we should use explicit wait. below we are wait for the element to be visible up to 5 second
        Then doing the assertion
         */
        ReusableMethods.waitForVisibility(loginPage.invalidCredentialsError, 5);
        ReusableMethods.verifyElementDisplayed(loginPage.invalidCredentialsError);
        Assert.assertTrue(loginPage.invalidCredentialsError.getText().equals("invalid credentials"));
        ReusableMethods.getScreenshot("Error Message");
        Driver.closeDriver();

    }

    @Test
    public void invalidEmail() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //        click on login button
        homePage = new HomePage();
        loginPage = new LoginPage();
        faker = new Faker();
//        clicking home login button
        homePage.homeLoginButton.click();
//        type email, password, and click login button

        loginPage.username.sendKeys(faker.name().username());

        ReusableMethods.verifyElementDisplayed(loginPage.invalidEmailError);
        Assert.assertTrue(loginPage.invalidEmailError.getText().equals("email must be a valid email"));
ReusableMethods.getScreenshot("Invalid Email");
loginPage.username.clear();
loginPage.username.sendKeys(faker.internet().emailAddress());
//ReusableMethods.verifyElementNotDisplayed(By.xpath("//*[text()='email must be a valid email')]]"));
ReusableMethods.verifyElementNotDisplayed(loginPage.invalidEmailError);

    }
}