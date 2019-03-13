package controller;

import dao.SuperGameDAO;
import entity.SuperGame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import record.TuneRecord;
import util.FileUtil;
import util.UIUtil;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static util.FileUtil.TUNES_IN_SUPER_GAME_COUNT;

public class SuperGameSettingsController implements Initializable {

    private static final SuperGameDAO SUPER_GAME_DAO = new SuperGameDAO();
    private static final String SELECTED_BUTTON_STYLE = "selectedSuperGameSettingsButton";

    @FXML
    private Label tune1Label;

    @FXML
    private Label tune2Label;

    @FXML
    private Label tune3Label;

    @FXML
    private Label tune4Label;

    @FXML
    private Label tune5Label;

    @FXML
    private Label tune6Label;

    @FXML
    private Label tune7Label;

    @FXML
    private Button openTune1Button;

    @FXML
    private Button openTune2Button;

    @FXML
    private Button openTune3Button;

    @FXML
    private Button openTune4Button;

    @FXML
    private Button openTune5Button;

    @FXML
    private Button openTune6Button;

    @FXML
    private Button openTune7Button;

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
    private TextField title5;

    @FXML
    private TextField author5;

    @FXML
    private TextField title6;

    @FXML
    private TextField author6;

    @FXML
    private TextField title7;

    @FXML
    private TextField author7;

    @FXML
    private Pane pane;

    @FXML
    private Button play1Button;

    @FXML
    private Button play2Button;

    @FXML
    private Button play3Button;

    @FXML
    private Button play4Button;

    @FXML
    private Button play5Button;

    @FXML
    private Button play6Button;

    @FXML
    private Button play7Button;

    @FXML
    private Button pause1Button;

    @FXML
    private Button pause2Button;

    @FXML
    private Button pause3Button;

    @FXML
    private Button pause4Button;

    @FXML
    private Button pause5Button;

    @FXML
    private Button pause6Button;

    @FXML
    private Button pause7Button;

