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
public class SettingsTour1Category3Pane {
    private TextField title10TextField;
    private TextField author10TextField;
    private TextField title20TextField;
    private TextField author20TextField;
    private TextField title30TextField;
    private TextField author30TextField;
    private TextField title40TextField;
    private TextField author40TextField;
    private Pane settingsTour1Category3Pane;
    private Scene settingsTour1Category3Scene;
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
    private Button play20Button;
    private Button pause20Button;
    private Button play30Button;
    private Button pause30Button;
    private Button play40Button;
    private Button pause40Button;
    private ImageView playImageView10;
    private ImageView pauseImageView10;
    private ImageView playImageView20;
    private ImageView pauseImageView20;
    private ImageView playImageView30;
    private ImageView pauseImageView30;
    private ImageView playImageView40;
    private ImageView pauseImageView40;
    private Label tour1Label;

    public SettingsTour1Category3Pane() {
        settingsTour1Category3Pane = new Pane();

        settingsCategoriesBackground = new ImageView(new Image(Main.getPathToResource("images/settings_categories.jpg")));
        settingsCategoriesBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        settingsCategoriesBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        settingsCategoriesBackground.setSmooth(true);//сглаживание

        playImageView10 = new ImageView(new Image(Main.getPathToResource("images/play.png")));
        playImageView10.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        playImageView10.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        pauseImageView10 = new ImageView(new Image(Main.getPathToResource("images/pause.png")));
        pauseImageView10.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        pauseImageView10.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        playImageView20 = new ImageView(new Image(Main.getPathToResource("images/play.png")));
        playImageView20.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        playImageView20.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        pauseImageView20 = new ImageView(new Image(Main.getPathToResource("images/pause.png")));
        pauseImageView20.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        pauseImageView20.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        playImageView30 = new ImageView(new Image(Main.getPathToResource("images/play.png")));
        playImageView30.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        playImageView30.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        pauseImageView30 = new ImageView(new Image(Main.getPathToResource("images/pause.png")));
        pauseImageView30.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        pauseImageView30.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        playImageView40 = new ImageView(new Image(Main.getPathToResource("images/play.png")));
        playImageView40.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        playImageView40.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        pauseImageView40 = new ImageView(new Image(Main.getPathToResource("images/pause.png")));
        pauseImageView40.setFitHeight(0.04 * Main.SCREEN_SIZE.getHeight());
        pauseImageView40.setFitWidth(0.04 * Main.SCREEN_SIZE.getHeight());

        categoryTextField = new TextField();
        categoryTextField.setPromptText("Название категории");
        categoryTextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.1);
        categoryTextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        categoryTextField.setPrefWidth(Main.SCREEN_SIZE.getWidth() * 0.2);

