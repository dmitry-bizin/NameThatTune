package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsRound2Controller extends AbstractSettingsRoundController implements Initializable {

    @FXML
    public Pane pane;

    @FXML
    public Label category1Label;

    @FXML
    public Label category2Label;

    @FXML
    public Label category3Label;

    @FXML
    public Label category4Label;

    @FXML
    public Label backLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize(category1Label, category2Label, category3Label, category4Label, backLabel, 2);
    }

    @FXML
    public void category1LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    public void category2LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    public void category3LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    public void category4LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    public void backLabelClick(MouseEvent mouseEvent) {
        handleBackLabelClick(pane);
    }

}
