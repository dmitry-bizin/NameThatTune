package main;

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
    private Pane pane;
    private Label gameLabel;
    private Label settingsLabel;
    private Label exitLabel;
    private Scene scene;
    private ImageView backgroundImageView;
    private Label copyrightLabel;

    public MainPane() {
        backgroundImageView = new ImageView(new Image(Main.getPathToResource("images/main.jpg")));
        backgroundImageView.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        backgroundImageView.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        backgroundImageView.setSmooth(true);//сглаживание

        pane = new Pane();

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

        copyrightLabel = new Label("© Bizin Dmitriy, 2016");
        copyrightLabel.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.46);
        copyrightLabel.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.96);
        copyrightLabel.setId("copyrightLabel");

        exitLabel = new Label("Выход");
        exitLabel.setCursor(Cursor.HAND);
        exitLabel.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.6);
        exitLabel.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        exitLabel.setId("mainPaneLabel");

        scene = new Scene(pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        scene.getStylesheets().add(Main.getPathToResource("css/style.css"));
        pane.getChildren().addAll(backgroundImageView, gameLabel, settingsLabel, exitLabel, copyrightLabel);
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

    public Scene getScene() {
        return scene;
    }
}
