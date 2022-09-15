package techproed.practice05.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class SearchProductPage {

    public SearchProductPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public  WebElement allProduct;

    @FindBy(id = "search_product")
    public WebElement searchBox;

    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement searchedProductsText;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement viewProduct;

    @FindBy(xpath = "//b[.='Availability:']")
    public WebElement availability;

    @FindBy(xpath = "//b[.='Condition:']")
    public  WebElement condition;

    @FindBy(xpath = "//b[.='Brand:']")
    public WebElement brand;

}