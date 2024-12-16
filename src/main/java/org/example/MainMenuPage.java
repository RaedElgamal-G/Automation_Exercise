package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilitiles.ElementActions;

public class MainMenuPage {
    private WebDriver driver;

    //locators
    private By signUpSignInLink = new By.ByXPath("//a[@href='/login']");
    private By loggedInAsUsertitle = new By.ByXPath("//i[@class='fa fa-user']/following-sibling::b");
    private By deleteAccountButton = new By.ByXPath("//a[@href='/delete_account']");

    public MainMenuPage(WebDriver driver) {
        this.driver = driver;
    }



    //Assertions
    @Step("Check That User Name ({expected}) Is Displayed In the Header")
    public void assertloggeedInWithUserIsDisplayed(String expected){
        ElementActions.assertEqualOnElement(driver,loggedInAsUsertitle,expected);
    }

    //Actions
    @Step("Click On Signup/Signin Link")
    public void clickOnSignUpSignInLink(){
        ElementActions.click(driver,signUpSignInLink);
    }

    @Step("Delete Account")
    public void deleteAccount(){
        ElementActions.click(driver,deleteAccountButton);
    }
}
