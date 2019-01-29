package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsRound1Category1Controller extends AbstractSettingsRoundCategoryController implements Initializable {

    @FXML
    public TextField categoryTextField;

    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    @FXML
    private void play1LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void pause1LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void play2LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void pause2LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void play3LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void pause3LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void play4LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void pause4LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    public void saveCategoryButtonClick(MouseEvent mouseEvent) {
        handleSaveCategoryButtonClick(categoryTextField, 1, 1);
    }

    @FXML
    public void backLabelClick(MouseEvent mouseEvent) {
        handleBackLabelClick(pane, 1);
    }

}
