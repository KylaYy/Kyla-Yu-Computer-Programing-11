package com.example.kylayufriendsbook;

import javafx.collections.ObservableList;
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

    //New Friend user input information
    public TextField name1Input;
    public TextField name2Input;
    public TextField emailInput;
    public TextField phoneNumInput;
    public TextField addressInput;
    public TextField favColourInput;
    public TextField groupNameInput;
    public ChoiceBox<Group> groupInput;

    //Friend info display box labels
    public Label nameDisplay;
    public Label emailDisplay;
    public Label phoneNumDisplay;
    public Label addressDisplay;
    public Label favColourDisplay;
    public ListView groupView;

    //Group and friend arraylists
    ArrayList<Group> groupList= new ArrayList<>();
    ArrayList<Friend> friendList = new ArrayList<>();

    //IO streams
    FileInputStream in;
    FileOutputStream out;

    //----------------------------------
    //Creating group and friend objects
    public void createNewGroup(ActionEvent actionEvent) {
        //Adding group to arraylist
        Group group = new Group(groupNameInput.getText());
        groupView.getItems().add(new Group(groupNameInput.getText()));
        groupNameInput.clear();
    }

    public void createNewFriend(ActionEvent actionEvent) {
        String firstName = name1Input.getText();
        String lastName = name2Input.getText();
        String email = emailInput.getText();
        String phoneNum = phoneNumInput.getText();
        String address = addressInput.getText();
        String favColour = favColourInput.getText();
        Group group = groupNameInput;
        Friend temp = new Friend(firstName, lastName, email, phoneNum, address, favColour, );
    }

    //---------------Saving and Loading --------------------
    public void saveGroup(ActionEvent actionEvent) throws IOException {
        ObservableList<Group> groupList = groupView.getItems();
        for (Group p : groupList){
            fileMethods.groupWriteToFile(p);
        }
        groupView.getItems().clear();
    }

    public void loadGroups(ActionEvent actionEvent) {
    }

    public void displayFriend(MouseEvent mouseEvent) {
    }

    public void deleteFriend(ActionEvent actionEvent) {
    }

    public void loadGroup(ActionEvent actionEvent) {
    }
}