package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static final int CATEGORIES_IN_ROUND_COUNT = 4;
    public static final int MUSICS_IN_CATEGORY_COUNT = 4;
    private static final String MUSICS = "musics";
    private static final String ROUND = "round";
    private static final String CATEGORY = "category";
    private static final String MUSIC = "music";
    private static final String SUPERGAME = "supergame";
    private static final String IMAGES = "/images/";
    private static final String NOTES = IMAGES + "notes/";
    private static final String ICON = IMAGES + "icon.png";
    private static final String FXML = "/fxml/";
    private static final String MAIN_FXML = FXML + "main.fxml";
    private static final String GAME_FXML = FXML + "game.fxml";
    private static final String SETTINGS_FXML = FXML + "settings.fxml";
    private static final String PRELOADER = FXML + "preloader.fxml";
    private static final String FXML_EXT = ".fxml";
    private static final String SETTINGS_ROUND = "settingsRound";
    private static final int ROUNDS_COUNT = 3;

    private FileUtil() {
    }

    public static void createDirectories() {
        createDir(MUSICS);
        for (int roundNumber = 1; roundNumber <= ROUNDS_COUNT; roundNumber++) {
            String roundPath = MUSICS + "/" + ROUND + roundNumber;
            createDir(roundPath);
            for (int categoryNumber = 1; categoryNumber <= CATEGORIES_IN_ROUND_COUNT; categoryNumber++) {
                String categoryPath = roundPath + "/" + CATEGORY + categoryNumber;
                createDir(categoryPath);
                for (int musicNumber = 1; musicNumber <= MUSICS_IN_CATEGORY_COUNT; musicNumber++) {
                    createDir(categoryPath + "/" + MUSIC + musicNumber);
                }
            }
        }
        createDir(MUSICS + "/" + SUPERGAME);
    }

    private static void createDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    public static File getMP3File(int roundNumber, int categoryNumber, int musicNumber) {
        return new File(MUSICS + "/" + ROUND + roundNumber + "/" + CATEGORY + categoryNumber + "/" + MUSIC + musicNumber + "/" + musicNumber + ".mp3");
    }

    public static Image getNoteImage(String color) {
        return new Image(FileUtil.class.getResource(NOTES + color).toString());
    }

    public static Image getIconImage() {
        return new Image(FileUtil.class.getResource(ICON).toString());
    }

    public static Parent loadMainFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(MAIN_FXML));
    }

    public static Parent loadGameFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(GAME_FXML));
    }

    public static Parent loadSettingsFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(SETTINGS_FXML));
    }

    public static Parent loadRoundFromFXML(int roundNumber) throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(FXML + ROUND + roundNumber + FXML_EXT));
    }

    public static Parent loadPreloaderFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(PRELOADER));
    }

    public static Parent loadSettingsRoundFromFXML(int roundNumber) throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(FXML + SETTINGS_ROUND + roundNumber + FXML_EXT));
    }

}
