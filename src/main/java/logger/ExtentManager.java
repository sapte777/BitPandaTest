package logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utilities.ConfigurationData;

public class ExtentManager {

    private static ExtentReports extentReport;
    private static String suiteName;
    private static String logDirName;

    public static ExtentReports getInstance() {
        if (extentReport == null) {
            setupExtentReports();
        }

        return extentReport;
    }

    private static ExtentReports setupExtentReports() {

        logDirName = suiteName + TacitusHelper.getDateAndTimeTitle();
        System.out.println("LogDirName is:  --->  " + logDirName);
        String reportDir = System.getProperty("user.dir") + ConfigurationData.getLoggingPath() + logDirName + "\\" + "index.html";
        
        System.out.println("The reportDir is: --->  "+ reportDir);
        System.out.println("The ConfigurationData.getLoggingPath() is: --->   "+ ConfigurationData.getLoggingPath());

        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportDir);
       
        extentReport = new ExtentReports();
        extentReport.attachReporter(extentHtmlReporter);
        
       extentHtmlReporter.config().setReportName(suiteName + " " + ConfigurationData.getExecutionEnvironment());
        System.out.println("The extent report is: --->  "+ extentReport);

        return extentReport;
    }

    public static String getLogDirName() {
        return logDirName;
    }

    public ExtentReports getReport() {
        return extentReport;
    }

    public static void setSuiteName(String newSuiteName) {
        suiteName = newSuiteName;
       
    }
}
