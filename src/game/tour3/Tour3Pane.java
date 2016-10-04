package game.tour3;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import main.Main;
import xml.Categories;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dmitriy on 17.02.2016.
 */
public class Tour3Pane {
    private Pane pane;
    private ImageView backgroundImageView;
    private Scene scene;
    private Label category1Label;
    private Label category2Label;
    private Label category3Label;
    private Label category4Label;
    private Label category1Melody10Label;
    private Label category1Melody20Label;
    private Label category1Melody30Label;
    private Label category1Melody40Label;
    private Label category2Melody10Label;
    private Label category2Melody20Label;
    private Label category2Melody30Label;
    private Label category2Melody40Label;
    private Label category3Melody10Label;
    private Label category3Melody20Label;
    private Label category3Melody30Label;
    private Label category3Melody40Label;
    private Label category4Melody10Label;
    private Label category4Melody20Label;
    private Label category4Melody30Label;
    private Label category4Melody40Label;
    private ImageView category1Melody10ImageView;
    private ImageView category1Melody20ImageView;
    private ImageView category1Melody30ImageView;
    private ImageView category1Melody40ImageView;
    private ImageView category2Melody10ImageView;
    private ImageView category2Melody20ImageView;
    private ImageView category2Melody30ImageView;
    private ImageView category2Melody40ImageView;
    private ImageView category3Melody10ImageView;
    private ImageView category3Melody20ImageView;
    private ImageView category3Melody30ImageView;
    private ImageView category3Melody40ImageView;
    private ImageView category4Melody10ImageView;
    private ImageView category4Melody20ImageView;
    private ImageView category4Melody30ImageView;
    private ImageView category4Melody40ImageView;
    private Label backLabel;
    private ImageView backImageView;
    private Categories categories;
    private Media[] medias;
    private MediaPlayer[] mediaPlayers;
    private Glow category1Melody10Glow;
    private Glow category1Melody20Glow;
    private Glow category1Melody30Glow;
    private Glow category1Melody40Glow;
    private Glow category2Melody10Glow;
    private Glow category2Melody20Glow;
    private Glow category2Melody30Glow;
    private Glow category2Melody40Glow;
    private Glow category3Melody10Glow;
    private Glow category3Melody20Glow;
    private Glow category3Melody30Glow;
    private Glow category3Melody40Glow;
    private Glow category4Melody10Glow;
    private Glow category4Melody20Glow;
    private Glow category4Melody30Glow;
    private Glow category4Melody40Glow;
    private Timeline category1Melody10Timeline;
    private Timeline category1Melody20Timeline;
    private Timeline category1Melody30Timeline;
    private Timeline category1Melody40Timeline;
    private Timeline category2Melody10Timeline;
    private Timeline category2Melody20Timeline;
    private Timeline category2Melody30Timeline;
    private Timeline category2Melody40Timeline;
    private Timeline category3Melody10Timeline;
    private Timeline category3Melody20Timeline;
    private Timeline category3Melody30Timeline;
    private Timeline category3Melody40Timeline;
    private Timeline category4Melody10Timeline;
    private Timeline category4Melody20Timeline;
    private Timeline category4Melody30Timeline;
    private Timeline category4Melody40Timeline;

