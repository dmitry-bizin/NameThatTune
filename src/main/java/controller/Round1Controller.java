package controller;

import controller.include.RoundController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Round1Controller implements Initializable {

    @FXML
    private RoundController roundController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roundController.init(1);
    }

}
