package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitiles.ElementActions;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By accountInformationPageTitle = new By.ByXPath("(//h2/b)[1]");
    private final By genderMrButton = new By.ByXPath("//input[@value='Mr']");
    private final By passwordField = new By.ByXPath("//input[@data-qa='password']");
    private final By daysDropDownList = new By.ByXPath("//select[@id='days']");
    private final By monthsDropDownList = new By.ByXPath("//select[@id='months']");
    private final By yearsDropDownList = new By.ByXPath("//select[@id='years']");
    private final By newsLetterCheckBox = new By.ByXPath("//input[@id='newsletter']");
    private final By ReceiveSpecialOffersCheckBox = new By.ByXPath("//input[@id='optin']");

    private final By firstNameField = new By.ByXPath("//input[@id='first_name']");
    private final By lastNameField = new By.ByXPath("//input[@id='last_name']");
    private final By companyField = new By.ByXPath("//input[@id='company']");
    private final By address1Field = new By.ByXPath("//input[@id='address1']");
    private final By address2Field = new By.ByXPath("//input[@id='address2']");
    private final By countyDropDownlist = new By.ByXPath("//select[@id='country']");
    private final By stateField = new By.ByXPath("//input[@id='state']");
    private final By cityField = new By.ByXPath("//input[@id='city']");
    private final By zipCode = new By.ByXPath("//input[@id='zipcode']");
    private final By mobileNumber = new By.ByXPath("//input[@data-qa='mobile_number']");
    private final By createAccountButton = new By.ByXPath("//button[@data-qa='create-account']");

    //Assertions
    @Step("Check That Account Information Page Title Is Displayed")
    public void assertAccountInformationPageIsOpened(){
        ElementActions.assertEqualOnElement(driver,accountInformationPageTitle, "ENTER ACCOUNT INFORMATION");
    }

    //Actions
    @Step("Enter Account Information Data")
    public void enterAccountInformationData(String password,String day, String month,String year){
        ElementActions.click(driver,genderMrButton);
        driver.findElement(passwordField).sendKeys(password);
        ElementActions.dropDownSelect(driver,daysDropDownList,day);
        ElementActions.dropDownSelect(driver,monthsDropDownList,month);
        ElementActions.dropDownSelect(driver,yearsDropDownList,year);
        ElementActions.click(driver,newsLetterCheckBox);
        ElementActions.click(driver,ReceiveSpecialOffersCheckBox);
    }

    @Step("Enter Address Information")
    public void enterAddressInformation (String name,String lastName, String company,String address1, String address2,String country, String state, String city, String zipCodeValue, String mobileNumberValue){
        driver.findElement(firstNameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address1Field).sendKeys(address1);
        driver.findElement(address2Field).sendKeys(address2);
        ElementActions.dropDownSelect(driver,countyDropDownlist,country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipCode).sendKeys(zipCodeValue);
        driver.findElement(mobileNumber).sendKeys(mobileNumberValue);

    }
    public void clickOnCreateAccountButton(){
        ElementActions.click(driver,createAccountButton);
    }



}
