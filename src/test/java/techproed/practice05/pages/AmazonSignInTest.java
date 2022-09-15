package techproed.practice05.pages;import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class AmazonSignInTest {

//        Go to the Amazon website
//        Click on sign in button
//        Send e mail by using faker
//        Click on continue
//        Assert "There was a problem"  message
//        Click on "Need help?"
//        Click on "Forgot your Password?"
//        Verify the text "Password assistance"
//        Navigate back
//        Click on "Create your account" button
//        Verify the text "Create account"

    AmazonSignInPage amazonSignInPage = new AmazonSignInPage();

    @Test
    public void amazonSignInTest(){
//        Go to the Amazon website
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

//        Click on sign in button
        amazonSignInPage.signInTab.click();

//        Send e mail by using faker
        amazonSignInPage.emailBox.sendKeys(Faker.instance().internet().emailAddress());

//        Click on continue
        amazonSignInPage.continueButton.click();

//        Assert "There was a problem"  message
        String warningMessageText = amazonSignInPage.warningMessage.getText();
        Assert.assertEquals(warningMessageText, "We cannot find an account with that email address");

//        Click on "Need help?"
        amazonSignInPage.needHelp.click();

//        Click on "Forgot your Password?"
        amazonSignInPage.forgotPassword.click();

//        Verify the text "Password assistance"
        boolean isPassDisplayed = amazonSignInPage.passwordAssistance.isDisplayed();
        Assert.assertTrue(isPassDisplayed);

//        Navigate back
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();

//        Click on "Create your account" button
        amazonSignInPage.createAccountButton.click();

//        Verify the text "Create account"
        String createAccountText = amazonSignInPage.createAccountText.getText();
        Assert.assertEquals(createAccountText, "Create account");

    }
}