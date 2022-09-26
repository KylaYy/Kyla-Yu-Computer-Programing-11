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
        Group group = groupView.getSelectionModel().getSelectedItem();
        Friend temp = new Friend(name, email, favColour, group);
        Group.getFriendList().add(temp);

        nameInput.clear();
        emailAddyInput.clear();
        favColourInput.clear();
        friendView.getItems().add(temp);
    }

    public void showFriends(MouseEvent mouseEvent) {
        friendView.getItems().clear();
        ArrayList<Friend> temp = Group.getFriendList();
        for( Friend f : temp){
            friendView.getItems().add(f);
        }
        btnAddFriend.setDisable(false);
        btnSaveFriends.setDisable(false);
        btnloadFriends.setDisable(false);
    }

    //---------------Saving and Loading --------------------
    public void saveGroup(ActionEvent actionEvent) throws IOException {
        ObservableList<Group> groupList = groupView.getItems();
        for (Group p : groupList){
            fileMethods.groupWriteToFile(p);
        }
        groupView.getItems().clear();
    }

    public void saveFriends(ActionEvent actionEvent) throws IOException{
        ObservableList<Friend> friendList = friendView.getItems();
        for (Friend p : friendList){
            Group group = p.getGroup();
            fileMethods.friendWriteToFile(p, group);
        }
        friendView.getItems().clear();
    }

    public void loadGroups(ActionEvent actionEvent) throws IOException{
        groupView.getItems().clear();
        fileMethods.loadGroups();
    }

    public void displayFriend(MouseEvent mouseEvent) {
        Friend friendTemp = friendView.getSelectionModel().getSelectedItem();

        nameDisplay.setText(friendTemp.getName());
        emailDisplay.setText(friendTemp.getEmail());
        favColourDisplay.setText(friendTemp.getFavColour());
        groupDisplay.setText(friendTemp.getGroup().toString());
    }

    public void loadFriends() throws IOException{
        friendView.getItems().clear();
        Group temp = groupView.getSelectionModel().getSelectedItem();
        ArrayList<Friend> friendsFromFile = fileMethods.loadFriends(temp);
        for( Friend f : friendsFromFile){
            friendView.getItems().add(f);
        }
    }
}