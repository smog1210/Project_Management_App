package com.example.project_management_app;

import android.graphics.Bitmap;
import android.view.View;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

/**
 *
 */
public class Profile {
    private String firstName;
    private String lastName;
    private String userName;
    private Boolean isActive;
    private Boolean isManager;
    private String EmployeeId;
    private String bio;
    private String phoneNumber;
    private String email;
    private String position;
    //private List<Integer> hours;
    private Boolean isLoggedIn;
    private String userId;
    //private Vector<Task> t;
    //private Bitmap profilePic;
    private String[] tasks;

    /**
     * CONSTRUCTOR: Profile.class
     * @param userName String, also is == email
     * @param firstName String
     * @param lastName String
     * @param userId String
     */
    Profile(String userName, String firstName, String lastName, String userId ) {
        this.userName = userName;
        this.email = userName;
        this.userId = userId;
        isActive = true;
        isManager = false;
        isLoggedIn = false;
        this.firstName = firstName;
        this.lastName = lastName;
        EmployeeId = "uninitialized";
        bio = "No Bio Written";
        phoneNumber = "000-000-0000";
        position = "not assigned";
        //Vector<Task> t = new Vector<>();
        tasks = new String[] { "Hello", "I'm", "A String", "array"};
    }

    Profile(){
         firstName = "";
         lastName = "please log in";
         userName = "uninitialized";
         isActive = true;
         isManager = false;
         EmployeeId = "uninitialized";
         bio = "uninitialized";
         phoneNumber = "000-000-0000";
         email = "NotLoggedIn@noMail.com";
         position = "uninitialized";
         //hours;
         isLoggedIn = false;
         userId = "uninitialized";
         //t;
         //profilePic;
         tasks = new String[] {"uninitialized"};;
    }


    /*
    GETTERS AND SETTERS
     */
    public final String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
    public Boolean isManager() {

        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }
    */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /*
    public Queue<Integer> getHours() {
        return hours;
    }

    public void setHours(Queue<Integer> hours) {
        this.hours = hours;
    }
    */

    public Boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

//    public Vector<Task> getTasks() {
//        return t;
//    }
//
//    public void setTasks(Vector<Task> t) {
//        this.t = t;
//    }
//
//    public Bitmap getProfilePic() { return profilePic; }
//
//    public void setProfilePic(Bitmap profilePic) { this.profilePic = profilePic; }

    public void makeNewTask(View v){

    }

    public void sendTask(View v){

    }
}
