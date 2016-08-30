import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsSuperGamePane {
    private Pane settingsSuperGamePane;
    private Scene settingsSuperGameScene;

    public SettingsSuperGamePane() {
        settingsSuperGamePane = new Pane();
        settingsSuperGameScene = new Scene(settingsSuperGamePane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsSuperGamePane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsSuperGameScene() {
        return settingsSuperGameScene;
    }
}
