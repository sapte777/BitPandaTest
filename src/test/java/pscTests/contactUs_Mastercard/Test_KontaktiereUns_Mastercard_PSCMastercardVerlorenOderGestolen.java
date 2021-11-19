package pscTests.contactUs_Mastercard;

import driver.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.psc.KontaktiereUns;
import utilities.CRTestUtils;
import utilities.listeners.RetryAnalyzer;

public class Test_KontaktiereUns_Mastercard_PSCMastercardVerlorenOderGestolen extends BaseClass{
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
    private String docFilePath1="D://Udemy//Logo-Test_1.png";
    private String bereitsPSCKontoText;
    private String bereitsPSCKontoTitle ="Hast du bereits ein paysafecard Konto?";
    private String emailAddress = "marius.grigorita@paysafe.com";




    @Test(description = "Contact us login fill form" , retryAnalyzer = RetryAnalyzer.class)
    public void contactUs_Mastercard_PSCMastercardVerlorenOderGestolen() {


//      Step 1: Select the dropdown menu from Contact us page
        KontaktiereUns.clickAlleCookiesakzeptieren();
        Assert.assertEquals(CRTestUtils.getPageTitle(), pageTitle);

//      Step 2: Select Mastercard option from the dropdown menu on "How can we help you?" topic
        KontaktiereUns.clickPSCMastercadContactUs();
        KontaktiereUns.clickNextStepContactUs();
        worumAnfrageText=KontaktiereUns.getWorumAnfrageText();
        Assert.assertEquals(worumAnfrageText, worumAnfrage);

//      Step 3: Select "Meine paysafecard Mastercard ist verloren gegangen oder wurde gestohlen" option from the
//      dropdown menu on "What is your enquiry about?" topic
        KontaktiereUns.clickMastercard_PSCMastercarVerlorenOderGestohlen();
        KontaktiereUns.clickNextStepContactUs();
        deineFrageText= KontaktiereUns.getDeineFrageText();
        Assert.assertEquals(deineFrageText, deineFrageTitle);

//      Step 4: Insert email address and the question on the "Your question" topic
        KontaktiereUns.insertEmailAddress(emailAddress);
        KontaktiereUns.insertDeineFrageLoginIssuesDeineFrage(frage);
        KontaktiereUns.clickSubmit();
        
//      Step 5: Validate teh form was submitted
        vielenDankText= KontaktiereUns.getVielenDankText();
        Assert.assertEquals(vielenDankText,vielenDank);

    }

}
