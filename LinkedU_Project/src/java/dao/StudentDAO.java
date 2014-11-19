/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.StudentBean;
//import java.io.InputStream;
//import javax.servlet.http.Part;
//import org.primefaces.model.DefaultStreamedContent;
//import org.primefaces.model.StreamedContent;


/**
 *
 * @author kbandel
 */
public interface StudentDAO {
    
    public int insertStudent(StudentBean studentToInsert);
    public StudentBean[] findStudents();
    public StudentBean retrieveStudentPosting(String id);  
}


