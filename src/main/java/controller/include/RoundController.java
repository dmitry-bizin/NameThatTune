package controller.include;

import controller.common.AbstractRoundController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class RoundController extends AbstractRoundController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void backLabelClick(MouseEvent mouseEvent) {
        handleBackLabelClick(pane);
    }

    public void init(int roundNumber) {
        init(pane, roundNumber, category1Label, category2Label, category3Label, category4Label);
    }

}
