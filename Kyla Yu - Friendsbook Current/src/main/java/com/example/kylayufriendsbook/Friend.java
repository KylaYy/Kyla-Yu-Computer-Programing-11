package com.example.kylayufriendsbook;

import java.io.*;

public class Friend {
    public String name;
    public String email;
    public String favColour;
    public Group group;

    Friend(String name, String email, String favColour, Group group){
        this.name = name;
        this.email = email;
        this.favColour = favColour;
        this.group = group;

    }

    //getters and setters
    public String getName(){return name;}
    public void setFirstName(String Name){this.name = Name;}

    public String getEmail(){return email;}
    public void setEmail(String Email){this.email = Email;}

    public String getFavColour(){return favColour;}
    public void setFavColour(String favColour){this.favColour = favColour;}

    public Group getGroup(){return group;}
    public void setGroup(Group group){this.group = group;}

    //To String method
    public String toString(){ return name;}

    @Override
    public boolean equals(Object o) {
        if (o == this) return true; // check if the Object we pass is the same as the one we are calling on. ex. s.equals(s)
        if (!(o instanceof Friend)) return false; // check if o is an object of Friend

        Friend other = (Friend) o;

        if (this.name.equals(other.name) && this.email.equals(other.email) && this.favColour.equals(other.favColour) &&
                this.group.getGroupName().equals(other.group.getGroupName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 0;
    }
}
