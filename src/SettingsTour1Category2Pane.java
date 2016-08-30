import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsTour1Category2Pane {
    private Pane settingsTour1Category2Pane;
    private Scene settingsTour1Category2Scene;

    public SettingsTour1Category2Pane() {
        settingsTour1Category2Pane = new Pane();
        settingsTour1Category2Scene = new Scene(settingsTour1Category2Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour1Category2Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour1Category2Scene() {
        return settingsTour1Category2Scene;
    }
}
