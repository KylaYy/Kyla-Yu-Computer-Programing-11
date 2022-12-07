package com.example.kylayufriendsbook;

import java.io.*;

public class Group {
    public String groupName;
    public File groupFile;

    Group(String groupName){
        this.groupName = groupName;
        this.groupFile = new File(groupName + ".txt");
    }

    public String getGroupName(){return groupName;}
    public void setGroupName(String groupName){this.groupName = groupName;}

    public File getGroupFile(){return groupFile;}

    public String toString(){
        return groupName;
    }
}
