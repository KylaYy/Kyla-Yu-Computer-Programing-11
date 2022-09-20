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

    public GOCController() {
    }

    public int randRoll() {
        int r = (int)(Math.random() * 6) + 1;
        return r;
    }

    public void setRoll1(ActionEvent actionEvent) {
        this.btnRoll1.setDisable(true);
        int r = this.randRoll();
        this.roll1.setText(String.valueOf(r));
        this.roll1Value = r;
    }

    public void Higher(ActionEvent actionEvent) {
        this.HigherLower = "Higher";
        this.btnHigher.setDisable(true);
        this.btnLower.setDisable(true);
        this.poolAmount = Integer.parseInt(this.intpoolAmount.getText());
        int r = this.randRoll();
        this.roll2.setText(String.valueOf(r));
        this.roll2Value = r;
        this.roll2.setText(String.valueOf(r));
        this.roll2Value = r;
        if (this.HigherLower.equals("Higher") && this.roll1Value < this.roll2Value) {
            this.poolAmount += 10;
            this.intpoolAmount.setText(String.valueOf(this.poolAmount));
        } else {
            this.poolAmount -= 10;
            this.intpoolAmount.setText(String.valueOf(this.poolAmount));
        }

        if (this.poolAmount == 0) {
            this.btnRoll1.setDisable(true);
            this.btnRoll2.setDisable(true);
            this.btnLower.setDisable(true);
            this.btnHigher.setDisable(true);
            this.btnReset.setDisable(true);
        }

    }

    public void Lower(ActionEvent actionEvent) {
        this.HigherLower = "Lower";
        this.btnHigher.setDisable(true);
        this.btnLower.setDisable(true);
        this.poolAmount = Integer.parseInt(this.intpoolAmount.getText());
        int r = this.randRoll();
        this.roll2.setText(String.valueOf(r));
        this.roll2Value = r;
        this.roll2.setText(String.valueOf(r));
        this.roll2Value = r;
        if (this.HigherLower.equals("Lower") && this.roll1Value > this.roll2Value) {
            this.poolAmount += 10;
            this.intpoolAmount.setText(String.valueOf(this.poolAmount));
        } else {
            this.poolAmount -= 10;
            this.intpoolAmount.setText(String.valueOf(this.poolAmount));
        }

        if (this.poolAmount == 0) {
            this.btnRoll1.setDisable(true);
            this.btnRoll2.setDisable(true);
            this.btnLower.setDisable(true);
            this.btnHigher.setDisable(true);
            this.btnReset.setDisable(true);
        }

    }

    public void resetGame(ActionEvent actionEvent) {
        this.btnRoll1.setDisable(false);
        this.btnLower.setDisable(false);
        this.btnHigher.setDisable(false);
        this.btnReset.setDisable(false);
        this.intpoolAmount.setText(String.valueOf(100));
    }

    public void resetRolls(ActionEvent actionEvent) {
        this.btnRoll1.setDisable(false);
        this.btnLower.setDisable(false);
        this.btnHigher.setDisable(false);
        this.roll1.setText(" ");
        this.roll2.setText(" ");
    }
}
