package controller;

import controller.include.SettingsRoundCategoryController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsRound2Category1Controller implements Initializable {

    @FXML
    private SettingsRoundCategoryController settingsRoundCategoryController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settingsRoundCategoryController.init(2, 1);
    }

}
