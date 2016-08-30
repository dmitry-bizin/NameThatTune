import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsTour1Category4Pane {
    private Pane settingsTour1Category4Pane;
    private Scene settingsTour1Category4Scene;

    public SettingsTour1Category4Pane() {
        settingsTour1Category4Pane = new Pane();
        settingsTour1Category4Scene = new Scene(settingsTour1Category4Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour1Category4Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour1Category4Scene() {
        return settingsTour1Category4Scene;
    }
}
