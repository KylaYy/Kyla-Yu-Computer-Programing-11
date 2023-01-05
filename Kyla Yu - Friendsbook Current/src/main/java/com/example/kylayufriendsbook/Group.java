package com.example.kylayufriendsbook;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class Group {
    public String groupName;
    public File groupFile;
    public HashSet<Friend> friends;

    Group(String groupName){
        this.groupName = groupName;
        this.groupFile = new File(groupName + ".txt");
        this.friends = new HashSet<>();

    }

    //Getters and setters
    public String getGroupName(){return groupName;}
    public void setGroupName(String groupName){this.groupName = groupName;}

    public File getGroupFile(){return groupFile;}

    public HashSet getFriendList(){return friends;}

    public String toString(){
        return groupName;
    }

    public HashSet<Friend> getFriends() {
        return friends;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Group)) return false;

        Group other = (Group) o;
        if (this.groupName.equals(other.groupName)){
            return true;
        }
        else {return false;}
    }

    @Override
    public int hashCode(){
        return 0;
    }
}
