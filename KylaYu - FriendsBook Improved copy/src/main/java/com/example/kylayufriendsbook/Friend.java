package com.example.kylayufriendsbook;

import java.io.*;

public class Friend {
    public String name1;
    public String name2;
    public String fullName;
    public String email;
    public String phoneNum;
    public String address;
    public String favColour;
    public Group group;

    Friend(String firstName, String lastName, String email, String phoneNum, String address, String favColour, Group group){
        this.name1 = firstName;
        this.name2 = lastName;
        fullName = firstName + " " + lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.favColour = favColour;
        this.group = group;

    }

    //getters and setters
    public String getFirstName(){return name1;}
    public void setFirstName(String firstName){this.name1 = firstName;}

    public String getLastName(){return name2;}
    public void setLastName(String lastname){this.name2 = lastname;}

    public String getFullName(){return fullName;}
    public void setFullName(String firstName, String lastName){fullName = firstName + " " + lastName;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getPhoneNum(){return phoneNum;}
    public void setPhoneNum(String phoneNum){this.phoneNum = phoneNum;}

    public String getFavColour(){return favColour;}
    public void setFavColour(String favColour){this.favColour = favColour;}

    public Group getGroup(){return group;}

    //To String method
    public String toString(){ return fullName;}

    //Writing and retrieving data from text files

}
