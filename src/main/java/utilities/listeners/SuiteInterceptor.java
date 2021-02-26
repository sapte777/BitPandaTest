package utilities.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import logger.ExtentManager;

import java.util.logging.LogManager;

/**
 * Class name: ${NAME}
 * Created by DanG.
 */
public class SuiteInterceptor implements ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {

        // Disable 3rd party logging - disables everything (only tacitus and ExtentReports will work!!!!)
        LogManager.getLogManager().reset();

        String suiteName;

        if (iSuite.getXmlSuite().getParentSuite() != null) {
            suiteName = iSuite.getXmlSuite().getParentSuite().getName();
            System.out.println("The suite name este: ---> "+ suiteName);
        } else {
            suiteName = iSuite.getName();
            System.out.println("The suite name is: ---> "+ suiteName);
        }

        ExtentManager.setSuiteName(suiteName);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        ExtentManager.getInstance().flush();
    }
}
