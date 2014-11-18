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
import model.UniversityBean;
import model.UserBean;

/**
 *
 * @author admin
 */
public class UniversityDAOImpl implements UniversityDAO {

    @Override
    public int createUniversity(UniversityBean aUniversity) {
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
                    + aUniversity.getUnName()
                    + "','" + aUniversity.getPassword()
                    + "','" + aUniversity.getEmail()
                    + "')";
            rowCount = stmt.executeUpdate(insertString);
            insertString = "INSERT INTO Project_353.Logininfo VALUES ('"
                    + aUniversity.getUnName()
                    + "','" + aUniversity.getPassword()
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
    public UserBean findByUniversity(String aUniversity) {
        ResultSet rs = null;
        UserBean temp = null;
        try {
            String myDB = "jdbc:derby://localhost:1527/Project_353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String searchString = "SELECT * FROM Project_353.USERS WHERE USERID ='" + aUniversity + "'";
            Statement stmt = DBConn.createStatement();
            
            rs = stmt.executeQuery(searchString);
            if (rs.next()){
                String input = "";
                temp = new UserBean(rs.getString(1),rs.getString(2),rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12));
            }
                return temp;
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public int updateUniversity(UniversityBean aUniversity){
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
                    + "frstname = '" + aUniversity.getUnName() + "', "
                    + "password = '" + aUniversity.getPassword()  + "', "                   
                    + "WHERE email = '" + aUniversity.getEmail() + "'";
            
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


