package controller.common;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import util.FileUtil;
import util.UIUtil;

import java.io.File;
import java.util.stream.Stream;

import static util.FileUtil.CATEGORIES_IN_ROUND_COUNT;
import static util.FileUtil.TUNES_IN_CATEGORY_COUNT;

public abstract class AbstractRoundController {

    private Label[] notesLabels;
    private MediaPlayer[] mediaPlayers;
    private Glow[] glows;
    private Timeline[] timelines;

    protected void init(Pane pane, int roundNumber, Label... categoryLabels) {
        initGlowsAndTimelines();
        initMedia();
        Stream.of(notesLabels).forEach(label -> pane.getChildren().add(label));
        UIUtil.fillCategoryLabels(categoryLabels, roundNumber);
        initMP3(roundNumber);
    }

    private ImageView[] createImageViews() {
        ImageView[] imageViews = new ImageView[CATEGORIES_IN_ROUND_COUNT * TUNES_IN_CATEGORY_COUNT];
        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT; i++) {
            imageViews[TUNES_IN_CATEGORY_COUNT * i] = createNoteImageView("blue.png");
            imageViews[TUNES_IN_CATEGORY_COUNT * i + 1] = createNoteImageView("darkGreen.png");
            imageViews[TUNES_IN_CATEGORY_COUNT * i + 2] = createNoteImageView("orange.png");
            imageViews[TUNES_IN_CATEGORY_COUNT * i + 3] = createNoteImageView("violet.png");
        }
        return imageViews;
    }

    private void initGlowsAndTimelines() {
        glows = new Glow[CATEGORIES_IN_ROUND_COUNT * TUNES_IN_CATEGORY_COUNT];
        timelines = new Timeline[CATEGORIES_IN_ROUND_COUNT * TUNES_IN_CATEGORY_COUNT];
        UIUtil.initGlowsAndTimelines(glows, timelines);
    }

    private ImageView createNoteImageView(String color) {
        ImageView imageView = new ImageView(FileUtil.getNoteImage(color));
        imageView.setFitWidth(0.2 * UIUtil.getHeight());
        imageView.setFitHeight(0.2 * UIUtil.getHeight());
        return imageView;
    }

    private void initMedia() {
        mediaPlayers = new MediaPlayer[CATEGORIES_IN_ROUND_COUNT * TUNES_IN_CATEGORY_COUNT];
        notesLabels = new Label[CATEGORIES_IN_ROUND_COUNT * TUNES_IN_CATEGORY_COUNT];
        ImageView[] imageViews = createImageViews();
        // (0.7 * UIUtil.getWidth() - 0.8 * UIUtil.getHeight()) / 5 - промежуток между нотами
        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT; i++) {
            for (int j = 0; j < TUNES_IN_CATEGORY_COUNT; j++) {
                int t = TUNES_IN_CATEGORY_COUNT * i + j;
                double delta = j * imageViews[4 * i].getFitWidth();
                notesLabels[t] = new Label(null, imageViews[t]);
                notesLabels[t].setCursor(Cursor.HAND);
                notesLabels[t].setLayoutX(0.3 * UIUtil.getWidth() + (j + 1) * (0.7 * UIUtil.getWidth() - 0.8 * UIUtil.getHeight()) / 5 + delta);
                notesLabels[t].setLayoutY((0.025 + (0.25 * i)) * UIUtil.getHeight());
                notesLabels[t].setOnMouseClicked(event -> {
                    mediaPlayers[t].setVolume(1);
                    MediaPlayer.Status status = mediaPlayers[t].getStatus();
                    if (status.equals(MediaPlayer.Status.PLAYING)) {
                        timelines[t].pause();
                        glows[t].setLevel(1);
                        mediaPlayers[t].pause();
                    }
                    if (status.equals(MediaPlayer.Status.PAUSED) || status.equals(MediaPlayer.Status.READY)) {
                        for (int k = 0; k < 16; k++) {
                            if (k != t && mediaPlayers[k] != null && mediaPlayers[k].getStatus().equals(MediaPlayer.Status.PLAYING)) {
                                timelines[k].pause();
                                glows[k].setLevel(1);
                                mediaPlayers[k].pause();
                            }
                        }
                        notesLabels[t].setEffect(glows[t]);
                        glows[t].setLevel(0);
                        timelines[t].play();
                        mediaPlayers[t].play();
                    }
                });
            }
        }
    }

    private void initMP3(int roundNumber) {
        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT; i++) {
            for (int j = 0; j < TUNES_IN_CATEGORY_COUNT; j++) {
                File file = FileUtil.getMP3File(roundNumber, i + 1, j + 1);
                int t = TUNES_IN_CATEGORY_COUNT * i + j;
                if (file.exists()) {
                    Media media = new Media(file.toURI().toString());
                    mediaPlayers[t] = new MediaPlayer(media);
                    notesLabels[t].setDisable(false);
                } else {
                    mediaPlayers[t] = null;
                    notesLabels[t].setDisable(true);
                }
            }
        }
    }

    private void disposeResources() {
        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT * TUNES_IN_CATEGORY_COUNT; i++) {
            if (mediaPlayers[i] != null) {
                mediaPlayers[i].dispose();
                mediaPlayers[i] = null;
            }
            if (!notesLabels[i].isDisable()) {
                glows[i].setLevel(0);
                if (timelines[i].getStatus().equals(Animation.Status.RUNNING)) {
                    timelines[i].stop();
                }
            }
        }
    }

    protected void handleBackLabelClick(Pane pane) {
        disposeResources();
        UIUtil.changeSceneToGame(pane);
    }

}
