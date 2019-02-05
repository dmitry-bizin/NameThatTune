package controller;

import controller.include.SettingsRoundController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsRound2Controller implements Initializable {

    @FXML
    private SettingsRoundController settingsRoundController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settingsRoundController.init(2);
    }

}
