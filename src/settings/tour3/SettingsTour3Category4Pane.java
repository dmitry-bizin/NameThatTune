package settings.tour3;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import main.Main;
import xml.Categories;
import xml.Melody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by Dmitriy on 21.08.2016.
 */
public class SettingsTour3Category4Pane {
    private TextField title10TextField;
    private TextField author10TextField;
    private TextField title20TextField;
    private TextField author20TextField;
    private TextField title30TextField;
    private TextField author30TextField;
    private TextField title40TextField;
    private TextField author40TextField;
    private Pane pane;
    private Scene scene;
    private TextField categoryTextField;
    private Button saveCategoryButton;
    private Label backLabel;
    private FileChooser fileChooser;
    private Button openMelody10Button;
    private Button openMelody20Button;
    private Button openMelody30Button;
    private Button openMelody40Button;
    private Categories categories;
    private Separator v1Separator;
    private Separator v2Separator;
    private Separator v3Separator;
    private Separator hSeparator;
    private Label category10Label;
    private Label category20Label;
    private Label category30Label;
    private Label category40Label;
    private ImageView backgroundImageView;
    private File melody10File;
    private File melody20File;
    private File melody30File;
    private File melody40File;
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
    private Button play20Button;
    private Button pause20Button;
    private Button play30Button;
    private Button pause30Button;
    private Button play40Button;
    private Button pause40Button;
    private ImageView play10ImageView;
    private ImageView pause10ImageView;
    private ImageView play20ImageView;
    private ImageView pause20ImageView;
    private ImageView play30ImageView;
    private ImageView pause30ImageView;
    private ImageView play40ImageView;
    private ImageView pause40ImageView;
    private Label tour3Label;
    private Glow melody10Glow;
    private Timeline melody10Timeline;
    private Glow melody20Glow;
    private Timeline melody20Timeline;
    private Glow melody30Glow;
    private Timeline melody30Timeline;
    private Glow melody40Glow;
    private Timeline melody40Timeline;

