import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


/**
 * Created by Dmitriy on 17.02.2016.
 */
public class MainPane {
    private Pane mainPane;
    private Label gameLabel;
    private Label settingsLabel;
    private Label exitLabel;
    private Scene mainScene;
    private ImageView mainBackground;

    public MainPane() {
        mainBackground = new ImageView(new Image(Main.getPathToResource("images/main.jpg")));
        mainBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        mainBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        mainBackground.setSmooth(true);//сглаживание
        mainPane = new Pane();
        gameLabel = new Label("Игра");
        getGameLabel().setCursor(Cursor.HAND);
        settingsLabel = new Label("Настройки");
        getSettingsLabel().setCursor(Cursor.HAND);
        exitLabel = new Label("Выход");
        getExitLabel().setCursor(Cursor.HAND);
        getGameLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.6);//в процентах от размеров экрана,резиновая вёрстка
        getGameLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        getGameLabel().setId("mainPaneLabel");
        getSettingsLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.6);
        getSettingsLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
        getSettingsLabel().setId("mainPaneLabel");
        getExitLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.6);
        getExitLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        getExitLabel().setId("mainPaneLabel");
        mainScene = new Scene(mainPane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        mainScene.getStylesheets().add(Main.getPathToResource("css/style.css"));
        mainPane.getChildren().addAll(mainBackground, getGameLabel(), getSettingsLabel(), getExitLabel());
    }

    public Label getGameLabel() {
        return gameLabel;
    }

    public Label getSettingsLabel() {
        return settingsLabel;
    }

    public Label getExitLabel() {
        return exitLabel;
    }

    public Scene getMainScene() {
        return mainScene;
    }
}
