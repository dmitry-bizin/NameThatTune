package controller;

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
import util.FileUtil;
import util.UIUtil;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import static util.FileUtil.TUNES_IN_SUPER_GAME_COUNT;

public class SuperGameController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private Label timerLabel;

    private Label[] notesLabels;
    private MediaPlayer[] mediaPlayers;
    private Glow[] glows;
    private Timeline[] timelines;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initGlowsAndTimelines();
        initMedia();
        Stream.of(notesLabels).forEach(label -> pane.getChildren().add(label));
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

    private void initMedia() {
        mediaPlayers = new MediaPlayer[TUNES_IN_SUPER_GAME_COUNT];
        notesLabels = new Label[TUNES_IN_SUPER_GAME_COUNT];
        ImageView[] imageViews = createImageViews();
        for (int i = 0; i < TUNES_IN_SUPER_GAME_COUNT; i++) {
            notesLabels[i] = new Label(null, imageViews[i]);
            notesLabels[i].setCursor(Cursor.HAND);
            notesLabels[i].setLayoutX(0.07 * UIUtil.getWidth() + i * 0.13 * UIUtil.getWidth());
            notesLabels[i].setLayoutY(0.38 * UIUtil.getHeight() + (TUNES_IN_SUPER_GAME_COUNT - i) * 0.04 * UIUtil.getHeight());
            int finalI = i;
            notesLabels[i].setOnMouseClicked(event -> {
                mediaPlayers[finalI].setVolume(1);
                MediaPlayer.Status status = mediaPlayers[finalI].getStatus();
                if (status.equals(MediaPlayer.Status.PLAYING)) {
                    timelines[finalI].pause();
                    glows[finalI].setLevel(1);
                    mediaPlayers[finalI].pause();
                }
                if (status.equals(MediaPlayer.Status.PAUSED) || status.equals(MediaPlayer.Status.READY)) {
                    for (int k = 0; k < TUNES_IN_SUPER_GAME_COUNT; k++) {
                        if (k != finalI && mediaPlayers[k] != null && mediaPlayers[k].getStatus().equals(MediaPlayer.Status.PLAYING)) {
                            timelines[k].pause();
                            glows[k].setLevel(1);
                            mediaPlayers[k].pause();
                        }
                    }
                    notesLabels[finalI].setEffect(glows[finalI]);
                    glows[finalI].setLevel(0);
                    timelines[finalI].play();
                    mediaPlayers[finalI].play();
                }
            });
        }
    }

    @FXML
    public void backLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToGame(pane);
    }

}