        saveCategoryButton = new Button("Сохранить");
        saveCategoryButton.setCursor(Cursor.HAND);
        saveCategoryButton.setId("saveButton");
        saveCategoryButton.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.31);
        saveCategoryButton.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        saveCategoryButton.setOnMouseClicked(event -> {
            categories.setCategory3(categoryTextField.getText().equals("") ? "Категория 3" : categoryTextField.getText());
            categoryTextField.setText(categories.getCategory3());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("settings/categories1.xml"), "UTF-8")) {
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

        tour1Label = new Label("1 тур");
        tour1Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.6);
        tour1Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        tour1Label.setId("toursLabel");

        category10 = new Label("10");
        category10.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category10.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category10.setId("scoresLabel");

        separatorV1 = new Separator(Orientation.VERTICAL);
        separatorV1.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.25);
        separatorV1.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        separatorV1.setPrefHeight(Main.SCREEN_SIZE.getHeight() * 0.7);

        category20 = new Label("20");
        category20.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.25 + Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category20.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category20.setId("scoresLabel");

        separatorV2 = new Separator(Orientation.VERTICAL);
        separatorV2.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.5);
        separatorV2.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        separatorV2.setPrefHeight(Main.SCREEN_SIZE.getHeight() * 0.7);

        category30 = new Label("30");
        category30.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.50 + Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category30.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category30.setId("scoresLabel");

        separatorV3 = new Separator(Orientation.VERTICAL);
        separatorV3.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.75);
        separatorV3.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        separatorV3.setPrefHeight(Main.SCREEN_SIZE.getHeight() * 0.7);

        category40 = new Label("40");
        category40.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.75 + Main.SCREEN_SIZE.getWidth() * 0.25 / 2);
        category40.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        category40.setId("scoresLabel");

        separatorH = new Separator(Orientation.HORIZONTAL);
        separatorH.setLayoutX(0);
        separatorH.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
        separatorH.setPrefWidth(Main.SCREEN_SIZE.getWidth());

        fileChooser = new FileChooser();
        fileChooser.setTitle("Выбрать мелодию для загрузки");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Audio Files", "*.mp3"));

        openMelody10Button = new Button("Выбрать");
        openMelody10Button.setCursor(Cursor.HAND);
        openMelody10Button.setId("unselectedButton");
        openMelody10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        openMelody10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        openMelody10Button.setOnMouseClicked(event -> {
            melody10 = fileChooser.showOpenDialog(getSettingsTour1Category3Scene().getWindow());
            if (melody10 != null) {
                openMelody10Button.setId("selectedButton");
            }
        });

        openMelody20Button = new Button("Выбрать");
        openMelody20Button.setCursor(Cursor.HAND);
        openMelody20Button.setId("unselectedButton");
        openMelody20Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.26);
        openMelody20Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        openMelody20Button.setOnMouseClicked(event -> {
            melody20 = fileChooser.showOpenDialog(getSettingsTour1Category3Scene().getWindow());
            if (melody20 != null) {
                openMelody20Button.setId("selectedButton");
            }
        });

        openMelody30Button = new Button("Выбрать");
        openMelody30Button.setCursor(Cursor.HAND);
        openMelody30Button.setId("unselectedButton");
        openMelody30Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.51);
        openMelody30Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        openMelody30Button.setOnMouseClicked(event -> {
            melody30 = fileChooser.showOpenDialog(getSettingsTour1Category3Scene().getWindow());
            if (melody30 != null) {
                openMelody30Button.setId("selectedButton");
            }
        });

        openMelody40Button = new Button("Выбрать");
        openMelody40Button.setCursor(Cursor.HAND);
        openMelody40Button.setId("unselectedButton");
        openMelody40Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.76);
        openMelody40Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        openMelody40Button.setOnMouseClicked(event -> {
            melody40 = fileChooser.showOpenDialog(getSettingsTour1Category3Scene().getWindow());
            if (melody40 != null) {
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
            if (melody10 != null) {
                if (mediaPlayer10 != null) {//останавливает текущее воспроизведение
                    mediaPlayer10.dispose();
                }
                try (FileInputStream fileInputStream = new FileInputStream(melody10);
                     FileOutputStream fileOutputStream = new FileOutputStream("musics/tour1/category3/points10/10.mp3")) {
                    byte[] bytes = new byte[1024];
                    while (fileInputStream.read(bytes) != -1) {
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                melody10 = null;
                media10 = new Media(new File("musics/tour1/category3/points10/10.mp3").toURI().toString());
                mediaPlayer10 = new MediaPlayer(media10);
                openMelody10Button.setId("unselectedButton");
                play10Button.setDisable(false);
                pause10Button.setDisable(false);
            }
            melody1.setTitle(title10TextField.getText());
            melody1.setAuthor(author10TextField.getText());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("musics/tour1/category3/points10/10.xml"), "UTF-8")) {
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
            if (melody20 != null) {
                if (mediaPlayer20 != null) {//останавливает текущее воспроизведение
                    mediaPlayer20.dispose();
                }
                try (FileInputStream fileInputStream = new FileInputStream(melody20);
                     FileOutputStream fileOutputStream = new FileOutputStream("musics/tour1/category3/points20/20.mp3")) {
                    byte[] bytes = new byte[1024];
                    while (fileInputStream.read(bytes) != -1) {
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                melody20 = null;
                media20 = new Media(new File("musics/tour1/category3/points20/20.mp3").toURI().toString());
                mediaPlayer20 = new MediaPlayer(media20);
                openMelody20Button.setId("unselectedButton");
                play20Button.setDisable(false);
                pause20Button.setDisable(false);
            }
            melody2.setTitle(title20TextField.getText());
            melody2.setAuthor(author20TextField.getText());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("musics/tour1/category3/points20/20.xml"), "UTF-8")) {
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
            if (melody30 != null) {
                if (mediaPlayer30 != null) {//останавливает текущее воспроизведение
                    mediaPlayer30.dispose();
                }
                try (FileInputStream fileInputStream = new FileInputStream(melody30);
                     FileOutputStream fileOutputStream = new FileOutputStream("musics/tour1/category3/points30/30.mp3")) {
                    byte[] bytes = new byte[1024];
                    while (fileInputStream.read(bytes) != -1) {
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                melody30 = null;
                media30 = new Media(new File("musics/tour1/category3/points30/30.mp3").toURI().toString());
                mediaPlayer30 = new MediaPlayer(media30);
                openMelody30Button.setId("unselectedButton");
                play30Button.setDisable(false);
                pause30Button.setDisable(false);
            }
            melody3.setTitle(title30TextField.getText());
            melody3.setAuthor(author30TextField.getText());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("musics/tour1/category3/points30/30.xml"), "UTF-8")) {
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
            if (melody40 != null) {
                if (mediaPlayer40 != null) {//останавливает текущее воспроизведение
                    mediaPlayer40.dispose();
                }
                try (FileInputStream fileInputStream = new FileInputStream(melody40);
                     FileOutputStream fileOutputStream = new FileOutputStream("musics/tour1/category3/points40/40.mp3")) {
                    byte[] bytes = new byte[1024];
                    while (fileInputStream.read(bytes) != -1) {
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                melody40 = null;
                media40 = new Media(new File("musics/tour1/category3/points40/40.mp3").toURI().toString());
                mediaPlayer40 = new MediaPlayer(media40);
                openMelody40Button.setId("unselectedButton");
                play40Button.setDisable(false);
                pause40Button.setDisable(false);
            }
            melody4.setTitle(title40TextField.getText());
            melody4.setAuthor(author40TextField.getText());
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("musics/tour1/category3/points40/40.xml"), "UTF-8")) {
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
        play10Button.setGraphic(playImageView10);
        play10Button.setCursor(Cursor.HAND);
        play10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        play10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        pause10Button = new Button();
        pause10Button.setId("pauseButton");
        pause10Button.setGraphic(pauseImageView10);
        pause10Button.setCursor(Cursor.HAND);
        pause10Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.04 + playImageView10.getFitWidth());
        pause10Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);

        play10Button.setOnMouseClicked(event -> {
            mediaPlayer10.setVolume(1);
            mediaPlayer10.setCycleCount(Integer.MAX_VALUE);
            mediaPlayer10.play();
        });
        pause10Button.setOnMouseClicked(event -> {
            mediaPlayer10.setVolume(1);
            mediaPlayer10.setCycleCount(Integer.MAX_VALUE);
            mediaPlayer10.pause();
        });

        play20Button = new Button();
        play20Button.setId("playButton");
        play20Button.setGraphic(playImageView20);
        play20Button.setCursor(Cursor.HAND);
        play20Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.26);
        play20Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        pause20Button = new Button();
        pause20Button.setId("pauseButton");
        pause20Button.setGraphic(pauseImageView20);
        pause20Button.setCursor(Cursor.HAND);
        pause20Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.29 + playImageView10.getFitWidth());
        pause20Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);

        play20Button.setOnMouseClicked(event -> {
            mediaPlayer20.setVolume(1);
            mediaPlayer20.setCycleCount(Integer.MAX_VALUE);
            mediaPlayer20.play();
        });
        pause20Button.setOnMouseClicked(event -> {
            mediaPlayer20.setVolume(1);
            mediaPlayer20.setCycleCount(Integer.MAX_VALUE);
            mediaPlayer20.pause();
        });

        play30Button = new Button();
        play30Button.setId("playButton");
        play30Button.setGraphic(playImageView30);
        play30Button.setCursor(Cursor.HAND);
        play30Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.51);
        play30Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        pause30Button = new Button();
        pause30Button.setId("pauseButton");
        pause30Button.setGraphic(pauseImageView30);
        pause30Button.setCursor(Cursor.HAND);
        pause30Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.54 + playImageView10.getFitWidth());
        pause30Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);

        play30Button.setOnMouseClicked(event -> {
            mediaPlayer30.setVolume(1);
            mediaPlayer30.setCycleCount(Integer.MAX_VALUE);
            mediaPlayer30.play();
        });
        pause30Button.setOnMouseClicked(event -> {
            mediaPlayer30.setVolume(1);
            mediaPlayer30.setCycleCount(Integer.MAX_VALUE);
            mediaPlayer30.pause();
        });

        play40Button = new Button();
        play40Button.setId("playButton");
        play40Button.setGraphic(playImageView40);
        play40Button.setCursor(Cursor.HAND);
        play40Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.76);
        play40Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);
        pause40Button = new Button();
        pause40Button.setId("pauseButton");
        pause40Button.setGraphic(pauseImageView40);
        pause40Button.setCursor(Cursor.HAND);
        pause40Button.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.79 + playImageView10.getFitWidth());
        pause40Button.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.43);

        play40Button.setOnMouseClicked(event -> {
            mediaPlayer40.setVolume(1);
            mediaPlayer40.setCycleCount(Integer.MAX_VALUE);
            mediaPlayer40.play();
        });
        pause40Button.setOnMouseClicked(event -> {
            mediaPlayer40.setVolume(1);
            mediaPlayer40.setCycleCount(Integer.MAX_VALUE);
            mediaPlayer40.pause();
        });

        settingsTour1Category3Scene = new Scene(settingsTour1Category3Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        settingsTour1Category3Scene.getStylesheets().addAll(Main.getPathToResource("css/style.css"));
        settingsTour1Category3Pane.getChildren().addAll(settingsCategoriesBackground, categoryTextField, saveCategoryButton,
                backLabel, tour1Label, openMelody10Button, openMelody20Button, openMelody30Button, openMelody40Button, save10Button,
                save20Button, save30Button, save40Button, separatorV1, separatorV2, separatorV3, category10, category20,
                category30, category40, separatorH, title10TextField, author10TextField, title20TextField, author20TextField,
                title30TextField, author30TextField, title40TextField, author40TextField, play10Button, pause10Button,
                play20Button, pause20Button, play30Button, pause30Button, play40Button, pause40Button, playImageView20,
                pauseImageView20, playImageView30, pauseImageView30, playImageView40, pauseImageView40);
    }

    public Scene getSettingsTour1Category3Scene() {
        return settingsTour1Category3Scene;
    }

    public Label getBackLabel() {
        return backLabel;
    }

    public void back() {//при выходе со сцены
        melody10 = null;
        melody20 = null;
        melody30 = null;
        melody40 = null;
        openMelody10Button.setId("unselectedButton");
        openMelody20Button.setId("unselectedButton");
        openMelody30Button.setId("unselectedButton");
        openMelody40Button.setId("unselectedButton");
        if (mediaPlayer10 != null) {
            mediaPlayer10.dispose();
        }
        if (mediaPlayer20 != null) {
            mediaPlayer20.dispose();
        }
        if (mediaPlayer30 != null) {
            mediaPlayer30.dispose();
        }
        if (mediaPlayer40 != null) {
            mediaPlayer40.dispose();
        }
    }

    public void start() {//при заходе на сцену
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories1.xml"), "UTF-8");
             InputStreamReader inputStreamReader10 = new InputStreamReader(new FileInputStream("musics/tour1/category3/points10/10.xml"), "UTF-8");
             InputStreamReader inputStreamReader20 = new InputStreamReader(new FileInputStream("musics/tour1/category3/points20/20.xml"), "UTF-8");
             InputStreamReader inputStreamReader30 = new InputStreamReader(new FileInputStream("musics/tour1/category3/points30/30.xml"), "UTF-8");
             InputStreamReader inputStreamReader40 = new InputStreamReader(new FileInputStream("musics/tour1/category3/points40/40.xml"), "UTF-8")) {
            JAXBContext jaxbContext1 = JAXBContext.newInstance(Categories.class);
            JAXBContext jaxbContext2 = JAXBContext.newInstance(Melody.class);
            Unmarshaller unmarshaller1 = jaxbContext1.createUnmarshaller();
            Unmarshaller unmarshaller2 = jaxbContext2.createUnmarshaller();
            categories = (Categories) unmarshaller1.unmarshal(inputStreamReader);
            melody1 = (Melody) unmarshaller2.unmarshal(inputStreamReader10);
            melody2 = (Melody) unmarshaller2.unmarshal(inputStreamReader20);
            melody3 = (Melody) unmarshaller2.unmarshal(inputStreamReader30);
            melody4 = (Melody) unmarshaller2.unmarshal(inputStreamReader40);
            categoryTextField.setText(categories.getCategory3());
            title10TextField.setText(melody1.getTitle());
            author10TextField.setText(melody1.getAuthor());
            title20TextField.setText(melody2.getTitle());
            author20TextField.setText(melody2.getAuthor());
            title30TextField.setText(melody3.getTitle());
            author30TextField.setText(melody3.getAuthor());
            title40TextField.setText(melody4.getTitle());
            author40TextField.setText(melody4.getAuthor());
            File melody10 = new File("musics/tour1/category3/points10/10.mp3");
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
            File melody20 = new File("musics/tour1/category3/points20/20.mp3");
            if (melody20.exists()) {
                media20 = new Media(melody20.toURI().toString());
                mediaPlayer20 = new MediaPlayer(media20);
                play20Button.setDisable(false);
                pause20Button.setDisable(false);
            } else {
                media20 = null;
                mediaPlayer20 = null;
                play20Button.setDisable(true);
                pause20Button.setDisable(true);
            }
            File melody30 = new File("musics/tour1/category3/points30/30.mp3");
            if (melody30.exists()) {
                media30 = new Media(melody30.toURI().toString());
                mediaPlayer30 = new MediaPlayer(media30);
                play30Button.setDisable(false);
                pause30Button.setDisable(false);
            } else {
                media30 = null;
                mediaPlayer30 = null;
                play30Button.setDisable(true);
                pause30Button.setDisable(true);
            }
            File melody40 = new File("musics/tour1/category3/points40/40.mp3");
            if (melody40.exists()) {
                media40 = new Media(melody40.toURI().toString());
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