    public Tour3Pane() {
        pane = new Pane();
        backgroundImageView = new ImageView(new Image(Main.getPathToResource("images/tour.jpg")));
        backgroundImageView.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        backgroundImageView.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        backgroundImageView.setSmooth(true);//сглаживание

        medias = new Media[16];
        mediaPlayers = new MediaPlayer[16];

        category1Melody10ImageView = new ImageView(Main.getPathToResource("images/notes/blue.png"));
        category1Melody10ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category1Melody10ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category1Melody20ImageView = new ImageView(Main.getPathToResource("images/notes/darkGreen.png"));
        category1Melody20ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category1Melody20ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category1Melody30ImageView = new ImageView(Main.getPathToResource("images/notes/orange.png"));
        category1Melody30ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category1Melody30ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category1Melody40ImageView = new ImageView(Main.getPathToResource("images/notes/violet.png"));
        category1Melody40ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category1Melody40ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category2Melody10ImageView = new ImageView(Main.getPathToResource("images/notes/blue.png"));
        category2Melody10ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category2Melody10ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category2Melody20ImageView = new ImageView(Main.getPathToResource("images/notes/darkGreen.png"));
        category2Melody20ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category2Melody20ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category2Melody30ImageView = new ImageView(Main.getPathToResource("images/notes/orange.png"));
        category2Melody30ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category2Melody30ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category2Melody40ImageView = new ImageView(Main.getPathToResource("images/notes/violet.png"));
        category2Melody40ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category2Melody40ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category3Melody10ImageView = new ImageView(Main.getPathToResource("images/notes/blue.png"));
        category3Melody10ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category3Melody10ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category3Melody20ImageView = new ImageView(Main.getPathToResource("images/notes/darkGreen.png"));
        category3Melody20ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category3Melody20ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category3Melody30ImageView = new ImageView(Main.getPathToResource("images/notes/orange.png"));
        category3Melody30ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category3Melody30ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category3Melody40ImageView = new ImageView(Main.getPathToResource("images/notes/violet.png"));
        category3Melody40ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category3Melody40ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category4Melody10ImageView = new ImageView(Main.getPathToResource("images/notes/blue.png"));
        category4Melody10ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category4Melody10ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category4Melody20ImageView = new ImageView(Main.getPathToResource("images/notes/darkGreen.png"));
        category4Melody20ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category4Melody20ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category4Melody30ImageView = new ImageView(Main.getPathToResource("images/notes/orange.png"));
        category4Melody30ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category4Melody30ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category4Melody40ImageView = new ImageView(Main.getPathToResource("images/notes/violet.png"));
        category4Melody40ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category4Melody40ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        backImageView = new ImageView(Main.getPathToResource("images/back.png"));
        backImageView.setFitWidth(0.05 * Main.SCREEN_SIZE.getHeight());
        backImageView.setFitHeight(0.05 * Main.SCREEN_SIZE.getHeight());

        category1Label = new Label();
        category1Label.setLayoutX(0);
        category1Label.setLayoutY(0);
        category1Label.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        category1Label.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        category1Label.setId("gameLabel");
        category1Label.setFont(new Font(Main.SCREEN_SIZE.getHeight() * 0.045));
        category1Label.setWrapText(true);
        category1Label.setLineSpacing(0);
        category1Label.setAlignment(Pos.CENTER);
        category1Label.setTextAlignment(TextAlignment.CENTER);

        category2Label = new Label();
        category2Label.setLayoutX(0);
        category2Label.setLayoutY(Main.SCREEN_SIZE.height * 0.25);
        category2Label.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        category2Label.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        category2Label.setId("gameLabel");
        category2Label.setFont(new Font(Main.SCREEN_SIZE.getHeight() * 0.045));
        category2Label.setWrapText(true);
        category2Label.setLineSpacing(0);
        category2Label.setAlignment(Pos.CENTER);
        category2Label.setTextAlignment(TextAlignment.CENTER);

        category3Label = new Label();
        category3Label.setLayoutX(0);
        category3Label.setLayoutY(Main.SCREEN_SIZE.height * 0.5);
        category3Label.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        category3Label.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        category3Label.setId("gameLabel");
        category3Label.setFont(new Font(Main.SCREEN_SIZE.getHeight() * 0.045));
        category3Label.setWrapText(true);
        category3Label.setLineSpacing(0);
        category3Label.setAlignment(Pos.CENTER);
        category3Label.setTextAlignment(TextAlignment.CENTER);

        category4Label = new Label();
        category4Label.setLayoutX(0);
        category4Label.setLayoutY(Main.SCREEN_SIZE.height * 0.75);
        category4Label.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        category4Label.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        category4Label.setId("gameLabel");
        category4Label.setFont(new Font(Main.SCREEN_SIZE.getHeight() * 0.045));
        category4Label.setWrapText(true);
        category4Label.setLineSpacing(0);
        category4Label.setAlignment(Pos.CENTER);
        category4Label.setTextAlignment(TextAlignment.CENTER);

        category1Melody10Glow = new Glow();
        category1Melody10Timeline = new Timeline();
        category1Melody10Timeline.setCycleCount(Timeline.INDEFINITE);
        category1Melody10Timeline.setAutoReverse(true);
        category1Melody10Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category1Melody10Glow.levelProperty(), 1.0)));

        category1Melody20Glow = new Glow();
        category1Melody20Timeline = new Timeline();
        category1Melody20Timeline.setCycleCount(Timeline.INDEFINITE);
        category1Melody20Timeline.setAutoReverse(true);
        category1Melody20Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category1Melody20Glow.levelProperty(), 1.0)));

        category1Melody30Glow = new Glow();
        category1Melody30Timeline = new Timeline();
        category1Melody30Timeline.setCycleCount(Timeline.INDEFINITE);
        category1Melody30Timeline.setAutoReverse(true);
        category1Melody30Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category1Melody30Glow.levelProperty(), 1.0)));

        category1Melody40Glow = new Glow();
        category1Melody40Timeline = new Timeline();
        category1Melody40Timeline.setCycleCount(Timeline.INDEFINITE);
        category1Melody40Timeline.setAutoReverse(true);
        category1Melody40Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category1Melody40Glow.levelProperty(), 1.0)));

        category2Melody10Glow = new Glow();
        category2Melody10Timeline = new Timeline();
        category2Melody10Timeline.setCycleCount(Timeline.INDEFINITE);
        category2Melody10Timeline.setAutoReverse(true);
        category2Melody10Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category2Melody10Glow.levelProperty(), 1.0)));

        category2Melody20Glow = new Glow();
        category2Melody20Timeline = new Timeline();
        category2Melody20Timeline.setCycleCount(Timeline.INDEFINITE);
        category2Melody20Timeline.setAutoReverse(true);
        category2Melody20Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category2Melody20Glow.levelProperty(), 1.0)));

        category2Melody30Glow = new Glow();
        category2Melody30Timeline = new Timeline();
        category2Melody30Timeline.setCycleCount(Timeline.INDEFINITE);
        category2Melody30Timeline.setAutoReverse(true);
        category2Melody30Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category2Melody30Glow.levelProperty(), 1.0)));

        category2Melody40Glow = new Glow();
        category2Melody40Timeline = new Timeline();
        category2Melody40Timeline.setCycleCount(Timeline.INDEFINITE);
        category2Melody40Timeline.setAutoReverse(true);
        category2Melody40Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category2Melody40Glow.levelProperty(), 1.0)));

        category3Melody10Glow = new Glow();
        category3Melody10Timeline = new Timeline();
        category3Melody10Timeline.setCycleCount(Timeline.INDEFINITE);
        category3Melody10Timeline.setAutoReverse(true);
        category3Melody10Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category3Melody10Glow.levelProperty(), 1.0)));

        category3Melody20Glow = new Glow();
        category3Melody20Timeline = new Timeline();
        category3Melody20Timeline.setCycleCount(Timeline.INDEFINITE);
        category3Melody20Timeline.setAutoReverse(true);
        category3Melody20Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category3Melody20Glow.levelProperty(), 1.0)));

        category3Melody30Glow = new Glow();
        category3Melody30Timeline = new Timeline();
        category3Melody30Timeline.setCycleCount(Timeline.INDEFINITE);
        category3Melody30Timeline.setAutoReverse(true);
        category3Melody30Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category3Melody30Glow.levelProperty(), 1.0)));

        category3Melody40Glow = new Glow();
        category3Melody40Timeline = new Timeline();
        category3Melody40Timeline.setCycleCount(Timeline.INDEFINITE);
        category3Melody40Timeline.setAutoReverse(true);
        category3Melody40Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category3Melody40Glow.levelProperty(), 1.0)));

        category4Melody10Glow = new Glow();
        category4Melody10Timeline = new Timeline();
        category4Melody10Timeline.setCycleCount(Timeline.INDEFINITE);
        category4Melody10Timeline.setAutoReverse(true);
        category4Melody10Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category4Melody10Glow.levelProperty(), 1.0)));

        category4Melody20Glow = new Glow();
        category4Melody20Timeline = new Timeline();
        category4Melody20Timeline.setCycleCount(Timeline.INDEFINITE);
        category4Melody20Timeline.setAutoReverse(true);
        category4Melody20Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category4Melody20Glow.levelProperty(), 1.0)));

        category4Melody30Glow = new Glow();
        category4Melody30Timeline = new Timeline();
        category4Melody30Timeline.setCycleCount(Timeline.INDEFINITE);
        category4Melody30Timeline.setAutoReverse(true);
        category4Melody30Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category4Melody30Glow.levelProperty(), 1.0)));

        category4Melody40Glow = new Glow();
        category4Melody40Timeline = new Timeline();
        category4Melody40Timeline.setCycleCount(Timeline.INDEFINITE);
        category4Melody40Timeline.setAutoReverse(true);
        category4Melody40Timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(category4Melody40Glow.levelProperty(), 1.0)));

        //(0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 - промежуток между нотами
        category1Melody10Label = new Label(null, category1Melody10ImageView);
        category1Melody10Label.setCursor(Cursor.HAND);
        category1Melody10Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        category1Melody10Label.setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        category1Melody10Label.setOnMouseClicked(event -> {
            mediaPlayers[0].setVolume(1);
            mediaPlayers[0].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[0].getStatus().toString().equals("PLAYING")) {
                category1Melody10Timeline.pause();
                category1Melody10Glow.setLevel(1.0);
                mediaPlayers[0].pause();
            }
            if (mediaPlayers[0].getStatus().toString().equals("PAUSED") || mediaPlayers[0].getStatus().toString().equals("READY")) {
                category1Melody10Label.setEffect(category1Melody10Glow);
                category1Melody10Glow.setLevel(0.0);
                category1Melody10Timeline.play();
                mediaPlayers[0].play();
            }
        });

        category1Melody20Label = new Label(null, category1Melody20ImageView);
        category1Melody20Label.setCursor(Cursor.HAND);
        category1Melody20Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 2 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + category1Melody10ImageView.getFitWidth());
        category1Melody20Label.setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        category1Melody20Label.setOnMouseClicked(event -> {
            mediaPlayers[1].setVolume(1);
            mediaPlayers[1].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[1].getStatus().toString().equals("PLAYING")) {
                category1Melody20Timeline.pause();
                category1Melody20Glow.setLevel(1.0);
                mediaPlayers[1].pause();
            }
            if (mediaPlayers[1].getStatus().toString().equals("PAUSED") || mediaPlayers[1].getStatus().toString().equals("READY")) {
                category1Melody20Label.setEffect(category1Melody20Glow);
                category1Melody20Glow.setLevel(0.0);
                category1Melody20Timeline.play();
                mediaPlayers[1].play();
            }
        });

        category1Melody30Label = new Label(null, category1Melody30ImageView);
        category1Melody30Label.setCursor(Cursor.HAND);
        category1Melody30Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 3 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 2 * category1Melody10ImageView.getFitWidth());
        category1Melody30Label.setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        category1Melody30Label.setOnMouseClicked(event -> {
            mediaPlayers[2].setVolume(1);
            mediaPlayers[2].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[2].getStatus().toString().equals("PLAYING")) {
                category1Melody30Timeline.pause();
                category1Melody30Glow.setLevel(1.0);
                mediaPlayers[2].pause();
            }
            if (mediaPlayers[2].getStatus().toString().equals("PAUSED") || mediaPlayers[2].getStatus().toString().equals("READY")) {
                category1Melody30Label.setEffect(category1Melody30Glow);
                category1Melody30Glow.setLevel(0.0);
                category1Melody30Timeline.play();
                mediaPlayers[2].play();
            }
        });

        category1Melody40Label = new Label(null, category1Melody40ImageView);
        category1Melody40Label.setCursor(Cursor.HAND);
        category1Melody40Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 4 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 3 * category1Melody10ImageView.getFitWidth());
        category1Melody40Label.setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        category1Melody40Label.setOnMouseClicked(event -> {
            mediaPlayers[3].setVolume(1);
            mediaPlayers[3].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[3].getStatus().toString().equals("PLAYING")) {
                category1Melody40Timeline.pause();
                category1Melody40Glow.setLevel(1.0);
                mediaPlayers[3].pause();
            }
            if (mediaPlayers[3].getStatus().toString().equals("PAUSED") || mediaPlayers[3].getStatus().toString().equals("READY")) {
                category1Melody40Label.setEffect(category1Melody40Glow);
                category1Melody40Glow.setLevel(0.0);
                category1Melody40Timeline.play();
                mediaPlayers[3].play();
            }
        });

        category2Melody10Label = new Label(null, category2Melody10ImageView);
        category2Melody10Label.setCursor(Cursor.HAND);
        category2Melody10Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        category2Melody10Label.setLayoutY(0.275 * Main.SCREEN_SIZE.getHeight());
        category2Melody10Label.setOnMouseClicked(event -> {
            mediaPlayers[4].setVolume(1);
            mediaPlayers[4].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[4].getStatus().toString().equals("PLAYING")) {
                category2Melody10Timeline.pause();
                category2Melody10Glow.setLevel(1.0);
                mediaPlayers[4].pause();
            }
            if (mediaPlayers[4].getStatus().toString().equals("PAUSED") || mediaPlayers[4].getStatus().toString().equals("READY")) {
                category2Melody10Label.setEffect(category2Melody10Glow);
                category2Melody10Glow.setLevel(0.0);
                category2Melody10Timeline.play();
                mediaPlayers[4].play();
            }
        });

        category2Melody20Label = new Label(null, category2Melody20ImageView);
        category2Melody20Label.setCursor(Cursor.HAND);
        category2Melody20Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 2 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + category2Melody10ImageView.getFitWidth());
        category2Melody20Label.setLayoutY(0.275 * Main.SCREEN_SIZE.getHeight());
        category2Melody20Label.setOnMouseClicked(event -> {
            mediaPlayers[5].setVolume(1);
            mediaPlayers[5].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[5].getStatus().toString().equals("PLAYING")) {
                category2Melody20Timeline.pause();
                category2Melody20Glow.setLevel(1.0);
                mediaPlayers[5].pause();
            }
            if (mediaPlayers[5].getStatus().toString().equals("PAUSED") || mediaPlayers[5].getStatus().toString().equals("READY")) {
                category2Melody20Label.setEffect(category2Melody20Glow);
                category2Melody20Glow.setLevel(0.0);
                category2Melody20Timeline.play();
                mediaPlayers[5].play();
            }
        });

        category2Melody30Label = new Label(null, category2Melody30ImageView);
        category2Melody30Label.setCursor(Cursor.HAND);
        category2Melody30Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 3 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 2 * category2Melody10ImageView.getFitWidth());
        category2Melody30Label.setLayoutY(0.275 * Main.SCREEN_SIZE.getHeight());
        category2Melody30Label.setOnMouseClicked(event -> {
            mediaPlayers[6].setVolume(1);
            mediaPlayers[6].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[6].getStatus().toString().equals("PLAYING")) {
                category2Melody30Timeline.pause();
                category2Melody30Glow.setLevel(1.0);
                mediaPlayers[6].pause();
            }
            if (mediaPlayers[6].getStatus().toString().equals("PAUSED") || mediaPlayers[6].getStatus().toString().equals("READY")) {
                category2Melody30Label.setEffect(category2Melody30Glow);
                category2Melody30Glow.setLevel(0.0);
                category2Melody30Timeline.play();
                mediaPlayers[6].play();
            }
        });

        category2Melody40Label = new Label(null, category2Melody40ImageView);
        category2Melody40Label.setCursor(Cursor.HAND);
        category2Melody40Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 4 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 3 * category2Melody10ImageView.getFitWidth());
        category2Melody40Label.setLayoutY(0.275 * Main.SCREEN_SIZE.getHeight());
        category2Melody40Label.setOnMouseClicked(event -> {
            mediaPlayers[7].setVolume(1);
            mediaPlayers[7].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[7].getStatus().toString().equals("PLAYING")) {
                category2Melody40Timeline.pause();
                category2Melody40Glow.setLevel(1.0);
                mediaPlayers[7].pause();
            }
            if (mediaPlayers[7].getStatus().toString().equals("PAUSED") || mediaPlayers[7].getStatus().toString().equals("READY")) {
                category2Melody40Label.setEffect(category2Melody40Glow);
                category2Melody40Glow.setLevel(0.0);
                category2Melody40Timeline.play();
                mediaPlayers[7].play();
            }
        });

        category3Melody10Label = new Label(null, category3Melody10ImageView);
        category3Melody10Label.setCursor(Cursor.HAND);
        category3Melody10Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        category3Melody10Label.setLayoutY(0.525 * Main.SCREEN_SIZE.getHeight());
        category3Melody10Label.setOnMouseClicked(event -> {
            mediaPlayers[8].setVolume(1);
            mediaPlayers[8].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[8].getStatus().toString().equals("PLAYING")) {
                category3Melody10Timeline.pause();
                category3Melody10Glow.setLevel(1.0);
                mediaPlayers[8].pause();
            }
            if (mediaPlayers[8].getStatus().toString().equals("PAUSED") || mediaPlayers[8].getStatus().toString().equals("READY")) {
                category3Melody10Label.setEffect(category3Melody10Glow);
                category3Melody10Glow.setLevel(0.0);
                category3Melody10Timeline.play();
                mediaPlayers[8].play();
            }
        });

        category3Melody20Label = new Label(null, category3Melody20ImageView);
        category3Melody20Label.setCursor(Cursor.HAND);
        category3Melody20Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 2 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + category3Melody10ImageView.getFitWidth());
        category3Melody20Label.setLayoutY(0.525 * Main.SCREEN_SIZE.getHeight());
        category3Melody20Label.setOnMouseClicked(event -> {
            mediaPlayers[9].setVolume(1);
            mediaPlayers[9].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[9].getStatus().toString().equals("PLAYING")) {
                category3Melody20Timeline.pause();
                category3Melody20Glow.setLevel(1.0);
                mediaPlayers[9].pause();
            }
            if (mediaPlayers[9].getStatus().toString().equals("PAUSED") || mediaPlayers[9].getStatus().toString().equals("READY")) {
                category3Melody20Label.setEffect(category3Melody20Glow);
                category3Melody20Glow.setLevel(0.0);
                category3Melody20Timeline.play();
                mediaPlayers[9].play();
            }
        });

        category3Melody30Label = new Label(null, category3Melody30ImageView);
        category3Melody30Label.setCursor(Cursor.HAND);
        category3Melody30Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 3 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 2 * category3Melody10ImageView.getFitWidth());
        category3Melody30Label.setLayoutY(0.525 * Main.SCREEN_SIZE.getHeight());
        category3Melody30Label.setOnMouseClicked(event -> {
            mediaPlayers[10].setVolume(1);
            mediaPlayers[10].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[10].getStatus().toString().equals("PLAYING")) {
                category3Melody30Timeline.pause();
                category3Melody30Glow.setLevel(1.0);
                mediaPlayers[10].pause();
            }
            if (mediaPlayers[10].getStatus().toString().equals("PAUSED") || mediaPlayers[10].getStatus().toString().equals("READY")) {
                category3Melody30Label.setEffect(category3Melody30Glow);
                category3Melody30Glow.setLevel(0.0);
                category3Melody30Timeline.play();
                mediaPlayers[10].play();
            }
        });

        category3Melody40Label = new Label(null, category3Melody40ImageView);
        category3Melody40Label.setCursor(Cursor.HAND);
        category3Melody40Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 4 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 3 * category3Melody10ImageView.getFitWidth());
        category3Melody40Label.setLayoutY(0.525 * Main.SCREEN_SIZE.getHeight());
        category3Melody40Label.setOnMouseClicked(event -> {
            mediaPlayers[11].setVolume(1);
            mediaPlayers[11].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[11].getStatus().toString().equals("PLAYING")) {
                category3Melody40Timeline.pause();
                category3Melody40Glow.setLevel(1.0);
                mediaPlayers[11].pause();
            }
            if (mediaPlayers[11].getStatus().toString().equals("PAUSED") || mediaPlayers[11].getStatus().toString().equals("READY")) {
                category3Melody40Label.setEffect(category3Melody40Glow);
                category3Melody40Glow.setLevel(0.0);
                category3Melody40Timeline.play();
                mediaPlayers[11].play();
            }
        });

        category4Melody10Label = new Label(null, category4Melody10ImageView);
        category4Melody10Label.setCursor(Cursor.HAND);
        category4Melody10Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        category4Melody10Label.setLayoutY(0.775 * Main.SCREEN_SIZE.getHeight());
        category4Melody10Label.setOnMouseClicked(event -> {
            mediaPlayers[12].setVolume(1);
            mediaPlayers[12].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[12].getStatus().toString().equals("PLAYING")) {
                category4Melody10Timeline.pause();
                category4Melody10Glow.setLevel(1.0);
                mediaPlayers[12].pause();
            }
            if (mediaPlayers[12].getStatus().toString().equals("PAUSED") || mediaPlayers[12].getStatus().toString().equals("READY")) {
                category4Melody10Label.setEffect(category4Melody10Glow);
                category4Melody10Glow.setLevel(0.0);
                category4Melody10Timeline.play();
                mediaPlayers[12].play();
            }
        });

        category4Melody20Label = new Label(null, category4Melody20ImageView);
        category4Melody20Label.setCursor(Cursor.HAND);
        category4Melody20Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 2 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + category4Melody10ImageView.getFitWidth());
        category4Melody20Label.setLayoutY(0.775 * Main.SCREEN_SIZE.getHeight());
        category4Melody20Label.setOnMouseClicked(event -> {
            mediaPlayers[13].setVolume(1);
            mediaPlayers[13].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[13].getStatus().toString().equals("PLAYING")) {
                category4Melody20Timeline.pause();
                category4Melody20Glow.setLevel(1.0);
                mediaPlayers[13].pause();
            }
            if (mediaPlayers[13].getStatus().toString().equals("PAUSED") || mediaPlayers[13].getStatus().toString().equals("READY")) {
                category4Melody20Label.setEffect(category4Melody20Glow);
                category4Melody20Glow.setLevel(0.0);
                category4Melody20Timeline.play();
                mediaPlayers[13].play();
            }
        });

        category4Melody30Label = new Label(null, category4Melody30ImageView);
        category4Melody30Label.setCursor(Cursor.HAND);
        category4Melody30Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 3 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 2 * category4Melody10ImageView.getFitWidth());
        category4Melody30Label.setLayoutY(0.775 * Main.SCREEN_SIZE.getHeight());
        category4Melody30Label.setOnMouseClicked(event -> {
            mediaPlayers[14].setVolume(1);
            mediaPlayers[14].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[14].getStatus().toString().equals("PLAYING")) {
                category4Melody30Timeline.pause();
                category4Melody30Glow.setLevel(1.0);
                mediaPlayers[14].pause();
            }
            if (mediaPlayers[14].getStatus().toString().equals("PAUSED") || mediaPlayers[14].getStatus().toString().equals("READY")) {
                category4Melody30Label.setEffect(category4Melody30Glow);
                category4Melody30Glow.setLevel(0.0);
                category4Melody30Timeline.play();
                mediaPlayers[14].play();
            }
        });

        category4Melody40Label = new Label(null, category4Melody40ImageView);
        category4Melody40Label.setCursor(Cursor.HAND);
        category4Melody40Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 4 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 3 * category4Melody10ImageView.getFitWidth());
        category4Melody40Label.setLayoutY(0.775 * Main.SCREEN_SIZE.getHeight());
        category4Melody40Label.setOnMouseClicked(event -> {
            mediaPlayers[15].setVolume(1);
            mediaPlayers[15].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[15].getStatus().toString().equals("PLAYING")) {
                category4Melody40Timeline.pause();
                category4Melody40Glow.setLevel(1.0);
                mediaPlayers[15].pause();
            }
            if (mediaPlayers[15].getStatus().toString().equals("PAUSED") || mediaPlayers[15].getStatus().toString().equals("READY")) {
                category4Melody40Label.setEffect(category4Melody40Glow);
                category4Melody40Glow.setLevel(0.0);
                category4Melody40Timeline.play();
                mediaPlayers[15].play();
            }
        });

        backLabel = new Label(null, backImageView);
        backLabel.setLayoutX(0);
        backLabel.setLayoutY(0);
        backLabel.setCursor(Cursor.HAND);
        backLabel.setId("settingsToursCategoriesPaneLabel");

        scene = new Scene(pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        scene.getStylesheets().add(Main.getPathToResource("css/style.css"));
        pane.getChildren().addAll(backgroundImageView, category1Label, category2Label, category3Label, category4Label,
                category1Melody10Label, category1Melody20Label, category1Melody30Label, category1Melody40Label,
                category2Melody10Label, category2Melody20Label, category2Melody30Label, category2Melody40Label,
                category3Melody10Label, category3Melody20Label, category3Melody30Label, category3Melody40Label,
                category4Melody10Label, category4Melody20Label, category4Melody30Label, category4Melody40Label, backLabel);
    }

    public Scene getScene() {
        return scene;
    }

    public void back() {//освобождение ресурсов
        medias[0] = null;
        medias[1] = null;
        medias[2] = null;
        medias[3] = null;
        medias[4] = null;
        medias[5] = null;
        medias[6] = null;
        medias[7] = null;
        medias[8] = null;
        medias[9] = null;
        medias[10] = null;
        medias[11] = null;
        medias[12] = null;
        medias[13] = null;
        medias[14] = null;
        medias[15] = null;

        if (mediaPlayers[0] != null) {
            mediaPlayers[0].dispose();
        }
        if (mediaPlayers[1] != null) {
            mediaPlayers[1].dispose();
        }
        if (mediaPlayers[2] != null) {
            mediaPlayers[2].dispose();
        }
        if (mediaPlayers[3] != null) {
            mediaPlayers[3].dispose();
        }
        if (mediaPlayers[4] != null) {
            mediaPlayers[4].dispose();
        }
        if (mediaPlayers[5] != null) {
            mediaPlayers[5].dispose();
        }
        if (mediaPlayers[6] != null) {
            mediaPlayers[6].dispose();
        }
        if (mediaPlayers[7] != null) {
            mediaPlayers[7].dispose();
        }
        if (mediaPlayers[8] != null) {
            mediaPlayers[8].dispose();
        }
        if (mediaPlayers[9] != null) {
            mediaPlayers[9].dispose();
        }
        if (mediaPlayers[10] != null) {
            mediaPlayers[10].dispose();
        }
        if (mediaPlayers[11] != null) {
            mediaPlayers[11].dispose();
        }
        if (mediaPlayers[12] != null) {
            mediaPlayers[12].dispose();
        }
        if (mediaPlayers[13] != null) {
            mediaPlayers[13].dispose();
        }
        if (mediaPlayers[14] != null) {
            mediaPlayers[14].dispose();
        }
        if (mediaPlayers[15] != null) {
            mediaPlayers[15].dispose();
        }

        if (!category1Melody10Label.isDisable()) {
            category1Melody10Glow.setLevel(0.0);
            if (category1Melody10Timeline.getStatus().toString().equals("RUNNING")) {
                category1Melody10Timeline.pause();
            }
        }
        if (!category1Melody20Label.isDisable()) {
            category1Melody20Glow.setLevel(0.0);
            if (category1Melody20Timeline.getStatus().toString().equals("RUNNING")) {
                category1Melody20Timeline.pause();
            }
        }
        if (!category1Melody30Label.isDisable()) {
            category1Melody30Glow.setLevel(0.0);
            if (category1Melody30Timeline.getStatus().toString().equals("RUNNING")) {
                category1Melody30Timeline.pause();
            }
        }
        if (!category1Melody40Label.isDisable()) {
            category1Melody40Glow.setLevel(0.0);
            if (category1Melody40Timeline.getStatus().toString().equals("RUNNING")) {
                category1Melody40Timeline.pause();
            }
        }
        if (!category2Melody10Label.isDisable()) {
            category2Melody10Glow.setLevel(0.0);
            if (category2Melody10Timeline.getStatus().toString().equals("RUNNING")) {
                category2Melody10Timeline.pause();
            }
        }
        if (!category2Melody20Label.isDisable()) {
            category2Melody20Glow.setLevel(0.0);
            if (category2Melody20Timeline.getStatus().toString().equals("RUNNING")) {
                category2Melody20Timeline.pause();
            }
        }
        if (!category2Melody30Label.isDisable()) {
            category2Melody30Glow.setLevel(0.0);
            if (category2Melody30Timeline.getStatus().toString().equals("RUNNING")) {
                category2Melody30Timeline.pause();
            }
        }
        if (!category2Melody40Label.isDisable()) {
            category2Melody40Glow.setLevel(0.0);
            if (category2Melody40Timeline.getStatus().toString().equals("RUNNING")) {
                category2Melody40Timeline.pause();
            }
        }
        if (!category3Melody10Label.isDisable()) {
            category3Melody10Glow.setLevel(0.0);
            if (category3Melody10Timeline.getStatus().toString().equals("RUNNING")) {
                category3Melody10Timeline.pause();
            }
        }
        if (!category3Melody20Label.isDisable()) {
            category3Melody20Glow.setLevel(0.0);
            if (category3Melody20Timeline.getStatus().toString().equals("RUNNING")) {
                category3Melody20Timeline.pause();
            }
        }
        if (!category3Melody30Label.isDisable()) {
            category3Melody30Glow.setLevel(0.0);
            if (category3Melody30Timeline.getStatus().toString().equals("RUNNING")) {
                category3Melody30Timeline.pause();
            }
        }
        if (!category3Melody40Label.isDisable()) {
            category3Melody40Glow.setLevel(0.0);
            if (category3Melody40Timeline.getStatus().toString().equals("RUNNING")) {
                category3Melody40Timeline.pause();
            }
        }
        if (!category4Melody10Label.isDisable()) {
            category4Melody10Glow.setLevel(0.0);
            if (category4Melody10Timeline.getStatus().toString().equals("RUNNING")) {
                category4Melody10Timeline.pause();
            }
        }
        if (!category4Melody20Label.isDisable()) {
            category4Melody20Glow.setLevel(0.0);
            if (category4Melody20Timeline.getStatus().toString().equals("RUNNING")) {
                category4Melody20Timeline.pause();
            }
        }
        if (!category4Melody30Label.isDisable()) {
            category4Melody30Glow.setLevel(0.0);
            if (category4Melody30Timeline.getStatus().toString().equals("RUNNING")) {
                category4Melody30Timeline.pause();
            }
        }
        if (!category4Melody40Label.isDisable()) {
            category4Melody40Glow.setLevel(0.0);
            if (category4Melody40Timeline.getStatus().toString().equals("RUNNING")) {
                category4Melody40Timeline.pause();
            }
        }
        System.gc();
    }


    public void start() {//обновление всего
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories3.xml"), "UTF-8")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            categories = (Categories) unmarshaller.unmarshal(inputStreamReader);

            category1Label.setText(categories.getCategory1());
            category2Label.setText(categories.getCategory2());
            category3Label.setText(categories.getCategory3());
            category4Label.setText(categories.getCategory4());

            File category1Melody10File = new File("musics/tour3/category1/points10/10.mp3");
            if (category1Melody10File.exists()) {
                medias[0] = new Media(category1Melody10File.toURI().toString());
                mediaPlayers[0] = new MediaPlayer(medias[0]);
                category1Melody10Label.setDisable(false);
            } else {
                medias[0] = null;
                mediaPlayers[0] = null;
                category1Melody10Label.setDisable(true);
            }
            File category1Melody20File = new File("musics/tour3/category1/points20/20.mp3");
            if (category1Melody20File.exists()) {
                medias[1] = new Media(category1Melody20File.toURI().toString());
                mediaPlayers[1] = new MediaPlayer(medias[1]);
                category1Melody20Label.setDisable(false);
            } else {
                medias[1] = null;
                mediaPlayers[1] = null;
                category1Melody20Label.setDisable(true);
            }
            File category1Melody30File = new File("musics/tour3/category1/points30/30.mp3");
            if (category1Melody30File.exists()) {
                medias[2] = new Media(category1Melody30File.toURI().toString());
                mediaPlayers[2] = new MediaPlayer(medias[2]);
                category1Melody30Label.setDisable(false);
            } else {
                medias[2] = null;
                mediaPlayers[2] = null;
                category1Melody30Label.setDisable(true);
            }
            File category1Melody40File = new File("musics/tour3/category1/points40/40.mp3");
            if (category1Melody40File.exists()) {
                medias[3] = new Media(category1Melody40File.toURI().toString());
                mediaPlayers[3] = new MediaPlayer(medias[3]);
                category1Melody40Label.setDisable(false);
            } else {
                medias[3] = null;
                mediaPlayers[3] = null;
                category1Melody40Label.setDisable(true);
            }
            File category2Melody10File = new File("musics/tour3/category2/points10/10.mp3");
            if (category2Melody10File.exists()) {
                medias[4] = new Media(category2Melody10File.toURI().toString());
                mediaPlayers[4] = new MediaPlayer(medias[4]);
                category2Melody10Label.setDisable(false);
            } else {
                medias[4] = null;
                mediaPlayers[4] = null;
                category2Melody10Label.setDisable(true);
            }
            File category2Melody20File = new File("musics/tour3/category2/points20/20.mp3");
            if (category2Melody20File.exists()) {
                medias[5] = new Media(category2Melody20File.toURI().toString());
                mediaPlayers[5] = new MediaPlayer(medias[5]);
                category2Melody20Label.setDisable(false);
            } else {
                medias[5] = null;
                mediaPlayers[5] = null;
                category2Melody20Label.setDisable(true);
            }
            File category2Melody30File = new File("musics/tour3/category2/points30/30.mp3");
            if (category2Melody30File.exists()) {
                medias[6] = new Media(category2Melody30File.toURI().toString());
                mediaPlayers[6] = new MediaPlayer(medias[6]);
                category2Melody30Label.setDisable(false);
            } else {
                medias[6] = null;
                mediaPlayers[6] = null;
                category2Melody30Label.setDisable(true);
            }
            File category2Melody40File = new File("musics/tour3/category2/points40/40.mp3");
            if (category2Melody40File.exists()) {
                medias[7] = new Media(category2Melody40File.toURI().toString());
                mediaPlayers[7] = new MediaPlayer(medias[7]);
                category2Melody40Label.setDisable(false);
            } else {
                medias[7] = null;
                mediaPlayers[7] = null;
                category2Melody40Label.setDisable(true);
            }
            File category3Melody10File = new File("musics/tour3/category3/points10/10.mp3");
            if (category3Melody10File.exists()) {
                medias[8] = new Media(category3Melody10File.toURI().toString());
                mediaPlayers[8] = new MediaPlayer(medias[8]);
                category3Melody10Label.setDisable(false);
            } else {
                medias[8] = null;
                mediaPlayers[8] = null;
                category3Melody10Label.setDisable(true);
            }
            File category3Melody20File = new File("musics/tour3/category3/points20/20.mp3");
            if (category3Melody20File.exists()) {
                medias[9] = new Media(category3Melody20File.toURI().toString());
                mediaPlayers[9] = new MediaPlayer(medias[9]);
                category3Melody20Label.setDisable(false);
            } else {
                medias[9] = null;
                mediaPlayers[9] = null;
                category3Melody20Label.setDisable(true);
            }
            File category3Melody30File = new File("musics/tour3/category3/points30/30.mp3");
            if (category3Melody30File.exists()) {
                medias[10] = new Media(category3Melody30File.toURI().toString());
                mediaPlayers[10] = new MediaPlayer(medias[10]);
                category3Melody30Label.setDisable(false);
            } else {
                medias[10] = null;
                mediaPlayers[10] = null;
                category3Melody30Label.setDisable(true);
            }
            File category3Melody40File = new File("musics/tour3/category3/points40/40.mp3");
            if (category3Melody40File.exists()) {
                medias[11] = new Media(category3Melody40File.toURI().toString());
                mediaPlayers[11] = new MediaPlayer(medias[11]);
                category3Melody40Label.setDisable(false);
            } else {
                medias[11] = null;
                mediaPlayers[11] = null;
                category3Melody40Label.setDisable(true);
            }
            File category4Melody10File = new File("musics/tour3/category4/points10/10.mp3");
            if (category4Melody10File.exists()) {
                medias[12] = new Media(category4Melody10File.toURI().toString());
                mediaPlayers[12] = new MediaPlayer(medias[12]);
                category4Melody10Label.setDisable(false);
            } else {
                medias[12] = null;
                mediaPlayers[12] = null;
                category4Melody10Label.setDisable(true);
            }
            File category4Melody20File = new File("musics/tour3/category4/points20/20.mp3");
            if (category4Melody20File.exists()) {
                medias[13] = new Media(category4Melody20File.toURI().toString());
                mediaPlayers[13] = new MediaPlayer(medias[13]);
                category4Melody20Label.setDisable(false);
            } else {
                medias[13] = null;
                mediaPlayers[13] = null;
                category4Melody20Label.setDisable(true);
            }
            File category4Melody30File = new File("musics/tour3/category4/points30/30.mp3");
            if (category4Melody30File.exists()) {
                medias[14] = new Media(category4Melody30File.toURI().toString());
                mediaPlayers[14] = new MediaPlayer(medias[14]);
                category4Melody30Label.setDisable(false);
            } else {
                medias[14] = null;
                mediaPlayers[14] = null;
                category4Melody30Label.setDisable(true);
            }
            File category4Melody40File = new File("musics/tour3/category4/points40/40.mp3");
            if (category4Melody40File.exists()) {
                medias[15] = new Media(category4Melody40File.toURI().toString());
                mediaPlayers[15] = new MediaPlayer(medias[15]);
                category4Melody40Label.setDisable(false);
            } else {
                medias[15] = null;
                mediaPlayers[15] = null;
                category4Melody40Label.setDisable(true);
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public Label getBackLabel() {
        return backLabel;
    }
}
