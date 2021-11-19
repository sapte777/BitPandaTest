package pscTests.contactUs_Others;

import driver.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.psc.KontaktiereUns;
import utilities.CRTestUtils;
import utilities.listeners.RetryAnalyzer;

public class Test_KontaktiereUns_Others_FrageGuthaben_Ja extends BaseClass{
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
    private String serieNumber=CRTestUtils.getRandomNumberString(9);




    @Test(description = "Contact us login fill form" , retryAnalyzer = RetryAnalyzer.class)
    public void contactUs_Mastercard_FrageGuthaben_Ja() {


//      Step 1: Select the dropdown menu from Contact us page
        KontaktiereUns.clickAlleCookiesakzeptieren();
        Assert.assertEquals(CRTestUtils.getPageTitle(), pageTitle);

//      Step 2: Select "Others" option from the dropdown menu on "How can we help you?" topic
        KontaktiereUns.clickSonstigesContactUs();
        KontaktiereUns.clickNextStepContactUs();
        worumAnfrageText=KontaktiereUns.getWorumAnfrageText();
        Assert.assertEquals(worumAnfrageText, worumAnfrage);

//      Step 3: Select "Ich habe eine Frage zu meinem Guthaben" option from the
//      dropdown menu on "What is your enquiry about?" topic
        KontaktiereUns.clickOthers_FrageGuthaben();
        KontaktiereUns.clickNextStepContactUs();
        bereitsPSCKontoText=KontaktiereUns.getBereitsPSCKontoText();
        Assert.assertEquals(bereitsPSCKontoText,bereitsPSCKontoTitle);


//      Step 4: Select "Nein" option on "Do you already have a paysafecard account?" topic
        KontaktiereUns.clickJuniorPIN_Ja();
        KontaktiereUns.clickNextStepContactUs();
        erforderlicheInformationenText= KontaktiereUns.getErforderlicheInformationenText();
        Assert.assertEquals(erforderlicheInformationenText, erforderlicheInformationenTitle);

//      Step 5: Insert email address on "Required information" topic
        KontaktiereUns.insertEmailAddressErforderlicheInformationen(emailAddress);
        KontaktiereUns.clickNextStepContactUs();
        deineFrageText= KontaktiereUns.getDeineFrageText();
        Assert.assertEquals(deineFrageText, deineFrageTitle);

//      Step 6: Insert email address and the question on the "Your question" topic
        KontaktiereUns.insertEmailAddress(emailAddress);
        KontaktiereUns.insertDeineFrageLoginIssuesDeineFrage(frage);
        KontaktiereUns.clickSubmit();

//      Step 7: Validate the form was submitted
        vielenDankText= KontaktiereUns.getVielenDankText();
        Assert.assertEquals(vielenDankText,vielenDank);

    }

}
