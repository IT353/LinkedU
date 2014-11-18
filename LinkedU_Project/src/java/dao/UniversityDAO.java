/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.UniversityBean;
import model.UserBean;

/**
 *
 * @author admin
 */
public interface UniversityDAO {
    
    public int createUniversity(UniversityBean aUniversity);
    public UserBean[] findAll();
    public UserBean findByUniversity(String aUniversity);   
    public int updateUniversity(UniversityBean aUniversity); 
}
