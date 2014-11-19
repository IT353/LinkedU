/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.ArrayList;
import model.MessageBean;

/**
 *
 * @author ljpetr2
 */
public class MessageDAOImpl implements MessageDAO {
    public ArrayList findAll(){
        ArrayList empty  = new ArrayList(3);
        return empty;
    }
    
    
    public int createMessage(MessageBean aMessage){
        return 0;
    }
    
}
