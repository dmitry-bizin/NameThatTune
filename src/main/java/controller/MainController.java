package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import util.UIUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public Pane pane;

    @FXML
    private Label gameLabel;

    @FXML
    private Label settingsLabel;

    @FXML
    private Label exitLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameLabel.setLayoutX(UIUtil.getWidth() * 0.6);
        gameLabel.setLayoutY(UIUtil.getHeight() * 0.3);

        settingsLabel.setLayoutX(UIUtil.getWidth() * 0.6);
        settingsLabel.setLayoutY(UIUtil.getHeight() * 0.4);

        exitLabel.setLayoutX(UIUtil.getWidth() * 0.6);
        exitLabel.setLayoutY(UIUtil.getHeight() * 0.5);
    }

    @FXML
    public void exitLabelClick(MouseEvent mouseEvent) {
        UIUtil.getStage(pane).close();
    }

    @FXML
    public void gameLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToGame(pane);
    }

    @FXML
    public void settingsLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettings(pane);
    }

}
