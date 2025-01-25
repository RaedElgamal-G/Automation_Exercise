package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitiles.ElementActions;

public class AccountCreatedPage {
    private final WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By accountCreationPageTitle = new By.ByXPath("//b");
    private final By accountCreationContinueButton = new By.ByXPath("//a[@data-qa='continue-button']");

    //Assertions
    @Step("Check Creation Page Title Is Displayed")
    public void assertAccountISCreated(){
        ElementActions.assertEqualOnElement(driver,accountCreationPageTitle,"ACCOUNT CREATED!");
    }

    //Actions
    public void clickOnCreationContinueButton(){
        ElementActions.click(driver,accountCreationContinueButton);
    }


}
