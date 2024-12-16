package Automation.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


public class RegistrationTests extends TestsSetUp{

    //data from json file
    String password = dataRepo.getTestData("$.user1.password");
    String day= dataRepo.getTestData("$.user1.day");
    String month = dataRepo.getTestData("$.user1.month");
    String year = dataRepo.getTestData("$.user1.year");
    String name = dataRepo.getTestData("$.user1.name");
    String lastName = dataRepo.getTestData("$.user1.lastName");
    String email = dataRepo.getTestData("$.user1.email");
    String address1 = dataRepo.getTestData("$.user1.address1");
    String address2 = dataRepo.getTestData("$.user1.address2");
    String country= dataRepo.getTestData("$.user1.country");
    String company = dataRepo.getTestData("$.user1.company");
    String state = dataRepo.getTestData("$.user1.state");
    String city = dataRepo.getTestData("$.user1.city");
    String zipCodeValue =dataRepo.getTestData("$.user1.zipCodeValue");
    String mobileNumberValue=dataRepo.getTestData("$.user1.mobileNumberValue");

    @Test(description = "Register to Automation Exercise website")
    @Description("Register to Automation Exercise website")
    @Severity(SeverityLevel.CRITICAL)
    public void test_1_Exercise() {

        homepage.navigateToHomePage();
        homepage.assertOnHomePageTitle();
        mainmenuepage.clickOnSignUpSignInLink();
        signuploginpage.assertSignUpSignInpageIsOpedned();
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
}
