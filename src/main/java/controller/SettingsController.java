package controller;

import dao.SettingsDAO;
import entity.Setting;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import util.SettingsUtil;
import util.UIUtil;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    private static final SettingsDAO SETTINGS_DAO = new SettingsDAO();

    @FXML
    private Pane pane;

    @FXML
    private void round1SettingsLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRound(pane, 1);
    }

    @FXML
    private void round2SettingsLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRound(pane, 2);
    }

    @FXML
    private void round3SettingsLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRound(pane, 3);
    }

    @FXML
    private void superGameSettingsLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSuperGameSettings(pane);
    }

    @FXML
    private void currentDirectorySettingsClick(MouseEvent mouseEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Выбор директории с мелодиями");
        String currentDirectory = SETTINGS_DAO.readByKey(SettingsUtil.CURRENT_DIRECTORY_KEY);
        if (currentDirectory != null) {
            directoryChooser.setInitialDirectory(new File(currentDirectory));
        }
        File selectedDirectory = directoryChooser.showDialog(UIUtil.getStage(pane));
        if (selectedDirectory != null) {
            Setting currentDirectorySetting = new Setting(SettingsUtil.CURRENT_DIRECTORY_KEY, selectedDirectory.toString());
            SETTINGS_DAO.update(currentDirectorySetting);
        }
    }

    @FXML
    private void backLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToMain(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
