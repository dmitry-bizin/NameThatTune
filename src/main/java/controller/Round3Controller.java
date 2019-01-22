package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Round3Controller extends AbstractRoundController implements Initializable {

    @FXML
    public Pane pane;

    @FXML
    public Label backLabel;

    @FXML
    public ImageView backImageView;

    @FXML
    public Label category1Label;

    @FXML
    public Label category2Label;

    @FXML
    public Label category3Label;

    @FXML
    public Label category4Label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(backImageView, category1Label, category2Label, category3Label,
                category4Label, pane, 3);
    }

    @FXML
    public void backLabelClick(MouseEvent mouseEvent) {
        handleBackLabelClick(pane);
    }

}
