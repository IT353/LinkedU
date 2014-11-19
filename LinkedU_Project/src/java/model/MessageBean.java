/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author ljpetr2
 */
public class MessageBean {
    private String senderEmail;
    private String receiverEmail;
    private String message;
    private String timeSent;
    private String readStatus;
    private String subject;
    
    public MessageBean(){
    }
    
    public MessageBean(String senderEmail, String receiverEmail, String message, String timeSent, String readStatus, String subject){
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.message = message;
        this.timeSent = timeSent;
        this.readStatus = readStatus;
        this.subject = subject;
    }
    
    /**
     * @return the senderEmail
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    /**
     * @param senderEmail the senderEmail to set
     */
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    /**
     * @return the receiverEmail
     */
    public String getReceiverEmail() {
        return receiverEmail;
    }

    /**
     * @param receiverEmail the receiverEmail to set
     */
    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    /**
     * @return the Message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the timeSent
     */
    public String getTimeSent() {
        return timeSent;
    }

    /**
     * @param timeSent the timeSent to set
     */
    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    /**
     * @return the readStatus
     */
    public String getReadStatus() {
        return readStatus;
    }

    /**
     * @param readStatus the readStatus to set
     */
    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
            
    
    
}
