package danGrigTest.framework;

import driver.BaseClass;
import org.testng.Assert;
import pages.AutomationPracticeDemo_PageFactory;
import pages.Enums.ColorList;
import utilities.listeners.RetryAnalyzer;

import org.testng.annotations.Test;


public class Test_AutomationProcess extends BaseClass {

    private String confirmationLoginText;
    private String emailAddress = "dangrigorita@yahoo.com";
    private String password = "romania777";
    private String sizeItem = "L";
    private String color = "Orange";
    private String quantity = "2";


    @Test(description = "E2E testing flow for login/logout user and add/remove items from cart shopping." +
            "In the cart will be added a single blouse item with specific quantity, size, color and all" +
            "the available default dresses specifications", retryAnalyzer = RetryAnalyzer.class)
    public void loginPage() {

//        Prerequisites:

//        Have a registered user on http://automationpractice.com/index.php;
//        http://automationpractice.com/index.php page is opened (the page url link is defined in executionEnvironment of
//        config.properties file)


//        *************** Login Section *************

//      Steps 1: Click on "Sign in" button
        AutomationPracticeDemo_PageFactory.clickLoginUserButton();
        confirmationLoginText = AutomationPracticeDemo_PageFactory.getLoginSectionText();
        Assert.assertEquals(confirmationLoginText, "ALREADY REGISTERED?", "The login user " +
                            "WebElement was not found");

//      Step 2: Insert user email address and password
        AutomationPracticeDemo_PageFactory.insertUserEmailAddress(emailAddress);
        AutomationPracticeDemo_PageFactory.insertUserPassword(password);

//      Step 3: Click on "Sign in" button
        AutomationPracticeDemo_PageFactory.clickSubmitLogin();
        Assert.assertTrue(AutomationPracticeDemo_PageFactory.checkMyAccountText(), "The login WebElement" +
                            " was not found");


//        ************** Add Blouses to cart *******************

//      Step 4: Click on "Women/Blouses" button
        AutomationPracticeDemo_PageFactory.selectBlousesSection();
        Assert.assertTrue(AutomationPracticeDemo_PageFactory.checkBlousesSectionPresence(), "The Blouses section" +
                            " page is not reached");

//      Step 5: Click on the "Quick view" button of the available item
        AutomationPracticeDemo_PageFactory.selectItemsForCartWithoutSubmit();

//      Step6: In the "Quantity" section add 2 items
        AutomationPracticeDemo_PageFactory.setQuantityItem(quantity);
        Assert.assertTrue(AutomationPracticeDemo_PageFactory.checkQuantitySectionPresence(), "The quick view " +
                            "item details page is not reached");

//      Step7: In the "Size" dropdown menu select the size "L"
        AutomationPracticeDemo_PageFactory.selectItemSize(sizeItem);

//      Step 8: Select from "Color" checkboxes the black one
        AutomationPracticeDemo_PageFactory.selectItemColor(ColorList.BLACK.toString());

//      Step 9: Click on "Add to cart" button
        AutomationPracticeDemo_PageFactory.clickSubmitAddToCart();
        Assert.assertTrue(AutomationPracticeDemo_PageFactory.confirmTheItemIsAddedToCart(), "The Item details " +
                            "page is not reached");

//      Step 10: Click on "Continue shopping" button
        AutomationPracticeDemo_PageFactory.clickContinueShoppingSubmitButton();
        Assert.assertTrue(AutomationPracticeDemo_PageFactory.checkBlousesSectionPresence(), "The Blouses " +
                            "section page is not reached");


//       ************** Add Dresses to cart ************

//      Step 11: Click on "Dresses" button
        AutomationPracticeDemo_PageFactory.SelectDressesSection();
        Assert.assertTrue(AutomationPracticeDemo_PageFactory.checkDressesSectionPresence(), "The Dresses " +
                            "section page is not reached");


//      Step 12: Click on the "Quick view" button for each of the available items and add them to the Cart
        AutomationPracticeDemo_PageFactory.selectItemsForCartWithSubmit();
        Assert.assertTrue(AutomationPracticeDemo_PageFactory.confirmThePresenceOfItemsInCart(), "The items were" +
                            " not removed from the shopping cart");


//      Step 13: Remove all the items from the shopping cart using the "x" close button
        AutomationPracticeDemo_PageFactory.removeItemsFromProductsCart();
        Assert.assertTrue(AutomationPracticeDemo_PageFactory.confirmCartEmpty(), "The items were not removed " +
                            "from the shopping cart");


//     *********** LogOut User *****************

//      Step 14: Click on "Sigh out" button to logout the user
        AutomationPracticeDemo_PageFactory.clickLogoutUserButton();
        Assert.assertTrue(AutomationPracticeDemo_PageFactory.checkSignInButtonPresence(), "The sign in WebElement" +
                            " was not found");

    }


}
