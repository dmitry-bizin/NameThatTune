import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 21.08.2016.
 */
public class SettingsTour2Category3Pane {
    private Pane settingsTour2Category3Pane;
    private Scene settingsTour2Category3Scene;

    public SettingsTour2Category3Pane() {
        settingsTour2Category3Pane = new Pane();
        settingsTour2Category3Scene = new Scene(settingsTour2Category3Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour2Category3Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour2Category3Scene() {
        return settingsTour2Category3Scene;
    }
}
