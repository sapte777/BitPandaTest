package pscTests.contactUs_Aufladung;


import driver.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.psc.KontaktiereUns;
import utilities.CRTestUtils;
import utilities.listeners.RetryAnalyzer;

public class Test_KontaktiereUns_Aufladung_KeinGuthabenAufladen extends BaseClass{

    private String docFilePath="D://Udemy//Logo-Test_2.png";
    private String deineFrageTitle ="Deine Frage";
    private String deineFrageText;
    private String erforderlicheInformationenTitle="Erforderliche Informationen";
    private String erforderlicheInformationenText;

    @Test(description = "Contact us login fill form" , retryAnalyzer = RetryAnalyzer.class)
    public void contactUs_Aufladung_KeinGuthabenAufladen() {


//      Step 1: Select the dropdown menu from Contact us page
        KontaktiereUns.clickAlleCookiesakzeptieren();
        String pageTitle = "paysafecard Service-Team - Kontaktiere uns | German";
        Assert.assertEquals(CRTestUtils.getPageTitle(), pageTitle);

//      Step 2: Select Aufladung option from the dropdown menu on "How can we help you?" topic
        KontaktiereUns.clickAufladungContactUs();
        KontaktiereUns.clickNextStepContactUs();
        String worumAnfrageText = KontaktiereUns.getWorumAnfrageText();
        String worumAnfrage = "Worum geht es bei deiner Anfrage?";
        Assert.assertEquals(worumAnfrageText, worumAnfrage);


//      Step 3: Select Ich kann kein Guthaben aufladen from "Worum geht es bei deiner Anfrage?" topic
        KontaktiereUns.clickAufladung_KeinGuthabenAufladen();
        KontaktiereUns.clickColapseConfirmMyMobileNumberInfo(); // The method name must be changed
        KontaktiereUns.clickNextStepContactUs();

        erforderlicheInformationenText= KontaktiereUns.getErforderlicheInformationenText();
        Assert.assertEquals(erforderlicheInformationenText, erforderlicheInformationenTitle);

//      Step 4: Upload a document file on "Required information" topic
        KontaktiereUns.uploadVoucherFile(docFilePath);
        KontaktiereUns.clickNextStepContactUs();
        deineFrageText= KontaktiereUns.getDeineFrageText();
        Assert.assertEquals(deineFrageText, deineFrageTitle);


//      Step 5: Insert email address and the question on "Your question" topic
        String emailAddress = "marius.grigorita@paysafe.com";
        KontaktiereUns.insertEmailAddress(emailAddress);
        String frage = "Where is the main page here?";
        KontaktiereUns.insertDeineFrageLoginIssuesDeineFrage(frage);
        KontaktiereUns.clickSubmit();

//      Step 6: Validate the form was submitted
        String vielenDankText = KontaktiereUns.getVielenDankText();
        String vielenDank = "Vielen Dank!";
        Assert.assertEquals(vielenDankText, vielenDank);
    }
}
