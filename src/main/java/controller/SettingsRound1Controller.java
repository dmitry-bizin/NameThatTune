package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import util.UIUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsRound1Controller extends AbstractSettingsRoundController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private Label category1Label;

    @FXML
    private Label category2Label;

    @FXML
    private Label category3Label;

    @FXML
    private Label category4Label;

    @FXML
    private Label backLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init(backLabel, 1, category1Label, category2Label, category3Label, category4Label);
    }

    @FXML
    private void category1LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRoundCategory(pane, 1, 1);
    }

    @FXML
    private void category2LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void category3LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void category4LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void backLabelClick(MouseEvent mouseEvent) {
        handleBackLabelClick(pane);
    }

}
