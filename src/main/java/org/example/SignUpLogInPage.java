package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitiles.ElementActions;

public class SignUpLogInPage {
    private WebDriver driver;

    public SignUpLogInPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By newUserSignUpTitle = new By.ByXPath("//div[@class='signup-form']/h2");
    private By nameField = new By.ByXPath("//input[@data-qa='signup-name']");
    private By emailField = new By.ByXPath("//input[@data-qa='signup-email']");
    private By signUpButton = new By.ByXPath("//button[@data-qa='signup-button']");

    private By logInToYourAccountTitle = new By.ByCssSelector("div[class='login-form'] h2");
    private By loginEmail = new By.ByCssSelector("input[data-qa='login-email']");
    private By loginPassword = new By.ByCssSelector("input[data-qa='login-password']");
    private By loginButton = new By.ByCssSelector("button[data-qa='login-button']");
    private By errorMessage = new By.ByXPath("//form[@action='/login']/p");

    //Assertions
    @Step("Check that New User SignUp Title Is Displayed")
    public void assertSignUpSectionIsDisplayed(){
        ElementActions.assertTrueOnElement(driver,newUserSignUpTitle,"New User Signup!");
    }

    @Step("Check that Login to your account Is Displayed")
    public void assertLogInSectionIsDisplayed(){
        ElementActions.assertTrueOnElement(driver,logInToYourAccountTitle,"Login to your account");
    }

    @Step("Assert On Displayed Error Message")
    public void assertOnErrorMessageDisplayed(){
        ElementActions.assertEqualOnElement(driver,errorMessage,"Your email or password is incorrect!");
    }

    //Actions
    @Step("Signup With Name And Email")
    public void signUpWithNameAndEmail(String name,String email){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Login With valid email And password")
    public void logIn(String email,String password){
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
    }


    public void clickOnSignUpButton(){
        ElementActions.click(driver,signUpButton);
    }

    public void clickOnLoginButton(){
        ElementActions.click(driver,loginButton);
    }

}