    public SettingsTour3Category4Pane() {
        pane = new Pane();

        backgroundImageView = new ImageView(new Image(Main.getPathToResource("images/settings_categories.jpg")));
        backgroundImageView.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        backgroundImageView.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        backgroundImageView.setSmooth(true);//сглаживание

        play10ImageView = new ImageView(new Image(Main.getPathToResource("images/play.png")));
        play10ImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        play10ImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        pause10ImageView = new ImageView(new Image(Main.getPathToResource("images/pause.png")));
        pause10ImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        pause10ImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        play20ImageView = new ImageView(new Image(Main.getPathToResource("images/play.png")));
        play20ImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        play20ImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        pause20ImageView = new ImageView(new Image(Main.getPathToResource("images/pause.png")));
        pause20ImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        pause20ImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        play30ImageView = new ImageView(new Image(Main.getPathToResource("images/play.png")));
        play30ImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        play30ImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        pause30ImageView = new ImageView(new Image(Main.getPathToResource("images/pause.png")));
        pause30ImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        pause30ImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        play40ImageView = new ImageView(new Image(Main.getPathToResource("images/play.png")));
        play40ImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        play40ImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        pause40ImageView = new ImageView(new Image(Main.getPathToResource("images/pause.png")));
        pause40ImageView.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        pause40ImageView.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        categoryTextField = new TextField();
        categoryTextField.setPromptText("Название категории");
        categoryTextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.1);
        categoryTextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        categoryTextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);

        melody10Glow = new Glow();
        melody10Timeline = new Timeline();
        melody10Timeline.setCycleCount(Timeline.INDEFINITE);
        melody10Timeline.setAutoReverse(true);
        melody10Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(melody10Glow.levelProperty(), 1.0)));

        melody20Glow = new Glow();
        melody20Timeline = new Timeline();
        melody20Timeline.setCycleCount(Timeline.INDEFINITE);
        melody20Timeline.setAutoReverse(true);
        melody20Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(melody20Glow.levelProperty(), 1.0)));

        melody30Glow = new Glow();
        melody30Timeline = new Timeline();
        melody30Timeline.setCycleCount(Timeline.INDEFINITE);
        melody30Timeline.setAutoReverse(true);
        melody30Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(melody30Glow.levelProperty(), 1.0)));

        melody40Glow = new Glow();
        melody40Timeline = new Timeline();
        melody40Timeline.setCycleCount(Timeline.INDEFINITE);
        melody40Timeline.setAutoReverse(true);
        melody40Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(melody40Glow.levelProperty(), 1.0)));

        saveCategoryButton = new Button("Сохранить");
        saveCategoryButton.setCursor(Cursor.HAND);
        saveCategoryButton.setId("saveButton");
        saveCategoryButton.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.31);
        saveCategoryButton.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        saveCategoryButton.setOnMouseClicked(event -> {
            categories.setCategory4(categoryTextField.getText().equals("") ? "Категория 4" : categoryTextField.getText());
            categoryTextField.setText(categories.getCategory4());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("settings/categories3.xml"), "UTF-8")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
                marshaller.marshal(categories, outputStreamWriter);
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
        });

        backLabel = new Label("Назад");
        backLabel.setCursor(Cursor.HAND);
        backLabel.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.85);
        backLabel.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        backLabel.setId("settingsToursCategoriesPaneLabel");

        tour3Label = new Label("3 тур");
        tour3Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.6);
        tour3Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        tour3Label.setId("toursLabel");

        category10Label = new Label("10");
        category10Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category10Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category10Label.setId("scoresLabel");

        v1Separator = new Separator(Orientation.VERTICAL);
        v1Separator.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.25);
        v1Separator.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        v1Separator.setPrefHeight(Main.SCREEN_SIZE.getHeight() * 0.7);

        category20Label = new Label("20");
        category20Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.25 + Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category20Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category20Label.setId("scoresLabel");

        v2Separator = new Separator(Orientation.VERTICAL);
        v2Separator.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.5);
        v2Separator.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        v2Separator.setPrefHeight(Main.SCREEN_SIZE.getHeight() * 0.7);

        category30Label = new Label("30");
        category30Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.50 + Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category30Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category30Label.setId("scoresLabel");

        v3Separator = new Separator(Orientation.VERTICAL);
        v3Separator.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.75);
        v3Separator.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        v3Separator.setPrefHeight(Main.SCREEN_SIZE.getHeight() * 0.7);

        category40Label = new Label("40");
        category40Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.75 + Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category40Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category40Label.setId("scoresLabel");

        hSeparator = new Separator(Orientation.HORIZONTAL);
        hSeparator.setLayoutX(0);
        hSeparator.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
        hSeparator.setPrefWidth(Main.SCREEN_SIZE.getWidth());

        fileChooser = new FileChooser();
        fileChooser.setTitle("Выбрать мелодию для загрузки");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Audio Files", "*.mp3"));

        openMelody10Button = new Button("Выбрать");
        openMelody10Button.setCursor(Cursor.HAND);
        openMelody10Button.setId("unselectedButton");
        openMelody10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        openMelody10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        openMelody10Button.setOnMouseClicked(event -> {
            melody10File = fileChooser.showOpenDialog(getScene().getWindow());
            if (melody10File != null) {
                openMelody10Button.setId("selectedButton");
            }
        });

        openMelody20Button = new Button("Выбрать");
        openMelody20Button.setCursor(Cursor.HAND);
        openMelody20Button.setId("unselectedButton");
        openMelody20Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.26);
        openMelody20Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        openMelody20Button.setOnMouseClicked(event -> {
            melody20File = fileChooser.showOpenDialog(getScene().getWindow());
            if (melody20File != null) {
                openMelody20Button.setId("selectedButton");
            }
        });

        openMelody30Button = new Button("Выбрать");
        openMelody30Button.setCursor(Cursor.HAND);
        openMelody30Button.setId("unselectedButton");
        openMelody30Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.51);
        openMelody30Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        openMelody30Button.setOnMouseClicked(event -> {
            melody30File = fileChooser.showOpenDialog(getScene().getWindow());
            if (melody30File != null) {
                openMelody30Button.setId("selectedButton");
            }
        });

        openMelody40Button = new Button("Выбрать");
        openMelody40Button.setCursor(Cursor.HAND);
        openMelody40Button.setId("unselectedButton");
        openMelody40Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.76);
        openMelody40Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        openMelody40Button.setOnMouseClicked(event -> {
            melody40File = fileChooser.showOpenDialog(getScene().getWindow());
            if (melody40File != null) {
                openMelody40Button.setId("selectedButton");
            }
        });

        title10TextField = new TextField();
        title10TextField.setPromptText("Название песни");
        title10TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        title10TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.6);
        title10TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);
        author10TextField = new TextField();
        author10TextField.setPromptText("Автор песни");
        author10TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        author10TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.7);
        author10TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);

        title20TextField = new TextField();
        title20TextField.setPromptText("Название песни");
        title20TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.26);
        title20TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.6);
        title20TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);
        author20TextField = new TextField();
        author20TextField.setPromptText("Автор песни");
        author20TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.26);
        author20TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.7);
        author20TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);

        title30TextField = new TextField();
        title30TextField.setPromptText("Название песни");
        title30TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.51);
        title30TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.6);
        title30TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);
        author30TextField = new TextField();
        author30TextField.setPromptText("Автор песни");
        author30TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.51);
        author30TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.7);
        author30TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);

        title40TextField = new TextField();
        title40TextField.setPromptText("Название песни");
        title40TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.76);
        title40TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.6);
        title40TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);
        author40TextField = new TextField();
        author40TextField.setPromptText("Автор песни");
        author40TextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.76);
        author40TextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.7);
        author40TextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);

        save10Button = new Button("Сохранить");
        save10Button.setCursor(Cursor.HAND);
        save10Button.setId("saveButton");
        save10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        save10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.8);
        save10Button.setOnMouseClicked(event -> {
            if (melody10File != null) {
                if (mediaPlayer10 != null) {//останавливает текущее воспроизведение
                    if (melody10Timeline.getStatus().toString().equals("RUNNING")) {
                        melody10Timeline.pause();
                        melody10Glow.setLevel(0.0);
                    }
                    mediaPlayer10.dispose();
                }
                try (FileInputStream fileInputStream = new FileInputStream(melody10File);
                     FileOutputStream fileOutputStream = new FileOutputStream("musics/tour3/category4/points10/10.mp3")) {
                    byte[] bytes = new byte[1024];
                    while (fileInputStream.read(bytes) != -1) {
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                melody10File = null;
                media10 = new Media(new File("musics/tour3/category4/points10/10.mp3").toURI().toString());
                mediaPlayer10 = new MediaPlayer(media10);
                openMelody10Button.setId("unselectedButton");
                play10Button.setDisable(false);
                pause10Button.setDisable(false);
            }
            melody1.setTitle(title10TextField.getText());
            melody1.setAuthor(author10TextField.getText());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("musics/tour3/category4/points10/10.xml"), "UTF-8")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Melody.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
                marshaller.marshal(melody1, outputStreamWriter);
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
        });

        save20Button = new Button("Сохранить");
        save20Button.setCursor(Cursor.HAND);
        save20Button.setId("saveButton");
        save20Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.26);
        save20Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.8);
        save20Button.setOnMouseClicked(event -> {
            if (melody20File != null) {
                if (mediaPlayer20 != null) {//останавливает текущее воспроизведение
                    if (melody20Timeline.getStatus().toString().equals("RUNNING")) {
                        melody20Timeline.pause();
                        melody20Glow.setLevel(0.0);
                    }
                    mediaPlayer20.dispose();
                }
                try (FileInputStream fileInputStream = new FileInputStream(melody20File);
                     FileOutputStream fileOutputStream = new FileOutputStream("musics/tour3/category4/points20/20.mp3")) {
                    byte[] bytes = new byte[1024];
                    while (fileInputStream.read(bytes) != -1) {
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                melody20File = null;
                media20 = new Media(new File("musics/tour3/category4/points20/20.mp3").toURI().toString());
                mediaPlayer20 = new MediaPlayer(media20);
                openMelody20Button.setId("unselectedButton");
                play20Button.setDisable(false);
                pause20Button.setDisable(false);
            }
            melody2.setTitle(title20TextField.getText());
            melody2.setAuthor(author20TextField.getText());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("musics/tour3/category4/points20/20.xml"), "UTF-8")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Melody.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
                marshaller.marshal(melody2, outputStreamWriter);
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
        });

        save30Button = new Button("Сохранить");
        save30Button.setCursor(Cursor.HAND);
        save30Button.setId("saveButton");
        save30Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.51);
        save30Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.8);
        save30Button.setOnMouseClicked(event -> {
            if (melody30File != null) {
                if (mediaPlayer30 != null) {//останавливает текущее воспроизведение
                    if (melody30Timeline.getStatus().toString().equals("RUNNING")) {
                        melody30Timeline.pause();
                        melody30Glow.setLevel(0.0);
                    }
                    mediaPlayer30.dispose();
                }
                try (FileInputStream fileInputStream = new FileInputStream(melody30File);
                     FileOutputStream fileOutputStream = new FileOutputStream("musics/tour3/category4/points30/30.mp3")) {
                    byte[] bytes = new byte[1024];
                    while (fileInputStream.read(bytes) != -1) {
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                melody30File = null;
                media30 = new Media(new File("musics/tour3/category4/points30/30.mp3").toURI().toString());
                mediaPlayer30 = new MediaPlayer(media30);
                openMelody30Button.setId("unselectedButton");
                play30Button.setDisable(false);
                pause30Button.setDisable(false);
            }
            melody3.setTitle(title30TextField.getText());
            melody3.setAuthor(author30TextField.getText());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("musics/tour3/category4/points30/30.xml"), "UTF-8")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Melody.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
                marshaller.marshal(melody3, outputStreamWriter);
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
        });

        save40Button = new Button("Сохранить");
        save40Button.setCursor(Cursor.HAND);
        save40Button.setId("saveButton");
        save40Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.76);
        save40Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.8);
        save40Button.setOnMouseClicked(event -> {
            if (melody40File != null) {
                if (mediaPlayer40 != null) {//останавливает текущее воспроизведение
                    if (melody40Timeline.getStatus().toString().equals("RUNNING")) {
                        melody40Timeline.pause();
                        melody40Glow.setLevel(0.0);
                    }
                    mediaPlayer40.dispose();
                }
                try (FileInputStream fileInputStream = new FileInputStream(melody40File);
                     FileOutputStream fileOutputStream = new FileOutputStream("musics/tour3/category4/points40/40.mp3")) {
                    byte[] bytes = new byte[1024];
                    while (fileInputStream.read(bytes) != -1) {
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                melody40File = null;
                media40 = new Media(new File("musics/tour3/category4/points40/40.mp3").toURI().toString());
                mediaPlayer40 = new MediaPlayer(media40);
                openMelody40Button.setId("unselectedButton");
                play40Button.setDisable(false);
                pause40Button.setDisable(false);
            }
            melody4.setTitle(title40TextField.getText());
            melody4.setAuthor(author40TextField.getText());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("musics/tour3/category4/points40/40.xml"), "UTF-8")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Melody.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
                marshaller.marshal(melody4, outputStreamWriter);
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
        });

        play10Button = new Button();
        play10Button.setId("playButton");
        play10Button.setGraphic(play10ImageView);
        play10Button.setCursor(Cursor.HAND);
        play10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        play10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        pause10Button = new Button();
        pause10Button.setId("pauseButton");
        pause10Button.setGraphic(pause10ImageView);
        pause10Button.setCursor(Cursor.HAND);
        pause10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.04 + play10ImageView.getFitWidth());
        pause10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);

        play10Button.setOnMouseClicked(event -> {
            mediaPlayer10.setVolume(1);
            mediaPlayer10.setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayer20 != null && mediaPlayer20.getStatus().toString().equals("PLAYING")) {
                if (melody20Timeline.getStatus().toString().equals("RUNNING")) {
                    melody20Timeline.pause();
                    melody20Glow.setLevel(0.0);
                }
                mediaPlayer20.pause();
            }
            if (mediaPlayer30 != null && mediaPlayer30.getStatus().toString().equals("PLAYING")) {
                if (melody30Timeline.getStatus().toString().equals("RUNNING")) {
                    melody30Timeline.pause();
                    melody30Glow.setLevel(0.0);
                }
                mediaPlayer30.pause();
            }
            if (mediaPlayer40 != null && mediaPlayer40.getStatus().toString().equals("PLAYING")) {
                if (melody40Timeline.getStatus().toString().equals("RUNNING")) {
                    melody40Timeline.pause();
                    melody40Glow.setLevel(0.0);
                }
                mediaPlayer40.pause();
            }
            category10Label.setEffect(melody10Glow);
            melody10Glow.setLevel(0.0);
            melody10Timeline.play();
            mediaPlayer10.play();
        });
        pause10Button.setOnMouseClicked(event -> {
            melody10Timeline.pause();
            melody10Glow.setLevel(0.0);
            mediaPlayer10.pause();
        });

        play20Button = new Button();
        play20Button.setId("playButton");
        play20Button.setGraphic(play20ImageView);
        play20Button.setCursor(Cursor.HAND);
        play20Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.26);
        play20Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        pause20Button = new Button();
        pause20Button.setId("pauseButton");
        pause20Button.setGraphic(pause20ImageView);
        pause20Button.setCursor(Cursor.HAND);
        pause20Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.29 + play10ImageView.getFitWidth());
        pause20Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);

        play20Button.setOnMouseClicked(event -> {
            mediaPlayer20.setVolume(1);
            mediaPlayer20.setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayer10 != null && mediaPlayer10.getStatus().toString().equals("PLAYING")) {
                if (melody10Timeline.getStatus().toString().equals("RUNNING")) {
                    melody10Timeline.pause();
                    melody10Glow.setLevel(0.0);
                }
                mediaPlayer10.pause();
            }
            if (mediaPlayer30 != null && mediaPlayer30.getStatus().toString().equals("PLAYING")) {
                if (melody30Timeline.getStatus().toString().equals("RUNNING")) {
                    melody30Timeline.pause();
                    melody30Glow.setLevel(0.0);
                }
                mediaPlayer30.pause();
            }
            if (mediaPlayer40 != null && mediaPlayer40.getStatus().toString().equals("PLAYING")) {
                if (melody40Timeline.getStatus().toString().equals("RUNNING")) {
                    melody40Timeline.pause();
                    melody40Glow.setLevel(0.0);
                }
                mediaPlayer40.pause();
            }
            category20Label.setEffect(melody20Glow);
            melody20Glow.setLevel(0.0);
            melody20Timeline.play();
            mediaPlayer20.play();
        });
        pause20Button.setOnMouseClicked(event -> {
            melody20Timeline.pause();
            melody20Glow.setLevel(0.0);
            mediaPlayer20.pause();
        });

        play30Button = new Button();
        play30Button.setId("playButton");
        play30Button.setGraphic(play30ImageView);
        play30Button.setCursor(Cursor.HAND);
        play30Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.51);
        play30Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        pause30Button = new Button();
        pause30Button.setId("pauseButton");
        pause30Button.setGraphic(pause30ImageView);
        pause30Button.setCursor(Cursor.HAND);
        pause30Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.54 + play10ImageView.getFitWidth());
        pause30Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);

        play30Button.setOnMouseClicked(event -> {
            mediaPlayer30.setVolume(1);
            mediaPlayer30.setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayer10 != null && mediaPlayer10.getStatus().toString().equals("PLAYING")) {
                if (melody10Timeline.getStatus().toString().equals("RUNNING")) {
                    melody10Timeline.pause();
                    melody10Glow.setLevel(0.0);
                }
                mediaPlayer10.pause();
            }
            if (mediaPlayer20 != null && mediaPlayer20.getStatus().toString().equals("PLAYING")) {
                if (melody20Timeline.getStatus().toString().equals("RUNNING")) {
                    melody20Timeline.pause();
                    melody20Glow.setLevel(0.0);
                }
                mediaPlayer20.pause();
            }
            if (mediaPlayer40 != null && mediaPlayer40.getStatus().toString().equals("PLAYING")) {
                if (melody40Timeline.getStatus().toString().equals("RUNNING")) {
                    melody40Timeline.pause();
                    melody40Glow.setLevel(0.0);
                }
                mediaPlayer40.pause();
            }
            category30Label.setEffect(melody30Glow);
            melody30Glow.setLevel(0.0);
            melody30Timeline.play();
            mediaPlayer30.play();
        });
        pause30Button.setOnMouseClicked(event -> {
            melody30Timeline.pause();
            melody30Glow.setLevel(0.0);
            mediaPlayer30.pause();
        });

        play40Button = new Button();
        play40Button.setId("playButton");
        play40Button.setGraphic(play40ImageView);
        play40Button.setCursor(Cursor.HAND);
        play40Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.76);
        play40Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        pause40Button = new Button();
        pause40Button.setId("pauseButton");
        pause40Button.setGraphic(pause40ImageView);
        pause40Button.setCursor(Cursor.HAND);
        pause40Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.79 + play10ImageView.getFitWidth());
        pause40Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);

        play40Button.setOnMouseClicked(event -> {
            mediaPlayer40.setVolume(1);
            mediaPlayer40.setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayer10 != null && mediaPlayer10.getStatus().toString().equals("PLAYING")) {
                if (melody10Timeline.getStatus().toString().equals("RUNNING")) {
                    melody10Timeline.pause();
                    melody10Glow.setLevel(0.0);
                }
                mediaPlayer10.pause();
            }
            if (mediaPlayer20 != null && mediaPlayer20.getStatus().toString().equals("PLAYING")) {
                if (melody20Timeline.getStatus().toString().equals("RUNNING")) {
                    melody20Timeline.pause();
                    melody20Glow.setLevel(0.0);
                }
                mediaPlayer20.pause();
            }
            if (mediaPlayer30 != null && mediaPlayer30.getStatus().toString().equals("PLAYING")) {
                if (melody30Timeline.getStatus().toString().equals("RUNNING")) {
                    melody30Timeline.pause();
                    melody30Glow.setLevel(0.0);
                }
                mediaPlayer30.pause();
            }
            category40Label.setEffect(melody40Glow);
            melody40Glow.setLevel(0.0);
            melody40Timeline.play();
            mediaPlayer40.play();
        });
        pause40Button.setOnMouseClicked(event -> {
            melody40Timeline.pause();
            melody40Glow.setLevel(0.0);
            mediaPlayer40.pause();
        });

        scene = new Scene(pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        scene.getStylesheets().addAll(Main.getPathToResource("css/style.css"));
        pane.getChildren().addAll(backgroundImageView, categoryTextField, saveCategoryButton,
                backLabel, tour3Label, openMelody10Button, openMelody20Button, openMelody30Button, openMelody40Button, save10Button,
                save20Button, save30Button, save40Button, v1Separator, v2Separator, v3Separator, category10Label, category20Label,
                category30Label, category40Label, hSeparator, title10TextField, author10TextField, title20TextField, author20TextField,
                title30TextField, author30TextField, title40TextField, author40TextField, play10Button, pause10Button,
                play20Button, pause20Button, play30Button, pause30Button, play40Button, pause40Button, play20ImageView,
                pause20ImageView, play30ImageView, pause30ImageView, play40ImageView, pause40ImageView);
    }

    public Scene getScene() {
        return scene;
    }

    public Label getBackLabel() {
        return backLabel;
    }

    public void back() {//при выходе со сцены
        melody10File = null;
        melody20File = null;
        melody30File = null;
        melody40File = null;
        openMelody10Button.setId("unselectedButton");
        openMelody20Button.setId("unselectedButton");
        openMelody30Button.setId("unselectedButton");
        openMelody40Button.setId("unselectedButton");
        if (mediaPlayer10 != null) {
            mediaPlayer10.dispose();
            media10 = null;
            mediaPlayer10 = null;
        }
        if (mediaPlayer20 != null) {
            mediaPlayer20.dispose();
            media20 = null;
            mediaPlayer20 = null;
        }
        if (mediaPlayer30 != null) {
            mediaPlayer30.dispose();
            media30 = null;
            mediaPlayer30 = null;
        }
        if (mediaPlayer40 != null) {
            mediaPlayer40.dispose();
            media40 = null;
            mediaPlayer40 = null;
        }
        melody10Glow.setLevel(0.0);
        if (melody10Timeline.getStatus().toString().equals("RUNNING")) {
            melody10Timeline.stop();
        }
        melody20Glow.setLevel(0.0);
        if (melody20Timeline.getStatus().toString().equals("RUNNING")) {
            melody20Timeline.stop();
        }
        melody30Glow.setLevel(0.0);
        if (melody30Timeline.getStatus().toString().equals("RUNNING")) {
            melody30Timeline.stop();
        }
        melody40Glow.setLevel(0.0);
        if (melody40Timeline.getStatus().toString().equals("RUNNING")) {
            melody40Timeline.stop();
        }
        System.gc();
    }

    public void start() {//при заходе на сцену
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories3.xml"), "UTF-8");
             InputStreamReader inputStreamReader10 = new InputStreamReader(new FileInputStream("musics/tour3/category4/points10/10.xml"), "UTF-8");
             InputStreamReader inputStreamReader20 = new InputStreamReader(new FileInputStream("musics/tour3/category4/points20/20.xml"), "UTF-8");
             InputStreamReader inputStreamReader30 = new InputStreamReader(new FileInputStream("musics/tour3/category4/points30/30.xml"), "UTF-8");
             InputStreamReader inputStreamReader40 = new InputStreamReader(new FileInputStream("musics/tour3/category4/points40/40.xml"), "UTF-8")) {
            JAXBContext jaxbContext1 = JAXBContext.newInstance(Categories.class);
            JAXBContext jaxbContext2 = JAXBContext.newInstance(Melody.class);
            Unmarshaller unmarshaller1 = jaxbContext1.createUnmarshaller();
            Unmarshaller unmarshaller2 = jaxbContext2.createUnmarshaller();
            categories = (Categories) unmarshaller1.unmarshal(inputStreamReader);
            melody1 = (Melody) unmarshaller2.unmarshal(inputStreamReader10);
            melody2 = (Melody) unmarshaller2.unmarshal(inputStreamReader20);
            melody3 = (Melody) unmarshaller2.unmarshal(inputStreamReader30);
            melody4 = (Melody) unmarshaller2.unmarshal(inputStreamReader40);
            categoryTextField.setText(categories.getCategory4());
            title10TextField.setText(melody1.getTitle());
            author10TextField.setText(melody1.getAuthor());
            title20TextField.setText(melody2.getTitle());
            author20TextField.setText(melody2.getAuthor());
            title30TextField.setText(melody3.getTitle());
            author30TextField.setText(melody3.getAuthor());
            title40TextField.setText(melody4.getTitle());
            author40TextField.setText(melody4.getAuthor());
            File melody10File = new File("musics/tour3/category4/points10/10.mp3");
            if (melody10File.exists()) {
                media10 = new Media(melody10File.toURI().toString());
                mediaPlayer10 = new MediaPlayer(media10);
                play10Button.setDisable(false);
                pause10Button.setDisable(false);
            } else {
                media10 = null;
                mediaPlayer10 = null;
                play10Button.setDisable(true);
                pause10Button.setDisable(true);
            }
            File melody20File = new File("musics/tour3/category4/points20/20.mp3");
            if (melody20File.exists()) {
                media20 = new Media(melody20File.toURI().toString());
                mediaPlayer20 = new MediaPlayer(media20);
                play20Button.setDisable(false);
                pause20Button.setDisable(false);
            } else {
                media20 = null;
                mediaPlayer20 = null;
                play20Button.setDisable(true);
                pause20Button.setDisable(true);
            }
            File melody30File = new File("musics/tour3/category4/points30/30.mp3");
            if (melody30File.exists()) {
                media30 = new Media(melody30File.toURI().toString());
                mediaPlayer30 = new MediaPlayer(media30);
                play30Button.setDisable(false);
                pause30Button.setDisable(false);
            } else {
                media30 = null;
                mediaPlayer30 = null;
                play30Button.setDisable(true);
                pause30Button.setDisable(true);
            }
            File melody40File = new File("musics/tour3/category4/points40/40.mp3");
            if (melody40File.exists()) {
                media40 = new Media(melody40File.toURI().toString());
                mediaPlayer40 = new MediaPlayer(media40);
                play40Button.setDisable(false);
                pause40Button.setDisable(false);
            } else {
                media40 = null;
                mediaPlayer40 = null;
                play40Button.setDisable(true);
                pause40Button.setDisable(true);
            }
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
