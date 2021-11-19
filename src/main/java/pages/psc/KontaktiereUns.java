package pages.psc;

import driver.WebDriverThreadManager;
import logger.Tacitus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.CRTestUtils;


public class KontaktiereUns {

    public static WebDriver driver;

    @FindBy(id = "onetrust-accept-btn-handler")
    private static WebElement acceptCookiesWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-type-select")
    private static WebElement kontaktiereUnsDropDownWebElem;

    @FindBy(id = "nextForm")
    private static WebElement nextFormWebElem;

    @FindBy(xpath = " //h2[contains(text(),'Worum geht es bei deiner Anfrage?')]")
    private static WebElement worumAnfrageWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-registration-issue-select")
    private static WebElement registrationIssueDropDownWebElem;

//    @FindBy(id = "b2CForm-pscMastercard-143481-account-email")
//    private static WebElement loginIssueEmailAddressWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-phone-number")
    private static WebElement registrationPhoneNumberWebElem;

    @FindBy(id = "item-title2")
    private static WebElement colapseAnmeldendatenVergessenWebElem;

    @FindBy(xpath = "//h2[contains(text(),'Erforderliche Informationen')]")
    private static WebElement erforderlicheInfWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-account-email")
    private static WebElement emailAddres_InputWebELement;

    @FindBy(id = "b2CForm-pscMastercard-143481-email-1")
    private static WebElement emailAddresDeineFrageWebELement;

    @FindBy(xpath = "//h2[contains(text(),'Deine Frage')]")
    private static WebElement deineFrageTextWebELem;

    @FindBy(id = "b2CForm-pscMastercard-143481-textarea-1")
    private static WebElement deineFrageWebELement;

    @FindBy(id = "submitForm")
    private static WebElement submitButtonWebElem;

    @FindBy(xpath = "//h2[contains(text(),'Vielen Dank!')]")
    private static WebElement vielenDankWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-screenshot")
    private static WebElement uploadScreenshotWebElement;

    @FindBy(id = "b2CForm-pscMastercard-143481-voucherCopy")
    private static WebElement uploadFile_VoucherWebElement;

    @FindBy(id = "b2CForm-pscMastercard-143481-identityCard")
    private static WebElement uploadFile_IdentityCardWebElement;

    @FindBy(id="b2CForm-pscMastercard-143481-identificationDocumentOptional")
    private static WebElement uploadFile_IdentityCardOptionalWebElement;

    @FindBy(id = "b2CForm-pscMastercard-143481-login-issue-select")
    private static WebElement loginIssueDropDownWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-upgrade-issue-select")
    private static WebElement upgradeIssueSelectWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-topup-issue-select")
    private static WebElement aufladungDropDownWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-payments-issue-select")
    private static WebElement zahlungenDropDownWebElem;

    @FindBy(id="b2CForm-pscMastercard-143481-product-select")
    private static WebElement junioPINDropDownWebElem;

    @FindBy(xpath = "//h2[contains(text(),'Hast du bereits ein paysafecard Konto?')]")
    private static WebElement bereitsPSCKOntoWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-pinSerial_mandatory")
    private static WebElement serieNumberInputWebElem;

    @FindBy(id= "b2CForm-pscMastercard-143481-mastercard-issue-select")
    private static WebElement mastercardIssueDropDownWebElem;

    @FindBy(xpath = "//h2[contains(text(),'Wobei können wir dir helfen?')]")
    private static WebElement wobeiKonnerWrDirWebElem;

    @FindBy (id = "b2CForm-pscMastercard-143481-por")
    private static WebElement uploadMAstercardDocWeBElem;

    @FindBy (id="b2CForm-pscMastercard-143481-pin4digits")
    private static WebElement pin4digitsInputWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-other-issue-select")
    private static WebElement otherIssueDropDownWebElem;

    @FindBy(id = "b2CForm-pscMastercard-143481-pinSerial_optional")
    private static WebElement serieNumberOptionalInputWebElem;

//    ----------------------------------------------------------------------

    public static void init() {
        driver = WebDriverThreadManager.getDriver();
        PageFactory.initElements(driver, KontaktiereUns.class);
    }

//   ----------------------------------------------------------------------

//    ************ Login_ForgotLoginDetails methods ***********


