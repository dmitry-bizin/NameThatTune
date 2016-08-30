import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 21.08.2016.
 */
public class SettingsTour2Category2Pane {
    private Pane settingsTour2Category2Pane;
    private Scene settingsTour2Category2Scene;

    public SettingsTour2Category2Pane() {
        settingsTour2Category2Pane = new Pane();
        settingsTour2Category2Scene = new Scene(settingsTour2Category2Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour2Category2Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour2Category2Scene() {
        return settingsTour2Category2Scene;
    }
}
