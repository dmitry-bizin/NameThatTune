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
    private Label copyright;

    public MainPane() {
        mainBackground = new ImageView(new Image(Main.getPathToResource("images/main.jpg")));
        mainBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        mainBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        mainBackground.setSmooth(true);//сглаживание

        mainPane = new Pane();

        gameLabel = new Label("Игра");
        gameLabel.setCursor(Cursor.HAND);
        gameLabel.setId("mainPaneLabel");
        gameLabel.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.6);//в процентах от размеров экрана,резиновая вёрстка
        gameLabel.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);

        settingsLabel = new Label("Настройки");
        settingsLabel.setCursor(Cursor.HAND);
        settingsLabel.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.6);
        settingsLabel.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
        settingsLabel.setId("mainPaneLabel");

        copyright = new Label("© Bizin Dmitriy, 2016");
        copyright.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.46);
        copyright.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.96);
        copyright.setId("copyrightLabel");

        exitLabel = new Label("Выход");
        exitLabel.setCursor(Cursor.HAND);
        exitLabel.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.6);
        exitLabel.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        exitLabel.setId("mainPaneLabel");

        mainScene = new Scene(mainPane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        mainScene.getStylesheets().add(Main.getPathToResource("css/style.css"));
        mainPane.getChildren().addAll(mainBackground, gameLabel, settingsLabel, exitLabel, copyright);
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
