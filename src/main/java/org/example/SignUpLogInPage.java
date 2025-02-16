package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitiles.ElementActions;

public class SignUpLogInPage {
    private final WebDriver driver;

    public SignUpLogInPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By newUserSignUpTitle = new By.ByXPath("//div[@class='signup-form']/h2");
    private final By nameField = new By.ByXPath("//input[@data-qa='signup-name']");
    private final By emailField = new By.ByXPath("//input[@data-qa='signup-email']");
    private final By signUpButton = new By.ByXPath("//button[@data-qa='signup-button']");

    private final By logInToYourAccountTitle = new By.ByCssSelector("div[class='login-form'] h2");
    private final By loginEmail = new By.ByCssSelector("input[data-qa='login-email']");
    private final By loginPassword = new By.ByCssSelector("input[data-qa='login-password']");
    private final By loginButton = new By.ByCssSelector("button[data-qa='login-button']");
    private final By invalidCredentialsErrorMsg = new By.ByXPath("//form[@action='/login']/p");
    private final By existingEmailErrorMsg = new By.ByXPath("//input[@value='signup']/following-sibling::p");

    //Assertions
    @Step("Check that New User SignUp Title Is Displayed")
    public void assertSignUpSectionIsDisplayed(){
        ElementActions.assertTrueOnElement(driver,newUserSignUpTitle,"New User Signup!");
    }

    @Step("Check that Login to your account Is Displayed")
    public void assertLogInSectionIsDisplayed(){
        ElementActions.assertTrueOnElement(driver,logInToYourAccountTitle,"Login to your account");
    }

    @Step("Assert On Login with invalid Credentials Error Message")
    public void assertOnLoginErrorMessage(){
        ElementActions.assertEqualOnElement(driver, invalidCredentialsErrorMsg,"Your email or password is incorrect!");
    }

    @Step("Assert On Sign Up With Existing Email Error Message")
    public void assertOnExistingEmailErrorMessage(){
        ElementActions.assertEqualOnElement(driver, existingEmailErrorMsg,"Email Address already exist!");
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
