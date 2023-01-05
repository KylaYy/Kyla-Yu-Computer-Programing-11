package com.example.kylay_project2_fixed;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    //private void formWindowOpened (java.awt.event.WindowEvent evt){
        //requiredbutton.setEnabled(false);
    //}

    //JavaFX labels, buttons, listviews, etc.
    @FXML
    private Label journalTitleLbl;
    @FXML
    private Label journalNameLbl;
    @FXML
    private ListView<Journal> journalsListView;
    @FXML
    private TextField journalTitleField;
    @FXML
    private TextField authorNameField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button createJournalBtn;
    //Set for journal entries (to prevent duplicates)
    private Set<Journal> journalSet = new HashSet<>();
    //Opening journal entries
    @FXML
    private Button journalOpenButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Journal currentJournal;

    //Journal Methods ---------------------------------
    public void loadJournals() throws IOException {
        // read the values from the ALL_JOURNALS file
        // add the journals to journalsListView
        journalSet = FileMethods.loadJournals();
        for (Journal j : journalSet){
            journalsListView.getItems().add(j);
        }
    }

    public void createNewJournal(ActionEvent actionEvent) throws IOException{
        errorLabel.setText("  ");
        int journalSetLength = journalSet.size();
        Journal temp = new Journal(journalTitleField.getText(), authorNameField.getText());
        if (journalTitleField.getText().equals("") || authorNameField.getText().equals("")){
            errorLabel.setText("Error: some fields missing");
        }
        else if (journalSet.contains(temp)){
            errorLabel.setText("Warning: journal already exists");
        } else {
            // append journal name and author to a text file
            journalSet.add(temp);
            FileMethods.writeJournal(temp);
            FileMethods.createJournal(temp);
            journalsListView.getItems().add(temp);
        }

        journalTitleField.clear();
        authorNameField.clear();
    }

    public void showJournalInfo(MouseEvent mouseEvent) {
        Journal temp = (Journal)journalsListView.getSelectionModel().getSelectedItem();
        String nameTemp = temp.getAuthorName();
        String titleTemp = temp.getTitle();
        journalTitleLbl.setText(titleTemp);
        journalNameLbl.setText(nameTemp);
    }

    //Opening Journal -----------------
    public void openJournal(ActionEvent actionEvent) throws IOException {
        Journal temp = journalsListView.getSelectionModel().getSelectedItem();
        currentJournal = temp;

        switchScene(actionEvent);
    }

    public void switchScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DayToDayApplication.class.getResource("entry-page.fxml"));
        Parent root = fxmlLoader.load();
        EntryScreenController controller = fxmlLoader.getController();
        controller.initializeController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static Journal getCurrentJournal(){
        return currentJournal;
    }
}
