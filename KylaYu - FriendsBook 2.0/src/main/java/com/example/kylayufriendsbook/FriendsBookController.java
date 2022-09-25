package com.example.kylayufriendsbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FriendsBookController {

    //User info entry
    public TextField firstName;
    public TextField lastName;
    public TextField email;
    public TextField phoneNumber;
    public TextField address;
    public TextField favColour;
    public ListView friendsList;

    //display labels
    public Label lblName;
    public Label lblEmail;
    public Label lblPhoneNum;
    public Label lblAddress;
    public Label lblFavColour;

    //method called on button press, creates new friend object and adds friend to listview
    public void createNewFriend(ActionEvent actionEvent) {
        Friend temp = new Friend(firstName.getText(), lastName.getText(), email.getText(), phoneNumber.getText(), address.getText(), favColour.getText());
        friendsList.getItems().add(temp);
        firstName.clear(); lastName.clear(); email.clear(); phoneNumber.clear(); address.clear(); favColour.clear();
    }

    //Displays friend information on mouseclick
    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp = (Friend) friendsList.getSelectionModel().getSelectedItem();
        lblName.setText(temp.getFullName()); lblEmail.setText(temp.getEmail()); lblPhoneNum.setText(temp.getPhoneNum()); lblAddress.setText(temp.getAddress()); lblFavColour.setText(temp.getFavColour());
    }

    //removes friend from listview
    public void deleteFriend(ActionEvent actionEvent) {
        Friend toDelete = (Friend) friendsList.getSelectionModel().getSelectedItem();
        friendsList.getItems().remove(toDelete);
        lblName.setText(" ");
        lblEmail.setText(" ");
        lblPhoneNum.setText(" ");
        lblAddress.setText(" ");
        lblFavColour.setText(" ");
    }
}