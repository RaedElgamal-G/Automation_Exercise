package Automation.test;

import org.apache.commons.io.FileUtils;
import org.example.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilitiles.DriverFactory;
import utilitiles.PropertiesReader;

import java.io.File;

public class TestsSetUp {
    WebDriver driver;
    protected HomePage homepage;
    protected MainMenuPage mainmenuepage;
    protected SignUpLogInPage signuploginpage;
    protected RegistrationPage registeraionpage;
    protected AccountCreatedPage accountcreatedpage;
    protected DeleteAccountPage deleteaccountpage;
    protected ContactUsPage contactuspage;

    @BeforeMethod
    public void before_method_1(){
        driver=DriverFactory.initiateDriver(System.getProperty("browserName"),Boolean.parseBoolean(System.getProperty("headless")),true);
        homepage = new HomePage(driver);
        mainmenuepage= new MainMenuPage(driver);
        signuploginpage = new SignUpLogInPage(driver);
        registeraionpage = new RegistrationPage(driver);
        accountcreatedpage = new AccountCreatedPage(driver);
        deleteaccountpage = new DeleteAccountPage(driver);
        contactuspage = new ContactUsPage(driver);
    }

    @AfterMethod
    public void after_method_1(){
        driver.quit();

    }

    @BeforeSuite
    public void beforeSuite(){
        PropertiesReader.loadProperties();

        //clean old allure results in (target/allure-results)
        try {
            File allureResults = new File("target/allure-results");
            if (allureResults.exists()) {
                FileUtils.cleanDirectory(allureResults);
            }
        } catch (Exception e) {
            System.out.println("Failed to clean allure-results directory: " + e.getMessage());
        }

    }

}
