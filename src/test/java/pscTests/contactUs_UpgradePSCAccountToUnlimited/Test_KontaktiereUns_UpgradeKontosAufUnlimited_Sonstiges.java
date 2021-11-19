package pscTests.contactUs_UpgradePSCAccountToUnlimited;


import driver.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.psc.KontaktiereUns;
import utilities.CRTestUtils;
import utilities.listeners.RetryAnalyzer;

public class Test_KontaktiereUns_UpgradeKontosAufUnlimited_Sonstiges extends BaseClass{

    @Test(description = "Contact us login fill form" , retryAnalyzer = RetryAnalyzer.class)
    public void contactUs_UpgradeKontosAufUnlimited_Sonstiges() {


//      Step 1: Select the dropdown menu from Contact us page
        KontaktiereUns.clickAlleCookiesakzeptieren();
        String pageTitle = "paysafecard Service-Team - Kontaktiere uns | German";
        Assert.assertEquals(CRTestUtils.getPageTitle(), pageTitle);

//      Step 2: Select Upgrade Kontos Auf Unlimited option from the dropdown menu on "How can we help you?" topic
        KontaktiereUns.clickUpgradeEinesPSCKontosAufUnlimitedContactUs();
        KontaktiereUns.clickNextStepContactUs();
        String worumAnfrageText = KontaktiereUns.getWorumAnfrageText();
        String worumAnfrage = "Worum geht es bei deiner Anfrage?";
        Assert.assertEquals(worumAnfrageText, worumAnfrage);

//      Step 3: Select "Ich möchte ein Upgrade meines paysafecard Kontos durchführen" option from the dropdown menu
//      on "What is your enquiry about?" topic
        KontaktiereUns.clickUpgradeKontosAufUnlimited_Sonstiges_FromContactUs();
        KontaktiereUns.clickNextStepContactUs();
        String erforderlicheInformationenText = KontaktiereUns.getErforderlicheInformationenText();
        String erforderlicheInformationenTitle = "Erforderliche Informationen";
        Assert.assertEquals(erforderlicheInformationenText, erforderlicheInformationenTitle);

//      Step 4: Insert email address on "Required information" topic
        String emailAddress = "marius.grigorita@paysafe.com";
        KontaktiereUns.insertEmailAddressErforderlicheInformationen(emailAddress);
        KontaktiereUns.clickNextStepContactUs();
        String deineFrageText = KontaktiereUns.getDeineFrageText();
        String deineFrageTitle = "Deine Frage";
        Assert.assertEquals(deineFrageText, deineFrageTitle);

//      Step 5: Insert email address and the question on the "Your question" topic
        KontaktiereUns.insertEmailAddress(emailAddress);
        String frage = "Where is the main page here?";
        KontaktiereUns.insertDeineFrageLoginIssuesDeineFrage(frage);
        KontaktiereUns.clickSubmit();

//      Step 6: Validate teh form was submitted
        String vielenDankText = KontaktiereUns.getVielenDankText();
        String vielenDank = "Vielen Dank!";
        Assert.assertEquals(vielenDankText, vielenDank);

    }


}
