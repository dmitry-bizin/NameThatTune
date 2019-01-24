package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Round1Controller extends AbstractRoundController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private ImageView backImageView;

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
        init(backImageView, pane, 1, category1Label, category2Label, category3Label, category4Label);
    }

    @FXML
    private void backLabelClick(MouseEvent mouseEvent) {
        handleBackLabelClick(pane);
    }

}
