package pscTests.contactUs_Registration;

import driver.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.psc.KontaktiereUns;
import utilities.CRTestUtils;
import utilities.listeners.RetryAnalyzer;

public class Test_KontaktiereUns_Registration_EnteringMyDetails extends BaseClass{
    private String phoneNUmber=CRTestUtils.getRandomNumberString(9);
    private String frage ="Where is the main page here?";
    private String vielenDankText;
    private String vielenDank="Vielen Dank!";
    private String pageTitle ="paysafecard Service-Team - Kontaktiere uns | German";
    private String worumAnfrage="Worum geht es bei deiner Anfrage?";
    private String worumAnfrageText;
    private String erforderlicheInformationenTitle="Erforderliche Informationen";
    private String erforderlicheInformationenText;
    private String deineFrageTitle ="Deine Frage";
    private String deineFrageText;
    private String docFilePath="D://Udemy//Logo-Test_2.png";

    @Test(description = "Contact us login fill form" , retryAnalyzer = RetryAnalyzer.class)
    public void contactUs_Registration_EnteringMyDetails() {


//      Step 1: Select the dropdown menu from Contact us page
        KontaktiereUns.clickAlleCookiesakzeptieren();
        Assert.assertEquals(CRTestUtils.getPageTitle(), pageTitle);

//      Step 2: Select Registration option from the dropdown menu on "How can we help you?" topic
        KontaktiereUns.clickRegistrationDetailsContactUs();
        KontaktiereUns.clickNextStepContactUs();
        worumAnfrageText= KontaktiereUns.getWorumAnfrageText();
        Assert.assertEquals(worumAnfrageText, worumAnfrage);

//      Step 3: Select "I have a question about entering my details" option from the dropdown menu on "What is your enquiry about?" topic
        KontaktiereUns.clickQuestionsEnteringMyDetailsFromContactUs();
        KontaktiereUns.clickNextStepContactUs();
        erforderlicheInformationenText= KontaktiereUns.getErforderlicheInformationenText();
        Assert.assertEquals(erforderlicheInformationenText, erforderlicheInformationenTitle);

//      Step 4: Upload a document file on "Required information" topic

        KontaktiereUns.uploadDocumentScreenshotFile(docFilePath);
        KontaktiereUns.clickNextStepContactUs();
        deineFrageText= KontaktiereUns.getDeineFrageText();
        Assert.assertEquals(deineFrageText, deineFrageTitle);

//      Step 5: Insert email address and the question on the "Your question" topic
        String emailAddress = "marius.grigorita@paysafe.com";
        KontaktiereUns.insertEmailAddress(emailAddress);
        KontaktiereUns.insertDeineFrageLoginIssuesDeineFrage(frage);
        KontaktiereUns.clickSubmit();
        
//      Step 6: Validate teh form was submitted
        vielenDankText= KontaktiereUns.getVielenDankText();
        Assert.assertEquals(vielenDankText,vielenDank);

    }

}
