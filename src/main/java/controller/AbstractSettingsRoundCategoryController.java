package controller;

import javafx.animation.Timeline;
import javafx.scene.effect.Glow;
import util.UIUtil;

import static util.FileUtil.TUNES_IN_CATEGORY_COUNT;

class AbstractSettingsRoundCategoryController {

    private Glow[] glows;
    private Timeline[] timelines;

    void init() {
        initGlowsAndTimelines();
    }

    private void initGlowsAndTimelines() {
        glows = new Glow[TUNES_IN_CATEGORY_COUNT];
        timelines = new Timeline[TUNES_IN_CATEGORY_COUNT];
        UIUtil.initGlowsAndTimelines(glows, timelines);
    }

}
