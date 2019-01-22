package controller;

import dao.CurrentDirectoryDAO;
import entity.CurrentDirectory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import util.UIUtil;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    private static final CurrentDirectoryDAO CURRENT_DIRECTORY_DAO = new CurrentDirectoryDAO();

    @FXML
    public Pane pane;

    @FXML
    public Label round1SettingsLabel;

    @FXML
    public Label round2SettingsLabel;

    @FXML
    public Label round3SettingsLabel;

    @FXML
    public Label supergameSettingsLabel;

    @FXML
    public Label currentDirectorySettings;

    @FXML
    public Label backLabel;

    @Override
    @SuppressWarnings("Duplicates")
    public void initialize(URL location, ResourceBundle resources) {
        round1SettingsLabel.setLayoutX(UIUtil.getWidth() * 0.03);
        round1SettingsLabel.setLayoutY(UIUtil.getHeight() * 0.1);

        round2SettingsLabel.setLayoutX(UIUtil.getWidth() * 0.03);
        round2SettingsLabel.setLayoutY(UIUtil.getHeight() * 0.2);

        round3SettingsLabel.setLayoutX(UIUtil.getWidth() * 0.03);
        round3SettingsLabel.setLayoutY(UIUtil.getHeight() * 0.3);

        supergameSettingsLabel.setLayoutX(UIUtil.getWidth() * 0.03);
        supergameSettingsLabel.setLayoutY(UIUtil.getHeight() * 0.4);

        currentDirectorySettings.setLayoutX(UIUtil.getWidth() * 0.03);
        currentDirectorySettings.setLayoutY(UIUtil.getHeight() * 0.5);

        backLabel.setLayoutX(UIUtil.getWidth() * 0.03);
        backLabel.setLayoutY(UIUtil.getHeight() * 0.6);
    }

    @FXML
    public void round1SettingsLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRound(pane, 1);
    }

    @FXML
    public void round2SettingsLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRound(pane, 2);
    }

    @FXML
    public void round3SettingsLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToSettingsRound(pane, 3);
    }

    @FXML
    public void supergameSettingsLabelClick(MouseEvent mouseEvent) {

    }

    @FXML
    public void currentDirectorySettingsClick(MouseEvent mouseEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Выбор директории с мелодиями");
        CurrentDirectory currentDirectory = CURRENT_DIRECTORY_DAO.read();
        if (currentDirectory != null) {
            directoryChooser.setInitialDirectory(new File(currentDirectory.getPath()));
        }
        File selectedDirectory = directoryChooser.showDialog(UIUtil.getStage(pane));
        if (selectedDirectory != null) {
            currentDirectory = new CurrentDirectory(selectedDirectory.toString());
            CURRENT_DIRECTORY_DAO.update(currentDirectory);
        }
    }

    @FXML
    public void backLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToMain(pane);
    }

}
