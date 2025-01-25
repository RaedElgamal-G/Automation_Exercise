package Automation.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utilitiles.JsonFileManager1;

public class ContactUsTests extends TestsSetUp {

    //reading json file (logInData)
    JsonFileManager1 dataRepo = new JsonFileManager1("src/test/resources/logInData.json");

    //data
    String name = dataRepo.getTestData("$.registeredUser.fitstName");
    String email = dataRepo.getTestData("$.registeredUser.email");
    String subject = "contact us test";
    String message = "contact us test";

    @Test(description = "Contact Us Form")
    @Description("Contact Us Form Test")
    @Severity(SeverityLevel.NORMAL)
    public void contactUsForm() {
        homepage.navigateToHomePage();
        homepage.assertOnHomePageTitle();
        mainmenuepage.clickOnContactUsLink();
        contactuspage.assertOnGetInTouchTitle("GET IN TOUCH");
        contactuspage.fillContactUsForm(name, email, subject, message);
        contactuspage.clickOnSubmitButton();
        contactuspage.clickOnOKButton();
        mainmenuepage.clickOnHomeButton();
        homepage.assertOnHomePageTitle();
    }

}
