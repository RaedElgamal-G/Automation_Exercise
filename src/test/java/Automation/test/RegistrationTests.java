package Automation.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utilitiles.JsonFileManager1;


public class RegistrationTests extends TestsSetUp{

    //reading json file (userNewdata)
    JsonFileManager1 newData = new JsonFileManager1("src/test/resources/userNewdata.json");
    JsonFileManager1 registeredData = new JsonFileManager1("src/test/resources/logInData.json");

    //data from json file (userNewdata)
    String password = newData.getTestData("$.user1.password");
    String day= newData.getTestData("$.user1.day");
    String month = newData.getTestData("$.user1.month");
    String year = newData.getTestData("$.user1.year");
    String name = newData.getTestData("$.user1.name");
    String lastName = newData.getTestData("$.user1.lastName");
    String email = newData.getTestData("$.user1.email");
    String address1 = newData.getTestData("$.user1.address1");
    String address2 = newData.getTestData("$.user1.address2");
    String country= newData.getTestData("$.user1.country");
    String company = newData.getTestData("$.user1.company");
    String state = newData.getTestData("$.user1.state");
    String city = newData.getTestData("$.user1.city");
    String zipCodeValue = newData.getTestData("$.user1.zipCodeValue");
    String mobileNumberValue= newData.getTestData("$.user1.mobileNumberValue");

    //data from json file (logInData)
    String existingEmail = registeredData.getTestData("$.registeredUser.email");

    @Test(description = "Register to Automation Exercise Website With New User")
        @Description("Register to Automation Exercise Website With New User")
        @Severity(SeverityLevel.CRITICAL)
    public void registerNewUser() {

        homepage.navigateToHomePage();
        homepage.assertOnHomePageTitle();
        mainmenuepage.clickOnSignUpSignInLink();
        signuploginpage.assertSignUpSectionIsDisplayed();
        signuploginpage.signUpWithNameAndEmail(name,email);
        signuploginpage.clickOnSignUpButton();
        registeraionpage.assertAccountInformationPageIsOpened();
        registeraionpage.enterAccountInformationData(password,day,month,year);
        registeraionpage.enterAddressInformation(name,lastName,company,address1,address2,country,state,city,zipCodeValue,mobileNumberValue);
        registeraionpage.clickOnCreateAccountButton();
        accountcreatedpage.assertAccountISCreated();
        accountcreatedpage.clickOnCreationContinueButton();
        mainmenuepage.assertloggeedInWithUserIsDisplayed(name);
        mainmenuepage.deleteAccount();
        deleteaccountpage.assertOnAccountDeletion();
        deleteaccountpage.clickOnDeletionContinueButton();

    }

    @Test(description = "Register to Automation Exercise Website With Existing Email")
        @Description("Register to Automation Exercise Website With Existing Email")
        @Severity(SeverityLevel.CRITICAL)
    public void registerUserWithExistingEmail() {

        homepage.navigateToHomePage();
        homepage.assertOnHomePageTitle();
        mainmenuepage.clickOnSignUpSignInLink();
        signuploginpage.assertSignUpSectionIsDisplayed();
        signuploginpage.signUpWithNameAndEmail(name,existingEmail);
        signuploginpage.clickOnSignUpButton();
        signuploginpage.assertOnExistingEmailErrorMessage();



    }
}
