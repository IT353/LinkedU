/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.UserBean;

/**
 *
 * @author admin
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public int createUser(UserBean aUser) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/Project_353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO Project_353.Users VALUES ('"
                    + aUser.getfName()
                    + "','" + aUser.getPassword()
                    + "','" + aUser.getEmail()
                    + "')";
            rowCount = stmt.executeUpdate(insertString);
            insertString = "INSERT INTO Project_353.Logininfo VALUES ('"
                    + aUser.getfName()
                    + "','" + aUser.getPassword()
                    + "')";
            
            stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

    @Override
    public UserBean[] findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public UserBean findByName(String aUser) {
        ResultSet rs = null;
        UserBean temp = null;
        try {
            String myDB = "jdbc:derby://localhost:1527/Project_353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String searchString = "SELECT * FROM Project_353.USERS WHERE USERID ='" + aUser + "'";
            Statement stmt = DBConn.createStatement();
            
            rs = stmt.executeQuery(searchString);
            if (rs.next()){
                String input = "";
                temp = new UserBean(rs.getString(1),rs.getString(2),rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12),rs.getString(13),rs.getString(13), rs.getString(14),
                        rs.getString(15), rs.getString(16));
            }
                return temp;
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public int updateUser(UserBean aUser){
            Connection DBConn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/Profile_353";
            DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String updateString;
            Statement stmt = DBConn.createStatement();

            // SQL UPDATE Syntax [http://www.w3schools.com]:
            // UPDATE table_name
            // SET column1=value, column2=value2,...
            // WHERE some_column=some_value
            // Note: Notice the WHERE clause in the UPDATE syntax. The WHERE clause specifies which record or records that should be updated. If you omit the WHERE clause, all records will be updated!
            updateString = "UPDATE Profile_353.Users SET "
                    + "frstname = '" + aUser.getfName() + "', "
                    + "lastname = '" + aUser.getlName() + "', "
                    + "password = '" + aUser.getPassword()  + "', "                   
                    + "WHERE email = '" + aUser.getEmail() + "'";
            
            rowCount = stmt.executeUpdate(updateString);
            
            System.out.println("updateString =" + updateString);
            DBConn.close();
            return rowCount;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
}


