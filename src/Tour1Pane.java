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
public class Tour1Pane {
    private Pane tour1Pane;
    private ImageView tour1Background;
    private Scene tour1Scene;
    private Label tour1Category1;
    private Label tour1Category2;
    private Label tour1Category3;
    private Label tour1Category4;
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
    private Glow glowCategory1Melody10;
    private Glow glowCategory1Melody20;
    private Glow glowCategory1Melody30;
    private Glow glowCategory1Melody40;
    private Glow glowCategory2Melody10;
    private Glow glowCategory2Melody20;
    private Glow glowCategory2Melody30;
    private Glow glowCategory2Melody40;
    private Glow glowCategory3Melody10;
    private Glow glowCategory3Melody20;
    private Glow glowCategory3Melody30;
    private Glow glowCategory3Melody40;
    private Glow glowCategory4Melody10;
    private Glow glowCategory4Melody20;
    private Glow glowCategory4Melody30;
    private Glow glowCategory4Melody40;
    private Timeline timelineCategory1Melody10;
    private Timeline timelineCategory1Melody20;
    private Timeline timelineCategory1Melody30;
    private Timeline timelineCategory1Melody40;
    private Timeline timelineCategory2Melody10;
    private Timeline timelineCategory2Melody20;
    private Timeline timelineCategory2Melody30;
    private Timeline timelineCategory2Melody40;
    private Timeline timelineCategory3Melody10;
    private Timeline timelineCategory3Melody20;
    private Timeline timelineCategory3Melody30;
    private Timeline timelineCategory3Melody40;
    private Timeline timelineCategory4Melody10;
    private Timeline timelineCategory4Melody20;
    private Timeline timelineCategory4Melody30;
    private Timeline timelineCategory4Melody40;

