package settings.tour3;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.Main;
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
public class SettingsTour3Pane {
    private Pane pane;
    private Scene scene;
    private Label category1Label;
    private Label category2Label;
    private Label category3Label;
    private Label category4Label;
    private Label backLabel;
    private ImageView backgroundImageView;
    private Categories categories;

    public SettingsTour3Pane() {
        backgroundImageView = new ImageView(new Image(Main.getPathToResource("images/settings_tours.jpg")));
        backgroundImageView.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        backgroundImageView.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        backgroundImageView.setSmooth(true);//сглаживание

        pane = new Pane();

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories3.xml"), "UTF-8")) {
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

        scene = new Scene(pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        scene.getStylesheets().add(Main.getPathToResource("css/style.css"));
        pane.getChildren().addAll(backgroundImageView, category1Label, category2Label, category3Label, category4Label, backLabel);
    }

    public Scene getScene() {
        return scene;
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

    public void update() {//обновляет название лэйблов
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories3.xml"), "UTF-8")) {
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
}
