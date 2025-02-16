package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitiles.ElementActions;

public class DeleteAccountPage {
    private final WebDriver driver;

    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By accoutnDeletionPageTitle = new By.ByXPath("//b");
    private final By accoutnDeletionContinueButton = new By.ByXPath("//a[@data-qa='continue-button']");

    //Assertions
    @Step("Check That Account Deletion Page Title Is Displayed")
    public void assertOnAccountDeletion(){
        ElementActions.assertEqualOnElement(driver,accoutnDeletionPageTitle,"ACCOUNT DELETED!");
    }

    //Actions
    public void clickOnDeletionContinueButton(){
        ElementActions.click(driver,accoutnDeletionContinueButton);
    }
}
