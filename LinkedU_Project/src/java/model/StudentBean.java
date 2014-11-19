/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

//import javax.servlet.http.Part;
//import org.primefaces.model.StreamedContent;


public class StudentBean {
    
    private String fName;
    //private Part uploadedEssay;
    //private Part uploadedImage;
    private String highschool;
    private String univOfChoice;
    private String majorsOfChoice;
    private String interests;
    private String activities;
    private String essay;
    private String about;
    private String city;
    private String state;
    private String stuEmail;
    private double  gpa;
    private int sat;
    private int  act;
    //private StreamedContent studentImage;
    
    
    public StudentBean(){  
    }
    
    public StudentBean(String fName, String highschool, String univOfChoice, String majorsOfChoice, String interests,
                            String activities, String essay, String about, String city, String state, String stuEmail, double gpa, int sat, int act){
        this.fName = fName;
        //this.uploadedEssay = uploadedEssay;
        //this.uploadedImage = uploadedImage;
        this.highschool = highschool;
        this.univOfChoice = univOfChoice;
        this.majorsOfChoice = majorsOfChoice;
        this.interests = interests;
        this.activities = activities;
        this.essay = essay;
        this.about = about;
        this.city = city;
        this.state = state;
        this.stuEmail = stuEmail;
        this.gpa = gpa;
        this.sat = sat;
        this.act = act;
        //this.studentImage = studentImage;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

  

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
     * @return the activities
     */
    public String getActivities() {
        return activities;
    }

    /**
     * @param activities the activities to set
     */
    public void setActivities(String activities) {
       this.activities=activities;
    }

    /**
     * @return the essay
     */
    public String getEssay() {
        return essay;
    }

    /**
     * @param essay the essay to set
     */
    public void setEssay(String essay) {
        this.essay = essay;
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

    /**
     * @return the stuEmail
     */
    public String getStuEmail() {
        return stuEmail;
    }

    /**
     * @param stuEmail the stuEmail to set
     */
    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }
    
    public void setAbout(String about) {
       this.about = about;
    }
     /**
     * @return the about
     */
    public String getAbout() {
        return about;
    }

    public void setHighSchool(String highSchool) {
        this.highschool=highSchool;
    }


    /**
     * @return the highschool
     */
    public String getHighschool() {
        return highschool;
    }

    /**
     * @param highschool the highschool to set
     */
    public void setHighschool(String highschool) {
        this.highschool = highschool;
    }

    public void setMajorsOfChoice(String majorsOfChoice) {
         this.majorsOfChoice = majorsOfChoice;
    }

    /**
     * @return the interests
     */
    public String getInterests() {
        return interests;
    }

    /**
     * @param interests the interests to set
     */
    public void setInterests(String interests) {
        this.interests = interests;
    }

}
