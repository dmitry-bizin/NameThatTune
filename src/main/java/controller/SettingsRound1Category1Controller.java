package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsRound1Category1Controller extends AbstractSettingsRoundCategoryController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private ImageView play1ImageView;

    @FXML
    private ImageView pause1ImageView;

    @FXML
    private ImageView play2ImageView;

    @FXML
    private ImageView pause2ImageView;

    @FXML
    private ImageView play3ImageView;

    @FXML
    private ImageView pause3ImageView;

    @FXML
    private ImageView play4ImageView;

    @FXML
    private ImageView pause4ImageView;

    @FXML
    private TextField categoryTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init(categoryTextField, play1ImageView, pause1ImageView, play2ImageView, pause2ImageView, play3ImageView, pause3ImageView, play4ImageView, pause4ImageView);
    }

    @FXML
    private void play1LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void pause1LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void play2LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void pause2LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void play3LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void pause3LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void play4LabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void pause4LabelClick(MouseEvent mouseEvent) {

    }

}
