package game.tour2;

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
public class Tour2Pane {
    private Pane pane;
    private ImageView backgroundImageView;
    private Scene scene;
    private Label category1Label;
    private Label category2Label;
    private Label category3Label;
    private Label category4Label;
    private Label[] notesLabels;
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
    private Glow[] glows;
    private Timeline[] timelines;

    public Tour2Pane() {
        pane = new Pane();
        backgroundImageView = new ImageView(new Image(Main.getPathToResource("images/tour.jpg")));
        backgroundImageView.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        backgroundImageView.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        backgroundImageView.setSmooth(true);//сглаживание

        medias = new Media[16];
        mediaPlayers = new MediaPlayer[16];
        notesLabels = new Label[16];
        glows = new Glow[16];
        timelines = new Timeline[16];

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

        for (int i = 0; i < 16; i++) {
            glows[i] = new Glow();
            timelines[i] = new Timeline();
            timelines[i].setCycleCount(Timeline.INDEFINITE);
            timelines[i].setAutoReverse(true);
            timelines[i].getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(glows[i].levelProperty(), 1.0)));
        }

        //(0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 - промежуток между нотами
        notesLabels[0] = new Label(null, category1Melody10ImageView);
        notesLabels[0].setCursor(Cursor.HAND);
        notesLabels[0].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        notesLabels[0].setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        notesLabels[0].setOnMouseClicked(event -> {
            mediaPlayers[0].setVolume(1);
            mediaPlayers[0].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[0].getStatus().toString().equals("PLAYING")) {
                timelines[0].pause();
                glows[0].setLevel(1.0);
                mediaPlayers[0].pause();
            }
            if (mediaPlayers[0].getStatus().toString().equals("PAUSED") || mediaPlayers[0].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 0 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[0].setEffect(glows[0]);
                glows[0].setLevel(0.0);
                timelines[0].play();
                mediaPlayers[0].play();
            }
        });

        notesLabels[1] = new Label(null, category1Melody20ImageView);
        notesLabels[1].setCursor(Cursor.HAND);
        notesLabels[1].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 2 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + category1Melody10ImageView.getFitWidth());
        notesLabels[1].setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        notesLabels[1].setOnMouseClicked(event -> {
            mediaPlayers[1].setVolume(1);
            mediaPlayers[1].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[1].getStatus().toString().equals("PLAYING")) {
                timelines[1].pause();
                glows[1].setLevel(1.0);
                mediaPlayers[1].pause();
            }
            if (mediaPlayers[1].getStatus().toString().equals("PAUSED") || mediaPlayers[1].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 1 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[1].setEffect(glows[1]);
                glows[1].setLevel(0.0);
                timelines[1].play();
                mediaPlayers[1].play();
            }
        });

        notesLabels[2] = new Label(null, category1Melody30ImageView);
        notesLabels[2].setCursor(Cursor.HAND);
        notesLabels[2].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 3 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 2 * category1Melody10ImageView.getFitWidth());
        notesLabels[2].setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        notesLabels[2].setOnMouseClicked(event -> {
            mediaPlayers[2].setVolume(1);
            mediaPlayers[2].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[2].getStatus().toString().equals("PLAYING")) {
                timelines[2].pause();
                glows[2].setLevel(1.0);
                mediaPlayers[2].pause();
            }
            if (mediaPlayers[2].getStatus().toString().equals("PAUSED") || mediaPlayers[2].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 2 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[2].setEffect(glows[2]);
                glows[2].setLevel(0.0);
                timelines[2].play();
                mediaPlayers[2].play();
            }
        });

        notesLabels[3] = new Label(null, category1Melody40ImageView);
        notesLabels[3].setCursor(Cursor.HAND);
        notesLabels[3].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 4 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 3 * category1Melody10ImageView.getFitWidth());
        notesLabels[3].setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        notesLabels[3].setOnMouseClicked(event -> {
            mediaPlayers[3].setVolume(1);
            mediaPlayers[3].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[3].getStatus().toString().equals("PLAYING")) {
                timelines[3].pause();
                glows[3].setLevel(1.0);
                mediaPlayers[3].pause();
            }
            if (mediaPlayers[3].getStatus().toString().equals("PAUSED") || mediaPlayers[3].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 3 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[3].setEffect(glows[3]);
                glows[3].setLevel(0.0);
                timelines[3].play();
                mediaPlayers[3].play();
            }
        });

        notesLabels[4] = new Label(null, category2Melody10ImageView);
        notesLabels[4].setCursor(Cursor.HAND);
        notesLabels[4].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        notesLabels[4].setLayoutY(0.275 * Main.SCREEN_SIZE.getHeight());
        notesLabels[4].setOnMouseClicked(event -> {
            mediaPlayers[4].setVolume(1);
            mediaPlayers[4].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[4].getStatus().toString().equals("PLAYING")) {
                timelines[4].pause();
                glows[4].setLevel(1.0);
                mediaPlayers[4].pause();
            }
            if (mediaPlayers[4].getStatus().toString().equals("PAUSED") || mediaPlayers[4].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 4 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[4].setEffect(glows[4]);
                glows[4].setLevel(0.0);
                timelines[4].play();
                mediaPlayers[4].play();
            }
        });

        notesLabels[5] = new Label(null, category2Melody20ImageView);
        notesLabels[5].setCursor(Cursor.HAND);
        notesLabels[5].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 2 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + category2Melody10ImageView.getFitWidth());
        notesLabels[5].setLayoutY(0.275 * Main.SCREEN_SIZE.getHeight());
        notesLabels[5].setOnMouseClicked(event -> {
            mediaPlayers[5].setVolume(1);
            mediaPlayers[5].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[5].getStatus().toString().equals("PLAYING")) {
                timelines[5].pause();
                glows[5].setLevel(1.0);
                mediaPlayers[5].pause();
            }
            if (mediaPlayers[5].getStatus().toString().equals("PAUSED") || mediaPlayers[5].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 5 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[5].setEffect(glows[5]);
                glows[5].setLevel(0.0);
                timelines[5].play();
                mediaPlayers[5].play();
            }
        });

        notesLabels[6] = new Label(null, category2Melody30ImageView);
        notesLabels[6].setCursor(Cursor.HAND);
        notesLabels[6].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 3 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 2 * category2Melody10ImageView.getFitWidth());
        notesLabels[6].setLayoutY(0.275 * Main.SCREEN_SIZE.getHeight());
        notesLabels[6].setOnMouseClicked(event -> {
            mediaPlayers[6].setVolume(1);
            mediaPlayers[6].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[6].getStatus().toString().equals("PLAYING")) {
                timelines[6].pause();
                glows[6].setLevel(1.0);
                mediaPlayers[6].pause();
            }
            if (mediaPlayers[6].getStatus().toString().equals("PAUSED") || mediaPlayers[6].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 6 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[6].setEffect(glows[6]);
                glows[6].setLevel(0.0);
                timelines[6].play();
                mediaPlayers[6].play();
            }
        });

        notesLabels[7] = new Label(null, category2Melody40ImageView);
        notesLabels[7].setCursor(Cursor.HAND);
        notesLabels[7].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 4 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 3 * category2Melody10ImageView.getFitWidth());
        notesLabels[7].setLayoutY(0.275 * Main.SCREEN_SIZE.getHeight());
        notesLabels[7].setOnMouseClicked(event -> {
            mediaPlayers[7].setVolume(1);
            mediaPlayers[7].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[7].getStatus().toString().equals("PLAYING")) {
                timelines[7].pause();
                glows[7].setLevel(1.0);
                mediaPlayers[7].pause();
            }
            if (mediaPlayers[7].getStatus().toString().equals("PAUSED") || mediaPlayers[7].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 7 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[7].setEffect(glows[7]);
                glows[7].setLevel(0.0);
                timelines[7].play();
                mediaPlayers[7].play();
            }
        });

        notesLabels[8] = new Label(null, category3Melody10ImageView);
        notesLabels[8].setCursor(Cursor.HAND);
        notesLabels[8].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        notesLabels[8].setLayoutY(0.525 * Main.SCREEN_SIZE.getHeight());
        notesLabels[8].setOnMouseClicked(event -> {
            mediaPlayers[8].setVolume(1);
            mediaPlayers[8].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[8].getStatus().toString().equals("PLAYING")) {
                timelines[8].pause();
                glows[8].setLevel(1.0);
                mediaPlayers[8].pause();
            }
            if (mediaPlayers[8].getStatus().toString().equals("PAUSED") || mediaPlayers[8].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 8 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[8].setEffect(glows[8]);
                glows[8].setLevel(0.0);
                timelines[8].play();
                mediaPlayers[8].play();
            }
        });

        notesLabels[9] = new Label(null, category3Melody20ImageView);
        notesLabels[9].setCursor(Cursor.HAND);
        notesLabels[9].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 2 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + category3Melody10ImageView.getFitWidth());
        notesLabels[9].setLayoutY(0.525 * Main.SCREEN_SIZE.getHeight());
        notesLabels[9].setOnMouseClicked(event -> {
            mediaPlayers[9].setVolume(1);
            mediaPlayers[9].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[9].getStatus().toString().equals("PLAYING")) {
                timelines[9].pause();
                glows[9].setLevel(1.0);
                mediaPlayers[9].pause();
            }
            if (mediaPlayers[9].getStatus().toString().equals("PAUSED") || mediaPlayers[9].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 9 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[9].setEffect(glows[9]);
                glows[9].setLevel(0.0);
                timelines[9].play();
                mediaPlayers[9].play();
            }
        });

        notesLabels[10] = new Label(null, category3Melody30ImageView);
        notesLabels[10].setCursor(Cursor.HAND);
        notesLabels[10].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 3 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 2 * category3Melody10ImageView.getFitWidth());
        notesLabels[10].setLayoutY(0.525 * Main.SCREEN_SIZE.getHeight());
        notesLabels[10].setOnMouseClicked(event -> {
            mediaPlayers[10].setVolume(1);
            mediaPlayers[10].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[10].getStatus().toString().equals("PLAYING")) {
                timelines[10].pause();
                glows[10].setLevel(1.0);
                mediaPlayers[10].pause();
            }
            if (mediaPlayers[10].getStatus().toString().equals("PAUSED") || mediaPlayers[10].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 10 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[10].setEffect(glows[10]);
                glows[10].setLevel(0.0);
                timelines[10].play();
                mediaPlayers[10].play();
            }
        });

        notesLabels[11] = new Label(null, category3Melody40ImageView);
        notesLabels[11].setCursor(Cursor.HAND);
        notesLabels[11].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 4 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 3 * category3Melody10ImageView.getFitWidth());
        notesLabels[11].setLayoutY(0.525 * Main.SCREEN_SIZE.getHeight());
        notesLabels[11].setOnMouseClicked(event -> {
            mediaPlayers[11].setVolume(1);
            mediaPlayers[11].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[11].getStatus().toString().equals("PLAYING")) {
                timelines[11].pause();
                glows[11].setLevel(1.0);
                mediaPlayers[11].pause();
            }
            if (mediaPlayers[11].getStatus().toString().equals("PAUSED") || mediaPlayers[11].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 11 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[11].setEffect(glows[11]);
                glows[11].setLevel(0.0);
                timelines[11].play();
                mediaPlayers[11].play();
            }
        });

        notesLabels[12] = new Label(null, category4Melody10ImageView);
        notesLabels[12].setCursor(Cursor.HAND);
        notesLabels[12].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        notesLabels[12].setLayoutY(0.775 * Main.SCREEN_SIZE.getHeight());
        notesLabels[12].setOnMouseClicked(event -> {
            mediaPlayers[12].setVolume(1);
            mediaPlayers[12].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[12].getStatus().toString().equals("PLAYING")) {
                timelines[12].pause();
                glows[12].setLevel(1.0);
                mediaPlayers[12].pause();
            }
            if (mediaPlayers[12].getStatus().toString().equals("PAUSED") || mediaPlayers[12].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 12 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[12].setEffect(glows[12]);
                glows[12].setLevel(0.0);
                timelines[12].play();
                mediaPlayers[12].play();
            }
        });

        notesLabels[13] = new Label(null, category4Melody20ImageView);
        notesLabels[13].setCursor(Cursor.HAND);
        notesLabels[13].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 2 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + category4Melody10ImageView.getFitWidth());
        notesLabels[13].setLayoutY(0.775 * Main.SCREEN_SIZE.getHeight());
        notesLabels[13].setOnMouseClicked(event -> {
            mediaPlayers[13].setVolume(1);
            mediaPlayers[13].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[13].getStatus().toString().equals("PLAYING")) {
                timelines[13].pause();
                glows[13].setLevel(1.0);
                mediaPlayers[13].pause();
            }
            if (mediaPlayers[13].getStatus().toString().equals("PAUSED") || mediaPlayers[13].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 13 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[13].setEffect(glows[13]);
                glows[13].setLevel(0.0);
                timelines[13].play();
                mediaPlayers[13].play();
            }
        });

        notesLabels[14] = new Label(null, category4Melody30ImageView);
        notesLabels[14].setCursor(Cursor.HAND);
        notesLabels[14].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 3 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 2 * category4Melody10ImageView.getFitWidth());
        notesLabels[14].setLayoutY(0.775 * Main.SCREEN_SIZE.getHeight());
        notesLabels[14].setOnMouseClicked(event -> {
            mediaPlayers[14].setVolume(1);
            mediaPlayers[14].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[14].getStatus().toString().equals("PLAYING")) {
                timelines[14].pause();
                glows[14].setLevel(1.0);
                mediaPlayers[14].pause();
            }
            if (mediaPlayers[14].getStatus().toString().equals("PAUSED") || mediaPlayers[14].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 14 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[14].setEffect(glows[14]);
                glows[14].setLevel(0.0);
                timelines[14].play();
                mediaPlayers[14].play();
            }
        });

        notesLabels[15] = new Label(null, category4Melody40ImageView);
        notesLabels[15].setCursor(Cursor.HAND);
        notesLabels[15].setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 4 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 3 * category4Melody10ImageView.getFitWidth());
        notesLabels[15].setLayoutY(0.775 * Main.SCREEN_SIZE.getHeight());
        notesLabels[15].setOnMouseClicked(event -> {
            mediaPlayers[15].setVolume(1);
            mediaPlayers[15].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[15].getStatus().toString().equals("PLAYING")) {
                timelines[15].pause();
                glows[15].setLevel(1.0);
                mediaPlayers[15].pause();
            }
            if (mediaPlayers[15].getStatus().toString().equals("PAUSED") || mediaPlayers[15].getStatus().toString().equals("READY")) {
                for (int i = 0; i < 16; i++) {
                    if (i != 15 && mediaPlayers[i] != null && mediaPlayers[i].getStatus().toString().equals("PLAYING")) {
                        timelines[i].pause();
                        glows[i].setLevel(1.0);
                        mediaPlayers[i].pause();
                    }
                }
                notesLabels[15].setEffect(glows[15]);
                glows[15].setLevel(0.0);
                timelines[15].play();
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
                notesLabels[0], notesLabels[1], notesLabels[2], notesLabels[3],
                notesLabels[4], notesLabels[5], notesLabels[6], notesLabels[7],
                notesLabels[8], notesLabels[9], notesLabels[10], notesLabels[11],
                notesLabels[12], notesLabels[13], notesLabels[14], notesLabels[15], backLabel);
    }

    public Scene getScene() {
        return scene;
    }

    public void back() {//освобождение ресурсов
        for (int i = 0; i < 16; i++) {
            if (mediaPlayers[i] != null) {
                mediaPlayers[i].dispose();
                medias[i] = null;
                mediaPlayers[i] = null;
            }
        }
        for (int i = 0; i < 16; i++) {
            if (!notesLabels[i].isDisable()) {
                glows[i].setLevel(0.0);
                if (timelines[i].getStatus().toString().equals("RUNNING")) {
                    timelines[i].stop();
                }
            }
        }
        System.gc();
    }


    public void start() {//обновление всего
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories2.xml"), "UTF-8")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            categories = (Categories) unmarshaller.unmarshal(inputStreamReader);

            category1Label.setText(categories.getCategory1());
            category2Label.setText(categories.getCategory2());
            category3Label.setText(categories.getCategory3());
            category4Label.setText(categories.getCategory4());

            File category1Melody10File = new File("musics/tour2/category1/points10/10.mp3");
            if (category1Melody10File.exists()) {
                medias[0] = new Media(category1Melody10File.toURI().toString());
                mediaPlayers[0] = new MediaPlayer(medias[0]);
                notesLabels[0].setDisable(false);
            } else {
                medias[0] = null;
                mediaPlayers[0] = null;
                notesLabels[0].setDisable(true);
            }
            File category1Melody20File = new File("musics/tour2/category1/points20/20.mp3");
            if (category1Melody20File.exists()) {
                medias[1] = new Media(category1Melody20File.toURI().toString());
                mediaPlayers[1] = new MediaPlayer(medias[1]);
                notesLabels[1].setDisable(false);
            } else {
                medias[1] = null;
                mediaPlayers[1] = null;
                notesLabels[1].setDisable(true);
            }
            File category1Melody30File = new File("musics/tour2/category1/points30/30.mp3");
            if (category1Melody30File.exists()) {
                medias[2] = new Media(category1Melody30File.toURI().toString());
                mediaPlayers[2] = new MediaPlayer(medias[2]);
                notesLabels[2].setDisable(false);
            } else {
                medias[2] = null;
                mediaPlayers[2] = null;
                notesLabels[2].setDisable(true);
            }
            File category1Melody40File = new File("musics/tour2/category1/points40/40.mp3");
            if (category1Melody40File.exists()) {
                medias[3] = new Media(category1Melody40File.toURI().toString());
                mediaPlayers[3] = new MediaPlayer(medias[3]);
                notesLabels[3].setDisable(false);
            } else {
                medias[3] = null;
                mediaPlayers[3] = null;
                notesLabels[3].setDisable(true);
            }
            File category2Melody10File = new File("musics/tour2/category2/points10/10.mp3");
            if (category2Melody10File.exists()) {
                medias[4] = new Media(category2Melody10File.toURI().toString());
                mediaPlayers[4] = new MediaPlayer(medias[4]);
                notesLabels[4].setDisable(false);
            } else {
                medias[4] = null;
                mediaPlayers[4] = null;
                notesLabels[4].setDisable(true);
            }
            File category2Melody20File = new File("musics/tour2/category2/points20/20.mp3");
            if (category2Melody20File.exists()) {
                medias[5] = new Media(category2Melody20File.toURI().toString());
                mediaPlayers[5] = new MediaPlayer(medias[5]);
                notesLabels[5].setDisable(false);
            } else {
                medias[5] = null;
                mediaPlayers[5] = null;
                notesLabels[5].setDisable(true);
            }
            File category2Melody30File = new File("musics/tour2/category2/points30/30.mp3");
            if (category2Melody30File.exists()) {
                medias[6] = new Media(category2Melody30File.toURI().toString());
                mediaPlayers[6] = new MediaPlayer(medias[6]);
                notesLabels[6].setDisable(false);
            } else {
                medias[6] = null;
                mediaPlayers[6] = null;
                notesLabels[6].setDisable(true);
            }
            File category2Melody40File = new File("musics/tour2/category2/points40/40.mp3");
            if (category2Melody40File.exists()) {
                medias[7] = new Media(category2Melody40File.toURI().toString());
                mediaPlayers[7] = new MediaPlayer(medias[7]);
                notesLabels[7].setDisable(false);
            } else {
                medias[7] = null;
                mediaPlayers[7] = null;
                notesLabels[7].setDisable(true);
            }
            File category3Melody10File = new File("musics/tour2/category3/points10/10.mp3");
            if (category3Melody10File.exists()) {
                medias[8] = new Media(category3Melody10File.toURI().toString());
                mediaPlayers[8] = new MediaPlayer(medias[8]);
                notesLabels[8].setDisable(false);
            } else {
                medias[8] = null;
                mediaPlayers[8] = null;
                notesLabels[8].setDisable(true);
            }
            File category3Melody20File = new File("musics/tour2/category3/points20/20.mp3");
            if (category3Melody20File.exists()) {
                medias[9] = new Media(category3Melody20File.toURI().toString());
                mediaPlayers[9] = new MediaPlayer(medias[9]);
                notesLabels[9].setDisable(false);
            } else {
                medias[9] = null;
                mediaPlayers[9] = null;
                notesLabels[9].setDisable(true);
            }
            File category3Melody30File = new File("musics/tour2/category3/points30/30.mp3");
            if (category3Melody30File.exists()) {
                medias[10] = new Media(category3Melody30File.toURI().toString());
                mediaPlayers[10] = new MediaPlayer(medias[10]);
                notesLabels[10].setDisable(false);
            } else {
                medias[10] = null;
                mediaPlayers[10] = null;
                notesLabels[10].setDisable(true);
            }
            File category3Melody40File = new File("musics/tour2/category3/points40/40.mp3");
            if (category3Melody40File.exists()) {
                medias[11] = new Media(category3Melody40File.toURI().toString());
                mediaPlayers[11] = new MediaPlayer(medias[11]);
                notesLabels[11].setDisable(false);
            } else {
                medias[11] = null;
                mediaPlayers[11] = null;
                notesLabels[11].setDisable(true);
            }
            File category4Melody10File = new File("musics/tour2/category4/points10/10.mp3");
            if (category4Melody10File.exists()) {
                medias[12] = new Media(category4Melody10File.toURI().toString());
                mediaPlayers[12] = new MediaPlayer(medias[12]);
                notesLabels[12].setDisable(false);
            } else {
                medias[12] = null;
                mediaPlayers[12] = null;
                notesLabels[12].setDisable(true);
            }
            File category4Melody20File = new File("musics/tour2/category4/points20/20.mp3");
            if (category4Melody20File.exists()) {
                medias[13] = new Media(category4Melody20File.toURI().toString());
                mediaPlayers[13] = new MediaPlayer(medias[13]);
                notesLabels[13].setDisable(false);
            } else {
                medias[13] = null;
                mediaPlayers[13] = null;
                notesLabels[13].setDisable(true);
            }
            File category4Melody30File = new File("musics/tour2/category4/points30/30.mp3");
            if (category4Melody30File.exists()) {
                medias[14] = new Media(category4Melody30File.toURI().toString());
                mediaPlayers[14] = new MediaPlayer(medias[14]);
                notesLabels[14].setDisable(false);
            } else {
                medias[14] = null;
                mediaPlayers[14] = null;
                notesLabels[14].setDisable(true);
            }
            File category4Melody40File = new File("musics/tour2/category4/points40/40.mp3");
            if (category4Melody40File.exists()) {
                medias[15] = new Media(category4Melody40File.toURI().toString());
                mediaPlayers[15] = new MediaPlayer(medias[15]);
                notesLabels[15].setDisable(false);
            } else {
                medias[15] = null;
                mediaPlayers[15] = null;
                notesLabels[15].setDisable(true);
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public Label getBackLabel() {
        return backLabel;
    }
}
