package pscTests.contactUs_Aufladung;


import driver.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.psc.KontaktiereUns;
import utilities.CRTestUtils;
import utilities.listeners.RetryAnalyzer;

public class Test_KontaktiereUns_Aufladung_LadelimitErreicht extends BaseClass{
    private String deineFrageTitle ="Deine Frage";
    private String deineFrageText;

    @Test(description = "Contact us login fill form" , retryAnalyzer = RetryAnalyzer.class)
    public void contactUs_Aufladung_LadelimitErreicht() {


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

//      Step 3: Select "Ich habe mein Ladelimit erreicht" option from the dropdown menu
//      on "What is your enquiry about?" topic
        KontaktiereUns.clickAufladung_LadelimitErreichtFromContactUs();
        KontaktiereUns.clickNextStepContactUs();
        deineFrageText= KontaktiereUns.getDeineFrageText();
        Assert.assertEquals(deineFrageText, deineFrageTitle);


//      Step 4: Insert email address on "Your question" topic
        String emailAddress = "marius.grigorita@paysafe.com";
        KontaktiereUns.insertEmailAddress(emailAddress);
        String frage = "Where is the main page here?";
        KontaktiereUns.insertDeineFrageLoginIssuesDeineFrage(frage);
        KontaktiereUns.clickSubmit();

//      Step 5: Validate the form was submitted
        String vielenDankText = KontaktiereUns.getVielenDankText();
        String vielenDank = "Vielen Dank!";
        Assert.assertEquals(vielenDankText, vielenDank);
    }
}
