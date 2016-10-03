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
public class SettingsTour2Pane {
    private Pane settingsTour2Pane;
    private Scene settingsTour2Scene;
    private Label category1Label;
    private Label category2Label;
    private Label category3Label;
    private Label category4Label;
    private Label backLabel;
    private ImageView settingsToursBackground;
    private Categories categories;

    public SettingsTour2Pane() {
        settingsToursBackground = new ImageView(new Image(Main.getPathToResource("images/settings_tours.jpg")));
        settingsToursBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        settingsToursBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        settingsToursBackground.setSmooth(true);//сглаживание

        settingsTour2Pane = new Pane();

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories2.xml"), "UTF-8")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            categories = (Categories) unmarshaller.unmarshal(inputStreamReader);

            category1Label = new Label(categories.getCategory1());
            category1Label.setCursor(Cursor.HAND);
            category1Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            category1Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
            category1Label.setId("settingsToursPaneLabel");

            category2Label = new Label(categories.getCategory2());
            category2Label.setCursor(Cursor.HAND);
            category2Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            category2Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.2);
            category2Label.setId("settingsToursPaneLabel");

            category3Label = new Label(categories.getCategory3());
            category3Label.setCursor(Cursor.HAND);
            category3Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            category3Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
            category3Label.setId("settingsToursPaneLabel");

            category4Label = new Label(categories.getCategory4());
            category4Label.setCursor(Cursor.HAND);
            category4Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
            category4Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
            category4Label.setId("settingsToursPaneLabel");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        backLabel = new Label("Назад");
        backLabel.setCursor(Cursor.HAND);
        backLabel.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);//в процентах от размеров экрана,резиновая вёрстка
        backLabel.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        backLabel.setId("settingsToursPaneLabel");

        settingsTour2Scene = new Scene(settingsTour2Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour2Scene.getStylesheets().add(Main.getPathToResource("css/style.css"));
        settingsTour2Pane.getChildren().addAll(settingsToursBackground, category1Label, category2Label, category3Label, category4Label, backLabel);
    }

    public void update() {//обновляет название лэйблов
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories2.xml"), "UTF-8")) {
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
