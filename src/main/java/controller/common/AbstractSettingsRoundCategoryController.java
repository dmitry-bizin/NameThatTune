package controller.common;

import dao.CategoryDAO;
import dao.DAO;
import dao.TuneDAO;
import entity.Category;
import entity.Tune;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import record.TuneRecord;
import util.FileUtil;
import util.UIUtil;

import java.io.File;
import java.util.List;

import static util.FileUtil.CATEGORIES_IN_ROUND_COUNT;
import static util.FileUtil.TUNES_IN_CATEGORY_COUNT;

public class AbstractSettingsRoundCategoryController {

    private static final DAO<Category> CATEGORY_DAO = new CategoryDAO();
    private static final TuneDAO TUNE_DAO = new TuneDAO();

    private Glow[] glows;
    private Timeline[] timelines;
    private Media[] medias;
    private MediaPlayer[] mediaPlayers;
    private File[] tuneFiles;

    protected void init(int roundNumber, int categoryNumber, TextField categoryTextField, Label roundLabel, TuneRecord... tuneRecords) {
        tuneFiles = new File[TUNES_IN_CATEGORY_COUNT];
        medias = new Media[TUNES_IN_CATEGORY_COUNT];
        mediaPlayers = new MediaPlayer[TUNES_IN_CATEGORY_COUNT];
        initGlowsAndTimelines();
        initData(roundNumber, categoryNumber, categoryTextField, roundLabel, tuneRecords);
    }

    private void initData(int roundNumber, int categoryNumber, TextField categoryTextField, Label roundLabel, TuneRecord... tuneRecords) {
        roundLabel.setText(roundNumber + " тур");
        initCategoryTextField(categoryTextField, roundNumber, categoryNumber);
        List<Tune> tunes = TUNE_DAO.readByCategoryId((roundNumber - 1) * CATEGORIES_IN_ROUND_COUNT + categoryNumber);
        for (int i = 0; i < tunes.size(); i++) {
            Tune tune = tunes.get(i);
            TuneRecord tuneRecord = tuneRecords[i];
            tuneRecord.authorTextField.setText(tune.getAuthor());
            tuneRecord.titleTextField.setText(tune.getTitle());
            tuneFiles[i] = FileUtil.getMP3File(roundNumber, categoryNumber, i + 1);
            if (tuneFiles[i].exists()) {
                medias[i] = new Media(tuneFiles[i].toURI().toString());
                mediaPlayers[i] = new MediaPlayer(medias[i]);
                tuneRecord.playButton.setDisable(false);
                tuneRecord.pauseButton.setDisable(false);
            } else {
                medias[i] = null;
                mediaPlayers[i] = null;
                tuneRecord.playButton.setDisable(true);
                tuneRecord.pauseButton.setDisable(true);
            }
        }
    }

    private void initGlowsAndTimelines() {
        glows = new Glow[TUNES_IN_CATEGORY_COUNT];
        timelines = new Timeline[TUNES_IN_CATEGORY_COUNT];
        UIUtil.initGlowsAndTimelines(glows, timelines);
    }

    protected void handleSaveCategoryClick(TextField categoryTextField, int roundNumber, int categoryNumber) {
        if (categoryTextField.getText().isEmpty()) {
            initCategoryTextField(categoryTextField, roundNumber, categoryNumber);
        } else {
            int categoryId = (roundNumber - 1) * CATEGORIES_IN_ROUND_COUNT + categoryNumber;
            Category category = new Category(categoryId, categoryTextField.getText(), roundNumber);
            CATEGORY_DAO.updateById(categoryId, category);
        }
    }

    private void initCategoryTextField(TextField categoryTextField, int roundNumber, int categoryNumber) {
        Category category = CATEGORY_DAO.readById((roundNumber - 1) * CATEGORIES_IN_ROUND_COUNT + categoryNumber);
        if (category != null) {
            categoryTextField.setText(category.getTitle());
        } else {
            categoryTextField.setText("Категория " + categoryNumber);
        }
    }

