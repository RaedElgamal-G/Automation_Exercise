package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitiles.BrowserActions;
import utilitiles.ElementActions;

public class HomePage {
    private final WebDriver driver;
    private String homePageUrl="https://automationexercise.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By homePageTitle = new By.ByXPath("//div[@class='col-sm-12']");

    //Assertions
    @Step("Check That Home Page Title Is Displayed")
    public void assertOnHomePageTitle() {
        ElementActions.assertTrueOnElement(driver,homePageTitle,"AutomationExercise");
    }


    //Actions
    @Step("Navigate To Home Page")
    public void navigateToHomePage(){
        BrowserActions.navigate(driver,homePageUrl);
    }




}
