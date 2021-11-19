package utilities;

import driver.WebDriverThreadManager;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import logger.Tacitus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by DanGrig on 26.02.2020.
 */
public class CRTestUtils {

    /**
     * Method used to get random strings for usage in test cases only used characters are the letters of the alphabet
     *
     * @param length used to get the length of the required string
     * @return It returns a String object
     */
    public static String getRandomAlphabetString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Method used to get random strings for usage in test cases only used characters are numbers
     *
     * @param length used to get the length of the required string
     * @return It returns a String object
     */
    public static String getRandomNumberString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Method used to get random strings for usage in test cases only used characters are letters and numbers
     *
     * @param length used to get the length of the required string
     * @return It returns a String object
     */
    public static String getRandomCharacterString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Method used to click WebElements through javascript
     *
     * @param webElement the element which is needed to be clicked through javascript injection
     */
    public static void jsClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverThreadManager.getDriver();
        executor.executeScript("arguments[0].click();", webElement);

    }







    /**
     * method used to check if a given date is today
     * @param webElement the element which contains the date
     * @return True if today, false otherwise
     */
    public static Boolean checkDateIsCurrentDate(WebElement webElement){
        String displayedDate = webElement.getText();
        Boolean check = Boolean.FALSE;
        displayedDate = displayedDate.substring(0,displayedDate.lastIndexOf(" "));
        if (!displayedDate.isEmpty()) {
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            try {
                //try to parse the date displayed in the UI, if there is a PARSE error, there is an issue
                Date uiDate = dateFormat.parse(displayedDate);
                Date systemDate = new Date();
                String str = new SimpleDateFormat("dd-MMM-yyyy").format(systemDate);
                systemDate =  dateFormat.parse(str);
                if(uiDate.compareTo(systemDate)==0){
                    check = Boolean.TRUE;
                }else {
                    check = Boolean.FALSE;
                }
                return check;

            } catch (ParseException ex) {
                check = Boolean.FALSE;
                Tacitus.getInstance().logError("Cannot parse dates", ex);
            }
        }
        return check;
    }

    /**
     *
     * Method used to wait for a specific time
     * @param sleepSeconds time to wait in seconds
     */
    public  static void waitTest(int sleepSeconds){
        try {
            TimeUnit.SECONDS.sleep(sleepSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method used to get the Today date as dd-MMM-yyyy
     * @return String used for asserts
     */
    public static String getCurrentDateAsString() {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Date today = Calendar.getInstance().getTime();
        String helper = df.format(today);
        return helper.toUpperCase();
    }

    /**
     * Method used to get the current date in any give format
     * @param format choice of date format
     * @return a string containing the date
     */
    public static String getCurrentDateAsString(String format){
        try {
            DateFormat df = new SimpleDateFormat(format);
            Date today = Calendar.getInstance().getTime();
            String helper = df.format(today);
            return helper.toUpperCase();
        } catch (Exception ex) {
            System.out.println("Wrong format given");
            return null;
        }
    }

    /**
     * Method used to get a Date as String from a WebElement
     * @param webElement element containing the Date text
     * @param format conversion format
     * @return Date as String, null if errors
     */
    public static String getDateAsString(WebElement webElement,String format){
        try {
            DateFormat df = new SimpleDateFormat(format);
            String helper = webElement.getText();
            String date = df.parse(helper).toString();
            return date.toUpperCase();
        } catch (ParseException pex){
            System.out.println("Cannot parse the date, please check the format");
            return null;
        } catch (Exception ex){
            System.out.println("Cannot perform date parsing. Please check the WebElement or the text.");
            return null;
        }
    }

    /**
     * Method used to get a String as a date
     * @param data String to convert
     * @param format the format to parse
     * @return Date or null if error
     */
    public static Date getDateFromString(String data, String format){
        try {
            DateFormat sdf = new SimpleDateFormat(format);
            Date dateObject = sdf.parse(data);
            return dateObject;
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * Method which waits for the DOM to be in ready state
     */
    public static void checkPageIsReady() {

        JavascriptExecutor js = (JavascriptExecutor) WebDriverThreadManager.getDriver();


        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Page Is loaded.");
            return;
        }

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i = 0; i < 25; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    /**
     * Method used to scroll a page through javascript
     */
    public static void jsScroll(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverThreadManager.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true)", element);
        CRTestUtils.checkPageIsReady();
    }

    /**
     * Method used to scroll a page through javascript
     */
    public static void jsScrollPageDown() {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverThreadManager.getDriver();
        executor.executeScript("window.scrollBy(0,1000)");
        CRTestUtils.checkPageIsReady();
    }

    /**
     * Method used to check if a WebElement is Displayed
     * @param webElement webelement to check against
     * @return True if displayed, false otherwise
     */
    public static boolean checkElementDisplayed(WebElement webElement){
        Tacitus.getInstance().log("Finding if your WebElement is displayed");
            try{
                jsScroll(webElement);
                return webElement.isDisplayed();
            }catch (org.openqa.selenium.NoSuchElementException ex){
                return false;
            }

    }





    public static String randomEmail(){
        Tacitus.getInstance().log("Generating the random email");
        String email = getRandomCharacterString(5)+"@"+getRandomCharacterString(4)+".com";
        Tacitus.getInstance().log("Email was generated!");
        return email;
    }


    /**
     *  this method checks the length of a field
     * @param el - selects the element to be measured
     * @return returns true if the size is the desired one
     */
    public static boolean getAttrValue( WebElement el, int elLength){
        boolean eval_size = false;
        String el_value = el.getAttribute("value");
        try{
            if(el_value.length() ==elLength) {
                Tacitus.getInstance().logSuccess(" The max length is: " + el_value.length() +"!");
                eval_size = true;
            } else{
                Tacitus.getInstance().logSuccess(" The max length is: " + el_value.length() + ", it should be: 30!");
                eval_size = false;
            }
        } catch(NoSuchElementException e ){
            Tacitus.getInstance().logFail(" I can`t find the element to get it`s max length size!");
        }
        return eval_size;
    }


    public static String getPageTitle (){
        Tacitus.getInstance().log("Getting page title ... ");
        WebDriver _driver = WebDriverThreadManager.getDriver();
        return _driver.getTitle();
    }

}