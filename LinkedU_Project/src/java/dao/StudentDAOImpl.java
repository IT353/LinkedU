/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.StudentBean;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author kbandel
 */
public class StudentDAOImpl implements StudentDAO {

    //private DefaultStreamedContent myImage;

    @Override
    public int insertStudent(StudentBean studentToInsert) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        //  String myDB = "jdbc:derby://localhost:1527/Project353";
        String myDB = "jdbc:derby://gfish.it.ilstu.edu:1527/kbandel_Fall2014_KKLM_LinkeduDB";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        int rowCount = 0;

        //add userID validation here.
        try {
            String sql = "INSERT INTO LinkedU.Students (USEREMAIL,FIRSTNAME,CITY, STATE, GPA,SAT, ACT, HIGHSCHOOL, UNICHOICES, MAJCHOICES, ABOUT, "
                    + "INTERESTS, ACTIVITIES, PICTURE, ESSAY) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // With the connection made, create a statement to talk to the DB server.
//            //insert login info
//            String sql = "INSERT INTO PROJECT353.LoginInfo "
//                    + "(USERID, PASSWORD,ESSAY,IMAGE,GPA,SAT,ACT,HIGH_SCHOOL,LAST_NAME,ABOUT,EMAIL) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = DBConn.prepareStatement(sql);
            statement.setString(1, studentToInsert.getStuEmail());
            statement.setString(2, studentToInsert.getfName());
            statement.setString(3, studentToInsert.getCity());
            statement.setString(4, studentToInsert.getState());
            statement.setDouble(5, studentToInsert.getGpa());
            statement.setInt(6, studentToInsert.getSat());
            statement.setInt(7, studentToInsert.getAct());
            statement.setString(8, studentToInsert.getHighschool());
            statement.setString(9, studentToInsert.getUnivOfChoice());
            statement.setString(10, studentToInsert.getMajorsOfChoice());
            statement.setString(11, studentToInsert.getAbout());

            statement.setString(12, studentToInsert.getInterests());
            statement.setString(13, studentToInsert.getActivities());
            //get inputstream from image
            //InputStream is2 = studentToInsert.getUploadedImage().getInputStream();
            //statement.setBinaryStream(14, is2, (int) studentToInsert.getUploadedImage().getSize());

            //InputStream is = studentToInsert.getUploadedEssay().getInputStream();
            //statement.setBinaryStream(15, is, (int) studentToInsert.getUploadedEssay().getSize());
            //System.out.println("MESSAGE FROM DAO IMPL-length of uploaded file: " + studentToInsert.getUploadedEssay().getSize());

            //rowCount = statement.executeUpdate();
            //statement.close();
            //is.close();

        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return rowCount;
    }

