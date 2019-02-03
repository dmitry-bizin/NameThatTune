package controller;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import util.UIUtil;

abstract class AbstractSettingsRoundController {

    void init(int roundNumber, Label... categoryLabels) {
        UIUtil.fillCategoryLabels(categoryLabels, roundNumber);
    }

    void handleBackLabelClick(Pane pane) {
        UIUtil.changeSceneToSettings(pane);
    }

}
