package com.example.kylayufriendsbook;

import java.io.*;

public class fileMethods{

    //Group write to file method
    File groupFile = new File();

    public static void groupWriteToFile(Group group) throws IOException {
        FileOutputStream tempFile = new FileOutputStream(group.getGroupFile(), true);
        FileWriter fr = new FileWriter(group.getGroupFile());
        BufferedWriter bw = new BufferedWriter(fr);

        bw.write(group.getGroupName() + "|\n");
        bw.write(";\n");
        bw.close();
    }
    public void friendWriteToFile(Friend friend) throws IOException {
        Group friendGroup = friend.getGroup();
        FileOutputStream out = new FileOutputStream(friendGroup.getGroupFile());
        FileWriter fw = new FileWriter(friendGroup.getGroupFile());
        BufferedWriter bw = new BufferedWriter(fw);

        //Writing to designated group file
        bw.write(friend.getFirstName() + "|\n");
        bw.write(friend.getLastName() + "|\n");
        bw.write(friend.getEmail() + "|\n");
        bw.write(friend.getAddress() + "|\n");
        bw.write(friend.getFavColour() + "|\n");
        bw.write(friend.getGroup().toString() + "|\n");
        bw.write(";\n");
        bw.close();
    }
}