    @Override
    public StudentBean[] findStudents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StudentBean retrieveStudentPosting(String id) {
        StudentBean retrievedStudent = null;
        boolean querySuccessful;
        String text = null;
        InputStream inputStream = null;

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        //String myDB = "jdbc:derby://localhost:1527/Project353";
        String myDB = "jdbc:derby://gfish.it.ilstu.edu:1527/kbandel_Fall2014_KKLM_LinkeduDB";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        try {

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to insert user info
            String query = "SELECT  USEREMAIL,FIRSTNAME, CITY,STATE, GPA, SAT, ACT,HIGHSCHOOL, UNICHOICES, MAJCHOICES,ABOUT,INTERESTS, PICTURE,ESSAY,ACTIVITIES "
                    + "from LinkedU.Students"
                    + " WHERE   FIRSTNAME like '" + id + "'";
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String email, name, city, state, activities, unichoices, majchoices, interests, about, highschool;
            double gpa = 0;
            int act = 0, sat;
            Blob essay, image;

            while (rs.next()) {
                email = rs.getString("USEREMAIL");
                name = rs.getString("FIRSTNAME");
                city = rs.getString("CITY");
                state = rs.getString("STATE");
                activities = rs.getString("ACTIVITIES");
                interests = rs.getString("INTERESTS");
                unichoices = rs.getString("UNICHOICES");
                majchoices = rs.getString("MAJCHOICES");
                essay = rs.getBlob("ESSAY");
                image = rs.getBlob("PICTURE");
                about = rs.getString("ABOUT");
                highschool = rs.getString("HIGHSCHOOL");
                gpa = rs.getDouble("GPA");
                act = rs.getInt("ACT");
                sat = rs.getInt("SAT");
                //make LoginInfo object using values
                System.out.println("name and email in dao impl after retrieval" + name + email);

                //GET CONTENT FROM ESSAY BLOB
                byte[] bdata = essay.getBytes(1, (int) essay.length());
                text = new String(bdata);
                querySuccessful = true;
                System.out.println(text);
                System.out.println(highschool);

                //GET BYTES FROM IMAGE BLOB
                byte[] imageData = image.getBytes(1, (int) image.length());
                // InputStream imageStream = imageData.;
                //InputStream is = new BufferedInputStream ( imageData.getInputStream() );  
                //BufferedImage image = ImageIO.read (is);  

                //  inputStream = image.getBinaryStream(1, image.length());
                //myImage = new DefaultStreamedContent(new ByteArrayInputStream(imageData), "image/jpg");
                //if (myImage == null) {
                //    System.out.println("my Image is null");
                //}
                //System.out.println("myImage has :" + image.length());

                retrievedStudent = new StudentBean();
                retrievedStudent.setfName(name);
                retrievedStudent.setStuEmail(email);
                retrievedStudent.setCity(city);
                retrievedStudent.setState(state);
                retrievedStudent.setActivities(activities);
                retrievedStudent.setInterests(interests);
                retrievedStudent.setMajorsOfChoice(majchoices);
                retrievedStudent.setUnivOfChoice(unichoices);
                retrievedStudent.setAbout(about);
                retrievedStudent.setSat(sat);
                retrievedStudent.setAct(act);
                retrievedStudent.setGpa(gpa);
                retrievedStudent.setHighSchool(highschool);
                
                byte[] bdata1 = essay.getBytes(1, (int) essay.length());
                String text1 = new String(bdata1);
                retrievedStudent.setEssay(text1);
                //retrievedStudent.setStudentImage(myImage);

            }
            rs.close();

            stmt.close();
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select in StudentDAOImpl");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return retrievedStudent;
    }

//    @Override
//    public UserBean findUserById(String id) {
//        UserBean user=null;
//       
//         DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
//        String myDB = "jdbc:derby://localhost:1527/Project353";
//        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student"); 
//        try {
//
//            // With the connection made, create a statement to talk to the DB server.
//            // Create a SQL statement to insert user info
//           String query="SELECT  U.USER_ID,LAST_NAME,SECURITY_QUESTION, EMAIL_ADDRESS,SECURITY_ANSWER,PASSWORD, FIRST_NAME "
//                    + "from PROJECT353.USERS U , PROJECT353.LOGININFO L where  U.USER_ID = L.USERID"
//           +" and  U.USER_ID like "+"'"+ id+"'";
//            Statement stmt = DBConn.createStatement();
//             ResultSet rs = stmt.executeQuery(query);
//            String userid, firstName, lastName, email,  pwd, question, answer;
//        
//             while (rs.next()) {
//                userid = rs.getString("USER_ID");
//                lastName = rs.getString("LAST_NAME");
//                question = rs.getString("SECURITY_QUESTION");
//                email= rs.getString("EMAIL_ADDRESS");
//                answer=rs.getString("SECURITY_ANSWER");
//                pwd = rs.getString("PASSWORD");
//                firstName = rs.getString("FIRST_NAME");
//                   //make LoginInfo object using values
//                 System.out.println(id+lastName);
//               
//                // make a USER object out of the values
//               user = new UserBean(userid,firstName, lastName, email, question,answer, pwd);
//                // add the newly created object to the collection
//                
//            }
//            rs.close();
//             
//            stmt.close();
//        } catch (Exception e) {
//            System.err.println("ERROR: Problems with SQL select");
//            e.printStackTrace();
//        }
//        try {
//            DBConn.close();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }       
//        
//        return user;
//    }
    //  }
}
