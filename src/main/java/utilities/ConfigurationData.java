package utilities;

import logger.Tacitus;


import java.util.Properties;

/**
 *  * Class name: ${NAME}
 * <p>
 * Created by DanG.
 */
public class ConfigurationData {

    public static String getDefaultBrowser() {
        return getValueFromConfigurationFile("browser");
    }

    public static String getLoggingPath() {
        return getValueFromConfigurationFile("loggingPath");
    }


    public static String getExecutionEnvironment() {
        return getValueFromConfigurationFile("executionEnvironment");
    }

    public static Boolean getForceBrowserClosure() {
        return Boolean.valueOf(getValueFromConfigurationFile("forceBrowserClosure"));
    }

    public static Boolean getBaseScreenshot() {
        return Boolean.valueOf(getValueFromConfigurationFile("baseScreenshot"));
    }

    public static Integer getFailedReattemptsNumber() {
        return Integer.valueOf(getValueFromConfigurationFile("failedReattempts"));
    }
//
//    public static String getSQLUrl() {
//        return getValueFromConfigurationFile("DB_URL_SIT");
//    }
//
//    public static String getSQLUsername() {
//        return getValueFromConfigurationFile("DB_USER_SIT");
//    }
//
//    public static String getSQLPassword() {
//        return getValueFromConfigurationFile("DB_PASSWORD_SIT");
//    }

    /**
     * Retrieves a value from the config.properties file.
     *
     * @param value - String - name of the value to be retrieved
     * @return String - the retrieved value
     */
    private static String getValueFromConfigurationFile(String value) {
        Properties _props = new Properties();
        String _propFileName = "config.properties";

        try {
            _props.load(ConfigurationData.class.getClassLoader().getResourceAsStream(_propFileName));
            return _props.getProperty(value);
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Unable to retrieve value from config.properties. Value: " + value, ex);
            return null;
        }
    }

  

//    public static String getDefaultUsername() {
//        return getValueFromConfigurationFile("username");
//    }
//
//    public static String getDefaultPassword() {
//        return getValueFromConfigurationFile("password");
//    }
}
