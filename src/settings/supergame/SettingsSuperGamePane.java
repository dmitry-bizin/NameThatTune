package settings.supergame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import main.Main;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsSuperGamePane {
    private Pane pane;
    private Scene scene;

    public SettingsSuperGamePane() {
        pane = new Pane();
        scene = new Scene(pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getScene() {
        return scene;
    }
}