    public Tour1Pane() {
        tour1Pane = new Pane();
        tour1Background = new ImageView(new Image(Main.getPathToResource("images/tour1.jpg")));
        tour1Background.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        tour1Background.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        tour1Background.setSmooth(true);//сглаживание

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

        tour1Category1 = new Label();
        tour1Category1.setLayoutX(0);
        tour1Category1.setLayoutY(0);
        tour1Category1.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category1.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category1.setId("gameLabel");
        tour1Category1.setFont(new Font(Main.SCREEN_SIZE.getHeight() * 0.045));
        tour1Category1.setWrapText(true);
        tour1Category1.setLineSpacing(0);
        tour1Category1.setAlignment(Pos.CENTER);
        tour1Category1.setTextAlignment(TextAlignment.CENTER);

        tour1Category2 = new Label();
        tour1Category2.setLayoutX(0);
        tour1Category2.setLayoutY(Main.SCREEN_SIZE.height * 0.25);
        tour1Category2.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category2.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category2.setId("gameLabel");
        tour1Category2.setFont(new Font(Main.SCREEN_SIZE.getHeight() * 0.045));
        tour1Category2.setWrapText(true);
        tour1Category2.setLineSpacing(0);
        tour1Category2.setAlignment(Pos.CENTER);
        tour1Category2.setTextAlignment(TextAlignment.CENTER);

        tour1Category3 = new Label();
        tour1Category3.setLayoutX(0);
        tour1Category3.setLayoutY(Main.SCREEN_SIZE.height * 0.5);
        tour1Category3.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category3.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category3.setId("gameLabel");
        tour1Category3.setFont(new Font(Main.SCREEN_SIZE.getHeight() * 0.045));
        tour1Category3.setWrapText(true);
        tour1Category3.setLineSpacing(0);
        tour1Category3.setAlignment(Pos.CENTER);
        tour1Category3.setTextAlignment(TextAlignment.CENTER);

        tour1Category4 = new Label();
        tour1Category4.setLayoutX(0);
        tour1Category4.setLayoutY(Main.SCREEN_SIZE.height * 0.75);
        tour1Category4.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category4.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category4.setId("gameLabel");
        tour1Category4.setFont(new Font(Main.SCREEN_SIZE.getHeight() * 0.045));
        tour1Category4.setWrapText(true);
        tour1Category4.setLineSpacing(0);
        tour1Category4.setAlignment(Pos.CENTER);
        tour1Category4.setTextAlignment(TextAlignment.CENTER);

        glowCategory1Melody10 = new Glow();
        timelineCategory1Melody10 = new Timeline();
        timelineCategory1Melody10.setCycleCount(Timeline.INDEFINITE);
        timelineCategory1Melody10.setAutoReverse(true);
        timelineCategory1Melody10.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory1Melody10.levelProperty(), 1.0)));

        glowCategory1Melody20 = new Glow();
        timelineCategory1Melody20 = new Timeline();
        timelineCategory1Melody20.setCycleCount(Timeline.INDEFINITE);
        timelineCategory1Melody20.setAutoReverse(true);
        timelineCategory1Melody20.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory1Melody20.levelProperty(), 1.0)));

        glowCategory1Melody30 = new Glow();
        timelineCategory1Melody30 = new Timeline();
        timelineCategory1Melody30.setCycleCount(Timeline.INDEFINITE);
        timelineCategory1Melody30.setAutoReverse(true);
        timelineCategory1Melody30.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory1Melody30.levelProperty(), 1.0)));

        glowCategory1Melody40 = new Glow();
        timelineCategory1Melody40 = new Timeline();
        timelineCategory1Melody40.setCycleCount(Timeline.INDEFINITE);
        timelineCategory1Melody40.setAutoReverse(true);
        timelineCategory1Melody40.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory1Melody40.levelProperty(), 1.0)));

        glowCategory2Melody10 = new Glow();
        timelineCategory2Melody10 = new Timeline();
        timelineCategory2Melody10.setCycleCount(Timeline.INDEFINITE);
        timelineCategory2Melody10.setAutoReverse(true);
        timelineCategory2Melody10.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory2Melody10.levelProperty(), 1.0)));

        glowCategory2Melody20 = new Glow();
        timelineCategory2Melody20 = new Timeline();
        timelineCategory2Melody20.setCycleCount(Timeline.INDEFINITE);
        timelineCategory2Melody20.setAutoReverse(true);
        timelineCategory2Melody20.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory2Melody20.levelProperty(), 1.0)));

        glowCategory2Melody30 = new Glow();
        timelineCategory2Melody30 = new Timeline();
        timelineCategory2Melody30.setCycleCount(Timeline.INDEFINITE);
        timelineCategory2Melody30.setAutoReverse(true);
        timelineCategory2Melody30.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory2Melody30.levelProperty(), 1.0)));

        glowCategory2Melody40 = new Glow();
        timelineCategory2Melody40 = new Timeline();
        timelineCategory2Melody40.setCycleCount(Timeline.INDEFINITE);
        timelineCategory2Melody40.setAutoReverse(true);
        timelineCategory2Melody40.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory2Melody40.levelProperty(), 1.0)));

        glowCategory3Melody10 = new Glow();
        timelineCategory3Melody10 = new Timeline();
        timelineCategory3Melody10.setCycleCount(Timeline.INDEFINITE);
        timelineCategory3Melody10.setAutoReverse(true);
        timelineCategory3Melody10.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory3Melody10.levelProperty(), 1.0)));

        glowCategory3Melody20 = new Glow();
        timelineCategory3Melody20 = new Timeline();
        timelineCategory3Melody20.setCycleCount(Timeline.INDEFINITE);
        timelineCategory3Melody20.setAutoReverse(true);
        timelineCategory3Melody20.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory3Melody20.levelProperty(), 1.0)));

        glowCategory3Melody30 = new Glow();
        timelineCategory3Melody30 = new Timeline();
        timelineCategory3Melody30.setCycleCount(Timeline.INDEFINITE);
        timelineCategory3Melody30.setAutoReverse(true);
        timelineCategory3Melody30.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory3Melody30.levelProperty(), 1.0)));

        glowCategory3Melody40 = new Glow();
        timelineCategory3Melody40 = new Timeline();
        timelineCategory3Melody40.setCycleCount(Timeline.INDEFINITE);
        timelineCategory3Melody40.setAutoReverse(true);
        timelineCategory3Melody40.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory3Melody40.levelProperty(), 1.0)));

        glowCategory4Melody10 = new Glow();
        timelineCategory4Melody10 = new Timeline();
        timelineCategory4Melody10.setCycleCount(Timeline.INDEFINITE);
        timelineCategory4Melody10.setAutoReverse(true);
        timelineCategory4Melody10.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory4Melody10.levelProperty(), 1.0)));

        glowCategory4Melody20 = new Glow();
        timelineCategory4Melody20 = new Timeline();
        timelineCategory4Melody20.setCycleCount(Timeline.INDEFINITE);
        timelineCategory4Melody20.setAutoReverse(true);
        timelineCategory4Melody20.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory4Melody20.levelProperty(), 1.0)));

        glowCategory4Melody30 = new Glow();
        timelineCategory4Melody30 = new Timeline();
        timelineCategory4Melody30.setCycleCount(Timeline.INDEFINITE);
        timelineCategory4Melody30.setAutoReverse(true);
        timelineCategory4Melody30.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory4Melody30.levelProperty(), 1.0)));

        glowCategory4Melody40 = new Glow();
        timelineCategory4Melody40 = new Timeline();
        timelineCategory4Melody40.setCycleCount(Timeline.INDEFINITE);
        timelineCategory4Melody40.setAutoReverse(true);
        timelineCategory4Melody40.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glowCategory4Melody40.levelProperty(), 1.0)));

        //(0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 - промежуток между нотами
        category1Melody10Label = new Label(null, category1Melody10ImageView);
        category1Melody10Label.setCursor(Cursor.HAND);
        category1Melody10Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        category1Melody10Label.setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        category1Melody10Label.setOnMouseClicked(event -> {
            mediaPlayers[0].setVolume(1);
            mediaPlayers[0].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[0].getStatus().toString().equals("PLAYING")) {
                timelineCategory1Melody10.pause();
                glowCategory1Melody10.setLevel(1.0);
                mediaPlayers[0].pause();
            }
            if (mediaPlayers[0].getStatus().toString().equals("PAUSED") || mediaPlayers[0].getStatus().toString().equals("READY")) {
                category1Melody10Label.setEffect(glowCategory1Melody10);
                glowCategory1Melody10.setLevel(0.0);
                timelineCategory1Melody10.play();
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
                timelineCategory1Melody20.pause();
                glowCategory1Melody20.setLevel(1.0);
                mediaPlayers[1].pause();
            }
            if (mediaPlayers[1].getStatus().toString().equals("PAUSED") || mediaPlayers[1].getStatus().toString().equals("READY")) {
                category1Melody20Label.setEffect(glowCategory1Melody20);
                glowCategory1Melody20.setLevel(0.0);
                timelineCategory1Melody20.play();
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
                timelineCategory1Melody30.pause();
                glowCategory1Melody30.setLevel(1.0);
                mediaPlayers[2].pause();
            }
            if (mediaPlayers[2].getStatus().toString().equals("PAUSED") || mediaPlayers[2].getStatus().toString().equals("READY")) {
                category1Melody30Label.setEffect(glowCategory1Melody30);
                glowCategory1Melody30.setLevel(0.0);
                timelineCategory1Melody30.play();
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
                timelineCategory1Melody40.pause();
                glowCategory1Melody40.setLevel(1.0);
                mediaPlayers[3].pause();
            }
            if (mediaPlayers[3].getStatus().toString().equals("PAUSED") || mediaPlayers[3].getStatus().toString().equals("READY")) {
                category1Melody40Label.setEffect(glowCategory1Melody40);
                glowCategory1Melody40.setLevel(0.0);
                timelineCategory1Melody40.play();
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
                timelineCategory2Melody10.pause();
                glowCategory2Melody10.setLevel(1.0);
                mediaPlayers[4].pause();
            }
            if (mediaPlayers[4].getStatus().toString().equals("PAUSED") || mediaPlayers[4].getStatus().toString().equals("READY")) {
                category2Melody10Label.setEffect(glowCategory2Melody10);
                glowCategory2Melody10.setLevel(0.0);
                timelineCategory2Melody10.play();
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
                timelineCategory2Melody20.pause();
                glowCategory2Melody20.setLevel(1.0);
                mediaPlayers[5].pause();
            }
            if (mediaPlayers[5].getStatus().toString().equals("PAUSED") || mediaPlayers[5].getStatus().toString().equals("READY")) {
                category2Melody20Label.setEffect(glowCategory2Melody20);
                glowCategory2Melody20.setLevel(0.0);
                timelineCategory2Melody20.play();
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
                timelineCategory2Melody30.pause();
                glowCategory2Melody30.setLevel(1.0);
                mediaPlayers[6].pause();
            }
            if (mediaPlayers[6].getStatus().toString().equals("PAUSED") || mediaPlayers[6].getStatus().toString().equals("READY")) {
                category2Melody30Label.setEffect(glowCategory2Melody30);
                glowCategory2Melody30.setLevel(0.0);
                timelineCategory2Melody30.play();
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
                timelineCategory2Melody40.pause();
                glowCategory2Melody40.setLevel(1.0);
                mediaPlayers[7].pause();
            }
            if (mediaPlayers[7].getStatus().toString().equals("PAUSED") || mediaPlayers[7].getStatus().toString().equals("READY")) {
                category2Melody40Label.setEffect(glowCategory2Melody40);
                glowCategory2Melody40.setLevel(0.0);
                timelineCategory2Melody40.play();
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
                timelineCategory3Melody10.pause();
                glowCategory3Melody10.setLevel(1.0);
                mediaPlayers[8].pause();
            }
            if (mediaPlayers[8].getStatus().toString().equals("PAUSED") || mediaPlayers[8].getStatus().toString().equals("READY")) {
                category3Melody10Label.setEffect(glowCategory3Melody10);
                glowCategory3Melody10.setLevel(0.0);
                timelineCategory3Melody10.play();
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
                timelineCategory3Melody20.pause();
                glowCategory3Melody20.setLevel(1.0);
                mediaPlayers[9].pause();
            }
            if (mediaPlayers[9].getStatus().toString().equals("PAUSED") || mediaPlayers[9].getStatus().toString().equals("READY")) {
                category3Melody20Label.setEffect(glowCategory3Melody20);
                glowCategory3Melody20.setLevel(0.0);
                timelineCategory3Melody20.play();
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
                timelineCategory3Melody30.pause();
                glowCategory3Melody30.setLevel(1.0);
                mediaPlayers[10].pause();
            }
            if (mediaPlayers[10].getStatus().toString().equals("PAUSED") || mediaPlayers[10].getStatus().toString().equals("READY")) {
                category3Melody30Label.setEffect(glowCategory3Melody30);
                glowCategory3Melody30.setLevel(0.0);
                timelineCategory3Melody30.play();
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
                timelineCategory3Melody40.pause();
                glowCategory3Melody40.setLevel(1.0);
                mediaPlayers[11].pause();
            }
            if (mediaPlayers[11].getStatus().toString().equals("PAUSED") || mediaPlayers[11].getStatus().toString().equals("READY")) {
                category3Melody40Label.setEffect(glowCategory3Melody40);
                glowCategory3Melody40.setLevel(0.0);
                timelineCategory3Melody40.play();
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
                timelineCategory4Melody10.pause();
                glowCategory4Melody10.setLevel(1.0);
                mediaPlayers[12].pause();
            }
            if (mediaPlayers[12].getStatus().toString().equals("PAUSED") || mediaPlayers[12].getStatus().toString().equals("READY")) {
                category4Melody10Label.setEffect(glowCategory4Melody10);
                glowCategory4Melody10.setLevel(0.0);
                timelineCategory4Melody10.play();
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
                timelineCategory4Melody20.pause();
                glowCategory4Melody20.setLevel(1.0);
                mediaPlayers[13].pause();
            }
            if (mediaPlayers[13].getStatus().toString().equals("PAUSED") || mediaPlayers[13].getStatus().toString().equals("READY")) {
                category4Melody20Label.setEffect(glowCategory4Melody20);
                glowCategory4Melody20.setLevel(0.0);
                timelineCategory4Melody20.play();
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
                timelineCategory4Melody30.pause();
                glowCategory4Melody30.setLevel(1.0);
                mediaPlayers[14].pause();
            }
            if (mediaPlayers[14].getStatus().toString().equals("PAUSED") || mediaPlayers[14].getStatus().toString().equals("READY")) {
                category4Melody30Label.setEffect(glowCategory4Melody30);
                glowCategory4Melody30.setLevel(0.0);
                timelineCategory4Melody30.play();
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
                timelineCategory4Melody40.pause();
                glowCategory4Melody40.setLevel(1.0);
                mediaPlayers[15].pause();
            }
            if (mediaPlayers[15].getStatus().toString().equals("PAUSED") || mediaPlayers[15].getStatus().toString().equals("READY")) {
                category4Melody40Label.setEffect(glowCategory4Melody40);
                glowCategory4Melody40.setLevel(0.0);
                timelineCategory4Melody40.play();
                mediaPlayers[15].play();
            }
        });

        backLabel = new Label(null, backImageView);
        backLabel.setLayoutX(0);
        backLabel.setLayoutY(0);
        backLabel.setCursor(Cursor.HAND);
        backLabel.setId("settingsToursCategoriesPaneLabel");

        tour1Scene = new Scene(tour1Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        tour1Scene.getStylesheets().add(Main.getPathToResource("css/style.css"));
        tour1Pane.getChildren().addAll(tour1Background, tour1Category1, tour1Category2, tour1Category3, tour1Category4,
                category1Melody10Label, category1Melody20Label, category1Melody30Label, category1Melody40Label,
                category2Melody10Label, category2Melody20Label, category2Melody30Label, category2Melody40Label,
                category3Melody10Label, category3Melody20Label, category3Melody30Label, category3Melody40Label,
                category4Melody10Label, category4Melody20Label, category4Melody30Label, category4Melody40Label, backLabel);
    }

    public Scene getTour1Scene() {
        return tour1Scene;
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
            glowCategory1Melody10.setLevel(0.0);
            if (timelineCategory1Melody10.getStatus().toString().equals("RUNNING")) {
                timelineCategory1Melody10.pause();
            }
        }
        if (!category1Melody20Label.isDisable()) {
            glowCategory1Melody20.setLevel(0.0);
            if (timelineCategory1Melody20.getStatus().toString().equals("RUNNING")) {
                timelineCategory1Melody20.pause();
            }
        }
        if (!category1Melody30Label.isDisable()) {
            glowCategory1Melody30.setLevel(0.0);
            if (timelineCategory1Melody30.getStatus().toString().equals("RUNNING")) {
                timelineCategory1Melody30.pause();
            }
        }
        if (!category1Melody40Label.isDisable()) {
            glowCategory1Melody40.setLevel(0.0);
            if (timelineCategory1Melody40.getStatus().toString().equals("RUNNING")) {
                timelineCategory1Melody40.pause();
            }
        }
        if (!category2Melody10Label.isDisable()) {
            glowCategory2Melody10.setLevel(0.0);
            if (timelineCategory2Melody10.getStatus().toString().equals("RUNNING")) {
                timelineCategory2Melody10.pause();
            }
        }
        if (!category2Melody20Label.isDisable()) {
            glowCategory2Melody20.setLevel(0.0);
            if (timelineCategory2Melody20.getStatus().toString().equals("RUNNING")) {
                timelineCategory2Melody20.pause();
            }
        }
        if (!category2Melody30Label.isDisable()) {
            glowCategory2Melody30.setLevel(0.0);
            if (timelineCategory2Melody30.getStatus().toString().equals("RUNNING")) {
                timelineCategory2Melody30.pause();
            }
        }
        if (!category2Melody40Label.isDisable()) {
            glowCategory2Melody40.setLevel(0.0);
            if (timelineCategory2Melody40.getStatus().toString().equals("RUNNING")) {
                timelineCategory2Melody40.pause();
            }
        }
        if (!category3Melody10Label.isDisable()) {
            glowCategory3Melody10.setLevel(0.0);
            if (timelineCategory3Melody10.getStatus().toString().equals("RUNNING")) {
                timelineCategory3Melody10.pause();
            }
        }
        if (!category3Melody20Label.isDisable()) {
            glowCategory3Melody20.setLevel(0.0);
            if (timelineCategory3Melody20.getStatus().toString().equals("RUNNING")) {
                timelineCategory3Melody20.pause();
            }
        }
        if (!category3Melody30Label.isDisable()) {
            glowCategory3Melody30.setLevel(0.0);
            if (timelineCategory3Melody30.getStatus().toString().equals("RUNNING")) {
                timelineCategory3Melody30.pause();
            }
        }
        if (!category3Melody40Label.isDisable()) {
            glowCategory3Melody40.setLevel(0.0);
            if (timelineCategory3Melody40.getStatus().toString().equals("RUNNING")) {
                timelineCategory3Melody40.pause();
            }
        }
        if (!category4Melody10Label.isDisable()) {
            glowCategory4Melody10.setLevel(0.0);
            if (timelineCategory4Melody10.getStatus().toString().equals("RUNNING")) {
                timelineCategory4Melody10.pause();
            }
        }
        if (!category4Melody20Label.isDisable()) {
            glowCategory4Melody20.setLevel(0.0);
            if (timelineCategory4Melody20.getStatus().toString().equals("RUNNING")) {
                timelineCategory4Melody20.pause();
            }
        }
        if (!category4Melody30Label.isDisable()) {
            glowCategory4Melody30.setLevel(0.0);
            if (timelineCategory4Melody30.getStatus().toString().equals("RUNNING")) {
                timelineCategory4Melody30.pause();
            }
        }
        if (!category4Melody40Label.isDisable()) {
            glowCategory4Melody40.setLevel(0.0);
            if (timelineCategory4Melody40.getStatus().toString().equals("RUNNING")) {
                timelineCategory4Melody40.pause();
            }
        }
        System.gc();
    }


    public void start() {//обновление всего
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories1.xml"), "UTF-8")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            categories = (Categories) unmarshaller.unmarshal(inputStreamReader);
            tour1Category1.setText(categories.getCategory1());
            tour1Category2.setText(categories.getCategory2());
            tour1Category3.setText(categories.getCategory3());
            tour1Category4.setText(categories.getCategory4());

            File category1Points10 = new File("musics/tour1/category1/points10/10.mp3");
            if (category1Points10.exists()) {
                medias[0] = new Media(category1Points10.toURI().toString());
                mediaPlayers[0] = new MediaPlayer(medias[0]);
                category1Melody10Label.setDisable(false);
            } else {
                medias[0] = null;
                mediaPlayers[0] = null;
                category1Melody10Label.setDisable(true);
            }
            File category1Points20 = new File("musics/tour1/category1/points20/20.mp3");
            if (category1Points20.exists()) {
                medias[1] = new Media(category1Points20.toURI().toString());
                mediaPlayers[1] = new MediaPlayer(medias[1]);
                category1Melody20Label.setDisable(false);
            } else {
                medias[1] = null;
                mediaPlayers[1] = null;
                category1Melody20Label.setDisable(true);
            }
            File category1Points30 = new File("musics/tour1/category1/points30/30.mp3");
            if (category1Points30.exists()) {
                medias[2] = new Media(category1Points30.toURI().toString());
                mediaPlayers[2] = new MediaPlayer(medias[2]);
                category1Melody30Label.setDisable(false);
            } else {
                medias[2] = null;
                mediaPlayers[2] = null;
                category1Melody30Label.setDisable(true);
            }
            File category1Points40 = new File("musics/tour1/category1/points40/40.mp3");
            if (category1Points40.exists()) {
                medias[3] = new Media(category1Points40.toURI().toString());
                mediaPlayers[3] = new MediaPlayer(medias[3]);
                category1Melody40Label.setDisable(false);
            } else {
                medias[3] = null;
                mediaPlayers[3] = null;
                category1Melody40Label.setDisable(true);
            }
            File category2Points10 = new File("musics/tour1/category2/points10/10.mp3");
            if (category2Points10.exists()) {
                medias[4] = new Media(category2Points10.toURI().toString());
                mediaPlayers[4] = new MediaPlayer(medias[4]);
                category2Melody10Label.setDisable(false);
            } else {
                medias[4] = null;
                mediaPlayers[4] = null;
                category2Melody10Label.setDisable(true);
            }
            File category2Points20 = new File("musics/tour1/category2/points20/20.mp3");
            if (category2Points20.exists()) {
                medias[5] = new Media(category2Points20.toURI().toString());
                mediaPlayers[5] = new MediaPlayer(medias[5]);
                category2Melody20Label.setDisable(false);
            } else {
                medias[5] = null;
                mediaPlayers[5] = null;
                category2Melody20Label.setDisable(true);
            }
            File category2Points30 = new File("musics/tour1/category2/points30/30.mp3");
            if (category2Points30.exists()) {
                medias[6] = new Media(category2Points30.toURI().toString());
                mediaPlayers[6] = new MediaPlayer(medias[6]);
                category2Melody30Label.setDisable(false);
            } else {
                medias[6] = null;
                mediaPlayers[6] = null;
                category2Melody30Label.setDisable(true);
            }
            File category2Points40 = new File("musics/tour1/category2/points40/40.mp3");
            if (category2Points40.exists()) {
                medias[7] = new Media(category2Points40.toURI().toString());
                mediaPlayers[7] = new MediaPlayer(medias[7]);
                category2Melody40Label.setDisable(false);
            } else {
                medias[7] = null;
                mediaPlayers[7] = null;
                category2Melody40Label.setDisable(true);
            }
            File category3Points10 = new File("musics/tour1/category3/points10/10.mp3");
            if (category3Points10.exists()) {
                medias[8] = new Media(category3Points10.toURI().toString());
                mediaPlayers[8] = new MediaPlayer(medias[8]);
                category3Melody10Label.setDisable(false);
            } else {
                medias[8] = null;
                mediaPlayers[8] = null;
                category3Melody10Label.setDisable(true);
            }
            File category3Points20 = new File("musics/tour1/category3/points20/20.mp3");
            if (category3Points20.exists()) {
                medias[9] = new Media(category3Points20.toURI().toString());
                mediaPlayers[9] = new MediaPlayer(medias[9]);
                category3Melody20Label.setDisable(false);
            } else {
                medias[9] = null;
                mediaPlayers[9] = null;
                category3Melody20Label.setDisable(true);
            }
            File category3Points30 = new File("musics/tour1/category3/points30/30.mp3");
            if (category3Points30.exists()) {
                medias[10] = new Media(category3Points30.toURI().toString());
                mediaPlayers[10] = new MediaPlayer(medias[10]);
                category3Melody30Label.setDisable(false);
            } else {
                medias[10] = null;
                mediaPlayers[10] = null;
                category3Melody30Label.setDisable(true);
            }
            File category3Points40 = new File("musics/tour1/category3/points40/40.mp3");
            if (category3Points40.exists()) {
                medias[11] = new Media(category3Points40.toURI().toString());
                mediaPlayers[11] = new MediaPlayer(medias[11]);
                category3Melody40Label.setDisable(false);
            } else {
                medias[11] = null;
                mediaPlayers[11] = null;
                category3Melody40Label.setDisable(true);
            }
            File category4Points10 = new File("musics/tour1/category4/points10/10.mp3");
            if (category4Points10.exists()) {
                medias[12] = new Media(category4Points10.toURI().toString());
                mediaPlayers[12] = new MediaPlayer(medias[12]);
                category4Melody10Label.setDisable(false);
            } else {
                medias[12] = null;
                mediaPlayers[12] = null;
                category4Melody10Label.setDisable(true);
            }
            File category4Points20 = new File("musics/tour1/category4/points20/20.mp3");
            if (category4Points20.exists()) {
                medias[13] = new Media(category4Points20.toURI().toString());
                mediaPlayers[13] = new MediaPlayer(medias[13]);
                category4Melody20Label.setDisable(false);
            } else {
                medias[13] = null;
                mediaPlayers[13] = null;
                category4Melody20Label.setDisable(true);
            }
            File category4Points30 = new File("musics/tour1/category4/points30/30.mp3");
            if (category4Points30.exists()) {
                medias[14] = new Media(category4Points30.toURI().toString());
                mediaPlayers[14] = new MediaPlayer(medias[14]);
                category4Melody30Label.setDisable(false);
            } else {
                medias[14] = null;
                mediaPlayers[14] = null;
                category4Melody30Label.setDisable(true);
            }
            File category4Points40 = new File("musics/tour1/category4/points40/40.mp3");
            if (category4Points40.exists()) {
                medias[15] = new Media(category4Points40.toURI().toString());
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
