package controller;

import dao.CategoryDAO;
import dao.DAO;
import entity.Category;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import util.UIUtil;

import java.util.List;
import java.util.stream.Collectors;

abstract class AbstractSettingsRoundController {

    private static final DAO<Category> CATEGORY_DAO = new CategoryDAO();

    void init(Label backLabel, int roundNumber, Label... categoryLabels) {
        initLabels(roundNumber, categoryLabels);
        backLabel.setLayoutX(UIUtil.getWidth() * 0.01);
        backLabel.setLayoutY(UIUtil.getHeight() * 0.5);
    }

    private void initLabels(int roundNumber, Label... categoryLabels) {
        List<Category> categoryList = CATEGORY_DAO.readAll().stream()
                .filter(category -> category.getRoundId() == roundNumber)
                .collect(Collectors.toList());
        for (int i = 0; i < categoryLabels.length; i++) {
            categoryLabels[i].setText(categoryList.get(i).getTitle());
            categoryLabels[i].setLayoutX(UIUtil.getWidth() * 0.01);
            categoryLabels[i].setLayoutY(UIUtil.getHeight() * 0.1 * (i + 1));
        }
    }

    void handleBackLabelClick(Pane pane) {
        UIUtil.changeSceneToSettings(pane);
    }

}
