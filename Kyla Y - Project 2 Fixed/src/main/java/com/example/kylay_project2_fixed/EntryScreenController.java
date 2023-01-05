package com.example.kylay_project2_fixed;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashSet;

public class EntryScreenController {
    //Entries and entry control------------------------
    //Journal info
    private Journal currentJournal = JournalScreenController.getCurrentJournal();
    @FXML
    private Label entryTitleLbl;
    @FXML
    private Label entryDisplaylbl;
    @FXML
    private Label errorLabel;
    @FXML
    private Label journalTitle;
    //For getting entry info
    @FXML
    private TextArea entryInputField;
    @FXML
    private TextField entryTitleField;
    private int entryNum;
    //Switching between entries
    @FXML
    private Button previousEntry;
    @FXML
    private Button nextEntry;
    HashSet<String> entrySet = new HashSet<>();

    public void initializeController() throws IOException {
        entryNum = 0;
        journalTitle.setText(currentJournal.getTitle());
        currentJournal.setEntries(FileMethods.loadEntries(currentJournal));
        System.out.println(currentJournal.getEntries().size());
        showEntry(entryNum);
        setPreviousNextButtons();
    }

    private void setPreviousNextButtons(){
        int journalSize = currentJournal.getEntries().size();
        previousEntry.setDisable(entryNum == 0);
        nextEntry.setDisable(entryNum == (journalSize-1) || journalSize == 0);
    }

    //Entry methods
    public void goToPreviousEntry(ActionEvent actionEvent) {
        entryNum--;
        if (entryNum < 0){
            entryNum = 0;
        }
        setPreviousNextButtons();
        showEntry(entryNum);
    }

    public void goToNextEntry(ActionEvent actionEvent) {
        entryNum ++;
        int journalSize = currentJournal.getEntries().size();
        if (journalSize <= entryNum){
            entryNum = journalSize-1;
        }
        setPreviousNextButtons();
        showEntry(entryNum);

    }

    public void createNewEntry(ActionEvent actionEvent) throws IOException {
        errorLabel.setText("");
        String entryTitle = entryTitleField.getText();
        String entryText = entryInputField.getText();
        Entry temp = new Entry(entryTitle, entryText);
        if (entryTitle.equals("") || entryText.equals("")) {
            errorLabel.setText("Error: title or body are empty");
            return;
        }
        if (entrySet.contains(temp.getEntryTitle())){
            errorLabel.setText("Error: this entry already exists");
            return;
        }
        entrySet.add(temp.getEntryTitle());
        FileMethods.writeEntry(currentJournal, temp);
        currentJournal.addEntry(temp);
        entryInputField.clear();
        entryTitleField.clear();
        showEntry(currentJournal.getEntries().size()-1);
        entryNum = currentJournal.getEntries().size() - 1;
        setPreviousNextButtons();
    }

    private void showEntry(int entryNum){
        if (currentJournal.getEntries().size() == 0){
            return;
        }
        else{
            Entry entry = currentJournal.getEntries().get(entryNum);
            entryTitleLbl.setText(entry.getEntryTitle());
            entryDisplaylbl.setText(entry.getEntry());
        }
    }

    public void returnToHomescreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DayToDayApplication.class.getResource("temp.fxml"));
        Parent root = fxmlLoader.load();
        JournalScreenController controller = fxmlLoader.getController();
        controller.loadJournals();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
