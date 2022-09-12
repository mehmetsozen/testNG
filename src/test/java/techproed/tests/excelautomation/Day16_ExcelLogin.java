package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.tests.smoketest.HomePage;
import techproed.tests.smoketest.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day16_ExcelLogin {
    ExcelUtil excelUtil;
    HomePage homePage;
    LoginPage loginPage;
    List<Map<String, String>> testData;

    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage= new HomePage();
        loginPage=new LoginPage();

        try{
            homePage.homeLoginButton.click();
        }catch(Exception e){

        }
        try{
           homePage.userID.click();
           homePage.logoutLink.click();
           homePage.OK.click();
           homePage.homeLoginButton.click();

        }catch(Exception e){

        }
    }

    @Test
    public void customerLogin() throws IOException {
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
String customerSheet="customer_info";
       excelUtil= new ExcelUtil(path,customerSheet);
testData=excelUtil.getDataList();
       // System.out.println(testData);
        for(Map<String, String> eachData:testData){
            login();
            ReusableMethods.waitFor(1);
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(eachData.get("password").substring(0,5));
            ReusableMethods.waitFor(1);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
            ReusableMethods.verifyElementDisplayed(homePage.userID);
            ReusableMethods.getScreenshot(eachData.get("username"));

        }
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
//login 4 times
//    customer@bluerentalcars.com   12345
//    customer1@bluerentalcars.com  12346
//    customer2@bluerentalcars.com  12347
//    customer3@bluerentalcars.com  12348
/*
SUDO CODE
1st login:customer@bluerentalcars.com   12345
try{//using try catch cause 2nd time login button will not be there
click homepage login  ->>> 2nd time no such element exception,
if you don't use try catch test case fails and stops
}catch(Exception e){
}
---------------------------------
2nd, 3rd, 4th login
try{
click on user id ->>> 1st login, these elements will not be there, throws no such element exception, so used try catch
click on log out
click on OK
click homepage login
}catch(Exception e){
}
-----------------------------------
//for all steps
for{
send username -> get excel data
send password -> get excel data
click login button
do assertion
take screenshot
}
-------
 */
}
