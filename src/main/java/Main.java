import com.sun.javafx.application.LauncherImpl;
import db.JDBC;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.FileUtil;
import util.UIUtil;

import java.io.IOException;

public class Main extends Application {

    static {
        FileUtil.createDirectories();
        JDBC.init();
    }

    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class, MainPreloader.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FileUtil.loadMainFromFXML();
            Scene scene = new Scene(root, UIUtil.getWidth(), UIUtil.getHeight());
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setTitle("Угадай мелодию!");
            primaryStage.getIcons().add(FileUtil.getIconImage());
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.setResizable(false);
            primaryStage.show();
            UIUtil.addKeyHandler(scene, primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
