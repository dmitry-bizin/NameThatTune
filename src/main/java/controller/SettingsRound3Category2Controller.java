package controller;

import controller.include.SettingsRoundCategoryController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsRound3Category2Controller implements Initializable {

    @FXML
    private SettingsRoundCategoryController settingsRoundCategoryController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settingsRoundCategoryController.init(3, 2);
    }

}
