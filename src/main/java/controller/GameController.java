package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import util.UIUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private void round1LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToRound(pane, 1);
    }

    @FXML
    private void round2LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToRound(pane, 2);
    }

    @FXML
    private void round3LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToRound(pane, 3);
    }

    @FXML
    private void superGameLabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void backLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToMain(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
