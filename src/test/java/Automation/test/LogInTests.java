package Automation.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utilitiles.JsonFileManager1;

public class LogInTests extends TestsSetUp {

    //reading json file (logInData)
    JsonFileManager1 dataRepo = new JsonFileManager1("src/test/resources/logInData.json");

    //data from json file (logInData)
    String name = dataRepo.getTestData("$.user1.fitstName");
    String email = dataRepo.getTestData("$.user1.email");
    String password = dataRepo.getTestData("$.user1.password");

    @Test(description = "Login with valid email and password")
    @Description("Login with valid email and password")
    @Severity(SeverityLevel.CRITICAL)
    public void loginNewUser() {
        homepage.navigateToHomePage();
        homepage.assertOnHomePageTitle();
        mainmenuepage.clickOnSignUpSignInLink();
        signuploginpage.assertLogInSectionIsDisplayed();
        signuploginpage.logIn(email, password);
        signuploginpage.clickOnLoginButton();
        mainmenuepage.assertloggeedInWithUserIsDisplayed(name);

    }

}
