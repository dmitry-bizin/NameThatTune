import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 21.08.2016.
 */
public class SettingsTour3Category4Pane {
    private Pane settingsTour3Category4Pane;
    private Scene settingsTour3Category4Scene;

    public SettingsTour3Category4Pane() {
        settingsTour3Category4Pane = new Pane();
        settingsTour3Category4Scene = new Scene(settingsTour3Category4Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour3Category4Pane.getChildren().addAll(/*добавить*/);
    }

    public Scene getSettingsTour3Category4Scene() {
        return settingsTour3Category4Scene;
    }
}
