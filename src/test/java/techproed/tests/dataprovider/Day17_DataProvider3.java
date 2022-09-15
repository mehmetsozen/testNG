package techproed.tests.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.tests.smoketest.HomePage;
import techproed.tests.smoketest.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day17_DataProvider3 {

    HomePage homePage;
    LoginPage loginPage;
    ExcelUtil excelUtil;

    // DATA PROVIDER METHOD
    //Copied from previous class
    //In excel, we used most of the same code
    //Here we use Data provider to get the list of credentials and use it without any loop.

    @DataProvider
    public Object[][] customerData(){

//        path of customer sheet
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
//        customer sheet name
        String customerSheet ="customer_info";
//        Use Excel Util
        excelUtil = new ExcelUtil(path,customerSheet);
//        getting the data from the excel using excel util method
        Object[][] customerCredentials = excelUtil.getDataArrayWithoutFirstRow();


        return customerCredentials;
    }

    //Data provider is similar to getting data from excel.
    //We will login similar to excel login using data provider.
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
        loginPage.password.sendKeys(passWord.substring(0,5));
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
