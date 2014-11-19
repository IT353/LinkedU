/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.MessageDAO;
import dao.MessageDAOImpl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.MessageBean;

/**
 *
 * @author ljpetr2
 */
@ManagedBean
@SessionScoped
public class MessageController {
    private MessageBean theModel;
    private String response;
    private List<MessageBean> messages;
    
    public MessageController(){
        theModel = new MessageBean();
    }

    /**
     * @return the theModel
     */
    public MessageBean getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(MessageBean theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the messages
     */
    public List<MessageBean> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<MessageBean> messages) {
        this.messages = messages;
    }
    
    
    public List<MessageBean> retrieveMessages(String aEmail) {
            MessageDAO aMessageDAO = new MessageDAOImpl();    
            this.setMessages((List<MessageBean>) aMessageDAO.findAll(aEmail));           
 
            return getMessages(); 
    }
    
    public String createMessage(){
        MessageDAO aAccountDAO = new MessageDAOImpl();    
            int rowCount = aAccountDAO.createMessage(theModel); 
        
            if (rowCount == 1 ) {
                setResponse("Message sent!");
            }
            else
                setResponse("Failure to send");
            
            return "messagesCompose.xhtml";
    }
    
    public String navigate(){
        return "messages.xhtml";
    }
    
    public String replyMessage(String sender){
        theModel.setSenderEmail(theModel.getReceiverEmail());
        theModel.setReceiverEmail(sender);
        theModel.setMessage("");
        theModel.setSubject("");
        
        return "messagesCompose.xhtml";
        
    }
    
    public String composeMessage(String receiver){
        theModel.setSenderEmail(receiver);
        theModel.setReceiverEmail("");
        theModel.setMessage("");
        theModel.setSubject("");
        
        return "messagesCompose.xhtml";       
    }
    
    public String viewMessage(MessageBean message){
            MessageDAO aAccountDAO = new MessageDAOImpl();    
            int rowCount = aAccountDAO.readMessage(message); 

            if (rowCount == 1 ) {
                theModel = message;
                return "messagesRead.xhtml";
            }
            else {
                return "messages.xhtml";
            }    
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
}
