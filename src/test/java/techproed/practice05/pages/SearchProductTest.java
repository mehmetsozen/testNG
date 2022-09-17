package techproed.practice05.pages;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.SearchProductPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class SearchProductTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Products' button
//5. Verify user is navigated to ALL PRODUCTS page successfully
//6. Enter product name in search input and click search button
//7. Verify 'SEARCHED PRODUCTS' is visible
//8. Verify all the product features related to search are visible

    SearchProductPage searchProductPage = new SearchProductPage();
@Test
    public void searchProduct() {
//1.    Launch browser
//2.    Navigate to url 'http://automationexercise.com'
    Driver.getDriver().get(ConfigReader.getProperty("autoexercise"));

    //3.    Verify that home page is visible successfully
    String homePageTitle = Driver.getDriver().getTitle();
    System.out.println(homePageTitle);
    Assert.assertEquals("Automation Exercise", homePageTitle);

//4.    Click on 'Products' button
    searchProductPage.productButton.click();

    //5.    Verify user is navigated to ALL PRODUCTS page successfully
    String allProducts = searchProductPage.allProduct.getText();
    Assert.assertEquals(allProducts, "ALL PRODUCTS");

//6.    Enter product name in search input and click search button
    searchProductPage.searchBox.sendKeys("Blue Top");
    searchProductPage.searchButton.click();

    //7.    Verify 'SEARCHED PRODUCTS' is visible
    String searchedProducts = searchProductPage.searchedProductsText.getText();
    System.out.println(searchedProducts);
    Assert.assertEquals(searchedProducts, "Automation Exercise");

//8.    View Product
    searchProductPage.viewProduct.click();

    //9.    Verify all the products' features related to search are visible
    String availability = searchProductPage.availability.getText();
    System.out.println(availability);
    Assert.assertEquals(availability, "Availability:");

    String condition = searchProductPage.condition.getText();
    System.out.println(condition);
    Assert.assertEquals(condition, "Condition:");

    String brand = searchProductPage.brand.getText();
    System.out.println(brand);
    Assert.assertEquals(brand, "Brand:");

//10.   Close the page
    ReusableMethods.waitFor(1);
    Driver.closeDriver();

}}
