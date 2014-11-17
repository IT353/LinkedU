/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.AccountBean;
import dao.DBHelper;

/**
 *
 * @author ljpetr2
 */
public class AccountDAOImpl implements AccountDAO {
    
 

    @Override
    public ArrayList findAllAccounts() {

        String query = "SELECT * FROM LinkedU.LOGININFO";
        ArrayList aAccountCollection = selectAccountsFromDB(query);
        return aAccountCollection;
    }
    
    
    @Override
    public ArrayList findAccount(String aEmail, String aPass) {
        String query = "SELECT * FROM account.LOGININFO ";
        query += "WHERE useremail = '" + aEmail + "'";
        query += "AND   password = '" + aPass + "'";

        ArrayList aAccountCollection = selectAccountsFromDB(query);
        return aAccountCollection;
    }
    
    
    private ArrayList selectAccountsFromDB(String query) {
        ArrayList aAccountBeanCollection = new ArrayList();
        Connection DBConn = null;
        try {
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            // if doing the above in Oracle: DBHelper.loadDriver("oracle.jdbc.driver.OracleDriver");
            String myDB = "jdbc:derby://localhost:1527/kbandel_Fall2014_KKLM_LinkeduDB";
            // if doing the above in Oracle:  String myDB = "jdbc:oracle:thin:@oracle.itk.ilstu.edu:1521:ora478";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String useremail, password, accountType;
            int login;
            AccountBean aAccountBean;
            while (rs.next()) {
                // 1. if a float (say PRICE) is to be retrieved, use rs.getFloat("PRICE");
                // 2. Instead of using column name, can alternatively use: rs.getString(1); // not 0
                useremail = rs.getString("Useremail");
                password = rs.getString("Password");
                accountType = rs.getString("AccountType");
                



                // make a ProfileBean object out of the values
                aAccountBean = new AccountBean(useremail, password, accountType);
                // add the newly created object to the collection
                aAccountBeanCollection.add(aAccountBean);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aAccountBeanCollection;
    }
    
    
    @Override
    public int createAccount(AccountBean aAccount) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/kbandel_Fall2014_KKLM_LinkeduDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO account.Users VALUES ('"
                    + aAccount.getUserEmail()
                    + "','" + aAccount.getPassword()
                    + "','" + aAccount.getAccountType() 
                    + "'"
                    + ")";

            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }
    
    
    @Override
    public int updateAccount(AccountBean pro) {
        Connection DBConn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/kbandel_Fall2014_KKLM_LinkeduDB";
            DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            

            String updateString;
            Statement stmt = DBConn.createStatement();

            // SQL UPDATE Syntax [http://www.w3schools.com]:
            // UPDATE table_name
            // SET column1=value, column2=value2,...
            // WHERE some_column=some_value
            // Note: Notice the WHERE clause in the UPDATE syntax. The WHERE clause specifies which record or records that should be updated. If you omit the WHERE clause, all records will be updated!
            updateString = "UPDATE account.Users SET "
                    + "username = '" + pro.getUserEmail() + "', "
                    + "password = '" + pro.getPassword() + "', "
                    + "accountType = '" + pro.getAccountType() + " "      
                    + "WHERE username = '" + pro.getUserEmail() + "'";
            rowCount = stmt.executeUpdate(updateString);
            System.out.println("updateString =" + updateString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }   
}
