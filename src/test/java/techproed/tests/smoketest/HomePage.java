package techproed.tests.smoketest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(partialLinkText = "Login")
    public WebElement homeLoginButton;
    @FindBy(id="dropdown-basic-button")
    public WebElement userID;


}
