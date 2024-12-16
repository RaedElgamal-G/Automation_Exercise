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

    //Assertions
    @Step("Check that Signup/Signin page Title Is Displayed")
    public void assertSignUpSignInpageIsOpedned(){
        ElementActions.assertTrueOnElement(driver,newUserSignUpTitle,"New User Signup!");
    }
    //Actions
    @Step("Signup With Name And Email")
    public void signUpWithNameAndEmail(String name,String email){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickOnSignUpButton(){
        ElementActions.click(driver,signUpButton);
    }


}
