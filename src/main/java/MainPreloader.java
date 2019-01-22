import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.FileUtil;
import util.UIUtil;

import java.io.IOException;

public class MainPreloader extends Preloader {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(createPreloaderScene());
        stage.setResizable(false);
        stage.getIcons().add(FileUtil.getIconImage());
        stage.setAlwaysOnTop(true);
        stage.show();
        stage.setX((UIUtil.getWidth() - stage.getWidth()) / 2);
        stage.setY((UIUtil.getHeight() - stage.getHeight()) / 2);
    }

    private Scene createPreloaderScene() throws IOException {
        return new Scene(FileUtil.loadPreloaderFromFXML());
    }

    @Override
    public void handleProgressNotification(ProgressNotification progressNotification) {

    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
        if (stateChangeNotification.getType().equals(StateChangeNotification.Type.BEFORE_START)) {
            stage.hide();
        }
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification preloaderNotification) {

    }

}
