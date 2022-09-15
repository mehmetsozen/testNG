package techproed.tests.smoketest.login;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.tests.smoketest.HomePage;
import techproed.tests.smoketest.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day16_PositiveLogin {
    HomePage homePage;
    LoginPage loginPage;
    @Test(groups="login-group")
    public void customerLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage= new HomePage();
        loginPage=new LoginPage();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("app_customer_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("app_customer_password"));
        loginPage.loginButton.click();
        ReusableMethods.verifyElementDisplayed(homePage.userID);
        Select select=new Select(homePage.selectACar);
        select.selectByIndex(3);
Driver.closeDriver();

    }

}
