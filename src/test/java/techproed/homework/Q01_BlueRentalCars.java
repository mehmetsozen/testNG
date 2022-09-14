package techproed.homework;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Q01_BlueRentalCars {
    @Test
    public void blueCarTest(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));


    }

}
