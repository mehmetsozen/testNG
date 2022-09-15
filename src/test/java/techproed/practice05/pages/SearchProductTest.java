package techproed.practice05.pages;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

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
    public void searchProductsTest() throws InterruptedException {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automation_exercise_url"));

//3. Verify that home page is visible successfully
        String homePageUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(homePageUrl);
        Assert.assertEquals(homePageUrl,"https://automationexercise.com/");

//4. Click on 'Products' button
        searchProductPage.productsButton.click();

//5. Verify user is navigated to ALL PRODUCTS page successfully
        boolean isAllProductDisplayed = searchProductPage.allProduct.isDisplayed();
        Assert.assertTrue(isAllProductDisplayed);

//6. Enter product name in search input and click search button
        searchProductPage.searchBox.sendKeys(ConfigReader.getProperty("product_name"));
        searchProductPage.searchButton.click();


//7. Verify 'SEARCHED PRODUCTS' is visible
        boolean  isSearchedProductsTextDisplayed = searchProductPage.searchedProductsText.isDisplayed();
        Assert.assertTrue(isSearchedProductsTextDisplayed);

//8. Verify all the product features related to search are visible
        Thread.sleep(2000);
        searchProductPage.viewProduct.click();
        Assert.assertTrue(searchProductPage.availability.getText().contains("In Stock"));
        Assert.assertTrue(searchProductPage.condition.getText().contains("New"));
        Assert.assertTrue(searchProductPage.brand.getText().contains("Polo"));

    }
}
