package com.example.kylayufriendsbook;

import java.io.*;
import java.util.ArrayList;

public class fileMethods{

    // Writing to file -------------------------------------------
    static File groupsFile = new File("groupsToFile.txt");

    public static void groupWriteToFile(Group group) throws IOException {
        FileOutputStream out = new FileOutputStream(groupsFile, true);
        FileWriter fr = new FileWriter(group.getGroupFile());
        BufferedWriter bw = new BufferedWriter(fr);

        bw.write(group.getGroupName());
        bw.write(";\n");
        bw.close();
    }
    public static void friendWriteToFile(Friend friend, Group group) throws IOException {
        FileOutputStream out = new FileOutputStream(group.getGroupFile(), true);
        FileWriter fw = new FileWriter(group.getGroupFile());
        BufferedWriter bw = new BufferedWriter(fw);

        //Writing to designated group file
        bw.write(friend.getName() + "|\n");
        bw.write(friend.getEmail() + "|\n");
        bw.write(friend.getFavColour() + "|\n");
        bw.write(friend.getGroup().toString() + "|\n");
        bw.write(";\n");
        bw.close();
    }

    // Reading from file ------------------------
    private static String name;
    private static String email;
    private static String favColour;
    private static ArrayList<Friend> friendsFromFile = new ArrayList<>();

    private static FileReader fr;
    private static BufferedReader br;

    public static ArrayList<Group> loadGroups() throws IOException{
        fr = new FileReader(groupsFile);
        br = new BufferedReader(fr);
        String line;
        ArrayList<Group> groupsList = new ArrayList<>();

        while((line = br.readLine()) != null){
            if(!line.equals(";")){
                Group groupTemp = new Group(line);
                groupsList.add(groupTemp);
            }
        }
        return groupsList;
    }

    public static ArrayList loadFriends(Group group) throws IOException{
        fr = new FileReader(group.getGroupFile());
        br = new BufferedReader(fr);
        String line;
        String friendLine = "";

        while((line = br.readLine()) != null){
            if (!line.equals(";")){
                friendLine += line;
            }else{
                parseFriend(friendLine);
                friendLine = "";
            }
        }
        return friendsFromFile;
    }

    private static void parseFriend(String friend){
        friend = friend.replaceAll("|", " ");
        friend = friend.replaceAll(";", "");
        String[] friendAttributes = friend.split(" ");

        String name = friendAttributes[0];
        String email = friendAttributes[1];
        String favColour = friendAttributes[2];
        Group group = new Group(friendAttributes[3]);

        Friend temp = new Friend(name, email, favColour, group);

        friendsFromFile.add(temp);

    }
}
