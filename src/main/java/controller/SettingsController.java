package controller;

import dao.CurrentDirectoryDAO;
import entity.CurrentDirectory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    }

    @FXML
    private void currentDirectorySettingsClick(MouseEvent mouseEvent) {
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
    private void backLabelClick(MouseEvent mouseEvent) {
        UIUtil.changeSceneToMain(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
