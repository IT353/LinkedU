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
import java.sql.Timestamp;
import java.util.ArrayList;
import model.MessageBean;

/**
 *
 * @author ljpetr2
 */
public class MessageDAOImpl implements MessageDAO {
    
    @Override
    public ArrayList findAll(String aEmail){
        String query = "SELECT * FROM LinkedU.Messages ";
        query+= "WHERE receiverEmail='" + aEmail + "'";
        ArrayList aMessageCollection = selectMessagesFromDB(query);
        return aMessageCollection;
    }
    
    
    private ArrayList selectMessagesFromDB(String query) {
        ArrayList aMessageBeanCollection = new ArrayList();
        Connection DBConn = null;
        try {
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            // if doing the above in Oracle: DBHelper.loadDriver("oracle.jdbc.driver.OracleDriver");
            String myDB = "jdbc:derby://gfish.it.ilstu.edu:1527/kbandel_Fall2014_KKLM_LinkeduDB";
            // if doing the above in Oracle:  String myDB = "jdbc:oracle:thin:@oracle.itk.ilstu.edu:1521:ora478";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String senderEmail, receiveEmail, message, readstatus, subject, time;
            Timestamp timeSent;
            MessageBean aMessageBean;
            while (rs.next()) {
                // 1. if a float (say PRICE) is to be retrieved, use rs.getFloat("PRICE");
                // 2. Instead of using column name, can alternatively use: rs.getString(1); // not 0
                senderEmail = rs.getString("SENDEREMAIL");
                receiveEmail= rs.getString("RECEIVEREMAIL");
                message = rs.getString("MESSAGE");
                timeSent = rs.getTimestamp("TIMESENT");
                readstatus = rs.getString("READSTATUS");
                subject = rs.getString("SUBJECT");
                
                time = timeSent.toString();

                
                aMessageBean = new MessageBean(senderEmail, receiveEmail, message, time, readstatus, subject);
                // add the newly created object to the collection
                aMessageBeanCollection.add(aMessageBean);
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
        return aMessageBeanCollection;
    }
    
    
    @Override
    public int createMessage(MessageBean aMessage) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://gfish.it.ilstu.edu:1527/kbandel_Fall2014_KKLM_LinkeduDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO LinkedU.MESSAGES VALUES ('"
                    + aMessage.getSenderEmail()
                    + "','" + aMessage.getReceiverEmail()
                    + "','" + aMessage.getMessage()
                    + "',CURRENT_TIMESTAMP"
                    + ",'n"
                    + "','" + aMessage.getSubject()
                    + "')";

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
    public int readMessage(MessageBean pro){
        Connection DBConn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://gfish.it.ilstu.edu:1527/kbandel_Fall2014_KKLM_LinkeduDB";
            DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            

            String updateString;
            Statement stmt = DBConn.createStatement();

            // SQL UPDATE Syntax [http://www.w3schools.com]:
            // UPDATE table_name
            // SET column1=value, column2=value2,...
            // WHERE some_column=some_value
            // Note: Notice the WHERE clause in the UPDATE syntax. The WHERE clause specifies which record or records that should be updated. If you omit the WHERE clause, all records will be updated!
            updateString = "UPDATE LinkedU.Messages SET "
                    + "READSTATUS = 'y' "
                    + "WHERE SENDEREMAIL = '" + pro.getSenderEmail() + "' "
                    + "AND RECEIVEREMAIL = '" + pro.getReceiverEmail() + "' "
                    + "AND SUBJECT = '" + pro.getSubject() + "'";
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
