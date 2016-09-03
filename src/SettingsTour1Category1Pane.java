import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import xml.Categories;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsTour1Category1Pane {
    private Pane settingsTour1Category1Pane;
    private Scene settingsTour1Category1Scene;
    private TextField categoryTextField;
    private Button saveCategoryButton;
    private Label backLabel;
    private FileChooser fileChooser;
    private Button openFileChooserButton;
    private Button playButton;
    private Button pauseButton;
    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;
    private Categories categories;
    private Separator separatorV1;
    private Separator separatorV2;
    private Separator separatorV3;
    private Separator separatorH;
    private Label category10;
    private Label category20;
    private Label category30;
    private Label category40;
    private ImageView settingsCategoriesBackground;

    public SettingsTour1Category1Pane() {
        settingsTour1Category1Pane = new Pane();
        settingsCategoriesBackground = new ImageView(new Image(Main.getResource("images/settings_categories.jpg")));
        settingsCategoriesBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        settingsCategoriesBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        settingsCategoriesBackground.setSmooth(true);//сглаживание
        try (FileReader fileReader = new FileReader("settings/categories1.xml")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            categories = (Categories) unmarshaller.unmarshal(fileReader);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        categoryTextField = new TextField();
        categoryTextField.setPromptText("Название категории");
        categoryTextField.setText(categories.getCategory1());
        categoryTextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.1);
        categoryTextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        categoryTextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);
        saveCategoryButton = new Button("Сохранить");
        saveCategoryButton.setCursor(Cursor.HAND);
        saveCategoryButton.getStyleClass().add("saveButton");
        saveCategoryButton.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.31);
        saveCategoryButton.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        saveCategoryButton.setOnMouseClicked(event -> {
            categories.setCategory1(categoryTextField.getText().equals("") ? "Категория 1" : categoryTextField.getText());
            try (FileWriter fileWriter = new FileWriter("settings/categories1.xml")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
                marshaller.marshal(new Categories(categories.getCategory1(), categories.getCategory2(), categories.getCategory3(), categories.getCategory4()), fileWriter);
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
        });
        backLabel = new Label("Назад");
        getBackLabel().setCursor(Cursor.HAND);
        getBackLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.8);
        getBackLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        getBackLabel().getStyleClass().add("settingsToursCategoriesPaneLabel");
        category10 = new Label("10");
        category10.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category10.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category10.getStyleClass().add("scoresLabel");
        separatorV1 = new Separator(Orientation.VERTICAL);
        separatorV1.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.25);
        separatorV1.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        separatorV1.setPrefHeight(Main.SCREEN_SIZE.getHeight() * 0.7);
        category20 = new Label("20");
        category20.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.25 + Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category20.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category20.getStyleClass().add("scoresLabel");
        separatorV2 = new Separator(Orientation.VERTICAL);
        separatorV2.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.5);
        separatorV2.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        separatorV2.setPrefHeight(Main.SCREEN_SIZE.getHeight() * 0.7);
        category30 = new Label("30");
        category30.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.50 + Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category30.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category30.getStyleClass().add("scoresLabel");
        separatorV3 = new Separator(Orientation.VERTICAL);
        separatorV3.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.75);
        separatorV3.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        separatorV3.setPrefHeight(Main.SCREEN_SIZE.getHeight() * 0.7);
        category40 = new Label("40");
        category40.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.75 + Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category40.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category40.getStyleClass().add("scoresLabel");
        separatorH = new Separator(Orientation.HORIZONTAL);
        separatorH.setLayoutX(0);
        separatorH.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
        separatorH.setPrefWidth(Main.SCREEN_SIZE.getWidth());
        fileChooser = new FileChooser();
        fileChooser.setTitle("Выбрать мелодию для загрузки");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Audio Files", "*.mp3"));
        openFileChooserButton = new Button("Выбрать");
        openFileChooserButton.setCursor(Cursor.HAND);
        openFileChooserButton.getStyleClass().add("saveButton");
        openFileChooserButton.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        openFileChooserButton.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.2);
        openFileChooserButton.setOnMouseClicked(event -> {
            File melody10 = fileChooser.showOpenDialog(getSettingsTour1Category1Scene().getWindow());
            try (FileInputStream fileInputStream = new FileInputStream(melody10);
                 FileOutputStream fileOutputStream = new FileOutputStream("musics/tour1/category1/points10/10.mp3")) {
                byte[] bytes = new byte[1024];
                while (fileInputStream.read(bytes) != -1) {
                    fileOutputStream.write(bytes);
                    fileOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        playButton = new Button("Играть");
        pauseButton = new Button("Пауза");
        playButton.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        playButton.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
        pauseButton.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        pauseButton.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        File file = new File("musics/tour1/category1/points10");
        File[] files = file.listFiles();
        media = new Media(files[0].toURI().toString());//если нет мелодии,тоже ошибка!!!исправить
        mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);
        //TODO сделать,чтобы при изменении мелодии потом проигрывалась изменённая(старой не будет и mediaPlayer выдаст ошибку)
        playButton.setOnMouseClicked(event -> {
            mediaPlayer.play();
        });
        pauseButton.setOnMouseClicked(event -> {
            mediaPlayer.pause();
        });
        settingsTour1Category1Scene = new Scene(settingsTour1Category1Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour1Category1Scene.getStylesheets().addAll(Main.getResource("css/style.css"));
        settingsTour1Category1Pane.getChildren().addAll(settingsCategoriesBackground, categoryTextField, saveCategoryButton,
                getBackLabel(), openFileChooserButton, playButton, pauseButton, mediaView, separatorV1, separatorV2, separatorV3,
                category10, category20, category30, category40, separatorH);
    }

    public Scene getSettingsTour1Category1Scene() {
        return settingsTour1Category1Scene;
    }

    public Label getBackLabel() {
        return backLabel;
    }

    public void update() {
        categoryTextField.setText(categories.getCategory1());
        //TODO делать update музыки
    }

}
