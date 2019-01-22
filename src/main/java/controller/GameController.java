package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import util.UIUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    public Pane pane;

    @FXML
    public Label round1Label;

    @FXML
    public Label round2Label;

    @FXML
    public Label round3Label;

    @FXML
    public Label supergameLabel;

    @FXML
    public Label backLabel;

    @Override
    @SuppressWarnings("Duplicates")
    public void initialize(URL location, ResourceBundle resources) {
        round1Label.setLayoutX(UIUtil.getWidth() * 0.03);
        round1Label.setLayoutY(UIUtil.getHeight() * 0.1);

        round2Label.setLayoutX(UIUtil.getWidth() * 0.03);
        round2Label.setLayoutY(UIUtil.getHeight() * 0.2);

        round3Label.setLayoutX(UIUtil.getWidth() * 0.03);
        round3Label.setLayoutY(UIUtil.getHeight() * 0.3);

        supergameLabel.setLayoutX(UIUtil.getWidth() * 0.03);
        supergameLabel.setLayoutY(UIUtil.getHeight() * 0.4);

        backLabel.setLayoutX(UIUtil.getWidth() * 0.03);
        backLabel.setLayoutY(UIUtil.getHeight() * 0.5);
    }

    @FXML
    public void round1LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToRound(pane, 1);
    }

    @FXML
    public void round2LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToRound(pane, 2);
    }

    @FXML
    public void round3LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToRound(pane, 3);
    }

    @FXML
    public void supergameLabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    public void backLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToMain(pane);
    }

}
