import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 21.08.2016.
 */
public class SettingsTour3Category1Pane {
    private Pane settingsTour3Category1Pane;
    private Scene settingsTour3Category1Scene;

    public SettingsTour3Category1Pane() {
        settingsTour3Category1Pane = new Pane();
        settingsTour3Category1Scene = new Scene(settingsTour3Category1Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour3Category1Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour3Category1Scene() {
        return settingsTour3Category1Scene;
    }
}
