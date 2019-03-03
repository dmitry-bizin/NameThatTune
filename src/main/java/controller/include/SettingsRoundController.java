package controller.include;

import controller.common.AbstractSettingsRoundController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import util.UIUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsRoundController extends AbstractSettingsRoundController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private Label infoLabel;

    @FXML
    private Label category1Label;

    @FXML
    private Label category2Label;

    @FXML
    private Label category3Label;

    @FXML
    private Label category4Label;

    private int roundNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void init(int roundNumber) {
        this.roundNumber = roundNumber;
        init(infoLabel, roundNumber, category1Label, category2Label, category3Label, category4Label);
    }

    @FXML
    private void category1LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRoundCategory(pane, roundNumber, 1);
    }

    @FXML
    private void category2LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRoundCategory(pane, roundNumber, 2);
    }

    @FXML
    private void category3LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRoundCategory(pane, roundNumber, 3);
    }

    @FXML
    private void category4LabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRoundCategory(pane, roundNumber, 4);
    }

    @FXML
    private void backLabelClick(MouseEvent mouseEvent) {
        handleBackLabelClick(pane);
    }

}
