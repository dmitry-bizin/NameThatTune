import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import xml.Categories;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
    private Categories categories;

    public SettingsTour1Pane() {
        settingsToursBackground = new ImageView(new Image(Main.getResource("images/settings_tours.jpg")));
        settingsToursBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        settingsToursBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        settingsToursBackground.setSmooth(true);//сглаживание
        settingsTour1Pane = new Pane();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories1.xml"), "UTF-8")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            categories = (Categories) unmarshaller.unmarshal(inputStreamReader);
            category1Label = new Label(categories.getCategory1());
            getCategory1Label().setCursor(Cursor.HAND);
            getCategory1Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory1Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
            getCategory1Label().getStyleClass().add("settingsToursPaneLabel");
            category2Label = new Label(categories.getCategory2());
            getCategory2Label().setCursor(Cursor.HAND);
            getCategory2Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory2Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.2);
            getCategory2Label().getStyleClass().add("settingsToursPaneLabel");
            category3Label = new Label(categories.getCategory3());
            getCategory3Label().setCursor(Cursor.HAND);
            getCategory3Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory3Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
            getCategory3Label().getStyleClass().add("settingsToursPaneLabel");
            category4Label = new Label(categories.getCategory4());
            getCategory4Label().setCursor(Cursor.HAND);
            getCategory4Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            getCategory4Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
            getCategory4Label().getStyleClass().add("settingsToursPaneLabel");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        backLabel = new Label("Назад");
        getBackLabel().setCursor(Cursor.HAND);
        getBackLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
        getBackLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        getBackLabel().getStyleClass().add("settingsToursPaneLabel");
        settingsTour1Scene = new Scene(settingsTour1Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour1Scene.getStylesheets().add(Main.getResource("css/style.css"));
        settingsTour1Pane.getChildren().addAll(settingsToursBackground, category1Label, category2Label, category3Label, category4Label, backLabel);
    }

    public void update() {//обновляет название лэйблов
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories1.xml"), "UTF-8")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            categories = (Categories) unmarshaller.unmarshal(inputStreamReader);
            category1Label.setText(categories.getCategory1());
            category2Label.setText(categories.getCategory2());
            category3Label.setText(categories.getCategory3());
            category4Label.setText(categories.getCategory4());
        } catch (IOException | JAXBException e) {
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
