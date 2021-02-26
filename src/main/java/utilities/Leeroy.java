package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import logger.Tacitus;

/**
 * Created by DanG
 */
public class Leeroy {

    // Connection object
    private static Connection con = null;

    // Statement object
    private Statement stmt;

    // Constant for Database URL
    private static String DB_URL;

    // Constant for Database Username
    private static String DB_USER;

    // Constant for Database Password
    private static String DB_PASSWORD;

    // Field to be returned
    private String fieldName;

    public void setUp()  {
        try {
            readInfo();
            // Make Connection to database
            Class.forName("jdbc:mysql://localhost:3306/users");
            // Get connection to database
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Statement object to send the SQL statement to database
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used to execute an SQL query and compare it with the expected result
     * EXAMPLE: DON'T FORGET TO CALL SETUP() BEFORE TEST AND CLOSECONNECTION() AFTER TEST
     *
     * @param querryCommand  used to write the SQL query
     * @param expectedResult used to write the text that will be compared with the actual result
     * @param columnName     used to write the name of the column you are interested in getting the value(s)
     * @return the element that allows you to assert
     */
    public Boolean getColumnValues(String querryCommand, String columnName, String expectedResult) {
//        Tacitus.getInstance().log("Executing SQL Query that should return value for assert");
        try {
            ResultSet rs = stmt.executeQuery(querryCommand);
            while (rs.next()) {
                fieldName = rs.getString(columnName);
            }
            rs.close();
        } catch (SQLException sqlEX) {
//            Tacitus.getInstance().logError("Something went wrong while executing SQL statement", sqlEX);
        }
        try {
            // Let's see what we get :)

            if (expectedResult.equals("") && fieldName == null) {
                return Boolean.TRUE;
            } else {
                return fieldName.equals(expectedResult);
            }
        } catch (Exception ex) {
//            Tacitus.getInstance().logError("Something went wrong while comparing the value from SQL result", ex);
            throw ex;
        }
    }





    /**
     * Method used to execute an SQL query and get a SINGLE
     *
     * cell as a string
     * EXAMPLE: DON'T FORGET TO CALL SETUP() BEFORE TEST AND CLOSECONNECTION() AFTER TEST
     *
     * @param querryCommand  used to write the SQL query
     * @param columnName     used to write the name of the column you are interested in getting the value(s)
     * @return a String containing the required data
     */
    public String getColumnValueAsString(String querryCommand, String columnName) {
        Tacitus.getInstance().log("Executing SQL Query that should return value for assert");
        try {
            ResultSet rs = stmt.executeQuery(querryCommand);
            while (rs.next()) {
                fieldName = rs.getString(columnName);
                System.out.println("The field value is:" + rs.getString(columnName));
            }
            rs.close();
        } catch (SQLException sqlEX) {
            Tacitus.getInstance().logError("Something went wrong while executing SQL statement", sqlEX);
        }
        try {
            // Let's see what we get :)
                return fieldName.toString();

        } catch (NullPointerException nex){
            Tacitus.getInstance().log("The returned value is null");
            return "";
        } catch (Exception ex) {
            Tacitus.getInstance().logError("Something went wrong while comparing the value from SQL result", ex);
            return null;
        }
    }


    /**
     * Method used to get the count value from a SQL Query
     *
     * !!!!!!!!!!!!!!!!!PLEASE USE A QUERRY THAT HAS ONLY ONE ROW AS RESULT!!!!!!!!!!!!!!!!!!
     *
     * @param querryCommand SQL query to use for database
//     * @param columnName Command where the count result is used
     * @return count value as Integer
     */
    public int getCountValue(String querryCommand, String alias) {
        Tacitus.getInstance().log("Executing SQL Query that should return count rows value for assert");

        try {
            ResultSet rs = stmt.executeQuery(querryCommand);
            int rowCount=0;
           rs.next();
            rowCount=rs.getInt(alias);
            return rowCount;

        } catch (SQLException sqlEX) {
            Tacitus.getInstance().logError("Something went wrong while executing SQL statement", sqlEX);
        }
       return Integer.parseInt(null);
    }


    private void readInfo() {
        try {

//            DB_URL = ConfigurationData.getSQLUrl();
//            DB_USER = ConfigurationData.getSQLUsername();
//            DB_PASSWORD = ConfigurationData.getSQLPassword();

        } catch (Exception ex) {
            Tacitus.getInstance().logError("Cannot read the database info or there is a fileReader error", ex);
            ex.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            // Close databse connection
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Tacitus.getInstance().logError("cannot close JDBC", ex);
        }

    }

    /**
     * Method used to return a list of String from a query
     * @param querryCommand SQL Query
     * @param column the desired column
     * @return List of String
     */
    public List<String> getColumnValuesAsList(String querryCommand, String column){
        Tacitus.getInstance().log("Running the querry "+querryCommand);
        try {
            ResultSet rs = stmt.executeQuery(querryCommand);
            List<String> results = new ArrayList<>();
            while(rs.next()){
                results.add(rs.getString(column));
            }
            return results;
        } catch (SQLException ex) {
            Tacitus.getInstance().logError("Cannot get the results for "+querryCommand, ex);
        }
        return null;
    }

    /**
     *  This method is used to run querries in DB
     * @param scriptName - Name of the script
     * @param columnName - Name of the culoumn
     * @return - the result of the querry
     */
    public static String runSQLScript(String scriptName, String columnName) {
        try{
        Leeroy sqlCheck = new Leeroy();
        sqlCheck.setUp();
        String sqlResult = sqlCheck.getColumnValueAsString(scriptName, columnName);
        sqlCheck.closeConnection();
        return sqlResult;
        } catch (Exception ex){
            Tacitus.getInstance().logError("Error while running a static SQL script", ex);
            return "";
        }

    }


    /**
     * creates a connection for update , it has autocommit on
     */
    public void updateSetUp()  {
        try {
            readInfo();
            // Make Connection to database
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Get connection to database
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            con.setAutoCommit(true);
            // Statement object to send the SQL statement to database
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method used to execute an SQL querry and get a multiple cells as a String
     * EXAMPLE: DON'T FORGET TO CALL SETUP() BEFORE TEST AND CLOSECONNECTION() AFTER TEST
     *
     * @param query  used to write the SQL querry
     * @param column  used to write the name of the column you are interested in getting the value(s)
     * @return a String containing the required data
     */
    public ArrayList<String> queryMultipleRowsInDatabase(String query, String column) {
        Tacitus.getInstance().log("Executing SQL Query that should return value for assert");
        ArrayList<String> result = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int j = 0;
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    if (rsmd.getColumnName(i).toUpperCase().equals(column)) {
                        if (i == 1) result.add(j, String.valueOf(rs.getObject(i)));
                        else result.set(j, String.valueOf(rs.getObject(i)));
                        break;
                    } else if (i == 1) result.add(j, rsmd.getColumnName(i) + "=" + String.valueOf(rs.getObject(i)));
                    else
                        result.set(j, result.get(j) + "|" + rsmd.getColumnName(i) + "=" + String.valueOf(rs.getObject(i)));
                }
                j = j + 1;
            }
        } catch (SQLException sqlEX) {
            Tacitus.getInstance().logError("Something went wrong while executing SQL statement", sqlEX);
        }
        return result;
    }



}
