import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
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
    private ImageView category1Melody10ImageView;
    private ImageView category1Melody20ImageView;
    private ImageView category1Melody30ImageView;
    private ImageView category1Melody40ImageView;
    private Label backLabel;
    private ImageView backImageView;
    private Categories categories;
    private Media[] medias;
    private MediaPlayer[] mediaPlayers;

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

        category1Melody20ImageView = new ImageView(Main.getPathToResource("images/notes/green.png"));
        category1Melody20ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category1Melody20ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category1Melody30ImageView = new ImageView(Main.getPathToResource("images/notes/red.png"));
        category1Melody30ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category1Melody30ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

        category1Melody40ImageView = new ImageView(Main.getPathToResource("images/notes/yellow.png"));
        category1Melody40ImageView.setFitWidth(0.2 * Main.SCREEN_SIZE.getHeight());
        category1Melody40ImageView.setFitHeight(0.2 * Main.SCREEN_SIZE.getHeight());

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

        //(0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 - промежуток между нотами
        category1Melody10Label = new Label(null, category1Melody10ImageView);
        category1Melody10Label.setCursor(Cursor.HAND);
        category1Melody10Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5);
        category1Melody10Label.setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        category1Melody10Label.setOnMouseClicked(event -> {
            category1Melody10Label.setOpacity(0.7);
            mediaPlayers[0].setVolume(1);
            mediaPlayers[0].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[0].getStatus().toString().equals("PLAYING")) {
                mediaPlayers[0].pause();
            }
            if (mediaPlayers[0].getStatus().toString().equals("PAUSED") || mediaPlayers[0].getStatus().toString().equals("READY")) {
                mediaPlayers[0].play();
            }
        });

        category1Melody20Label = new Label(null, category1Melody20ImageView);
        category1Melody20Label.setCursor(Cursor.HAND);
        category1Melody20Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 2 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + category1Melody10ImageView.getFitWidth());
        category1Melody20Label.setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        category1Melody20Label.setOnMouseClicked(event -> {
            category1Melody20Label.setOpacity(0.7);
            mediaPlayers[1].setVolume(1);
            mediaPlayers[1].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[1].getStatus().toString().equals("PLAYING")) {
                mediaPlayers[1].pause();
            }
            if (mediaPlayers[1].getStatus().toString().equals("PAUSED") || mediaPlayers[1].getStatus().toString().equals("READY")) {
                mediaPlayers[1].play();
            }
        });

        category1Melody30Label = new Label(null, category1Melody30ImageView);
        category1Melody30Label.setCursor(Cursor.HAND);
        category1Melody30Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 3 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 2 * category1Melody10ImageView.getFitWidth());
        category1Melody30Label.setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        category1Melody30Label.setOnMouseClicked(event -> {
            category1Melody30Label.setOpacity(0.7);
            mediaPlayers[2].setVolume(1);
            mediaPlayers[2].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[2].getStatus().toString().equals("PLAYING")) {
                mediaPlayers[2].pause();
            }
            if (mediaPlayers[2].getStatus().toString().equals("PAUSED") || mediaPlayers[2].getStatus().toString().equals("READY")) {
                mediaPlayers[2].play();
            }
        });

        category1Melody40Label = new Label(null, category1Melody40ImageView);
        category1Melody40Label.setCursor(Cursor.HAND);
        category1Melody40Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3 + 4 * (0.7 * Main.SCREEN_SIZE.getWidth() - 0.8 * Main.SCREEN_SIZE.getHeight()) / 5 + 3 * category1Melody10ImageView.getFitWidth());
        category1Melody40Label.setLayoutY(0.025 * Main.SCREEN_SIZE.getHeight());
        category1Melody40Label.setOnMouseClicked(event -> {
            category1Melody40Label.setOpacity(0.7);
            mediaPlayers[3].setVolume(1);
            mediaPlayers[3].setCycleCount(Integer.MAX_VALUE);
            if (mediaPlayers[3].getStatus().toString().equals("PLAYING")) {
                mediaPlayers[3].pause();
            }
            if (mediaPlayers[3].getStatus().toString().equals("PAUSED") || mediaPlayers[3].getStatus().toString().equals("READY")) {
                mediaPlayers[3].play();
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
                category1Melody10Label, category1Melody20Label, category1Melody30Label, category1Melody40Label, backLabel);
    }

    public Scene getTour1Scene() {
        return tour1Scene;
    }

    public void back() {//освобождение ресурсов
        medias[0] = null;
        medias[1] = null;
        medias[2] = null;
        medias[3] = null;
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

        category1Melody10Label.setOpacity(1);
        category1Melody20Label.setOpacity(1);
        category1Melody30Label.setOpacity(1);
        category1Melody40Label.setOpacity(1);
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
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public Label getBackLabel() {
        return backLabel;
    }
}
