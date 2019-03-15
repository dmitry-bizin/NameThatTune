package controller;

import dao.SettingsDAO;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import util.FileUtil;
import util.SettingsUtil;
import util.UIUtil;

import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import static util.FileUtil.TUNES_IN_SUPER_GAME_COUNT;

public class SuperGameController implements Initializable {

    private static final double STEP = 0.1;// in seconds
    private static final SettingsDAO SETTINGS_DAO = new SettingsDAO();

    @FXML
    private Pane pane;

    @FXML
    private Label timerLabel;

    private Label[] noteLabels;
    private MediaPlayer[] mediaPlayers;
    private Glow[] glows;
    private Timeline[] timelines;
    private Timeline timerTimeline;
    private double currentSeconds;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTimerLabel();
        initGlowsAndTimelines();
        initMedia();
        Stream.of(noteLabels).forEach(label -> pane.getChildren().add(label));
        initMP3();
    }

    private void initTimerLabel() {
        currentSeconds = Integer.parseInt(Optional.ofNullable(SETTINGS_DAO.readByKey(SettingsUtil.COUNT_SECONDS_KEY))
                .orElse(SettingsUtil.COUNT_SECONDS_DEFAULT_VALUE));
        timerLabel.setText(String.format(Locale.ENGLISH, "%.1f", currentSeconds));
    }

    private void initTimerTimeline() {
        timerTimeline = new Timeline();
        timerTimeline.setCycleCount(Timeline.INDEFINITE);
        timerTimeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(STEP * 1_000), event -> {
                    currentSeconds -= STEP;
                    if (currentSeconds <= 0) {
                        timerTimeline.stop();
                        currentSeconds = 0;
                        stopAll();
                    }
                    timerLabel.setText(String.format(Locale.ENGLISH, "%.1f", currentSeconds));
                }));
        timerTimeline.playFromStart();
    }

    private void stopAll() {
        Stream.of(noteLabels).filter(Objects::nonNull).forEach(label -> label.setDisable(true));
        dispose();
    }

    private void initGlowsAndTimelines() {
        glows = new Glow[TUNES_IN_SUPER_GAME_COUNT];
        timelines = new Timeline[TUNES_IN_SUPER_GAME_COUNT];
        UIUtil.initGlowsAndTimelines(glows, timelines);
    }

    private ImageView[] createImageViews() {
        ImageView[] imageViews = new ImageView[TUNES_IN_SUPER_GAME_COUNT];
        imageViews[0] = createNoteImageView("blue.png");
        imageViews[1] = createNoteImageView("green.png");
        imageViews[2] = createNoteImageView("orange.png");
        imageViews[3] = createNoteImageView("pink.png");
        imageViews[4] = createNoteImageView("red.png");
        imageViews[5] = createNoteImageView("violet.png");
        imageViews[6] = createNoteImageView("yellow.png");
        return imageViews;
    }

    private ImageView createNoteImageView(String color) {
        ImageView imageView = new ImageView(FileUtil.getNoteImage(color));
        imageView.setFitWidth(0.15 * UIUtil.getHeight());
        imageView.setFitHeight(0.15 * UIUtil.getHeight());
        return imageView;
    }

    private void initMP3() {
        for (int i = 0; i < TUNES_IN_SUPER_GAME_COUNT; i++) {
            File file = FileUtil.getMP3File(i + 1);
            UIUtil.initMP3(file, mediaPlayers, noteLabels, i);
        }
    }

    private void initMedia() {
        mediaPlayers = new MediaPlayer[TUNES_IN_SUPER_GAME_COUNT];
        noteLabels = new Label[TUNES_IN_SUPER_GAME_COUNT];
        ImageView[] imageViews = createImageViews();
        for (int i = 0; i < TUNES_IN_SUPER_GAME_COUNT; i++) {
            noteLabels[i] = new Label(null, imageViews[i]);
            noteLabels[i].setCursor(Cursor.HAND);
            noteLabels[i].setLayoutX(0.07 * UIUtil.getWidth() + i * 0.13 * UIUtil.getWidth());
            noteLabels[i].setLayoutY(0.38 * UIUtil.getHeight() + (TUNES_IN_SUPER_GAME_COUNT - i) * 0.04 * UIUtil.getHeight());
            int t = i;
            noteLabels[i].setOnMouseClicked(event -> {
                if (timerTimeline == null) {
                    initTimerTimeline();
                }
                if (mediaPlayers[t].getStatus().equals(MediaPlayer.Status.PLAYING)) {
                    timerTimeline.pause();
                }
                if (mediaPlayers[t].getStatus().equals(MediaPlayer.Status.STOPPED) ||
                        mediaPlayers[t].getStatus().equals(MediaPlayer.Status.READY)) {
                    timerTimeline.play();
                }
                UIUtil.clickNoteHandler(
                        mediaPlayers,
                        timelines,
                        glows,
                        noteLabels,
                        t,
                        TUNES_IN_SUPER_GAME_COUNT,
                        false
                );
            });
        }
    }

    @FXML
    private void backLabelClick(MouseEvent mouseEvent) {
        dispose();
        UIUtil.changeSceneToGame(pane);
    }

    private void dispose() {
        if (timerTimeline != null && timerTimeline.getStatus().equals(Animation.Status.RUNNING)) {
            timerTimeline.stop();
        }
        UIUtil.disposeResources(mediaPlayers, glows, timelines, TUNES_IN_SUPER_GAME_COUNT);
    }

}
