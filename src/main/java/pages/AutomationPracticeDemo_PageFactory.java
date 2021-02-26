package pages;

import com.relevantcodes.extentreports.ExtentTest;
import driver.WebDriverThreadManager;
import logger.Tacitus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.CRTestUtils;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class AutomationPracticeDemo_PageFactory {

    private JavascriptExecutor js;
    public static WebDriver driver;
    public static ExtentTest test;


    // *************  Login Section *************
    @FindBy(xpath = "//a[contains(@class,'login')]")
    private static WebElement loginUserSignInButton;

    @FindBy(xpath = "//h3[contains(text(),'Already registered?')]")
    private static WebElement loginSection;

    @FindBy(id = "email")
    private static WebElement emailAddressInput;

    @FindBy(id = "passwd")
    private static WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private static WebElement submitLogin;

    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    private static WebElement confirmMyAccountText;

    @FindBy(className = "logout")
    private static WebElement logoutUserButton;

// ****************************** Add Blouses to Cart section WebElements ************************

    @FindBy(xpath = "//div[@id='block_top_menu']//a[contains(@title,'Women')]")
    private static WebElement womenSectionSelectionButton;

    @FindBy(xpath = "//div[@id='block_top_menu']//a[@title='Blouses']")
    private static WebElement selectBlousesSectionButton;

    @FindBy(xpath = "//span[@class='cat-name' and contains(text(),'Blouses')]")
    private static WebElement blousesSectionConfirmation;

//	************************* Add Dresses to Cart  section WebElements ****************


    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[contains(@title,'Dresses')]")
    private static WebElement dressesSectionSelection;

    @FindBy(xpath = "//span[@class='cat-name' and contains(text(),'Dresses')]")
    private static WebElement dressesSectionConfirmation;


    @FindBy(xpath = "//div[@class='shopping_cart']/a[contains(@title,'View my shopping cart')]")
    private static WebElement myShoppingCart;

    @FindBy(xpath = "//div[@class='cart_block_list']//a[@class='ajax_cart_block_remove_link']")
    private static List<WebElement> removeItemsList;

    @FindBy(xpath = "//div[@class='shopping_cart']/a[contains(@title,'View my shopping cart')]//span[contains(text(),'(empty)')]")
    private static WebElement cartEmptyConfirmationText;


    // **************************** Items section details **************

    @FindBy(xpath = "//div[@id='center_column']/ul/li")
    private static List<WebElement> overItemSection;

    @FindBy(xpath = "//a[@class='quick-view']")
    private static List<WebElement> openItemDetail;

    @FindBy(id = "quantity_wanted")
    private static WebElement quantityItemsInput;

    @FindBy(id = "group_1")
    private static WebElement itemSizeOptionsInput;


    @FindBy(xpath = "//ul[@id='color_to_pick_list']//a[contains(@class,'color_pick')]")
    private static List<WebElement> listItemColor;


    @FindBy(xpath = "//form[@id='buy_block']//button[contains(@type,'submit')]")
    private static WebElement addItemToCartButton;

    @FindBy(xpath = "//span[contains(@title,'Continue shopping')]")
    private static WebElement continueShoppingSubmitButton;


//------------------------------------------------------------------------------------------------
    public static void init() {
        driver = WebDriverThreadManager.getDriver();
        PageFactory.initElements(driver, AutomationPracticeDemo_PageFactory.class);
    }

// ************* Login user methods *************

   /**
    *
   This method is used to click on "Sign In" button
    *
    */
   public static void clickLoginUserButton() {
        Tacitus.getInstance().log("Finding \"loginUserSignInButton\" WebElement");
        try {
            loginUserSignInButton.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"loginUserSignInButton\" WebElement", ex);
            throw ex;
        }
    }


    /**
     *
     * This method is used to check if the "loginUserSignInButton" WebElement is displayed on the screen.
     * The method returns "true" if the user is logged in or "false" if not
     *
     */
    public static boolean checkSignInButtonPresence() {
        Tacitus.getInstance().log("Finding the presence of \"loginUserSignInButton\" WebElement");
        try {
            return loginUserSignInButton.isDisplayed();

        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the presence of \"loginUserSignInButton\" WebElement", ex);
            return false;
        }
    }



    /**
     *
     * This method is click on "Sign out" button.
     *
     */
    public static void clickLogoutUserButton() {
        Tacitus.getInstance().log("Finding \"logoutUserButton\" WebElement");
        try {
            CRTestUtils.jsScroll(logoutUserButton);
            logoutUserButton.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"logoutUserButton\" WebElement", ex);
            throw ex;
        }
    }



    /**
     *
     * This method is used to validate the presence of section where the user can login into his account
     *
     */

    public static String getLoginSectionText() {
        Tacitus.getInstance().log("Finding \"loginSection\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            return loginSection.getText();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"loginSection\"  WebElement", ex);
            throw ex;
        }
    }



    /**
     * This method is used to insert the user's email address
     * @param email is used to select the value
     */
    public static void insertUserEmailAddress(String email) {
        Tacitus.getInstance().log("Finding  \"emailAddressInput\" WebElement");
        try {
            emailAddressInput.sendKeys(email);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"emailAddressInpu\"t WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to insert the user's password
     * @param password is used to select the value
     */
    public static void insertUserPassword(String password) {
        Tacitus.getInstance().log("Finding \"passwordInput\" WebElement");
        try {
            passwordInput.sendKeys(password);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"passwordInput\"  WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to submit the "Sing in" after the user's credentials are inserted
     */
    public static void clickSubmitLogin() {
        Tacitus.getInstance().log("Finding \"submitLogin\" WebElement");
        try {
            submitLogin.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"submitLogin\" WebElement", ex);
            throw ex;
        }
    }


    /**
     * This method is used to check if the user is logged in his account.
     * The method returns "true" if the user is logged in or "false" if not
     */
    public static boolean checkMyAccountText() {
        Tacitus.getInstance().log("Finding the \"confirmMyAccountText\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            return confirmMyAccountText.isDisplayed();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"confirmMyAccountText\" WebElement", ex);
            return false;
        }

    }


//	********************* Add Blouses methods *******************

    /**
     * This method is used to click on Women/Blouses subsection
     */
    public static void selectBlousesSection() {
        Tacitus.getInstance().log("Finding the \"womenSectionSelectionButton\" webElement");
        try {
            CRTestUtils.checkPageIsReady();
            Actions actions = new Actions(driver);
            actions.moveToElement(womenSectionSelectionButton).perform();
            CRTestUtils.waitTest(2);
            actions.moveToElement(selectBlousesSectionButton).click().build().perform();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("The \"womenSectionSelectionButton\" WebElement was not found", ex);
            throw ex;
        }
    }



    /**
     * This method is used to check if the "Blouses" page section is reached.
     * The method returns "true" if the user is logged in or "false" if not
     */
    public static boolean checkBlousesSectionPresence(){
        Tacitus.getInstance().log("Finding the \"blousesSectionConfirmation\" WebElement");
        try{
            CRTestUtils.checkPageIsReady();
            return blousesSectionConfirmation.isDisplayed();
        }catch(Exception ex){
            Tacitus.getInstance().logError("Error while finding the \"blousesSectionConfirmation\" WebElement",ex);
            return false;
        }
    }


    /**
     * This method is used to check if the "Dresses" page section is reached.
     * The method returns "true" if the user is logged in or "false" if not
     */
    public static boolean checkDressesSectionPresence(){
        Tacitus.getInstance().log("Finding the \"dressesSectionConfirmation\" WebElement");
        try{
            CRTestUtils.checkPageIsReady();
            return dressesSectionConfirmation.isDisplayed();
        }catch(Exception ex){
            Tacitus.getInstance().logError("Error while finding the \"dressesSectionConfirmation\" WebElement",ex);
            return false;
        }
    }


    /**
     * This method is used to click on "Dresses" tab from main page.
     */
    public static void SelectDressesSection() {
        Tacitus.getInstance().log("Finding the \"dressesSectionSelection\" webElement");
        try {
            CRTestUtils.checkPageIsReady();
            dressesSectionSelection.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"dressesSectionSelection\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to insert the quantity for the selected item.
     * First, the driver is used to switch to the frame where quantity, size, color options are available.
     * It clears the current value and insert the desired one
     * @param quantity is used to select the value
     */
    public static void setQuantityItem(String quantity) {
        Tacitus.getInstance().log("Finding \"quantityItemsInput\" WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            driver.switchTo().frame(0);
            quantityItemsInput.clear();
            quantityItemsInput.sendKeys(quantity);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("The \"quantityItemsInput\" WebElement was not found", ex);
            throw ex;
        }
    }


    /**
     * This method is used to check if the desired item "Quick View" is selected.
     * One of the available frame's WebElements is used for validation (the presence of "quantityItemsInput" WebElement)
     */
    public static boolean checkQuantitySectionPresence() {
        Tacitus.getInstance().log("Finding  \"quantityItemsInput\" WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            return quantityItemsInput.isDisplayed();

        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"quantityItemsInput\" WebElement", ex);
            return false;
        }
    }


    /**
     * This method is used to select the "Size" Item .
     * @param size is used to select the value
     */
    public static void selectItemSize(String size) {
        Tacitus.getInstance().log("Finding \"itemSizeOptionsInput\" WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            Select itemSelect = new Select(itemSizeOptionsInput);
            itemSelect.selectByVisibleText(size);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"itemSizeOptionsInput\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to select the "Color" item.
     * @param color is used to select the value
     */
    public static void selectItemColor(String color) {
        Tacitus.getInstance().log("Finding listItemColor WebElement");
        try {
            if (listItemColor.size() > 0) {
                for (WebElement colorElem : listItemColor) {
                    String colorItem = colorElem.getAttribute("name");
                    if (colorItem.equals(color)) {
                        colorElem.click();
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"listItemColor\" WebElement", ex);
            throw ex;
        }

    }

    /**
     * This method is used to click on "Add to cart" button
     */
    public static void clickSubmitAddToCart() {
        Tacitus.getInstance().log("Finding \"addItemToCartButton\" WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            addItemToCartButton.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"addItemToCartButton\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to check if the desired item is added in the shopping cart.
     *  One of the available WebElements is used for validation (the presence of "continueShoppingSubmitButton" WebElement)
     * The method returns "true" if the item is added or "false" if not
     */
    public static boolean confirmTheItemIsAddedToCart() {
        Tacitus.getInstance().log("Finding \"continueShoppingSubmitButton\"  WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            CRTestUtils.waitTest(5);
            return continueShoppingSubmitButton.isDisplayed();

        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"continueShoppingSubmitButton\" WebElement", ex);
            return false;
        }
    }

    /**
     * This method is used to click on "Continue shopping" button
     */
    public static void clickContinueShoppingSubmitButton() {
        Tacitus.getInstance().log("Finding \"continueShoppingSubmit\" WebElement");
        try {
            CRTestUtils.checkPageIsReady();
            CRTestUtils.waitTest(2);
            continueShoppingSubmitButton.click();
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding the \"continueShoppingSubmit\" WebElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to add in cart all the available items without adding the items to the shopping cart.
     * First "Actions" class is used to hover the mouse to the desired WebElement
     */
    public static void selectItemsForCartWithoutSubmit() {
        Tacitus.getInstance().
                log("Finding \"openItemDetail\" WebElement from \"selectItemsForCartWithoutSubmit\" method");

        try {

            CRTestUtils.checkPageIsReady();
            for (int i = 0; i < openItemDetail.size(); i++) {
                Actions actions = new Actions(driver);
                actions.moveToElement(overItemSection.get(i)).perform();
                actions.moveToElement(openItemDetail.get(i)).click().build().perform();
                CRTestUtils.waitTest(2);

            }

        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding \"openItemDetail\" WebElement from" +
                                                    " \"selectItemsForCartWithoutSubmit\" method", ex);
            throw ex;
        }
    }

    /**
     * This method is used to add in cart all the available items including the methods used for "Add to cart"
     * and "Continue shopping".
     * First "Actions" class is used to hover the mouse to the desired WebElement
     */
    public static void selectItemsForCartWithSubmit() {
        Tacitus.getInstance().log("Finding \"openItemDetail\" WebElement from \"selectItemsForCartWithSubmit\" method");

        try {

            CRTestUtils.checkPageIsReady();
            CRTestUtils.jsScrollPageDown();
            Actions actions = new Actions(driver);

            for (int i = 0; i < openItemDetail.size(); i++) {

                actions.moveToElement(overItemSection.get(i)).perform();
                actions.moveToElement(openItemDetail.get(i)).click().build().perform();

                driver.switchTo().frame(0);
                clickSubmitAddToCart();
                CRTestUtils.waitTest(2);
                clickContinueShoppingSubmitButton();
                CRTestUtils.waitTest(2);
            }

        } catch (Exception ex) {
            Tacitus.getInstance().logError("Error while finding \"openItemDetail\" WebElement from" +
                                                    " \"selectItemsForCartWithSubmit\" method", ex);
            throw ex;
        }
    }


    /**
     * This method is used to removes items from the "Cart products"
     * First "Actions" class is used to hover the mouse to the desired WebElement
     */
    public static void removeItemsFromProductsCart() {
        Tacitus.getInstance().log("Finding the \"myShoppingCart\" webElement");
        try {
            CRTestUtils.jsScroll(myShoppingCart);
            CRTestUtils.checkPageIsReady();
            Actions actions = new Actions(driver);
            actions.moveToElement(myShoppingCart).perform();
            CRTestUtils.waitTest(2);
            for (int i = removeItemsList.size() - 1; i >= 0; i--) {

                actions.moveToElement(removeItemsList.get(i)).click().build().perform();
            }

        } catch (Exception ex) {
            Tacitus.getInstance().logError("TError while finding the Finding the \"myShoppingCart\" webElement", ex);
            throw ex;
        }
    }

    /**
     * This method is used to confirm the removed items from the shopping cart products
     */
    public static boolean confirmCartEmpty(){
        Tacitus.getInstance().log("Finding the \"cartEmptyConfirmationText\" WebElement");
        try{
            CRTestUtils.waitTest(4);
            return cartEmptyConfirmationText.isDisplayed();
        }catch(Exception ex){
            Tacitus.getInstance().logError("Error while finding the \"cartEmptyConfirmationText\" WebElement", ex);
            return false;
        }
    }

    /**
     * This method is used to confirm the the shopping cart products is empty
     * The method returns "true" if the cart is empty  or false if not
     */
    public static boolean confirmThePresenceOfItemsInCart(){
        Tacitus.getInstance().log("Finding the \"cartProductsText\" WebElement");
        try{
            CRTestUtils.jsScroll(cartEmptyConfirmationText);
            return (!cartEmptyConfirmationText.isDisplayed());
        }catch(Exception ex){
            Tacitus.getInstance().logError("Error while finding the \"cartProductsText\" WebElement", ex);
            return false;
        }
    }

}
