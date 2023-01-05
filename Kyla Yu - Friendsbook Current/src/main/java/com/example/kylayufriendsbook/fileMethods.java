package com.example.kylayufriendsbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class fileMethods{

    // Writing to file -------------------------------------------
    static File groupsFile = new File("groupsToFile.txt");

    public static void groupWriteToFile(Group group) throws IOException {
        FileOutputStream out = new FileOutputStream(group.getGroupFile(), true);
        FileWriter fw = new FileWriter(group.getGroupFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Object object : group.getFriendList()){
            //Writing to designated group file
            Friend friend = (Friend) object;
            bw.write(friend.getName() + "|\n");
            bw.write(friend.getEmail() + "|\n");
            bw.write(friend.getFavColour() + "|\n");
            bw.write(friend.getGroup().toString() + "|\n");
            bw.write(";\n");
            bw.close();
        }
    }
    public static void friendWriteToFile(Group group) throws IOException {

    }

    // Reading from file ------------------------
    private static String name;
    private static String email;
    private static String favColour;
    private static HashSet<Friend> friendsFromFile = new HashSet<>();

    private static FileReader fr;
    private static BufferedReader br;

    public static Group loadGroup(String fileName) throws IOException{
        Group group = new Group(fileName);
        /*fr = new FileReader(group.getGroupFile());
        br = new BufferedReader(fr);
        String line;
        String friendLine = "";

        while((line = br.readLine()) != null){
            if (!line.equals(";")){
                friendLine += line;
            }else{
                parseFriend(friendLine, group);
                friendLine = "";
            }
        }*/
        return group;
    }

    public static HashSet loadFriends(Group group) throws IOException{
        fr = new FileReader(group.getGroupFile());
        br = new BufferedReader(fr);
        String line;
        String friendLine = "";

        while((line = br.readLine()) != null){
            if (!line.equals(";")){
                friendLine += line;
            }else{
                parseFriend(friendLine, group);
                friendLine = "";
            }
        }
        return friendsFromFile;
    }

    private static void parseFriend(String friend, Group group){
        friend = friend.replaceAll(";", "");
        String[] friendAttributes = friend.split("\\|");

        String nameTemp = friendAttributes[0];
        String emailTemp = friendAttributes[1];
        String favColourTemp = friendAttributes[2];
        Group groupTemp = group;

        Friend temp = new Friend(nameTemp, emailTemp, favColourTemp, groupTemp);

        temp.getGroup().getFriendList().add(temp);
        friendsFromFile.add(temp);

    }
}
