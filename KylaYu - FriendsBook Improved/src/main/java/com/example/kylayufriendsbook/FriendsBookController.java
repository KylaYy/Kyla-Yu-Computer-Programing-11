package com.example.kylayufriendsbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FriendsBookController {

    //User info entry
    public TextField firstName;
    public TextField lastName;
    public TextField email;
    public TextField phoneNumber;
    public TextField address;
    public TextField favColour;
    public ChoiceBox<String> group;
    public ListView<Friend> friendsList;

    //display labels
    public Label lblName;
    public Label lblEmail;
    public Label lblPhoneNum;
    public Label lblAddress;
    public Label lblFavColour;
    public ChoiceBox<String> friendDisplayChoice;
    public TextField groupName;

    //Group names list
    public ArrayList<String> groups = new ArrayList<>();

    //method called on button press, creates new friend object and adds friend to listview
    public void createNewFriend(ActionEvent actionEvent) throws IOException {
        Friend temp = new Friend(firstName.getText(), lastName.getText(), email.getText(), phoneNumber.getText(), address.getText(), favColour.getText(), group.getValue());
        firstName.clear(); lastName.clear(); email.clear(); phoneNumber.clear(); address.clear(); favColour.clear();
        temp.writeTotxtFile();
    }

    //Displays friend information on mouseclick
    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp = (Friend) friendsList.getSelectionModel().getSelectedItem();
        lblName.setText(temp.getFullName()); lblEmail.setText(temp.getEmail()); lblPhoneNum.setText(temp.getPhoneNum()); lblAddress.setText(temp.getAddress()); lblFavColour.setText(temp.getFavColour());
    }

    //removes friend from listview
    public void deleteFriend(ActionEvent actionEvent) throws IOException{
        Friend toDelete = (Friend) friendsList.getSelectionModel().getSelectedItem();
        friendsList.getItems().remove(toDelete);
        lblName.setText(" ");
        lblEmail.setText(" ");
        lblPhoneNum.setText(" ");
        lblAddress.setText(" ");
        lblFavColour.setText(" ");

        String toDeleteFromFile = toDelete.getFirstName() + "," + toDelete.getLastName() + "," + toDelete.getEmail() + "," + toDelete.getPhoneNum() + "," + toDelete.getAddress() + "," + toDelete.getFavColour() + "," + toDelete.getGroup() + "\n";

        //Initializing variables and file editors/readers
        FileInputStream in;
        FileOutputStream out;
        File toDeleteFile = new File(toDelete.getGroup() + ".txt");
        File tempFile = new File("tempFile");
        in = new FileInputStream(toDeleteFile);
        out = new FileOutputStream(tempFile);
        FileReader fr = new FileReader(toDeleteFile);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(tempFile);
        BufferedWriter bw = new BufferedWriter(fw);
        String lineCurr;
        while ((lineCurr = br.readLine()) != null){
            String trimmedLine = lineCurr.trim();
            if (lineCurr.equals(toDeleteFromFile)){continue;}
            bw.write(lineCurr + System.getProperty("line.separator"));
        }
        bw.close();
        br.close();
        boolean successful = tempFile.renameTo(toDeleteFile);
    }

    //Create text file for new group
    public void createGroup(ActionEvent actionEvent) throws IOException {

        groupName.clear();
        //txt file for each new group made
        FileOutputStream out;
        String groupNameString = groupName.getText();
        FileWriter fw = new FileWriter(groupNameString + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        out = new FileOutputStream(groupNameString + ".txt");
        bw.close();

        //adding new group to dropdown choiceboxes
        groups.add(groupNameString);
        friendDisplayChoice.getItems().addAll(groups);
        group.getItems().addAll(groups);

    }

    public void loadGroup(ActionEvent actionEvent) throws IOException{
        String groupTemp = friendDisplayChoice.getValue();

        FileInputStream in;
        FileReader fr = new FileReader(groupTemp + ".txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Friend> friendsofGroup = new ArrayList<>();

        String friendTempLine;
        while ((friendTempLine = br.readLine()) != null){
            String[] friendInfo = friendTempLine.split(",");
            Friend friendTemp = new Friend(friendInfo[0], friendInfo[1], friendInfo[2], friendInfo[3], friendInfo[4], friendInfo[5], friendInfo[6]);
            friendsofGroup.add(friendTemp);
        }
    }
}