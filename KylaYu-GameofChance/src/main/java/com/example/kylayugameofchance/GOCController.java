package com.example.kylayugameofchance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class GOCController {

    public Label intpoolAmount;
    public Label roll1;
    public Button btnHigher;
    public Button btnLower;
    public Label roll2;
    public String HigherLower;
    public int roll1Value;
    public int roll2Value;
    public Button btnRoll2;
    public Button btnRoll1;
    public int poolAmount;
    public Button btnReset;

    public int randRoll(){
        int r = (int)(Math.random()*6) + 1;
        return r;
    }

    public void setRoll1(ActionEvent actionEvent){
        btnRoll1.setDisable(true);
        btnRoll2.setDisable(true);
        int r = randRoll();
        roll1.setText(String.valueOf(r));
        roll1Value = r;

    }

    public void setRoll2(ActionEvent actionEvent) {
        btnRoll2.setDisable(true);
        int r = randRoll();
        roll2.setText((String.valueOf(r)));
        roll2Value = r;
    }

    public void Higher(ActionEvent actionEvent) {
        HigherLower = "Higher";
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        btnRoll2.setDisable(false);
    }

    public void Lower(ActionEvent actionEvent) {
        HigherLower = "Lower";
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        btnRoll2.setDisable(false);
    }

    public void resetGame(ActionEvent actionEvent) {
        btnRoll1.setDisable(false);
        btnLower.setDisable(false);
        btnHigher.setDisable(false);
        btnReset.setDisable(false);
        intpoolAmount.setText(String.valueOf(100));

    }

    public void resetRolls(ActionEvent actionEvent) {
        btnRoll1.setDisable(false);
        btnLower.setDisable(false);
        btnHigher.setDisable(false);

        poolAmount = Integer.parseInt(intpoolAmount.getText());

        if (HigherLower.equals("Higher") && (roll2Value>roll1Value)){
            poolAmount += 10;
        }
        if (HigherLower.equals("Lower") && (roll1Value>roll2Value)){
            poolAmount += 10;
        }
        else{
            poolAmount -= 10;
        }
        if (poolAmount == 0){
            btnRoll1.setDisable(true);
            btnRoll2.setDisable(true);
            btnLower.setDisable(true);
            btnHigher.setDisable(true);
            btnReset.setDisable(true);
        }
        intpoolAmount.setText(String.valueOf(poolAmount));
        roll1.setText(" ");
        roll2.setText(" ");

    }


}