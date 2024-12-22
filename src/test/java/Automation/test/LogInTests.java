package Automation.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utilitiles.JsonFileManager1;

public class LogInTests extends TestsSetUp {

    //reading json file (logInData)
    JsonFileManager1 dataRepo = new JsonFileManager1("src/test/resources/logInData.json");

    //valid user data from json file (logInData)
    String validName = dataRepo.getTestData("$.registeredUser.fitstName");
    String validEmail = dataRepo.getTestData("$.registeredUser.email");
    String validPassword = dataRepo.getTestData("$.registeredUser.password");

    //Invalid user data from json file (logInData)
    String invalidEmail = dataRepo.getTestData("$.unregisteredUser.email");
    String invalidPassword = dataRepo.getTestData("$.unregisteredUser.password");

    @Test(description = "Login with valid email and password")
    @Description("Login with valid email and password")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithValidCredentials() {
        homepage.navigateToHomePage();
        homepage.assertOnHomePageTitle();
        mainmenuepage.clickOnSignUpSignInLink();
        signuploginpage.assertLogInSectionIsDisplayed();
        signuploginpage.logIn(validEmail, validPassword);
        signuploginpage.clickOnLoginButton();
        mainmenuepage.assertloggeedInWithUserIsDisplayed(validName);

    }

    @Test(description = "Login with Invalid email and password")
    @Description("Login with Invalid email and password")
    @Severity(SeverityLevel.MINOR)
    public void loginWithInvalidCredentials() {
        homepage.navigateToHomePage();
        homepage.assertOnHomePageTitle();
        mainmenuepage.clickOnSignUpSignInLink();
        signuploginpage.assertLogInSectionIsDisplayed();
        signuploginpage.logIn(invalidEmail, invalidPassword);
        signuploginpage.clickOnLoginButton();
        signuploginpage.assertOnLoginErrorMessage();

    }

    @Test(description = "Login with valid email and password and logout")
    @Description("Login with valid email and password and logout")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithValidCredentialsAndLogout() {
        homepage.navigateToHomePage();
        homepage.assertOnHomePageTitle();
        mainmenuepage.clickOnSignUpSignInLink();
        signuploginpage.assertLogInSectionIsDisplayed();
        signuploginpage.logIn(validEmail, validPassword);
        signuploginpage.clickOnLoginButton();
        mainmenuepage.assertloggeedInWithUserIsDisplayed(validName);
        mainmenuepage.clickOnLogOutButton();
        signuploginpage.assertLogInSectionIsDisplayed();
    }


}
