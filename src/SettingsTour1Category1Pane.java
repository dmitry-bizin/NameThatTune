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
import javafx.stage.FileChooser;
import xml.Categories;
import xml.Melody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by Dmitriy on 20.08.2016.
 */
public class SettingsTour1Category1Pane {
    private TextField title10TextField;
    private TextField author10TextField;
    private TextField title20TextField;
    private TextField author20TextField;
    private TextField title30TextField;
    private TextField author30TextField;
    private TextField title40TextField;
    private TextField author40TextField;
    private Pane settingsTour1Category1Pane;
    private Scene settingsTour1Category1Scene;
    private TextField categoryTextField;
    private Button saveCategoryButton;
    private Label backLabel;
    private FileChooser fileChooser;
    private Button openMelody10Button;
    private Button openMelody20Button;
    private Button openMelody30Button;
    private Button openMelody40Button;
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
    private File melody10;
    private File melody20;
    private File melody30;
    private File melody40;
    private Media media10;
    private MediaPlayer mediaPlayer10;
    private Media media20;
    private MediaPlayer mediaPlayer20;
    private Media media30;
    private MediaPlayer mediaPlayer30;
    private Media media40;
    private MediaPlayer mediaPlayer40;
    private Button save10Button;
    private Button save20Button;
    private Button save30Button;
    private Button save40Button;
    private Melody melody1;
    private Melody melody2;
    private Melody melody3;
    private Melody melody4;
    private Button play10Button;
    private Button pause10Button;
    private ImageView playImageView;
    private ImageView pauseImageView;

    public SettingsTour1Category1Pane() {
        settingsTour1Category1Pane = new Pane();
        settingsCategoriesBackground = new ImageView(new Image(Main.getResource("images/settings_categories.jpg")));
        settingsCategoriesBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        settingsCategoriesBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        settingsCategoriesBackground.setSmooth(true);//сглаживание
        playImageView = new ImageView(new Image(Main.getResource("images/play.png")));
        playImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        playImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());
        pauseImageView = new ImageView(new Image(Main.getResource("images/pause.png")));
        pauseImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        pauseImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());
        try (FileReader fileReader = new FileReader("settings/categories1.xml")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            categories = (Categories) unmarshaller.unmarshal(fileReader);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader("musics/tour1/category1/points10/10.xml")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Melody.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            melody1 = (Melody) unmarshaller.unmarshal(fileReader);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader("musics/tour1/category1/points20/20.xml")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Melody.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            melody2 = (Melody) unmarshaller.unmarshal(fileReader);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader("musics/tour1/category1/points30/30.xml")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Melody.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            melody3 = (Melody) unmarshaller.unmarshal(fileReader);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader("musics/tour1/category1/points40/40.xml")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Melody.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            melody4 = (Melody) unmarshaller.unmarshal(fileReader);
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
            categoryTextField.setText(categories.getCategory1());
            try (FileWriter fileWriter = new FileWriter("settings/categories1.xml")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
                marshaller.marshal(categories, fileWriter);
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
        openMelody10Button = new Button("Выбрать");
        openMelody10Button.setCursor(Cursor.HAND);
        openMelody10Button.getStyleClass().add("unselectedButton");
        openMelody10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        openMelody10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        openMelody10Button.setOnMouseClicked(event -> {
            melody10 = fileChooser.showOpenDialog(getSettingsTour1Category1Scene().getWindow());
            if (melody10 != null) {
                openMelody10Button.getStyleClass().add("selectedButton");
            }
        });
        title10TextField = new TextField();
        title10TextField.setPromptText("Название песни");
        title10TextField.setText(melody1.getTitle());
        title10TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        title10TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.6);
        title10TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);
        author10TextField = new TextField();
        author10TextField.setPromptText("Автор песни");
        author10TextField.setText(melody1.getAuthor());
        author10TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        author10TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.7);
        author10TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);
        save10Button = new Button("Сохранить");
        save10Button.setCursor(Cursor.HAND);
        save10Button.getStyleClass().add("saveButton");
        save10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        save10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.8);
        save10Button.setOnMouseClicked(event -> {
            if (melody10 != null) {
                play10Button.setDisable(false);
                pause10Button.setDisable(false);
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
                melody10 = null;
                File melody10 = new File("musics/tour1/category1/points10/10.mp3");
                media10 = new Media(melody10.toURI().toString());
                mediaPlayer10 = new MediaPlayer(media10);
                openMelody10Button.getStyleClass().remove("selectedButton");
            }
            melody1.setTitle(title10TextField.getText());
            melody1.setAuthor(author10TextField.getText());
            try (FileWriter fileWriter = new FileWriter("musics/tour1/category1/points10/10.xml")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Melody.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
                marshaller.marshal(melody1, fileWriter);
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
        });
        play10Button = new Button();
        play10Button.getStyleClass().add("playButton");
        play10Button.setGraphic(playImageView);
        play10Button.setCursor(Cursor.HAND);
        play10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        play10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        pause10Button = new Button();
        pause10Button.getStyleClass().add("pauseButton");
        pause10Button.setGraphic(pauseImageView);
        pause10Button.setCursor(Cursor.HAND);
        pause10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.04 + playImageView.getFitWidth());
        pause10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        File melody10 = new File("musics/tour1/category1/points10/10.mp3");
        if (melody10.exists()) {
            media10 = new Media(melody10.toURI().toString());
            mediaPlayer10 = new MediaPlayer(media10);
            play10Button.setDisable(false);
            pause10Button.setDisable(false);
        } else {
            media10 = null;
            mediaPlayer10 = null;
            play10Button.setDisable(true);
            pause10Button.setDisable(true);
        }
        play10Button.setOnMouseClicked(event -> {
            mediaPlayer10.play();
        });
        pause10Button.setOnMouseClicked(event -> {
            mediaPlayer10.pause();
        });
        //TODO сделать, чтобы при изменении мелодии потом проигрывалась изменённая(старой не будет и mediaPlayer выдаст ошибку)
        settingsTour1Category1Scene = new Scene(settingsTour1Category1Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour1Category1Scene.getStylesheets().addAll(Main.getResource("css/style.css"));
        settingsTour1Category1Pane.getChildren().addAll(settingsCategoriesBackground, categoryTextField, saveCategoryButton,
                getBackLabel(), openMelody10Button, save10Button, separatorV1, separatorV2, separatorV3,
                category10, category20, category30, category40, separatorH, title10TextField, author10TextField, play10Button, pause10Button);
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
