package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dat14_DependsOnMethods {

    @Test
    public void homePage(){

        System.out.println("Home Page");

    }

    @Test
    public void logInPage(){

        System.out.println("Login Page");
        //Assert.assertTrue(false);//If this one fails, checkOutPage will not be executed.

    }

    /*
    dependsOnMethods connects checkOutPage to loginPage
    if checkOutPage method executes, then logInPage  runs first
    if the logInPage passes then checkOutPage will execute
    if the logInPage fails  then checkOutPage will not execute

     */

    @Test(dependsOnMethods = "logInPage")
    public void checkOutPage(){

        System.out.println("Check Out Page");

    }

}