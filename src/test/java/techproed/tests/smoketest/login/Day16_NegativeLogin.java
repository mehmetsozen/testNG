package techproed.tests.smoketest.login;import com.github.javafaker.Faker;
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
    @Test(groups = "login-group")
    public void loginScreenErrorMessages() throws IOException {
        //        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //        click on login button
        homePage = new HomePage();
        loginPage=new LoginPage();
        faker=new Faker();
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
        ReusableMethods.waitForVisibility(loginPage.invalidCredentialsError,5);
        ReusableMethods.verifyElementDisplayed(loginPage.invalidCredentialsError);
        Assert.assertTrue(loginPage.invalidCredentialsError.getText().equals("invalid credentials"));
        ReusableMethods.getScreenshot("Error Message");
//        Driver.closeDriver();


    }

    @Test(groups = "login-group")
    public void invalidEmail() throws IOException {
        //        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //        click on login button
        homePage = new HomePage();
        loginPage=new LoginPage();
        faker=new Faker();
//        GOING TO THE LOGIN PAGE FIRST TIME
        try{
            // if there is any exception, then keep going.
            // will be used only at the 1st login since homeLoginButton is available
            homePage.homeLoginButton.click();
        }catch (Exception e){
        }

//        GOING TO THE LOGIN PAGE AFTER FIRST TIME
        try{
            // if there is any exception, then keep going.
            // will be used AFTER the 1st login since userID is available AFTER the 1st login
//            Logging Out
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homeLoginButton.click();

        }catch (Exception e){

        }
//        typing invalid email
        loginPage.username.sendKeys(faker.name().username());
//      waiting for the error message and verify the error text
        ReusableMethods.waitForVisibility(loginPage.invalidEmailError,5);
        ReusableMethods.verifyElementDisplayed(loginPage.invalidEmailError);
        Assert.assertTrue(loginPage.invalidEmailError.getText().equals("email must be a valid email"));
        ReusableMethods.getScreenshot("Invalid_Email");

//        Verifying when there is valid email, error message is gone
        loginPage.username.sendKeys(faker.internet().emailAddress());
//       Doing assertion
//        verifyElementNotDisplayed -> PASS IF ELEMENT IS NOT ON THE PAGE. FAILS IF ELEMENT IS ON THE PAGE
//
        ReusableMethods.verifyElementNotDisplayed(loginPage.invalidEmailError);
        ReusableMethods.getScreenshot("Valid_Email");
        Driver.closeDriver();


    }

}