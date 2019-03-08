package controller.common;

import dao.CategoryDAO;
import dao.DAO;
import dao.TuneDAO;
import entity.Category;
import entity.Tune;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    private static final String SELECTED_BUTTON_STYLE = "selectedButton";

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
            UIUtil.initSettingsData(
                    tuneRecord,
                    tuneFiles,
                    medias,
                    mediaPlayers,
                    i
            );
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
        UIUtil.disposeResources(mediaPlayers, glows, timelines, TUNES_IN_CATEGORY_COUNT);
        UIUtil.changeSceneToSettingsRound(pane, roundNumber);
    }

    protected void handleChooseMP3Click(Pane pane, Button openTuneButton, Button saveButton, int tuneNumber) {
        UIUtil.handleChooseMP3Click(pane, openTuneButton, saveButton, tuneNumber, tuneFiles, SELECTED_BUTTON_STYLE);
    }

    protected void handleSaveTuneClick(int roundNumber, int categoryNumber, int tuneNumber, Button openTuneButton, TuneRecord tuneRecord) {
        UIUtil.handleSaveTuneClick(
                tuneFiles,
                tuneNumber,
                mediaPlayers,
                timelines,
                glows,
                medias,
                openTuneButton,
                tuneRecord,
                () -> FileUtil.saveMP3File(tuneFiles[tuneNumber - 1], roundNumber, categoryNumber, tuneNumber),
                () -> FileUtil.getMP3File(roundNumber, categoryNumber, tuneNumber),
                SELECTED_BUTTON_STYLE
        );
        int tuneId = (roundNumber - 1) * CATEGORIES_IN_ROUND_COUNT + (categoryNumber - 1) * TUNES_IN_CATEGORY_COUNT + tuneNumber;
        Tune tune = new Tune(tuneId,
                tuneRecord.titleTextField.getText(),
                tuneRecord.authorTextField.getText(),
                10 * tuneNumber,
                (roundNumber - 1) * CATEGORIES_IN_ROUND_COUNT + categoryNumber);
        TUNE_DAO.updateById(tuneId, tune);
    }

    protected void handlePlayButton(int tuneNumber, Label tuneLabel) {
        UIUtil.handlePlayButton(tuneNumber, tuneLabel, mediaPlayers, timelines, glows);
    }

    protected void handlePauseButton(int tuneNumber) {
        UIUtil.handlePauseButton(tuneNumber, timelines, glows, mediaPlayers);
    }

}
