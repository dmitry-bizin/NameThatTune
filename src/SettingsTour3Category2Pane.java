import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 21.08.2016.
 */
public class SettingsTour3Category2Pane {
    private Pane settingsTour3Category2Pane;
    private Scene settingsTour3Category2Scene;

    public SettingsTour3Category2Pane() {
        settingsTour3Category2Pane = new Pane();
        settingsTour3Category2Scene = new Scene(settingsTour3Category2Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour3Category2Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour3Category2Scene() {
        return settingsTour3Category2Scene;
    }
}
