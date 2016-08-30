import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsTour1Category3Pane {
    private Pane settingsTour1Category3Pane;
    private Scene settingsTour1Category3Scene;

    public SettingsTour1Category3Pane() {
        settingsTour1Category3Pane = new Pane();
        settingsTour1Category3Scene = new Scene(settingsTour1Category3Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour1Category3Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour1Category3Scene() {
        return settingsTour1Category3Scene;
    }
}
