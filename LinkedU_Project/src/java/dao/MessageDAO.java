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
public interface MessageDAO {
    public ArrayList findAll(String aEmail);
    public int createMessage(MessageBean aMessage);
    public int readMessage(MessageBean pro);
}
