package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitiles.ElementActions;

public class ContactUsPage {
    private final WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By getInTouchTitle = new By.ByXPath("//div[@class='contact-form']/h2");
    private final By nameField = new By.ByName("name");
    private final By emailField = new By.ByName("email");
    private final By subjectField = new By.ByName("subject");
    private final By messageField = new By.ByName("message");
    private final By submitButton = new By.ByName("submit");

    //Assertions
    @Step("Assert On Get In Touch Title")
    public void assertOnGetInTouchTitle(String expected) {
        ElementActions.assertEqualOnElement(driver, getInTouchTitle, expected);
    }

    //Actions
    public void fillContactUsForm(String name, String email, String subject, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickOnSubmitButton() {
        driver.findElement(submitButton).click();
    }

    @Step("Click On OK Button On The Popup")
    public void clickOnOKButton() {
    // Switch to the browser popup
    Alert confirmation = driver.switchTo().alert();

    // Get popup text and print it
    System.out.println("Confirmation text: " + confirmation.getText());

    // Accept the popup
    confirmation.accept(); // Use confirmation.dismiss() to cancel
}



}