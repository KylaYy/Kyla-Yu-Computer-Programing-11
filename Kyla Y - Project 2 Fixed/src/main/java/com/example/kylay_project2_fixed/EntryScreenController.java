package com.example.kylay_project2_fixed;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EntryScreenController {
    //Entries and entry control------------------------
    //Journal info
    public Journal currentJournal = JournalScreenController.getCurrentJournal();
    public Label entryTitleLbl;
    public Label entryDisplaylbl;
    //For getting entry info
    public TextArea entryInputField;
    public TextField entryTitleField;
    public int entryNum;
    //Switching between entries
    public Button previousEntry;
    public Button nextEntry;

    //Entry methods
    public void goToPreviousEntry(ActionEvent actionEvent) {
        entryNum--;
        if (entryNum == 0){
            previousEntry.setDisable(true);
        }
        if (entryNum < 0){
            entryNum = 0;
            previousEntry.setDisable(true);
        }
    }

    public void goToNextEntry(ActionEvent actionEvent) {
        entryNum ++;
        int journalSize = currentJournal.getEntries().size();
        if (journalSize >= entryNum){
            entryNum = journalSize-1;
        }
        Entry entryCurr = currentJournal.getEntries().get(entryNum);
        entryTitleLbl.setText(entryCurr.getEntryTitle());
        entryDisplaylbl.setText(entryCurr.getEntry());

    }

    public void createNewEntry(ActionEvent actionEvent) {
        String entryTitle = entryInputField.getText();
        String entryText = entryInputField.getText();
        Entry temp = new Entry();
        currentJournal.addEntry(temp);
    }
}