    private Glow[] glows;
    private Timeline[] timelines;
    private Media[] medias;
    private MediaPlayer[] mediaPlayers;
    private File[] tuneFiles;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tuneFiles = new File[TUNES_IN_SUPER_GAME_COUNT];
        medias = new Media[TUNES_IN_SUPER_GAME_COUNT];
        mediaPlayers = new MediaPlayer[TUNES_IN_SUPER_GAME_COUNT];
        glows = new Glow[TUNES_IN_SUPER_GAME_COUNT];
        timelines = new Timeline[TUNES_IN_SUPER_GAME_COUNT];
        UIUtil.initGlowsAndTimelines(glows, timelines);
        initData(
                new TuneRecord(title1, author1, play1Button, pause1Button),
                new TuneRecord(title2, author2, play2Button, pause2Button),
                new TuneRecord(title3, author3, play3Button, pause3Button),
                new TuneRecord(title4, author4, play4Button, pause4Button),
                new TuneRecord(title5, author5, play5Button, pause5Button),
                new TuneRecord(title6, author6, play6Button, pause6Button),
                new TuneRecord(title7, author7, play7Button, pause7Button)
        );
    }

    private void initData(TuneRecord... tuneRecords) {
        List<SuperGame> superGames = SUPER_GAME_DAO.readAll();
        for (int i = 0; i < superGames.size(); i++) {
            SuperGame superGame = superGames.get(i);
            TuneRecord tuneRecord = tuneRecords[i];
            tuneRecord.authorTextField.setText(superGame.getAuthor());
            tuneRecord.titleTextField.setText(superGame.getTitle());
            tuneFiles[i] = FileUtil.getMP3File(i + 1);
            UIUtil.initSettingsData(
                    tuneRecord,
                    tuneFiles,
                    medias,
                    mediaPlayers,
                    i
            );
        }
    }

    private void handleSaveTuneClick(int tuneNumber, Button openTuneButton, TuneRecord tuneRecord) {
        UIUtil.handleSaveTuneClick(
                tuneFiles,
                tuneNumber,
                mediaPlayers,
                timelines,
                glows,
                medias,
                openTuneButton,
                tuneRecord,
                () -> FileUtil.saveMP3File(tuneFiles[tuneNumber - 1], tuneNumber),
                () -> FileUtil.getMP3File(tuneNumber),
                SELECTED_BUTTON_STYLE
        );
        SuperGame superGame = new SuperGame(
                tuneNumber,
                tuneRecord.titleTextField.getText(),
                tuneRecord.authorTextField.getText()
        );
        SUPER_GAME_DAO.updateById(tuneNumber, superGame);
    }

    @FXML
    private void play1ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePlayButton(1, tune1Label, mediaPlayers, timelines, glows);
    }

    @FXML
    private void pause1ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePauseButton(1, timelines, glows, mediaPlayers);
    }

    @FXML
    private void play2ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePlayButton(2, tune2Label, mediaPlayers, timelines, glows);
    }

    @FXML
    private void pause2ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePauseButton(2, timelines, glows, mediaPlayers);
    }

    @FXML
    private void play3ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePlayButton(3, tune3Label, mediaPlayers, timelines, glows);
    }

    @FXML
    private void pause3ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePauseButton(3, timelines, glows, mediaPlayers);
    }

    @FXML
    private void play4ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePlayButton(4, tune4Label, mediaPlayers, timelines, glows);
    }

    @FXML
    private void pause4ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePauseButton(4, timelines, glows, mediaPlayers);
    }

    @FXML
    private void play5ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePlayButton(5, tune5Label, mediaPlayers, timelines, glows);
    }

    @FXML
    private void pause5ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePauseButton(5, timelines, glows, mediaPlayers);
    }

    @FXML
    private void play6ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePlayButton(6, tune6Label, mediaPlayers, timelines, glows);
    }

    @FXML
    private void pause6ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePauseButton(6, timelines, glows, mediaPlayers);
    }

    @FXML
    private void play7ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePlayButton(7, tune7Label, mediaPlayers, timelines, glows);
    }

    @FXML
    private void pause7ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handlePauseButton(7, timelines, glows, mediaPlayers);
    }

    @FXML
    private void backLabelClick(MouseEvent mouseEvent) {
        UIUtil.disposeResources(mediaPlayers, glows, timelines, TUNES_IN_SUPER_GAME_COUNT);
        UIUtil.changeSceneToSettings(pane);
    }

    @FXML
    private void openTune1ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handleChooseMP3Click(pane, openTune1Button, 1, tuneFiles, SELECTED_BUTTON_STYLE);
    }

    @FXML
    private void openTune2ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handleChooseMP3Click(pane, openTune2Button, 2, tuneFiles, SELECTED_BUTTON_STYLE);
    }

    @FXML
    private void openTune3ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handleChooseMP3Click(pane, openTune3Button, 3, tuneFiles, SELECTED_BUTTON_STYLE);
    }

    @FXML
    private void openTune4ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handleChooseMP3Click(pane, openTune4Button, 4, tuneFiles, SELECTED_BUTTON_STYLE);
    }

    @FXML
    private void openTune5ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handleChooseMP3Click(pane, openTune5Button, 5, tuneFiles, SELECTED_BUTTON_STYLE);
    }

    @FXML
    private void openTune6ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handleChooseMP3Click(pane, openTune6Button, 6, tuneFiles, SELECTED_BUTTON_STYLE);
    }

    @FXML
    private void openTune7ButtonClick(MouseEvent mouseEvent) {
        UIUtil.handleChooseMP3Click(pane, openTune7Button, 7, tuneFiles, SELECTED_BUTTON_STYLE);
    }

    @FXML
    private void save1ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                1,
                openTune1Button,
                new TuneRecord(title1, author1, play1Button, pause1Button)
        );
    }

    @FXML
    private void save2ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                2,
                openTune2Button,
                new TuneRecord(title2, author2, play2Button, pause2Button)
        );
    }

    @FXML
    private void save3ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                3,
                openTune3Button,
                new TuneRecord(title3, author3, play3Button, pause3Button)
        );
    }

    @FXML
    private void save4ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                4,
                openTune4Button,
                new TuneRecord(title4, author4, play4Button, pause4Button)
        );
    }

    @FXML
    private void save5ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                5,
                openTune5Button,
                new TuneRecord(title5, author5, play5Button, pause5Button)
        );
    }

    @FXML
    private void save6ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                6,
                openTune6Button,
                new TuneRecord(title6, author6, play6Button, pause6Button)
        );
    }

    @FXML
    private void save7ButtonClick(MouseEvent mouseEvent) {
        handleSaveTuneClick(
                7,
                openTune7Button,
                new TuneRecord(title7, author7, play7Button, pause7Button)
        );
    }

}
