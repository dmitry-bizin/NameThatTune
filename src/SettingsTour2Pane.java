import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsTour2Pane {
    private Pane settingsTour2Pane;
    private Scene settingsTour2Scene;
    private Label category1Label;
    private Label category2Label;
    private Label category3Label;
    private Label category4Label;
    private Label backLabel;
    private ImageView settingsToursBackground;

    public SettingsTour2Pane() {
        settingsToursBackground = new ImageView(new Image(Main.getResource("images/settings_tours.jpg")));
        settingsToursBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        settingsToursBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        settingsToursBackground.setSmooth(true);//сглаживание
        settingsTour2Pane = new Pane();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("settings/categories2.xml"))) {
            String nameCategory = bufferedReader.readLine();
            category1Label = new Label(nameCategory == null ? "Категория1" : nameCategory);
            getCategory1Label().setCursor(Cursor.HAND);
            getCategory1Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory1Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
            getCategory1Label().getStyleClass().add("settingsToursPaneLabel");
            nameCategory = bufferedReader.readLine();
            category2Label = new Label(nameCategory == null ? "Категория2" : nameCategory);
            getCategory2Label().setCursor(Cursor.HAND);
            getCategory2Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory2Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.2);
            getCategory2Label().getStyleClass().add("settingsToursPaneLabel");
            nameCategory = bufferedReader.readLine();
            category3Label = new Label(nameCategory == null ? "Категория3" : nameCategory);
            getCategory3Label().setCursor(Cursor.HAND);
            getCategory3Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory3Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
            getCategory3Label().getStyleClass().add("settingsToursPaneLabel");
            nameCategory = bufferedReader.readLine();
            category4Label = new Label(nameCategory == null ? "Категория4" : nameCategory);
            getCategory4Label().setCursor(Cursor.HAND);
            getCategory4Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory4Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
            getCategory4Label().getStyleClass().add("settingsToursPaneLabel");
        } catch (IOException e) {
            e.printStackTrace();
        }
        backLabel = new Label("Назад");
        getBackLabel().setCursor(Cursor.HAND);
        getBackLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
        getBackLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        getBackLabel().getStyleClass().add("settingsToursPaneLabel");
        settingsTour2Scene = new Scene(settingsTour2Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour2Scene.getStylesheets().add(Main.getResource("css/style.css"));
        settingsTour2Pane.getChildren().addAll(settingsToursBackground, category1Label, category2Label, category3Label, category4Label, backLabel);
    }

    public void update() {//обновляет название лэйблов
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("settings/categories2.xml"))) {
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

    public Scene getSettingsTour2Scene() {
        return settingsTour2Scene;
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
