package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import util.UIUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void exitLabelClick(MouseEvent mouseEvent) {
        UIUtil.getStage(pane).close();
    }

    @FXML
    private void gameLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToGame(pane);
    }

    @FXML
    private void settingsLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettings(pane);
    }

}
