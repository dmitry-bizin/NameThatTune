package util;

import dao.CategoryDAO;
import dao.DAO;
import entity.Category;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static util.FileUtil.CATEGORIES_IN_ROUND_COUNT;
import static util.FileUtil.TUNES_IN_CATEGORY_COUNT;

public class UIUtil {

    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private static final DAO<Category> CATEGORY_DAO = new CategoryDAO();

    private UIUtil() {
    }

    public static void addKeyHandler(Scene scene, Stage stage) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ESCAPE)) {
                stage.close();
            }
            if (event.getCode().equals(KeyCode.WINDOWS)) {
                stage.setIconified(true);
            }
        });
    }

    private static void changeScene(Parent root, Stage stage, String title) {
        Scene scene = new Scene(root, SCREEN_SIZE.getWidth(), SCREEN_SIZE.getHeight());
        addKeyHandler(scene, stage);
        stage.setScene(scene);
        stage.setTitle(title);
    }

    public static void changeSceneToMain(Pane pane) {
        try {
            Parent root = FileUtil.loadMainFromFXML();
            UIUtil.changeScene(root, getStage(pane), "Угадай мелодию!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToGame(Pane pane) {
        try {
            Parent root = FileUtil.loadGameFromFXML();
            UIUtil.changeScene(root, getStage(pane), "Игра");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToRound(Pane pane, int roundNumber) {
        try {
            Parent root = FileUtil.loadRoundFromFXML(roundNumber);
            UIUtil.changeScene(root, getStage(pane), roundNumber + " тур");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToSettings(Pane pane) {
        try {
            Parent root = FileUtil.loadSettingsFromFXML();
            UIUtil.changeScene(root, getStage(pane), "Настройки");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToSettingsRound(Pane pane, int roundNumber) {
        try {
            Parent root = FileUtil.loadSettingsRoundFromFXML(roundNumber);
            UIUtil.changeScene(root, getStage(pane), "Настройки " + roundNumber + "го тура");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToSettingsRoundCategory(Pane pane, int roundNumber, int categoryNumber) {
        try {
            Parent root = FileUtil.loadSettingsRoundCategoryFromFXML(roundNumber, categoryNumber);
            UIUtil.changeScene(root, getStage(pane), "Настройки " + roundNumber + "го тура");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillCategoryLabels(Label[] categoryLabels, int roundNumber) {
        List<Category> categoryList = CATEGORY_DAO.readAll().stream()
                .filter(category -> category.getRoundId() == roundNumber)
                .collect(Collectors.toList());
        for (int i = 0; i < categoryLabels.length; i++) {
            categoryLabels[i].setText(categoryList.get(i).getTitle());
        }
    }

    public static void initGlowsAndTimelines(Glow[] glows, Timeline[] timelines) {
        for (int i = 0; i < CATEGORIES_IN_ROUND_COUNT * TUNES_IN_CATEGORY_COUNT; i++) {
            glows[i] = new Glow();
            timelines[i] = new Timeline();
            timelines[i].setCycleCount(Timeline.INDEFINITE);
            timelines[i].setAutoReverse(true);
            timelines[i].getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glows[i].levelProperty(), 1.0)));
        }
    }

    public static double getWidth() {
        return SCREEN_SIZE.getWidth();
    }

    public static double getHeight() {
        return SCREEN_SIZE.getHeight();
    }

    public static Stage getStage(Pane pane) {
        return (Stage) pane.getScene().getWindow();
    }

}
