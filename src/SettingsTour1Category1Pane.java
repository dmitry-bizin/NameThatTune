import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;

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

    public SettingsTour1Category1Pane() {
        settingsTour1Category1Pane = new Pane();
        String text = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("settings/categories1.txt"))) {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        categoryTextField = new TextField();
        categoryTextField.setPromptText("Название категории");
        categoryTextField.setStyle("-fx-background-radius:10;-fx-border-radius:8;-fx-border-width:3pt;-fx-border-color:#cd853f;-fx-font-size:20pt; -fx-font-family:\"Segoe Print\";");
        categoryTextField.setText(text == null ? "" : text);
        categoryTextField.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        categoryTextField.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.01);
        saveCategoryButton = new Button("Сохранить");
        saveCategoryButton.setStyle("-fx-background-radius:10;-fx-border-radius:8;-fx-border-width:3pt;-fx-border-color:#cd853f;-fx-font-size:20pt; -fx-font-family:\"Segoe Print\";");
        saveCategoryButton.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.3);
        saveCategoryButton.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.01);
        saveCategoryButton.setOnMouseClicked(event -> {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("settings/categories1.txt"))) {
                String category1 = bufferedReader.readLine();
                String category2 = bufferedReader.readLine();
                String category3 = bufferedReader.readLine();
                String category4 = bufferedReader.readLine();
                bufferedReader.close();
                category1 = categoryTextField.getText().equals("") ? "Категория1" : categoryTextField.getText();
                category2 = category2 == null ? "Категория2" : category2;
                category3 = category3 == null ? "Категория3" : category3;
                category4 = category4 == null ? "Категория4" : category4;
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("settings/categories1.txt"))) {
                    bufferedWriter.write(category1 + "\n");
                    bufferedWriter.write(category2 + "\n");
                    bufferedWriter.write(category3 + "\n");
                    bufferedWriter.write(category4 + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        backLabel = new Label("Назад");
        getBackLabel().setCursor(Cursor.HAND);
        getBackLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.7);
        getBackLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.01);
        getBackLabel().setTextFill(Paint.valueOf("DARKBLUE"));
        getBackLabel().setFont(Main.font);
        fileChooser = new FileChooser();
        fileChooser.setTitle("Выбрать мелодию для загрузки");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aif"));
        openFileChooserButton = new Button("Выбрать");
        openFileChooserButton.setStyle("-fx-background-radius:10;-fx-border-radius:8;-fx-border-width:3pt;-fx-border-color:#cd853f;-fx-font-size:20pt; -fx-font-family:\"Segoe Print\";");
        openFileChooserButton.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.01);
        openFileChooserButton.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.2);
        openFileChooserButton.setOnMouseClicked(event -> {
            File points10 = new File("musics/tour1/category1/points10");
            File[] files = points10.listFiles();
            for (File file : files) {
                file.delete();
            }
            File music10 = fileChooser.showOpenDialog(getSettingsTour1Category1Scene().getWindow());
            try (FileInputStream fileInputStream = new FileInputStream(music10);
                 FileOutputStream fileOutputStream = new FileOutputStream("musics/tour1/category1/points10/" + music10.getName())) {
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
        settingsTour1Category1Pane.getChildren().addAll(categoryTextField, saveCategoryButton, getBackLabel(), openFileChooserButton, playButton, pauseButton, mediaView);
    }

    public Scene getSettingsTour1Category1Scene() {
        return settingsTour1Category1Scene;
    }

    public Label getBackLabel() {
        return backLabel;
    }

}
