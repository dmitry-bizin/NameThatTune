package controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.effect.Glow;
import javafx.util.Duration;

import static util.FileUtil.TUNES_IN_CATEGORY_COUNT;

class AbstractSettingsRoundCategoryController {

    private Glow[] glows;
    private Timeline[] timelines;

    void init() {
        initGlowsAndTimelines();
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
