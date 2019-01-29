package controller;

import dao.CategoryDAO;
import dao.DAO;
import entity.Category;
import javafx.animation.Timeline;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import util.UIUtil;

import static util.FileUtil.TUNES_IN_CATEGORY_COUNT;

class AbstractSettingsRoundCategoryController {

    private static final DAO<Category> CATEGORY_DAO = new CategoryDAO();

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

    void handleSaveCategoryButtonClick(TextField categoryTextField, int categoryNumber, int roundNumber) {
        if (categoryTextField.getText().isEmpty()) {
            Category category = CATEGORY_DAO.readById(categoryNumber);
            if (category != null) {
                categoryTextField.setText(category.getTitle());
            } else {
                categoryTextField.setText("Категория " + categoryNumber);
            }
        } else {
            Category category = new Category(categoryNumber, categoryTextField.getText(), roundNumber);
            CATEGORY_DAO.updateById(categoryNumber, category);
        }
    }

    void handleBackLabelClick(Pane pane, int roundNumber) {
        UIUtil.changeSceneToSettingsRound(pane, roundNumber);
    }

}