    /**
     * This method is used to click on "Alle Cookies akzeptieren" button
     */
    public static void clickAlleCookiesakzeptieren() {
        Tacitus.getInstance().log("Finding \"Alle Cookies akzeptieren\" WebElement");
        try {
            acceptCookiesWebElem.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Alle Cookies akzeptieren\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Login" option from the dropdown  "Contact Us page"
     */
    public static void clickLoginDetailsContactUs() {
        Tacitus.getInstance().log("Finding \"Login\" WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            Select objSelect = new Select(kontaktiereUnsDropDownWebElem);
            objSelect.selectByVisibleText("Login");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Login\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Registration" option from the dropdown  "Contact Us page"
     */
    public static void clickRegistrationDetailsContactUs() {
        Tacitus.getInstance().log("Finding \"Registration\" WebElement");
        try {
            Select objSelect = new Select(kontaktiereUnsDropDownWebElem);
            objSelect.selectByVisibleText("Registrierung");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Registration\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Upgrade eines paysafecard Kontos auf Unlimited" option from the dropdown  "Contact Us page"
     */
    public static void clickUpgradeEinesPSCKontosAufUnlimitedContactUs() {
        Tacitus.getInstance().log("Finding \"Upgrade eines paysafecard Kontos auf Unlimited\" WebElement");
        try {
            Select objSelect = new Select(kontaktiereUnsDropDownWebElem);
            objSelect.selectByVisibleText("Upgrade eines paysafecard Kontos auf Unlimited");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Upgrade eines paysafecard Kontos auf Unlimited\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Aufladung" option from the dropdown  "Contact Us page"
     */
    public static void clickAufladungContactUs() {
        Tacitus.getInstance().log("Finding \"Aufladung\" WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            Select objSelect = new Select(kontaktiereUnsDropDownWebElem);
            objSelect.selectByVisibleText("Aufladung");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Aufladung\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Zahlungen" option from the dropdown  "Contact Us page"
     */
    public static void clickZahlungenContactUs() {
        Tacitus.getInstance().log("Finding \"Zahlungen\" WebElement");
        try {
            Select objSelect = new Select(kontaktiereUnsDropDownWebElem);
            objSelect.selectByVisibleText("Zahlungen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Zahlungen\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "PSC Mastercad" option from the dropdown  "Contact Us page"
     */
    public static void clickPSCMastercadContactUs() {
        Tacitus.getInstance().log("Finding \"PSC Mastercad\" WebElement");
        try {
            Select objSelect = new Select(kontaktiereUnsDropDownWebElem);
            objSelect.selectByVisibleText("paysafecard Mastercard");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"PSC Mastercad\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Sonstiges" option from the dropdown  "Contact Us page"
     */
    public static void clickSonstigesContactUs() {
        Tacitus.getInstance().log("Finding \"Sonstiges\" WebElement");
        try {
            Select objSelect = new Select(kontaktiereUnsDropDownWebElem);
            objSelect.selectByVisibleText("Sonstiges");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Sonstiges\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to click on "Nächster Schritt " button from "Contact Us page"
     */
    public static void clickNextStepContactUs() {
        Tacitus.getInstance().log("Finding \"Nächster Schritt\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            CRTestUtils.jsClick(nextFormWebElem);

        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Nächster Schritt\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to validate the presence the "Worum geht es bei deiner Anfrage?" topic inside od Contact Us
     * page form.
     */

    public static String getWorumAnfrageText() {
        Tacitus.getInstance().log("Finding \"Worum Anfrage\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            return worumAnfrageWebElem.getText();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Worum Anfrage\"  WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to collapse the details about  "I want to confirm my mobile number" topic
     */
    public static void clickColapseConfirmMyMobileNumberInfo() {
        Tacitus.getInstance().log("Finding \"I want to confirm my mobile number\" WebElement");
        try {
            colapseAnmeldendatenVergessenWebElem.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"I want to confirm my mobile number\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "I want to confirm my mobile number" option from the dropdown menu of
     * "Contact Us page" / registration option
     */
    public static void clickConfirmMobileNumberFromContactUs() {
        Tacitus.getInstance().log("Finding \"I want to confirm my mobile number\" WebElement");
        try {
            Select objSelect = new Select(registrationIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich möchte meine Handynummer bestätigen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"I want to confirm my mobile number\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "I want to confirm my email address" option from the dropdown menu of
     * "Contact Us page" / registration option
     */
    public static void clickConfirmEmailAddressFromContactUs() {
        Tacitus.getInstance().log("Finding \"I want to confirm my email address\" WebElement");
        try {
            Select objSelect = new Select(registrationIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich möchte meine E-Mail Adresse bestätigen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"I want to confirm my email address\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "I have a question about uploading my documents" option from the dropdown menu of
     * "Contact Us page" / registration option
     */
    public static void clickQuestionsUploadMyDocumentsFromContactUs() {
        Tacitus.getInstance().log("Finding \"I have a question about uploading my documents\" WebElement");
        try {
            Select objSelect = new Select(registrationIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe eine Frage zum Hochladen meiner Dokumente");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"I have a question about uploading my documents\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Others" option from the dropdown menu of
     * "Contact Us page" / Registration option
     */
    public static void clickRegistrationOthersFromContactUs() {
        Tacitus.getInstance().log("Finding \"Others\" WebElement");
        try {
            Select objSelect = new Select(registrationIssueDropDownWebElem);
            objSelect.selectByVisibleText("Sonstiges");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Others\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "I have a question about entering my details" option from the dropdown menu of
     * "Contact Us page" / registration option
     */
    public static void clickQuestionsEnteringMyDetailsFromContactUs() {
        Tacitus.getInstance().log("Finding \"I have a question about entering my details\" WebElement");
        try {
            Select objSelect = new Select(registrationIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe eine Frage zur Eingabe meiner Daten");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"I have a question about entering my details\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to validate the presence the "Erforderliche Informationen" topic inside od Contact Us
     * page form.
     */

    public static String getErforderlicheInformationenText() {
        Tacitus.getInstance().log("Finding \"Erforderliche Informationen\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            return erforderlicheInfWebElem.getText();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Erforderliche Informationen\"  WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to insert text into "Phone number" input box from Registration Issues topic of Contact Us page
     */
    public static void insertPhoneNumberRegistration(String phoneNumber) {
        Tacitus.getInstance().log("Finding \"Phone number\" WebElement");
        try {
            registrationPhoneNumberWebElem.click();
            registrationPhoneNumberWebElem.sendKeys(phoneNumber);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Phone number\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to upload a document into "Choose file" input box from Registration Issues topic of Contact Us page
     */
    public static void uploadDocumentScreenshotFile(String docFilePath) {
        Tacitus.getInstance().log("Finding \"Choose file\" WebElement");
        try {
            uploadScreenshotWebElement.sendKeys(docFilePath);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Choose file\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to upload a document into "Choose file" input box from Aufladung topic of Contact Us page
     */
    public static void uploadVoucherFile(String docFilePath) {
        Tacitus.getInstance().log("Finding \"Choose file\" WebElement");
        try {
            uploadFile_VoucherWebElement.sendKeys(docFilePath);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Choose file\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to upload a document into "Choose file" input box from Junior PIN / Nein topic of Contact Us page
     */
    public static void uploadIdentityCardFile(String docFilePath) {
        Tacitus.getInstance().log("Finding \"Choose file\" WebElement");
        try {
            uploadFile_IdentityCardWebElement.sendKeys(docFilePath);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Choose file\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to upload a document into "Choose file" input box from Junior PIN / Nein topic of Contact Us page
     */
    public static void uploadIdentityCardOptionalFile(String docFilePath) {
        Tacitus.getInstance().log("Finding \"Choose file\" WebElement");
        try {
            uploadFile_IdentityCardOptionalWebElement.sendKeys(docFilePath);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Choose file\" WebElement", ex);
            throw ex;
        }
    }



    /**
     * This method is used to validate the presence of "Deine Frage" topic from Contact Us page
     */

    public static String getDeineFrageText() {
        Tacitus.getInstance().log("Finding \"Deine Frage\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            return deineFrageTextWebELem.getText();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Deine Frage\"  WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to insert text into "Email Address" input box from Login Issues/ Deine Frage topic of Contact Us page
     */
    public static void insertEmailAddress(String emailAddress) {
        Tacitus.getInstance().log("Finding \"Email Address deine Frage\" WebElement");
        try {
            emailAddresDeineFrageWebELement.click();
            emailAddresDeineFrageWebELement.sendKeys(emailAddress);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Email Address deine Frage\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to insert text into "Email Address" input box from Login Issues/ Erforderliche Informationen topic of Contact Us page
     */
    public static void insertEmailAddressErforderlicheInformationen(String emailAddress) {
        Tacitus.getInstance().log("Finding \"Email Address Erforderliche Informationen\" WebElement");
        try {
            emailAddres_InputWebELement.click();
            emailAddres_InputWebELement.sendKeys(emailAddress);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Email Address Erforderliche Informationen\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to insert text into "Deine Frage" input box from Login Issues/ Deine Frage topic of Contact Us page
     */
    public static void insertDeineFrageLoginIssuesDeineFrage(String frage) {
        Tacitus.getInstance().log("Finding \"Deine Frage\" WebElement");
        try {
            deineFrageWebELement.click();
            deineFrageWebELement.sendKeys(frage);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Deine Frage\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to click on "Submit" button
     */
    public static void clickSubmit() {
        Tacitus.getInstance().log("Finding \"Submit\" WebElement");
        try {
            CRTestUtils.jsClick(submitButtonWebElem);
//            submitButtonWebElem.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Submit\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to validate the presence of section where the user submitted a form
     */

    public static String getVielenDankText() {
        Tacitus.getInstance().log("Finding \"Vielen Dank\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            return vielenDankWebElem.getText();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Vielen Dank\"  WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "I have forgotten my login details" option from the dropdown menu of
     * "Contact Us page" / login option
     */
    public static void clickForgotLoginDetailsFromContactUs() {
        Tacitus.getInstance().log("Finding \"I have forgotten my login details\" WebElement");
        try {
            Select objSelect = new Select(loginIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe meine Anmeldedaten vergessen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"I have forgotten my login details\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "I didn't receive the notification" option from the dropdown menu of
     * "Contact Us page" / login option
     */
    public static void clickDidNotReceiveNotifFromContactUs() {
        Tacitus.getInstance().log("Finding \"I didn't receive the notification\" WebElement");
        try {
            Select objSelect = new Select(loginIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe die Benachrichtigung nicht erhalten");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"I didn't receive the notification\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "I didn't receive the mail with one-time code" option from the dropdown menu of
     * "Contact Us page" / login option
     */
    public static void clickDidNotReceiveOneTimeCodeFromContactUs() {
        Tacitus.getInstance().log("Finding \"I didn't receive the mail with one-time code\" WebElement");
        try {
            Select objSelect = new Select(loginIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe die E-Mail mit dem einmaligen Code nicht erhalten");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"I didn't receive the mail with one-time code\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "I would like to update my paysafecard account" option from the dropdown menu of
     * "Contact Us page" /  Upgrade eines paysafecard Kontos auf Unlimited option
     */
    public static void clickUpgradePSCKontosDurchführenFromContactUs() {
        Tacitus.getInstance().log("Finding \"Ich möchte ein Upgrade meines paysafecard Kontos durchführen\" WebElement");
        try {
            Select objSelect = new Select(upgradeIssueSelectWebElem);
            objSelect.selectByVisibleText("Ich möchte ein Upgrade meines paysafecard Kontos durchführen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich möchte ein Upgrade meines paysafecard Kontos durchführen\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Sonstiges" option from the dropdown menu of
     * "Contact Us page" /  Upgrade eines paysafecard Kontos auf Unlimited option
     */
    public static void clickUpgradeKontosAufUnlimited_Sonstiges_FromContactUs() {
        Tacitus.getInstance().log("Finding \"Sonstiges\" WebElement");
        try {
            Select objSelect = new Select(upgradeIssueSelectWebElem);
            objSelect.selectByVisibleText("Sonstiges");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Sonstiges\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Ich habe mein Ladelimit erreicht" option from the dropdown menu of
     * "Contact Us page" /  Aufladung option
     */
    public static void clickAufladung_LadelimitErreichtFromContactUs() {
        Tacitus.getInstance().log("Finding \"Ich habe mein Ladelimit erreicht\" WebElement");
        try {
            Select objSelect = new Select(aufladungDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe mein Ladelimit erreicht");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich habe mein Ladelimit erreicht\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Ich kann kein Guthaben aufladen" option from the dropdown menu of
     * "Contact Us page" /  Aufladung option
     */
    public static void clickAufladung_KeinGuthabenAufladen() {
        Tacitus.getInstance().log("Finding \"Ich kann kein Guthaben aufladen\" WebElement");
        try {
            Select objSelect = new Select(aufladungDropDownWebElem);
            objSelect.selectByVisibleText("Ich kann kein Guthaben aufladen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich kann kein Guthaben aufladen\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Sonstiges" option from the dropdown menu of
     * "Contact Us page" /  Aufladung option
     */
    public static void clickAufladung_Sonstiges() {
        Tacitus.getInstance().log("Finding \"Sonstiges\" WebElement");
        try {
            Select objSelect = new Select(aufladungDropDownWebElem);
            objSelect.selectByVisibleText("Sonstiges");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Sonstiges\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Others" option from the dropdown menu of
     * "Contact Us page" / login option
     */
    public static void clickLoginOthersFromContactUs() {
        Tacitus.getInstance().log("Finding \"Others\" WebElement");
        try {
            Select objSelect = new Select(loginIssueDropDownWebElem);
            objSelect.selectByVisibleText("Sonstiges");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Others\" WebElement", ex);
            throw ex;
        }
    }



    /**
     * This method is used to click on "Anmeldendaten vergessen" button
     */
    public static void clickColapseAnmeldendatenVorgessen() {
        Tacitus.getInstance().log("Finding \"Anmeldendaten Vergessen\" WebElement");
        try {
            colapseAnmeldendatenVergessenWebElem.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Anmeldendaten Vergessen\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Cannot read all 16 digits PSC prepaid code" option from the dropdown menu of
     * "Contact Us page" /  Zahlungen option
     */
    public static void clickZiffern16PSCCodesKannNichtLesen() {
        Tacitus.getInstance().log("Finding \"Ich kann nicht alle Ziffern des 16-stelligen paysafecard Prepaid Codes" +
                " lesen\" WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByVisibleText("Ich kann nicht alle Ziffern des 16-stelligen paysafecard Prepaid Codes" +
                    " lesen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich kann nicht alle Ziffern " +
                    "des 16-stelligen paysafecard Prepaid Codes lesen\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "The credit in the PSC  prepaid code has already been used" option from the
     * dropdown menu of
     * "Contact Us page" /  Zahlungen option
     */
    public static void clickGuthabenPSCCodesWurdeBereitsVerwendet() {
        Tacitus.getInstance().log("Finding \"Das Guthaben des paysafecard Prepaid Codes wurde bereits verwendet\" " +
                "WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByVisibleText("Das Guthaben des paysafecard Prepaid Codes wurde bereits verwendet");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Das Guthaben des paysafecard Prepaid Codes" +
                    " wurde bereits verwendet\" WebElement", ex);
            throw ex;
        }

    }


    /**
     * This method is used to select the "The credit in the PSC  prepaid code is invalid" option from the dropdown
     * menu of
     * "Contact Us page" /  Zahlungen option
     */
    public static void clickPSCCodeIstUngultig() {
        Tacitus.getInstance().log("Finding \"paysafecard Prepaid Code ist ungültig\" WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByValue("State I");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"paysafecard Prepaid Code ist ungültig\"" +
                    " WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "I accidentally bought a paysafecard prepaid code for under 18s / minors"
     * option from the dropdown menu of
     * "Contact Us page" /  Zahlungen option
     */
    public static void clickPSCCodeUnter18JGekauft() {
        Tacitus.getInstance().log("Finding \"Junior PIN\" WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByValue("Junior PIN");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Junior PIN\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Paysafecard prepaid code has been blocked" option from the dropdown menu of
     * "Contact Us page" /  Zahlungen option
     */
    public static void clickPSCCodeWurdeGesperrt() {
        Tacitus.getInstance().log("Finding \"paysafecard locked\" WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByValue("paysafecard locked");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"paysafecard locked\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Product not accepted at a certain webshop" option from the dropdown menu of
     * "Contact Us page" /  Zahlungen option
     */
    public static void clickPSCCodeOnlineShopNichtAkzeptiert() {
        Tacitus.getInstance().log("Finding \"Product not accepted at a certain webshop\" WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByValue("Product not accepted at a certain webshop");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Product not accepted at a certain" +
                    " webshop\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Amount is not credited at the webshop's account" option from the dropdown
     * menu of
     * "Contact Us page" /  Zahlungen option
     */
    public static void clickZahlungNichtBeimOnlineShopEingegangen() {
        Tacitus.getInstance().log("Finding \"Amount is not credited at the webshop's account\" WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByValue("Amount is not credited at the webshop__s account");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Amount is not credited at the webshop's" +
                    " account\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Ich habe eine Frage zum Empfang von Geld von einem Online-Shop" option from
     * the dropdown menu of
     * "Contact Us page" /  Zahlungen option
     */
    public static void clickFrageVonGeldVonEinemOnlineShop() {
        Tacitus.getInstance().log("Finding \"Ich habe eine Frage zum Empfang von Geld von einem Online-Shop\" WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByValue("Payout");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich habe eine Frage zum Empfang von Geld " +
                    "von einem Online-Shop\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Ich habe eine Fehlermeldung erhalten, als ich eine Zahlung vornehmen wollte"
     * option from the dropdown menu of "Contact Us page" /  Zahlungen option
     */
    public static void clickFehlermeldungErhaltenWennZahlungVornehmenWollte() {
        Tacitus.getInstance().log("Finding \"Ich habe eine Fehlermeldung erhalten, als ich eine Zahlung vornehmen " +
                "wollte\" WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByValue("Error message regarding the payment");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich habe eine Fehlermeldung erhalten, als" +
                    " ich eine Zahlung vornehmen wollte\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Sonstiges" option from the dropdown menu of "Contact Us page"/ Zahlungen
     * option
     */
    public static void clickZahlungen_Sonstiges() {
        Tacitus.getInstance().log("Finding \"Sonstiges\" WebElement");
        try {
            Select objSelect = new Select(zahlungenDropDownWebElem);
            objSelect.selectByVisibleText("Sonstiges");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Sonstiges\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Nein" option from the dropdown menu of "Contact Us page"/ Zahlungen /
     * Junior PIN
     * option
     */
    public static void clickJuniorPIN_Nein() {
        Tacitus.getInstance().log("Finding \"Junior PIN nein\" WebElement");
        try {
            Select objSelect = new Select(junioPINDropDownWebElem);
            objSelect.selectByVisibleText("Nein");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Junior PIN nein\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Ja" option from the dropdown menu of "Contact Us page"/ Zahlungen /
     * Junior PIN
     * option
     */
    public static void clickJuniorPIN_Ja() {
        Tacitus.getInstance().log("Finding \"Junior PIN Ja\" WebElement");
        try {
            Select objSelect = new Select(junioPINDropDownWebElem);
            objSelect.selectByVisibleText("Ja");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Junior PIN Ja\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Nein" option from the dropdown menu of "Contact Us page"/ Zahlungen /
     * paysafecard Prepaid Code wird in einem Online-Shop nicht akzeptiert
     * option
     */
    public static void clickPSCCodeOnlineNichtAkzeptiert_Nein() {
        Tacitus.getInstance().log("Finding \"Prepaid Code wird in einem Online-Shop nicht akzeptiert\" WebElement");
        try {
            Select objSelect = new Select(junioPINDropDownWebElem);
            objSelect.selectByVisibleText("Nein");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Prepaid Code wird in einem Online-Shop nicht akzeptiert\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Ja" option from the dropdown menu of "Contact Us page"/ Zahlungen /
     * paysafecard Prepaid Code wird in einem Online-Shop nicht akzeptiert
     * option
     */
    public static void clickPSCCodeOnlineNichtAkzeptiert_Ja() {
        Tacitus.getInstance().log("Finding \"Prepaid Code wird in einem Online-Shop nicht akzeptiert\" WebElement");
        try {
            Select objSelect = new Select(junioPINDropDownWebElem);
            objSelect.selectByVisibleText("Ja");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Prepaid Code wird in einem Online-Shop nicht akzeptiert\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to validate the presence the "Hast du bereits ein paysafecard Konto?" topic inside od Contact Us
     * page form / Zahlungen
     */

    public static String getBereitsPSCKontoText() {
        Tacitus.getInstance().log("Finding \"Hast du bereits ein paysafecard Konto?\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            return bereitsPSCKOntoWebElem.getText();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Hast du bereits ein paysafecard Konto?\"  WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to insert text into "Serie number" input box from Zahlungen topic of Contact Us page
     */
    public static void insertSerieNumberZahlungen(String serieNumber) {
        Tacitus.getInstance().log("Finding \"Phone number\" WebElement");
        try {
            serieNumberInputWebElem.click();
            serieNumberInputWebElem.sendKeys(serieNumber);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Phone number\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Ich habe eine Frage zum Bestellvorgang" option from the dropdown menu of "Contact Us page"/ Mastercard
     * option
     */
    public static void clickMastercard_FrageBestellvorgang() {
        Tacitus.getInstance().log("Finding \"Ich habe eine Frage zum Bestellvorgang\" WebElement");
        try {
            Select objSelect = new Select(mastercardIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe eine Frage zum Bestellvorgang");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich habe eine Frage zum Bestellvorgang\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Ich habe meine paysafecard Mastercard nicht erhalten" option from the dropdown menu of "Contact Us page"/ Mastercard
     * option
     */
    public static void clickMastercard_PSCMastercardNichtErhalten() {
        Tacitus.getInstance().log("Finding \"Ich habe meine paysafecard Mastercard nicht erhalten\" WebElement");
        try {
            Select objSelect = new Select(mastercardIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe meine paysafecard Mastercard nicht erhalten");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich habe meine paysafecard Mastercard nicht erhalten\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Ich habe die PIN für meine paysafecard Mastercard vergessen" option from the dropdown menu of "Contact Us page"/ Mastercard
     * option
     */
    public static void clickMastercard_PINMastercardVergessen() {
        Tacitus.getInstance().log("Finding \"Ich habe die PIN für meine paysafecard Mastercard vergessen\" WebElement");
        try {
            Select objSelect = new Select(mastercardIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe die PIN für meine paysafecard Mastercard vergessen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich habe die PIN für meine paysafecard Mastercard vergessen\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Ich möchte meine paysafecard Mastercard kündigen" option from the dropdown menu of "Contact Us page"/ Mastercard
     * option
     */
    public static void clickMastercard_PSCMastercardkundigen() {
        Tacitus.getInstance().log("Finding \"Ich möchte meine paysafecard Mastercard kündigen\" WebElement");
        try {
            Select objSelect = new Select(mastercardIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich möchte meine paysafecard Mastercard kündigen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich möchte meine paysafecard Mastercard kündigen\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Ich kann meine paysafecard Mastercard nicht aktivieren" option from the dropdown menu of "Contact Us page"/ Mastercard
     * option
     */
    public static void clickMastercard_PSCMastercardNichtAktivieren() {
        Tacitus.getInstance().log("Finding \"Ich kann meine paysafecard Mastercard nicht aktivieren\" WebElement");
        try {
            Select objSelect = new Select(mastercardIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich kann meine paysafecard Mastercard nicht aktivieren");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich kann meine paysafecard Mastercard nicht aktivierenn\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Meine paysafecard Mastercard ist verloren gegangen oder wurde gestohlen" option from the dropdown menu of "Contact Us page"/ Mastercard
     * option
     */
    public static void clickMastercard_PSCMastercarVerlorenOderGestohlen() {
        Tacitus.getInstance().log("Finding \"Meine paysafecard Mastercard ist verloren gegangen oder wurde gestohlen\" WebElement");
        try {
            Select objSelect = new Select(mastercardIssueDropDownWebElem);
            objSelect.selectByVisibleText("Meine paysafecard Mastercard ist verloren gegangen oder wurde gestohlen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Meine paysafecard Mastercard ist verloren gegangen oder wurde gestohlen\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Sonstiges" option from the dropdown menu of "Contact Us page"/ Mastercard
     * option
     */
    public static void clickMastercard_Sonstiges() {
        Tacitus.getInstance().log("Finding \"Sonstiges\" WebElement");
        try {
            Select objSelect = new Select(mastercardIssueDropDownWebElem);
            objSelect.selectByVisibleText("Sonstiges");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Sonstiges\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to validate the presence the "Hast du bereits ein paysafecard Konto?" topic inside od Contact Us
     * page form / Zahlungen
     */

    public static String getWobeiKonnenWirDirHelfenText() {
        Tacitus.getInstance().log("Finding \"Wobei können wir dir helfen?\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            return wobeiKonnerWrDirWebElem.getText();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Wobei können wir dir helfen?\"  WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to upload a document into "Choose file" input box from Mastercard / Card not received topic of Contact Us page
     */
    public static void uploadMastercardDocFile(String docFilePath) {
        Tacitus.getInstance().log("Finding \"Choose file doc mastercard\" WebElement");
        try {
            uploadMAstercardDocWeBElem.sendKeys(docFilePath);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Choose file doc mastercard\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to insert text into "4 digits PIN" input box from Mastercard topic of Contact Us page
     */
    public static void insert4digitsPINMastercard(String pin) {
        Tacitus.getInstance().log("Finding \"4 digits PIN\" WebElement");
        try {
            pin4digitsInputWebElem.click();
            pin4digitsInputWebElem.sendKeys(pin);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"4 digits PIN\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Ich habe eine Frage zu meinem Guthaben" option from the dropdown menu of
     * "Contact Us page" /  Others option
     */
    public static void clickOthers_FrageGuthaben() {
        Tacitus.getInstance().log("Finding \"Ich habe eine Frage zu meinem Guthaben\" WebElement");
        try {
            Select objSelect = new Select(otherIssueDropDownWebElem);
            objSelect.selectByVisibleText("Ich habe eine Frage zu meinem Guthaben");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich habe eine Frage zu meinem Guthaben\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "paysafecard Prepaid Code ist verloren gegangen oder wurde gestohlen" option from the dropdown menu of
     * "Contact Us page" /  Others option
     */
    public static void clickOthers_PrepaidCodeIstVerlorenOderGestohlen() {
        Tacitus.getInstance().log("Finding \"paysafecard Prepaid Code ist verloren gegangen oder wurde gestohlen\" WebElement");
        try {
            Select objSelect = new Select(otherIssueDropDownWebElem);
            objSelect.selectByVisibleText("paysafecard Prepaid Code ist verloren gegangen oder wurde gestohlen");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"paysafecard Prepaid Code ist verloren gegangen oder wurde gestohlen\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Ich möchte meine persönlichen Daten ändern" option from the dropdown menu of
     * "Contact Us page" /  Others option
     */
    public static void clickOthers_PersonalDataChange() {
        Tacitus.getInstance().log("Finding \"Ich möchte meine persönlichen Daten ändern\" WebElement");
        try {
            Select objSelect = new Select(otherIssueDropDownWebElem);
            objSelect.selectByValue("Personal data change");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich möchte meine persönlichen Daten ändern\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Ich habe eine allgemeine Frage zu den Produkten" option from the dropdown menu of
     * "Contact Us page" /  Others option
     */
    public static void clickOthers_FrageZuDenProdukten() {
        Tacitus.getInstance().log("Finding \"Ich habe eine allgemeine Frage zu den Produkten\" WebElement");
        try {
            Select objSelect = new Select(otherIssueDropDownWebElem);
            objSelect.selectByValue("Products");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich habe eine allgemeine Frage zu den Produkten\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Ich möchte mein paysafecard Konto kündigen" option from the dropdown menu of
     * "Contact Us page" /  Others option
     */
    public static void clickOthers_PSCAccountCancelationn() {
        Tacitus.getInstance().log("Finding \"Ich möchte mein paysafecard Konto kündigen\" WebElement");
        try {
            Select objSelect = new Select(otherIssueDropDownWebElem);
            objSelect.selectByValue("Cancellation");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Ich möchte mein paysafecard Konto kündigen\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to select the "Sonstiges" option from the dropdown menu of
     * "Contact Us page" /  Others option
     */
    public static void clickOthers_Others() {
        Tacitus.getInstance().log("Finding \"Sonstiges\" WebElement");
        try {
            Select objSelect = new Select(otherIssueDropDownWebElem);
            objSelect.selectByVisibleText("Sonstiges");
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Sonstiges\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to insert text into "Serie number optional" input box from Zahlungen topic of Contact Us page
     */
    public static void insertSerieNumberOptional(String serieNumber) {
        Tacitus.getInstance().log("Finding \"Serie number optional\" WebElement");
        try {
            serieNumberOptionalInputWebElem.click();
            serieNumberOptionalInputWebElem.sendKeys(serieNumber);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"Serie number optional\" WebElement", ex);
            throw ex;
        }
    }

}

