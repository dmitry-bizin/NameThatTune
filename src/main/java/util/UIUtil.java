package util;

import dao.CategoryDAO;
import dao.CurrentDirectoryDAO;
import entity.Category;
import entity.CurrentDirectory;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import record.TuneRecord;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;

public class UIUtil {

    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private static final CategoryDAO CATEGORY_DAO = new CategoryDAO();
    private static final CurrentDirectoryDAO CURRENT_DIRECTORY_DAO = new CurrentDirectoryDAO();

    private UIUtil() {
    }

    public static void addKeyHandlers(Scene scene, Stage stage) {
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
        addKeyHandlers(scene, stage);
        stage.setScene(scene);
        stage.setTitle(title);
    }

    public static void changeSceneToMain(Pane pane) {
        try {
            Parent root = FileUtil.loadMainFromFXML();
            changeScene(root, getStage(pane), "Угадай мелодию!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToGame(Pane pane) {
        try {
            Parent root = FileUtil.loadGameFromFXML();
            changeScene(root, getStage(pane), "Игра");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToRound(Pane pane, int roundNumber) {
        try {
            Parent root = FileUtil.loadRoundFromFXML(roundNumber);
            changeScene(root, getStage(pane), roundNumber + " тур");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToSettings(Pane pane) {
        try {
            Parent root = FileUtil.loadSettingsFromFXML();
            changeScene(root, getStage(pane), "Настройки");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToSettingsRound(Pane pane, int roundNumber) {
        try {
            Parent root = FileUtil.loadSettingsRoundFromFXML(roundNumber);
            changeScene(root, getStage(pane), "Настройки " + roundNumber + "го тура");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToSettingsRoundCategory(Pane pane, int roundNumber, int categoryNumber) {
        try {
            Parent root = FileUtil.loadSettingsRoundCategoryFromFXML(roundNumber, categoryNumber);
            changeScene(root, getStage(pane), "Настройки " + roundNumber + "го тура");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToSuperGame(Pane pane) {
        try {
            Parent root = FileUtil.loadSuperGameFromFXML();
            changeScene(root, getStage(pane), "Суперигра");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneToSuperGameSettings(Pane pane) {
        try {
            Parent root = FileUtil.loadSuperGameSettingsFromFXML();
            changeScene(root, getStage(pane), "Настройки суперигры");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillCategoryLabels(Label[] categoryLabels, int roundNumber) {
        List<Category> categoryList = CATEGORY_DAO.readByRoundId(roundNumber);
        for (int i = 0; i < categoryLabels.length; i++) {
            categoryLabels[i].setText(categoryList.get(i).getTitle());
        }
    }

    public static void initGlowsAndTimelines(Glow[] glows, Timeline[] timelines) {
        for (int i = 0; i < glows.length; i++) {
            glows[i] = new Glow();
            timelines[i] = new Timeline();
            timelines[i].setCycleCount(Timeline.INDEFINITE);
            timelines[i].setAutoReverse(true);
            timelines[i].getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glows[i].levelProperty(), 1)));
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

    private static FileChooser initFileChooser() {
        CurrentDirectory currentDirectory = CURRENT_DIRECTORY_DAO.read();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбор мелодии для загрузки");
        if (currentDirectory != null && Files.exists(Paths.get(currentDirectory.getPath()), LinkOption.NOFOLLOW_LINKS)) {
            fileChooser.setInitialDirectory(new File(currentDirectory.getPath()));
        }
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Audio Files", "*.mp3"));
        return fileChooser;
    }

    public static void initSettingsData(TuneRecord tuneRecord,
                                        File[] tuneFiles,
                                        Media[] medias,
                                        MediaPlayer[] mediaPlayers,
                                        int number) {
        if (tuneFiles[number].exists()) {
            medias[number] = new Media(tuneFiles[number].toURI().toString());
            mediaPlayers[number] = new MediaPlayer(medias[number]);
            tuneRecord.playButton.setDisable(false);
            tuneRecord.pauseButton.setDisable(false);
        } else {
            medias[number] = null;
            mediaPlayers[number] = null;
            tuneRecord.playButton.setDisable(true);
            tuneRecord.pauseButton.setDisable(true);
        }
        tuneRecord.saveButton.setDisable(true);
    }

    public static void handlePlayButton(int tuneNumber,
                                        Label tuneLabel,
                                        MediaPlayer[] mediaPlayers,
                                        Timeline[] timelines,
                                        Glow[] glows) {
        mediaPlayers[tuneNumber - 1].setVolume(1);
        for (int i = 0; i < mediaPlayers.length; i++) {
            if (i != tuneNumber - 1) {
                if (mediaPlayers[i] != null && mediaPlayers[i].getStatus().equals(MediaPlayer.Status.PLAYING)) {
                    if (timelines[i].getStatus().equals(Animation.Status.RUNNING)) {
                        timelines[i].pause();
                        glows[i].setLevel(0);
                    }
                    mediaPlayers[i].pause();
                }
            }
        }
        tuneLabel.setEffect(glows[tuneNumber - 1]);
        glows[tuneNumber - 1].setLevel(0);
        timelines[tuneNumber - 1].play();
        mediaPlayers[tuneNumber - 1].play();
    }

    public static void handlePauseButton(int tuneNumber,
                                         Timeline[] timelines,
                                         Glow[] glows,
                                         MediaPlayer[] mediaPlayers) {
        timelines[tuneNumber - 1].pause();
        glows[tuneNumber - 1].setLevel(0);
        mediaPlayers[tuneNumber - 1].pause();
    }

    public static void handleSaveTuneClick(File[] tuneFiles,
                                           int tuneNumber,
                                           MediaPlayer[] mediaPlayers,
                                           Timeline[] timelines,
                                           Glow[] glows,
                                           Media[] medias,
                                           Button openTuneButton,
                                           TuneRecord tuneRecord,
                                           Runnable runnable,
                                           Supplier<File> supplier,
                                           String style) {
        if (tuneFiles[tuneNumber - 1] != null) {
            if (mediaPlayers[tuneNumber - 1] != null) {
                if (timelines[tuneNumber - 1].getStatus().equals(Animation.Status.RUNNING)) {
                    timelines[tuneNumber - 1].pause();
                    glows[tuneNumber - 1].setLevel(0);
                }
                mediaPlayers[tuneNumber - 1].dispose();
            }
            runnable.run();
            tuneFiles[tuneNumber - 1] = null;
            medias[tuneNumber - 1] = new Media(supplier.get().toURI().toString());
            mediaPlayers[tuneNumber - 1] = new MediaPlayer(medias[tuneNumber - 1]);
            openTuneButton.getStyleClass().replaceAll(s -> s.equals(style) ? "un" + style : s);
            tuneRecord.playButton.setDisable(false);
            tuneRecord.pauseButton.setDisable(false);
            tuneRecord.saveButton.setDisable(true);
        }
    }

    public static void handleChooseMP3Click(Pane pane,
                                            Button openTuneButton,
                                            Button saveButton,
                                            int tuneNumber,
                                            File[] tuneFiles,
                                            String style) {
        FileChooser fileChooser = initFileChooser();
        tuneFiles[tuneNumber - 1] = fileChooser.showOpenDialog(getStage(pane));
        if (tuneFiles[tuneNumber - 1] != null) {
            saveButton.setDisable(false);
            openTuneButton.getStyleClass().replaceAll(s -> s.equals("un" + style) ? style : s);
        } else {
            saveButton.setDisable(true);
            openTuneButton.getStyleClass().replaceAll(s -> s.equals(style) ? "un" + style : s);
        }
    }

    public static void disposeResources(MediaPlayer[] mediaPlayers,
                                        Glow[] glows,
                                        Timeline[] timelines,
                                        int count) {
        for (int i = 0; i < count; i++) {
            if (mediaPlayers[i] != null) {
                mediaPlayers[i].dispose();
                mediaPlayers[i] = null;
            }
            if (glows[i] != null) {
                glows[i].setLevel(0);
            }
            if (timelines[i] != null && timelines[i].getStatus().equals(Animation.Status.RUNNING)) {
                timelines[i].stop();
            }
        }
    }

}