    protected void handleBackLabelClick(Pane pane, int roundNumber) {
        UIUtil.changeSceneToSettingsRound(pane, roundNumber);
    }

    private void handleOpenTuneButtonClick(File tuneFile, Button openTuneButton) {
        if (tuneFile != null) {
            openTuneButton.getStyleClass().replaceAll(s -> s.equals("unselectedButton") ? "selectedButton" : s);
        } else {
            openTuneButton.getStyleClass().replaceAll(s -> s.equals("selectedButton") ? "unselectedButton" : s);
        }
    }

    protected void handleChooseMP3Click(Pane pane, Button button, int tuneNumber) {
        FileChooser fileChooser = UIUtil.initFileChooser();
        tuneFiles[tuneNumber - 1] = fileChooser.showOpenDialog(UIUtil.getStage(pane));
        handleOpenTuneButtonClick(tuneFiles[tuneNumber - 1], button);
    }

    protected void handleSaveTuneClick(int roundNumber, int categoryNumber, int tuneNumber, Button openTuneButton, TuneRecord tuneRecord) {
        if (tuneFiles[tuneNumber - 1] != null) {
            if (mediaPlayers[tuneNumber - 1] != null) {
                if (timelines[tuneNumber - 1].getStatus().equals(Animation.Status.RUNNING)) {
                    timelines[tuneNumber - 1].pause();
                    glows[tuneNumber - 1].setLevel(0);
                }
                mediaPlayers[tuneNumber - 1].dispose();
            }
            FileUtil.saveMP3File(tuneFiles[tuneNumber - 1], roundNumber, categoryNumber, tuneNumber);
            tuneFiles[tuneNumber - 1] = null;
            medias[tuneNumber - 1] = new Media(FileUtil.getMP3File(roundNumber, categoryNumber, tuneNumber).toURI().toString());
            mediaPlayers[tuneNumber - 1] = new MediaPlayer(medias[tuneNumber - 1]);
            openTuneButton.getStyleClass().replaceAll(s -> s.equals("selectedButton") ? "unselectedButton" : s);
            tuneRecord.playButton.setDisable(false);
            tuneRecord.pauseButton.setDisable(false);
        }
        int tuneId = (roundNumber - 1) * CATEGORIES_IN_ROUND_COUNT + (categoryNumber - 1) * TUNES_IN_CATEGORY_COUNT + tuneNumber;
        Tune tune = new Tune(tuneId,
                tuneRecord.titleTextField.getText(),
                tuneRecord.authorTextField.getText(),
                10 * tuneNumber,
                (roundNumber - 1) * CATEGORIES_IN_ROUND_COUNT + categoryNumber);
        TUNE_DAO.updateById(tuneId, tune);
    }

    protected void handlePlayButton(int tuneNumber, Label tuneLabel) {
        mediaPlayers[tuneNumber - 1].setVolume(1);
        for (int i = 0; i < mediaPlayers.length; i++) {
            if (i != tuneNumber - 1) {
                if (mediaPlayers[i] != null && mediaPlayers[i].getStatus().equals(MediaPlayer.Status.PLAYING)) {
                    if (timelines[i].getStatus().equals(Animation.Status.RUNNING)) {
                        timelines[i].pause();
                        glows[i].setLevel(0);
                    }
                    mediaPlayers[i].pause();
                }
            }
        }
        tuneLabel.setEffect(glows[tuneNumber - 1]);
        glows[tuneNumber - 1].setLevel(0);
        timelines[tuneNumber - 1].play();
        mediaPlayers[tuneNumber - 1].play();
    }

    protected void handlePauseButton(int tuneNumber) {
        timelines[tuneNumber - 1].pause();
        glows[tuneNumber - 1].setLevel(0);
        mediaPlayers[tuneNumber - 1].pause();
    }

}
