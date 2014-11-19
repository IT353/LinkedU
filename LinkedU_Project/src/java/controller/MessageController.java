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
    
    
    public List<MessageBean> retrieveMessages() {
            MessageDAO aMessageDAO = new MessageDAOImpl();    
            this.setMessages((List<MessageBean>) aMessageDAO.findAll());           
 
            return getMessages(); 
    }
    
}
