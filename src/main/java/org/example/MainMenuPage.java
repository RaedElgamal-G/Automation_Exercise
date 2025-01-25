package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitiles.ElementActions;

public class MainMenuPage {
    private final WebDriver driver;

    //locators
    private final By signUpSignInLink = new By.ByXPath("//a[@href='/login']");
    private final By loggedInAsUsertitle = new By.ByXPath("//i[@class='fa fa-user']/following-sibling::b");
    private final By deleteAccountButton = new By.ByXPath("//a[@href='/delete_account']");
    private final By logoutButton = new By.ByCssSelector("a[href='/logout']");
    private final By contactUsLink = new By.ByXPath("//a[@href='/contact_us']");
    private final By homePageLink = new By.ByXPath("//i[@class='fa fa-home']");

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

    public void clickOnLogOutButton(){
        ElementActions.click(driver,logoutButton);
    }

    public void clickOnContactUsLink(){
        ElementActions.click(driver,contactUsLink);
    }
    public void clickOnHomeButton () {
        ElementActions.click(driver, homePageLink);
    }

}
