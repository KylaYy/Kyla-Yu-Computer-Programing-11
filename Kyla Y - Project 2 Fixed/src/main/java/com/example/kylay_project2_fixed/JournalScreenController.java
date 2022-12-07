package com.example.kylay_project2_fixed;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JournalScreenController {
    //Disabling Buttons on window opening
    private void formWindowOpened (java.awt.event.WindowEvent evt){
        //requiredbutton.setEnabled(false);
    }

    //JavaFX labels, buttons, listviews, etc.
    private Label journalTitleLbl;
    private Label journalNameLbl;
    private ListView<Journal> journalsListView;
    private TextField journalTitleField;
    private TextField authorNameField;
    private Label errorLabel;
    private Button createJournalBtn;
    //Set for journal entries (to prevent duplicates)
    private Set<Journal> journalSet = new HashSet<>();
    //Opening journal entries
    private Button journalOpenButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Journal currentJournal;

    //Journal Methods ---------------------------------
    public void createNewJournal(ActionEvent actionEvent) {
        errorLabel.setText("  ");
        int journalSetLength = journalSet.size();
        Journal temp = new Journal(journalTitleField.getText(), authorNameField.getText());
        journalSet.add(temp);
        if (journalSetLength == journalSet.size()){
            errorLabel.setText("A journal with that name already exists. Please enter a new name and try again.");
        } else{
            journalsListView.getItems().add(temp);
        }

        journalTitleField.clear();
        authorNameField.clear();
    }

    public void showJournalInfo(MouseEvent mouseEvent) {
        Journal temp = (Journal)journalsListView.getSelectionModel().getSelectedItem();
        String nameTemp = temp.getAuthorName();
        String titleTemp = temp.getTitle();
    }

    //Opening Journal -----------------
    public void openJournal(ActionEvent actionEvent) throws IOException {
        Journal temp = journalsListView.getSelectionModel().getSelectedItem();
        currentJournal = temp;

        switchScene(actionEvent);
    }

    public void switchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("entry-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public static Journal getCurrentJournal(){
        return currentJournal;
    }
}
