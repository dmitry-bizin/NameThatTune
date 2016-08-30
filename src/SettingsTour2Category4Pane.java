import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 21.08.2016.
 */
public class SettingsTour2Category4Pane {
    private Pane settingsTour2Category4Pane;
    private Scene settingsTour2Category4Scene;

    public SettingsTour2Category4Pane() {
        settingsTour2Category4Pane = new Pane();
        settingsTour2Category4Scene = new Scene(settingsTour2Category4Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour2Category4Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour2Category4Scene() {
        return settingsTour2Category4Scene;
    }
}
