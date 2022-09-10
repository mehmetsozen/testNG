package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day14_FirstDriverClass {
    @Test
    public void first(){
        //calling getDriver
        Driver.getDriver().get("https://techproeducation.com");
        //calling closeDriver
    Driver.closeDriver();
    }
}
