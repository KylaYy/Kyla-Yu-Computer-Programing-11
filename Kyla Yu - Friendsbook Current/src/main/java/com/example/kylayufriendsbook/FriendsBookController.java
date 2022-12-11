package com.example.kylayufriendsbook;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FriendsBookController {

    //New Group input:
    public TextField groupNameInput;
    //Selected group (set by button)
    public Group tempSelectedGroup;
    //New Friend user input information
    public TextField nameInput;
    public TextField favColourInput;
    public TextField emailAddyInput;
    //Friend info display box labels
    public Label nameDisplay;
    public Label emailDisplay;
    public Label favColourDisplay;
    public Label groupDisplay;
    //Listviews (friend and group)
    public ListView<Group> groupView;
    public ListView<Friend> friendView;
    //Buttons
    public Button btnSaveFriends;
    public Button btnloadFriends;
    public Button btnAddFriend;
    //Selected group display
    public Label selectedGroup;
    public TextField loadFileField;

    //IO streams
    FileInputStream in;
    FileOutputStream out;

    //Creating group and friend objects----------------------------------
    public void createNewGroup(ActionEvent actionEvent) {
        //Adding group to arraylist
        Group group = new Group(groupNameInput.getText());
        groupView.getItems().add(new Group(groupNameInput.getText()));
        groupNameInput.clear();
        //buttons
        btnAddFriend.setDisable(true);
        btnSaveFriends.setDisable(true);
        btnloadFriends.setDisable(true);
    }

    public void createNewFriend(ActionEvent actionEvent) {
        String name = nameInput.getText();
        String email = emailAddyInput.getText();
        String favColour = favColourInput.getText();
        tempSelectedGroup = groupView.getSelectionModel().getSelectedItem();
        Friend temp = new Friend(name, email, favColour, tempSelectedGroup);
        tempSelectedGroup.getFriendList().add(temp);

        nameInput.clear();
        emailAddyInput.clear();
        favColourInput.clear();
        friendView.getItems().add(temp);
    }

    //Displaying groups/friends-----------------------------------------------

    //Button to display friends in a group and allow editing of that group
    public void selectGroup(ActionEvent actionEvent) {
        friendView.getItems().clear();
        btnloadFriends.setDisable(false);
        btnAddFriend.setDisable(false);
        btnSaveFriends.setDisable(false);

        tempSelectedGroup = groupView.getSelectionModel().getSelectedItem();
        ArrayList<Friend> temp = tempSelectedGroup.getFriendList();
        for (Friend f : temp){
            friendView.getItems().add(f);
        }
        selectedGroup.setText(tempSelectedGroup.getGroupName());
        //groupView.getSelectionModel().clearSelection();
    }

    //Method to display friend attributes when selected in the listview
    public void displayFriend(MouseEvent mouseEvent) {
        Friend friendTemp = friendView.getSelectionModel().getSelectedItem();

        nameDisplay.setText(friendTemp.getName());
        emailDisplay.setText(friendTemp.getEmail());
        favColourDisplay.setText(friendTemp.getFavColour());
        groupDisplay.setText(friendTemp.getGroup().toString());
    }

    //---------------Saving and Loading --------------------
    public void saveGroup(ActionEvent actionEvent) throws IOException {
        ObservableList<Group> groupList = groupView.getItems();
        for (Group p : groupList){
            System.out.println(p);
            fileMethods.groupWriteToFile(p);
        }
        groupView.getItems().clear();
    }

    public void saveFriends(ActionEvent actionEvent) throws IOException{
        ObservableList<Friend> friendList = friendView.getItems();
        for (Friend p : friendList){
            Group group = tempSelectedGroup;
        }
        friendView.getItems().clear();
    }

    public void loadGroup(ActionEvent actionEvent) throws IOException{
        String fileName = loadFileField.getText();
        groupView.getItems().clear();
        Group group = fileMethods.loadGroup(fileName);
        groupView.getItems().add(group);
        tempSelectedGroup = group;
        loadFriends();
    }

    public void loadFriends() throws IOException{
        friendView.getItems().clear();
        ArrayList<Friend> friendsFromFile = fileMethods.loadFriends(tempSelectedGroup);
        for( Friend f : friendsFromFile){
            friendView.getItems().add(f);
        }
    }
}