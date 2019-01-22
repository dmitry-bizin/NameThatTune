package controller;

import dao.CategoryDAO;
import dao.DAO;
import entity.Category;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.util.Duration;
import util.FileUtil;
import util.UIUtil;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static util.FileUtil.CATEGORIES_IN_ROUND_COUNT;
import static util.FileUtil.MUSICS_IN_CATEGORY_COUNT;

abstract class AbstractRoundController {

    private static final DAO<Category> CATEGORY_DAO = new CategoryDAO();

    private Label[] notesLabels;
    private Media[] medias;
    private MediaPlayer[] mediaPlayers;
    private Glow[] glows;
    private Timeline[] timelines;

    void initialize(ImageView backImageView, Label category1Label,
                    Label category2Label, Label category3Label, Label category4Label, Pane pane, int roundNumber) {

        initBackImageView(backImageView);

        initCategoryLabels(category1Label, category2Label, category3Label, category4Label);

        medias = new Media[CATEGORIES_IN_ROUND_COUNT * MUSICS_IN_CATEGORY_COUNT];
        mediaPlayers = new MediaPlayer[CATEGORIES_IN_ROUND_COUNT * MUSICS_IN_CATEGORY_COUNT];
        notesLabels = new Label[CATEGORIES_IN_ROUND_COUNT * MUSICS_IN_CATEGORY_COUNT];
        glows = new Glow[CATEGORIES_IN_ROUND_COUNT * MUSICS_IN_CATEGORY_COUNT];
        timelines = new Timeline[CATEGORIES_IN_ROUND_COUNT * MUSICS_IN_CATEGORY_COUNT];
        ImageView[] imageViews = new ImageView[CATEGORIES_IN_ROUND_COUNT * MUSICS_IN_CATEGORY_COUNT];

        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT; i++) {
            imageViews[MUSICS_IN_CATEGORY_COUNT * i] = createNoteImageView("blue.png");
            imageViews[MUSICS_IN_CATEGORY_COUNT * i + 1] = createNoteImageView("darkGreen.png");
            imageViews[MUSICS_IN_CATEGORY_COUNT * i + 2] = createNoteImageView("orange.png");
            imageViews[MUSICS_IN_CATEGORY_COUNT * i + 3] = createNoteImageView("violet.png");
        }

        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT * MUSICS_IN_CATEGORY_COUNT; i++) {
            glows[i] = new Glow();
            timelines[i] = new Timeline();
            timelines[i].setCycleCount(Timeline.INDEFINITE);
            timelines[i].setAutoReverse(true);
            timelines[i].getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glows[i].levelProperty(), 1.0)));
        }

        // (0.7 * UIUtil.getWidth() - 0.8 * UIUtil.getHeight()) / 5 - промежуток между нотами

        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT; i++) {
            for (int j = 0; j < MUSICS_IN_CATEGORY_COUNT; j++) {
                int t = MUSICS_IN_CATEGORY_COUNT * i + j;
                double delta = j * imageViews[4 * i].getFitWidth();
                notesLabels[t] = new Label(null, imageViews[t]);
                notesLabels[t].setCursor(Cursor.HAND);
                notesLabels[t].setLayoutX(0.3 * UIUtil.getWidth() + (j + 1) * (0.7 * UIUtil.getWidth() - 0.8 * UIUtil.getHeight()) / 5 + delta);
                notesLabels[t].setLayoutY((0.025 + (0.25 * i)) * UIUtil.getHeight());
                notesLabels[t].setOnMouseClicked(event -> {
                    mediaPlayers[t].setVolume(1);
                    mediaPlayers[t].setCycleCount(Integer.MAX_VALUE);
                    MediaPlayer.Status status = mediaPlayers[t].getStatus();
                    if (status.equals(MediaPlayer.Status.PLAYING)) {
                        timelines[t].pause();
                        glows[t].setLevel(1.0);
                        mediaPlayers[t].pause();
                    }
                    if (status.equals(MediaPlayer.Status.PAUSED) || status.equals(MediaPlayer.Status.READY)) {
                        for (int k = 0; k < 16; k++) {
                            if (k != t && mediaPlayers[k] != null && mediaPlayers[k].getStatus().equals(MediaPlayer.Status.PLAYING)) {
                                timelines[k].pause();
                                glows[k].setLevel(1.0);
                                mediaPlayers[k].pause();
                            }
                        }
                        notesLabels[t].setEffect(glows[t]);
                        glows[t].setLevel(0.0);
                        timelines[t].play();
                        mediaPlayers[t].play();
                    }
                });
            }
        }

        Stream.of(notesLabels).forEach(label -> pane.getChildren().add(label));
        initData(category1Label, category2Label, category3Label, category4Label, roundNumber);
    }

    private void initBackImageView(ImageView backImageView) {
        backImageView.setFitWidth(0.05 * UIUtil.getHeight());
        backImageView.setFitHeight(0.05 * UIUtil.getHeight());
    }

    private ImageView createNoteImageView(String color) {
        ImageView imageView = new ImageView(FileUtil.getNoteImage(color));
        imageView.setFitWidth(0.2 * UIUtil.getHeight());
        imageView.setFitHeight(0.2 * UIUtil.getHeight());
        return imageView;
    }

    private void initData(Label category1Label, Label category2Label, Label category3Label, Label category4Label, int roundNumber) {
        List<Category> categoryList = CATEGORY_DAO.readAll().stream()
                .filter(category -> category.getRoundId() == roundNumber)
                .collect(Collectors.toList());
        category1Label.setText(categoryList.get(0).getTitle());
        category2Label.setText(categoryList.get(1).getTitle());
        category3Label.setText(categoryList.get(2).getTitle());
        category4Label.setText(categoryList.get(3).getTitle());

        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT; i++) {
            for (int j = 0; j < MUSICS_IN_CATEGORY_COUNT; j++) {
                File file = FileUtil.getMP3File(roundNumber, i + 1, j + 1);
                int t = MUSICS_IN_CATEGORY_COUNT * i + j;
                if (file.exists()) {
                    medias[t] = new Media(file.toURI().toString());
                    mediaPlayers[t] = new MediaPlayer(medias[t]);
                    notesLabels[t].setDisable(false);
                } else {
                    medias[t] = null;
                    mediaPlayers[t] = null;
                    notesLabels[t].setDisable(true);
                }
            }
        }
    }

    private void initCategoryLabels(Label category1Label, Label category2Label, Label category3Label, Label category4Label) {
        initCategoryLabel(category1Label, 0);
        initCategoryLabel(category2Label, 1);
        initCategoryLabel(category3Label, 2);
        initCategoryLabel(category4Label, 3);
    }

    private void initCategoryLabel(Label label, int labelNumber) {
        label.setLayoutY(UIUtil.getHeight() * 0.25 * labelNumber);
        label.setMaxSize(UIUtil.getWidth() * 0.3, UIUtil.getHeight() * 0.25);
        label.setMinSize(UIUtil.getWidth() * 0.3, UIUtil.getHeight() * 0.25);
        label.setFont(new Font(UIUtil.getHeight() * 0.045));
    }

    private void disposeResources() {
        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT * MUSICS_IN_CATEGORY_COUNT; i++) {
            if (mediaPlayers[i] != null) {
                mediaPlayers[i].dispose();
                medias[i] = null;
                mediaPlayers[i] = null;
            }
            if (!notesLabels[i].isDisable()) {
                glows[i].setLevel(0.0);
                if (timelines[i].getStatus().equals(Animation.Status.RUNNING)) {
                    timelines[i].stop();
                }
            }
        }
        //System.gc();
    }

    void handleBackLabelClick(Pane pane) {
        disposeResources();
        UIUtil.changeSceneToGame(pane);
    }

}
