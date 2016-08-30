import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsTour1Pane {
    private Pane settingsTour1Pane;
    private Scene settingsTour1Scene;
    private Label category1Label;
    private Label category2Label;
    private Label category3Label;
    private Label category4Label;
    private Label backLabel;
    private ImageView settingsToursBackground;

    public SettingsTour1Pane() {
        settingsToursBackground = new ImageView(new Image(Main.getResource("images/settings_tours.jpg")));
        settingsToursBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        settingsToursBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        settingsToursBackground.setSmooth(true);//сглаживание
        settingsTour1Pane = new Pane();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("settings/categories1.txt"))) {
            String nameCategory = bufferedReader.readLine();
            category1Label = new Label(nameCategory == null ? "Категория1" : nameCategory);
            getCategory1Label().setCursor(Cursor.HAND);
            getCategory1Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory1Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
            getCategory1Label().setTextFill(Paint.valueOf("YELLOW"));
            getCategory1Label().setFont(Main.font);
            nameCategory = bufferedReader.readLine();
            category2Label = new Label(nameCategory == null ? "Категория2" : nameCategory);
            getCategory2Label().setCursor(Cursor.HAND);
            getCategory2Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory2Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.2);
            getCategory2Label().setTextFill(Paint.valueOf("YELLOW"));
            getCategory2Label().setFont(Main.font);
            nameCategory = bufferedReader.readLine();
            category3Label = new Label(nameCategory == null ? "Категория3" : nameCategory);
            getCategory3Label().setCursor(Cursor.HAND);
            getCategory3Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory3Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
            getCategory3Label().setTextFill(Paint.valueOf("YELLOW"));
            getCategory3Label().setFont(Main.font);
            nameCategory = bufferedReader.readLine();
            category4Label = new Label(nameCategory == null ? "Категория4" : nameCategory);
            getCategory4Label().setCursor(Cursor.HAND);
            getCategory4Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory4Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
            getCategory4Label().setTextFill(Paint.valueOf("YELLOW"));
            getCategory4Label().setFont(Main.font);
        } catch (IOException e) {
            e.printStackTrace();
        }
        backLabel = new Label("Назад");
        getBackLabel().setCursor(Cursor.HAND);
        getBackLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
        getBackLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        getBackLabel().setTextFill(Paint.valueOf("YELLOW"));
        getBackLabel().setFont(Main.font);
        settingsTour1Scene = new Scene(settingsTour1Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour1Pane.getChildren().addAll(settingsToursBackground, category1Label, category2Label, category3Label, category4Label, backLabel);
    }

    public void update() {//обновляет название лэйблов
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("settings/categories1.txt"))) {
            String nameCategory = bufferedReader.readLine();
            category1Label.setText(nameCategory == null ? "Категория1" : nameCategory);
            nameCategory = bufferedReader.readLine();
            category2Label.setText(nameCategory == null ? "Категория2" : nameCategory);
            nameCategory = bufferedReader.readLine();
            category3Label.setText(nameCategory == null ? "Категория3" : nameCategory);
            nameCategory = bufferedReader.readLine();
            category4Label.setText(nameCategory == null ? "Категория4" : nameCategory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getSettingsTour1Scene() {
        return settingsTour1Scene;
    }

    public Label getCategory1Label() {
        return category1Label;
    }

    public Label getCategory2Label() {
        return category2Label;
    }

    public Label getCategory3Label() {
        return category3Label;
    }

    public Label getCategory4Label() {
        return category4Label;
    }

    public Label getBackLabel() {
        return backLabel;
    }
}
