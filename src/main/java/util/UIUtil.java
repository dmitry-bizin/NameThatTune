package util;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class UIUtil {

    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

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
