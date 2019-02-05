package controller.common;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import util.UIUtil;

public abstract class AbstractSettingsRoundController {

    protected void init(Label infoLabel, int roundNumber, Label... categoryLabels) {
        infoLabel.setText("Настройки " + roundNumber + "го тура");
        UIUtil.fillCategoryLabels(categoryLabels, roundNumber);
    }

    protected void handleBackLabelClick(Pane pane) {
        UIUtil.changeSceneToSettings(pane);
    }

}
