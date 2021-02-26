package utilities.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utilities.ConfigurationData;
import logger.ExtentTestManager;
import logger.Tacitus;


/**
 *
 * Class name: ${NAME}
 *
 * Created by DanG
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private static int attempts=0;
    private static int maxAttempts = ConfigurationData.getFailedReattemptsNumber();
//    private static int maxAttempts =2;
    
    

    @Override
    public boolean retry(ITestResult iTestResult) {
    	System.out.println("Max attempts is: "+ maxAttempts);
    	System.out.println("The itTestResult este: "+ iTestResult.isSuccess());
        if (!iTestResult.isSuccess()) {
            if (attempts < maxAttempts) {
                attempts++;

                ExtentTestManager.removeTest();
                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }

        Tacitus.getInstance().logError("Test was re-executed " + maxAttempts + " times, but it still failed.", null);
        return false;
    }

    public static Boolean shouldBeLogged() {
        return attempts == maxAttempts;
    }
}
