/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UniversityDAO;
import dao.UniversityDAOImpl;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import model.UniversityBean;
import model.UserBean;

/**
 *
 * @author admin
 */

@Named(value = "universityController")
@ManagedBean
@SessionScoped
public class UniversityController {

    // This corresponds to the response to be sent back to the client
    private String response;
    private UniversityBean theModel;

    /**
     * Creates a new instance of ProfileController
     */
    public UniversityController() {
        theModel = new UniversityBean();
    }
    
    public UniversityBean getTheModel() {
        return theModel;
    }

    public void setTheModel(UniversityBean theModel) {
        this.theModel = theModel;
    }

    public String getResponse() {  
        String resultStr = "";
        resultStr += "Hello " +theModel.getUnName() +
                "</br></br>Info inserted in DB: </br>University - "+ theModel.getUnName()+ 
                "</br> Password - "+ theModel.getPassword()+ 
                "</br> Email - "+ theModel.getEmail();
        response = resultStr;
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    public String createUniversity() {
        UniversityDAO aUniversityDAO = new UniversityDAOImpl();    // Creating a new object each time.
        int status = aUniversityDAO.createUniversity(theModel); // Doing anything with the object after this?
        if (status == 1){
            
       String to = theModel.getEmail();

        // Sender's email ID needs to be mentioned
        String from = "kapodla@ilstu.edu";

        // Assuming you are sending email from this host
        String host = "smtp.ilstu.edu";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
    //    properties.setProperty("mail.user", "yourID"); // if needed
      //  properties.setProperty("mail.password", "yourPassword"); // if needed

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
 
  try {
        MimeMessage message = new MimeMessage(session);  
        message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
        message.setSubject("LinkedU: Login");  
     
        MimeMultipart multipart = new MimeMultipart("related");  
  
        BodyPart messageBodyPart = new MimeBodyPart();  
        String htmlText = "<H1>Hello "+ theModel.getUnName()+ 
                ". Thank you for registering. Your username is: "+ theModel.getEmail() +
                "Your password is: " + theModel.getPassword()+". ";  
        messageBodyPart.setContent(htmlText, "text/html");  
  
  
        multipart.addBodyPart(messageBodyPart);  
          
        messageBodyPart = new MimeBodyPart();  
        DataSource fds = new FileDataSource("H:\\Assign3\\ISUlogo.png");  //Change picture to LinkedU!!!
        messageBodyPart.setDataHandler(new DataHandler(fds));  
        messageBodyPart.setHeader("Content-ID","<image>");  
  
        multipart.addBodyPart(messageBodyPart);  
   
        message.setContent(multipart);  
  
        Transport.send(message);  
          } catch (MessagingException mex) {
           mex.printStackTrace();
        }
        
            return "universityProfile.xhtml"; 
        }
        else
            return "error.xhtml"; 
    }
    
}
