package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ConfigurationData;
import logger.Tacitus;

import java.io.File;

/**
 * Created by DanG
 */
class WebDriverManager {
    /**
     * Creates a new WebDriver instance.
     *
     * @return - WebDriver object.
     */
    WebDriver createWebDriver() {
        BrowserTypes _browser = getDefaultBrowser();
        String _fileName = getFilePath(_browser.getFileName());
        System.out.println("the _fileName is: -->"+ _fileName);

        switch (_browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", _fileName);
                Tacitus.getInstance().logSuccess("Created a new Chrome instance.");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", _fileName);
                Tacitus.getInstance().logSuccess("Created a new Firefox instance.");
                return new FirefoxDriver();
            default:
                Tacitus.getInstance().logError("Unable to start browser.", null);
                return null;
        }
    }

  

    /**
     * Gets the location of the browser file. The driver must always be placed within the project's
     * resources folder.
     *
     * @return the driver's location.
     */
    private String getFilePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file.getAbsolutePath();
    }

    /**
     * Retrieves the driver for the browser on which all scripts will be executed.
     *
     * @return BrowserTypes - the type of browser.
     */
    private BrowserTypes getDefaultBrowser() {
        String _browser = ConfigurationData.getDefaultBrowser();
        switch (_browser) {
            case "CHROME":
                Tacitus.getInstance().log("Current default browser is Chrome.");
                return BrowserTypes.CHROME;
            case "FIREFOX":
                Tacitus.getInstance().log("Current default browser is Firefox.");
                return BrowserTypes.FIREFOX;
            default:
                Tacitus.getInstance().logError("Undefined browser type in config.properties.", null);
                return null;
        }
    }


    private enum BrowserTypes {
        CHROME("chromedriver.exe"),
        FIREFOX("geckodriver.exe");

        private String a;

        BrowserTypes(String a) {
            this.a = a;
        }

        public String getFileName() {
            return a;
        }
    }
}
