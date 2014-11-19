/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
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
import model.UserBean;

/**
 *
 * @author admin
 */

@Named(value = "userController")
@ManagedBean
@SessionScoped
public class UserController {

    // This corresponds to the response to be sent back to the client
    private String response;
    private UserBean theModel;

    /**
     * Creates a new instance of ProfileController
     */
    public UserController() {
        theModel = new UserBean();
    }
    
    public UserBean getTheModel() {
        return theModel;
    }

    public void setTheModel(UserBean theModel) {
        this.theModel = theModel;
    }

    public String getResponse() {  
        String resultStr = "";
        resultStr += "Hello " +theModel.getfName() + theModel.getlName() +
                "</br></br>Info inserted in DB: </br>Full Name - "+ theModel.getfName()+ 
                "</br> Password - "+ theModel.getPassword()+ 
                "</br> Email - "+ theModel.getEmail();
        response = resultStr;
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    public String createUser() {
        UserDAO aUserDAO = new UserDAOImpl();    // Creating a new object each time.
        int status = aUserDAO.createUser(theModel); // Doing anything with the object after this?
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
        String htmlText = "<H1>Hello "+ theModel.getfName()+ theModel.getlName() +
                ". Thank you for registering. Your username is: "+ theModel.getEmail() +
                "Your password is: " + theModel.getPassword()+". ";  
        messageBodyPart.setContent(htmlText, "text/html");  
  
  
        multipart.addBodyPart(messageBodyPart);  
          
        messageBodyPart = new MimeBodyPart();  
        DataSource fds = new FileDataSource("H:\\Assign3\\ISUlogo.png"); //Change ths picture to LinkedU!! 
        messageBodyPart.setDataHandler(new DataHandler(fds));  
        messageBodyPart.setHeader("Content-ID","<image>");  
  
        multipart.addBodyPart(messageBodyPart);  
   
        message.setContent(multipart);  
  
        Transport.send(message);  
          } catch (MessagingException mex) {
           mex.printStackTrace();
        }
        
            return "studentProfile.xhtml"; 
        }
        else
            return "error.xhtml"; 
    }
    
}
