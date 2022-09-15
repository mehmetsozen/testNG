package techproed.tests.dataprovider;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import techproed.tests.smoketest.HomePage;
import techproed.tests.smoketest.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day17_DataProvider2 {

    HomePage homePage;
    LoginPage loginPage;

    // DATA PROVIDER METHOD
    @DataProvider
    public Object[][] customerData(){

        Object [][] customerCredentials = {
                {"customer@bluerentalcars.com","12345"},
                {"customer1@bluerentalcars.com","12346"},
                {"customer2@bluerentalcars.com","12347"},
                {"customer3@bluerentalcars.com","12348"}
        };


        return customerCredentials;
    }

    public void login(){

//        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        initializing the pages
        homePage = new HomePage();
        loginPage=new LoginPage();


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
    }


    @Test(dataProvider = "customerData")
    public void dataProviderTest(String userName, String passWord) throws IOException {

        login();
//            Not that we are on login page, we can send username, password, and click on login button
        ReusableMethods.waitFor(1);
        loginPage.username.sendKeys(userName);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(passWord);
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
//            Asserting making sure login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);
        ReusableMethods.getScreenshot(userName);


    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }




}