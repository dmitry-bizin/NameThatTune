package controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import util.UIUtil;

import static util.FileUtil.TUNES_IN_CATEGORY_COUNT;

class AbstractSettingsRoundCategoryController {

    private Glow[] glows;
    private Timeline[] timelines;

    void init(TextField categoryTextField, ImageView... playPauseImageViews) {
        initPlayPauseImageView(playPauseImageViews);
        initCategoryTextField(categoryTextField);
        initGlowsAndTimelines();

    }

    private void initPlayPauseImageView(ImageView... playPauseImageViews) {
        for (ImageView imageView : playPauseImageViews) {
            imageView.setFitHeight(0.04 * UIUtil.getHeight());
            imageView.setFitWidth(0.04 * UIUtil.getHeight());
        }
    }

    private void initCategoryTextField(TextField categoryTextField) {
        categoryTextField.setLayoutX(UIUtil.getWidth() * 0.1);
        categoryTextField.setLayoutY(UIUtil.getHeight() * 0.1);
        categoryTextField.setPrefWidth(UIUtil.getWidth() * 0.2);
    }

    @SuppressWarnings("Duplicates")
    private void initGlowsAndTimelines() {
        glows = new Glow[TUNES_IN_CATEGORY_COUNT];
        timelines = new Timeline[TUNES_IN_CATEGORY_COUNT];
        for (int i = 0; i < TUNES_IN_CATEGORY_COUNT; i++) {
            glows[i] = new Glow();
            timelines[i] = new Timeline();
            timelines[i].setCycleCount(Timeline.INDEFINITE);
            timelines[i].setAutoReverse(true);
            timelines[i].getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glows[i].levelProperty(), 1.0)));
        }
    }

}
