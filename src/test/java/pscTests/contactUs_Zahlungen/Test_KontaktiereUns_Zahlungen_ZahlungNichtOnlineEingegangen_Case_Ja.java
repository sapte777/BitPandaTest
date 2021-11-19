package pscTests.contactUs_Zahlungen;

import driver.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.psc.KontaktiereUns;
import utilities.CRTestUtils;
import utilities.listeners.RetryAnalyzer;

public class Test_KontaktiereUns_Zahlungen_ZahlungNichtOnlineEingegangen_Case_Ja extends BaseClass{
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
    public void contactUs_Zahlungen_ZahlungNichtOnlineEingegangen_Ja() {


//      Step 1: Select the dropdown menu from Contact us page
        KontaktiereUns.clickAlleCookiesakzeptieren();
        Assert.assertEquals(CRTestUtils.getPageTitle(), pageTitle);

//      Step 2: Select Zahlungen option from the dropdown menu on "How can we help you?" topic
        KontaktiereUns.clickZahlungenContactUs();
        KontaktiereUns.clickNextStepContactUs();
        worumAnfrageText= KontaktiereUns.getWorumAnfrageText();
        Assert.assertEquals(worumAnfrageText, worumAnfrage);

//      Step 3: Select "Ich habe versehentlich einen paysafecard Prepaid Code für unter 18-Jährige/Minderjährige gekauft" option from the
//      dropdown menu on "What is your enquiry about?" topic
        KontaktiereUns.clickZahlungNichtBeimOnlineShopEingegangen();
        KontaktiereUns.clickNextStepContactUs();
        bereitsPSCKontoText=KontaktiereUns.getBereitsPSCKontoText();
        Assert.assertEquals(bereitsPSCKontoText,bereitsPSCKontoTitle);

//      Step 4: Select "Nein" option from "Die Zahlung ist nicht beim Online-Shop eingegangen" topic
        KontaktiereUns.clickPSCCodeOnlineNichtAkzeptiert_Ja();
        KontaktiereUns.clickNextStepContactUs();
        erforderlicheInformationenText= KontaktiereUns.getErforderlicheInformationenText();
        Assert.assertEquals(erforderlicheInformationenText, erforderlicheInformationenTitle);

//      Step 4: Upload document file ans psc seriennnumber on "Required information" topic
        KontaktiereUns.insertEmailAddressErforderlicheInformationen(emailAddress);
        KontaktiereUns.uploadDocumentScreenshotFile(docFilePath1); // The method name must be changed
        KontaktiereUns.clickNextStepContactUs();
        deineFrageText= KontaktiereUns.getDeineFrageText();
        Assert.assertEquals(deineFrageText, deineFrageTitle);

//      Step 5: Insert email address and the question on the "Your question" topic

        KontaktiereUns.insertEmailAddress(emailAddress);
        KontaktiereUns.insertDeineFrageLoginIssuesDeineFrage(frage);
        KontaktiereUns.clickSubmit();
        
//      Step 6: Validate teh form was submitted
        vielenDankText= KontaktiereUns.getVielenDankText();
        Assert.assertEquals(vielenDankText,vielenDank);

    }

}
