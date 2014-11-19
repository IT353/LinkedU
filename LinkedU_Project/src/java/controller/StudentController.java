/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.StudentDAOImpl;
import Model.StudentBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
//import javax.servlet.http.Part;
//import org.primefaces.model.DefaultStreamedContent;
//import org.primefaces.model.StreamedContent;

/**
 *
 * @author kbandel
 */
@ManagedBean
@SessionScoped
public class StudentController implements Serializable {

    private StudentBean studentToInsert;
    private String firstName;
    private String city;
    private String state;
    private String email;
    private String univOfChoice;
    private String majorsOfChoice;
    private String activities;
    private double gpa;
    private int sat;
    private int act;
    private String about;
    private String highSchool;
    //private Part essay;
    //private Part image;
    //private StreamedContent imageForPosting;
    private String essayForPosting;

    //private DefaultStreamedContent graphicImage;
    /**
     * Creates a new instance of StudentBean
     */
    public StudentController() {
      
    }
    
    public void upload() throws IOException {
        // intilize an InputStream       

//        InputStream inputStream = null;
//        OutputStream outputStream = null;
//        FacesContext context = FacesContext.getCurrentInstance();
//        ServletContext servletContext = (ServletContext) context
//                .getExternalContext().getContext();
//        String path = servletContext.getRealPath("");
//        boolean file1Success = false;
//        if (essay.getSize()> 0) {
//            String fileName = essay.getSubmittedFileName();
//         
//            System.out.println("!!!!!!!!!!!!!!!!!1"+fileName);
//            
//            //destination where the file will be uploaded
//            
//            File outputFile = new File(path + File.separator + "WEB-INF"
//                    + File.separator + fileName);
//            inputStream = essay.getInputStream();
//            outputStream = new FileOutputStream(outputFile);
//            byte[] buffer = new byte[1024];
//            int bytesRead = 0;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//            
//                outputStream.close();
//            
//           
//                inputStream.close();
//            
//            file1Success = true;
//        }
        //InputStream is = getEssay().getInputStream();//get the contents of file
        //String result = getStringFromInputStream(is);
        //System.out.println("Contents of the uploaded file: " + result);
        //System.out.println("Done");
        
        StudentDAOImpl stuImpl = new StudentDAOImpl();
        studentToInsert = new StudentBean();
        studentToInsert.setfName(this.firstName);  
        studentToInsert.setStuEmail(email);
        studentToInsert.setHighSchool(highSchool);
        studentToInsert.setGpa(gpa);
        studentToInsert.setSat(sat);
        studentToInsert.setAct(act);
        studentToInsert.setCity(getCity());
        studentToInsert.setState(getState());
        studentToInsert.setAbout(about);
        //studentToInsert.setUploadedEssay(this.essay);
        //studentToInsert.setUploadedImage(this.image);
        studentToInsert.setActivities(activities);
        studentToInsert.setMajorsOfChoice(majorsOfChoice);
        studentToInsert.setUnivOfChoice(univOfChoice);
      
//        private String univOfChoice;
//    private String majorsOfChoice;
//    private String activities;
        int rowCount = stuImpl.insertStudent(studentToInsert);
        System.out.println("rowCount is : " + rowCount);

        this.displayStudent();
    }

    /*
     *Upload an image
     */
//      public String uploadImage() throws IOException{
//          
//      InputStream is = getImage().getInputStream();//get the contents of file
//               
//		String result = getStringFromInputStream(is);
//             
//		System.out.println("Contents of the uploaded image: "+ result);
//          
//          return "fileUploadSuccess";
//      }
    //The uploaded essay is posted to the profile page
    /**
     *
     *
     * @returns
     */
    public String displayStudent() {
        StudentDAOImpl stuImpl = new StudentDAOImpl();
        StudentBean retrievedStudent = (stuImpl.retrieveStudentPosting(firstName));
        this.firstName = retrievedStudent.getfName();
        this.email=retrievedStudent.getStuEmail();
        //this.lName=retrievedStudent.getlName();
        this.city=retrievedStudent.getCity();
        this.state=retrievedStudent.getState();
        
        this.gpa=retrievedStudent.getGpa();
        this.act=retrievedStudent.getAct();
        this.sat=retrievedStudent.getSat();
        this.about=retrievedStudent.getAbout();
        
        this.highSchool=retrievedStudent.getHighschool();
        this.activities=retrievedStudent.getActivities();
        this.majorsOfChoice=retrievedStudent.getMajorsOfChoice();
        this.essayForPosting = retrievedStudent.getEssay().toString();
        //this.imageForPosting = retrievedStudent.getStudentImage();
        // imageForPosting = new DefaultStreamedContent(is,"image/jpg", "donwloaded_file.jpg");
        System.out.println("name received by controller from the dao: " + firstName);
       // System.out.println("image received by controller: " + imageForPosting);
        System.out.println("response returned by retrieve student posting  is : " + this.getEssayForPosting());
         System.out.println("SAT received by controller: " + sat);
          System.out.println("HighSchool received by controller: " + highSchool);
        return "detailedposting.xhtml";
    }

    // convert InputStream to String
    private static String getStringFromInputStream(InputStream is) {
        
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        
        String line;
        try {
            
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return sb.toString();
        
    }

//    private static String getEssay(Part part){
//      for (String cd:part.getHeader("content-disposition").split(";")){
//          if (cd.trim().startsWith("filename")){
//              String filename = cd.substring(cd.indexOf('=')+1).trim().replace("\"","");
//              return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1 );
//          }
//          
//      }
//      return null;  
//    }
   
    /**
     * @return the univOfChoice
     */
    public String getUnivOfChoice() {
        return univOfChoice;
    }

    /**
     * @param univOfChoice the univOfChoice to set
     */
    public void setUnivOfChoice(String univOfChoice) {
        this.univOfChoice = univOfChoice;
    }

    /**
     * @return the majorsOfChoice
     */
    public String getMajorsOfChoice() {
        return majorsOfChoice;
    }

    /**
     * @param majorsOfChoice the majorsOfChoice to set
     */
    public void setMajorsOfChoice(String majorsOfChoice) {
        this.majorsOfChoice=majorsOfChoice;
    }

    /**
     * @return the activities
     */
    public String getActivities() {
        return activities;
    }

    /**
     * @param stuActivities the activities to set
     */
    public void setActivities(String stuActivities) {
        this.activities=stuActivities;
    }

    /**
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * @return the sat
     */
    public int getSat() {
        return sat;
    }

    /**
     * @param sat the sat to set
     */
    public void setSat(int sat) {
        this.sat = sat;
    }

    /**
     * @return the act
     */
    public int getAct() {
        return act;
    }

    /**
     * @param act the act to set
     */
    public void setAct(int act) {
        this.act = act;
    }

    

    /**
     * @return the essayForPosting
     */
    public String getEssayForPosting() {
        return essayForPosting;
    }

    /**
     * @param essayForPosting the essayForPosting to set
     */
    public void setEssayForPosting(String essayForPosting) {
        this.essayForPosting = essayForPosting;
    }

    /**
     * @return the student
     */
    public StudentBean getStudent() {
        return studentToInsert;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(StudentBean student) {
        this.studentToInsert = student;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the about
     */
    public String getAbout() {
        return about;
    }

    /**
     * @param about the about to set
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * @return the highSchool
     */
    public String getHighSchool() {
        return highSchool;
    }

    /**
     * @param highSchool the highSchool to set
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
}

