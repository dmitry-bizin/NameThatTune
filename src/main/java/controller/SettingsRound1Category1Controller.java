package controller;

import controller.common.AbstractSettingsRoundCategoryController;
import dto.TuneRecord;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsRound1Category1Controller extends AbstractSettingsRoundCategoryController implements Initializable {

    @FXML
    public Label tune1Label;

    @FXML
    public Label tune2Label;

    @FXML
    public Label tune3Label;

    @FXML
    public Label tune4Label;

    @FXML
    private TextField categoryTextField;

    @FXML
    private Button openTune1Button;

    @FXML
    private Button openTune2Button;

    @FXML
    private Button openTune3Button;

    @FXML
    private Button openTune4Button;

    @FXML
    private TextField title1;

    @FXML
    private TextField author1;

    @FXML
    private TextField title2;

    @FXML
    private TextField author2;

    @FXML
    private TextField title3;

    @FXML
    private TextField author3;

    @FXML
    private TextField title4;

    @FXML
    private TextField author4;

    @FXML
    private Button play1Button;

    @FXML
    private Button pause1Button;

    @FXML
    private Button play2Button;

    @FXML
    private Button pause2Button;

    @FXML
    private Button play3Button;

    @FXML
    private Button pause3Button;

    @FXML
    private Button play4Button;

    @FXML
    private Button pause4Button;

    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init(1,
                1,
                categoryTextField,
                new TuneRecord(title1, author1, play1Button, pause1Button),
                new TuneRecord(title2, author2, play2Button, pause2Button),
                new TuneRecord(title3, author3, play3Button, pause3Button),
                new TuneRecord(title4, author4, play4Button, pause4Button)
        );
    }

    @FXML
    private void play1ButtonClick(MouseEvent mouseEvent) {
        handlePlayButton(1, tune1Label);
    }

    @FXML
    private void pause1ButtonClick(MouseEvent mouseEvent) {
        handlePauseButton(1);
    }

    @FXML
    private void play2ButtonClick(MouseEvent mouseEvent) {
        handlePlayButton(2, tune2Label);
    }

    @FXML
    private void pause2ButtonClick(MouseEvent mouseEvent) {
        handlePauseButton(2);
    }

    @FXML
    private void play3ButtonClick(MouseEvent mouseEvent) {
        handlePlayButton(3, tune3Label);
    }

    @FXML
    private void pause3ButtonClick(MouseEvent mouseEvent) {
        handlePauseButton(3);
    }

    @FXML
    private void play4ButtonClick(MouseEvent mouseEvent) {
        handlePlayButton(4, tune4Label);
    }

    @FXML
    private void pause4ButtonClick(MouseEvent mouseEvent) {
        handlePauseButton(4);
    }

    @FXML
    public void saveCategoryButtonClick(MouseEvent mouseEvent) {
        handleSaveCategoryClick(categoryTextField, 1, 1);
    }

    @FXML
    public void backLabelClick(MouseEvent mouseEvent) {
        handleBackLabelClick(pane, 1);
    }

    @FXML
    public void openTune1ButtonClick(MouseEvent mouseEvent) {
        handleChooseMP3Click(pane, openTune1Button, 1);
    }

    @FXML
    public void openTune2ButtonClick(MouseEvent mouseEvent) {
        handleChooseMP3Click(pane, openTune2Button, 2);
    }

    @FXML
    public void openTune3ButtonClick(MouseEvent mouseEvent) {
        handleChooseMP3Click(pane, openTune3Button, 3);
    }

    @FXML
    public void openTune4ButtonClick(MouseEvent mouseEvent) {
        handleChooseMP3Click(pane, openTune4Button, 4);
    }

    @FXML
    public void save1ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                1,
                1,
                1,
                openTune1Button,
                new TuneRecord(title1, author1, play1Button, pause1Button)
        );
    }

    @FXML
    public void save2ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                1,
                1,
                2,
                openTune2Button,
                new TuneRecord(title2, author2, play2Button, pause2Button)
        );
    }

    @FXML
    public void save3ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                1,
                1,
                3,
                openTune3Button,
                new TuneRecord(title3, author3, play3Button, pause3Button)
        );
    }

    @FXML
    public void save4ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                1,
                1,
                4,
                openTune4Button,
                new TuneRecord(title4, author4, play4Button, pause4Button)
        );
    }

}
