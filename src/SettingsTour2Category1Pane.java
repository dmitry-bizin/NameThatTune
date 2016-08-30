import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 21.08.2016.
 */
public class SettingsTour2Category1Pane {
    private Pane settingsTour2Category1Pane;
    private Scene settingsTour2Category1Scene;

    public SettingsTour2Category1Pane() {
        settingsTour2Category1Pane = new Pane();
        settingsTour2Category1Scene = new Scene(settingsTour2Category1Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour2Category1Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour2Category1Scene() {
        return settingsTour2Category1Scene;
    }
}
