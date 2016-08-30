import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsPane {
    private Pane settingsPane;
    private Scene settingsScene;
    private Label settingsTour1Label;
    private Label settingsTour2Label;
    private Label settingsTour3Label;
    private Label settingsSuperGameLabel;
    private Label backLabel;
    private ImageView settingsBackground;


    public SettingsPane() {
        settingsBackground = new ImageView(new Image(Main.getResource("images/settings.jpg")));
        settingsBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        settingsBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        settingsBackground.setSmooth(true);//сглаживание
        settingsPane = new Pane();
        settingsTour1Label = new Label("Настройки 1го тура");
        getSettingsTour1Label().setCursor(Cursor.HAND);
        getSettingsTour1Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
        getSettingsTour1Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        getSettingsTour1Label().setTextFill(Paint.valueOf("WHITE"));
        getSettingsTour1Label().setFont(Main.font);
        settingsTour2Label = new Label("Настройки 2го тура");
        getSettingsTour2Label().setCursor(Cursor.HAND);
        getSettingsTour2Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
        getSettingsTour2Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.2);
        getSettingsTour2Label().setTextFill(Paint.valueOf("WHITE"));
        getSettingsTour2Label().setFont(Main.font);
        settingsTour3Label = new Label("Настройки 3го тура");
        getSettingsTour3Label().setCursor(Cursor.HAND);
        getSettingsTour3Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
        getSettingsTour3Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        getSettingsTour3Label().setTextFill(Paint.valueOf("WHITE"));
        getSettingsTour3Label().setFont(Main.font);
        settingsSuperGameLabel = new Label("Настройки супер-игры");
        getSettingsSuperGameLabel().setCursor(Cursor.HAND);
        getSettingsSuperGameLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
        getSettingsSuperGameLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
        getSettingsSuperGameLabel().setTextFill(Paint.valueOf("WHITE"));
        getSettingsSuperGameLabel().setFont(Main.font);
        backLabel = new Label("Назад");
        getBackLabel().setCursor(Cursor.HAND);
        getBackLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
        getBackLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        getBackLabel().setTextFill(Paint.valueOf("WHITE"));
        getBackLabel().setFont(Main.font);
        settingsScene = new Scene(settingsPane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsPane.getChildren().addAll(settingsBackground, getSettingsTour1Label(), getSettingsTour2Label(), getSettingsTour3Label(), getSettingsSuperGameLabel(), getBackLabel());
    }

    public Scene getSettingsScene() {
        return settingsScene;
    }

    public Label getSettingsTour1Label() {
        return settingsTour1Label;
    }

    public Label getSettingsTour2Label() {
        return settingsTour2Label;
    }

    public Label getSettingsTour3Label() {
        return settingsTour3Label;
    }

    public Label getSettingsSuperGameLabel() {
        return settingsSuperGameLabel;
    }

    public Label getBackLabel() {
        return backLabel;
    }
}
