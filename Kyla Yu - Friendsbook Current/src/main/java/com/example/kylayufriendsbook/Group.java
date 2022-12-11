package com.example.kylayufriendsbook;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Group {
    public String groupName;
    public File groupFile;
    public ArrayList<Friend> friends;

    Group(String groupName){
        this.groupName = groupName;
        this.groupFile = new File(groupName + ".txt");
        this.friends = new ArrayList<>();

    }

    //Getters and setters
    public String getGroupName(){return groupName;}
    public void setGroupName(String groupName){this.groupName = groupName;}

    public File getGroupFile(){return groupFile;}

    public ArrayList getFriendList(){return friends;}

    public String toString(){
        return groupName;
    }
}
