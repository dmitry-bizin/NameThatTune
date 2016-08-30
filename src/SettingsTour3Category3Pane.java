import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 21.08.2016.
 */
public class SettingsTour3Category3Pane {
    private Pane settingsTour3Category3Pane;
    private Scene settingsTour3Category3Scene;

    public SettingsTour3Category3Pane() {
        settingsTour3Category3Pane = new Pane();
        settingsTour3Category3Scene = new Scene(settingsTour3Category3Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour3Category3Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour3Category3Scene() {
        return settingsTour3Category3Scene;
    }
}
