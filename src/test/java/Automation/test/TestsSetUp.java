package Automation.test;

import org.example.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilitiles.DriverFactory;
import utilitiles.JsonFileManager1;
import utilitiles.PropertiesReader;

public class TestsSetUp {
    WebDriver driver;
    protected HomePage homepage;
    protected MainMenuPage mainmenuepage;
    protected SignUpLogInPage signuploginpage;
    protected RegistrationPage registeraionpage;
    protected AccountCreatedPage accountcreatedpage;
    protected DeleteAccountPage deleteaccountpage;
    JsonFileManager1 dataRepo = new JsonFileManager1("src/test/resources/userdata.json");




    @BeforeMethod
    public void before_method_1(){
        driver=DriverFactory.initiateDriver(System.getProperty("browserName"),Boolean.parseBoolean(System.getProperty("headless")),true);
        homepage = new HomePage(driver);
        mainmenuepage= new MainMenuPage(driver);
        signuploginpage = new SignUpLogInPage(driver);
        registeraionpage = new RegistrationPage(driver);
        accountcreatedpage = new AccountCreatedPage(driver);
        deleteaccountpage = new DeleteAccountPage(driver);

    }

    @AfterMethod
    public void after_method_1(){
        driver.quit();

    }

    @BeforeSuite
    public void beforeSuite(){
        PropertiesReader.loadProperties();

    }
}
