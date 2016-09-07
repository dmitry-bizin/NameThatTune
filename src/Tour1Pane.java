import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;

/**
 * Created by Dmitriy on 17.02.2016.
 */
public class Tour1Pane {
    private Pane tour1Pane;
    //private ImageView tour1Background;
    private Scene tour1Scene;
    private Label tour1Category1;
    private Label tour1Category2;
    private Label tour1Category3;
    private Label tour1Category4;
    //TODO сделать back ещё!!!

    public Tour1Pane() {
        tour1Pane = new Pane();
        //tour1Background = new ImageView(new Image("file:res\\images\\1366x768_Music-note-wallpaper-free-desktop-background-image.jpg"));

        tour1Category1 = new Label("День Рождения");
        tour1Category1.setLayoutX(0);
        tour1Category1.setLayoutY(0);
        tour1Category1.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category1.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category1.setId("gameLabel");
        tour1Category1.setWrapText(true);
        tour1Category1.setLineSpacing(0);
        tour1Category1.setAlignment(Pos.CENTER);
        tour1Category1.setTextAlignment(TextAlignment.CENTER);

        tour1Category2 = new Label("Военные песни");
        tour1Category2.setLayoutX(0);
        tour1Category2.setLayoutY(Main.SCREEN_SIZE.height * 0.25);
        tour1Category2.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category2.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category2.setId("gameLabel");
        tour1Category2.setWrapText(true);
        tour1Category2.setLineSpacing(0);
        tour1Category2.setAlignment(Pos.CENTER);
        tour1Category2.setTextAlignment(TextAlignment.CENTER);

        tour1Category3 = new Label("Явления природы");
        tour1Category3.setLayoutX(0);
        tour1Category3.setLayoutY(Main.SCREEN_SIZE.height * 0.5);
        tour1Category3.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category3.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category3.setId("gameLabel");
        tour1Category3.setWrapText(true);
        tour1Category3.setLineSpacing(0);
        tour1Category3.setAlignment(Pos.CENTER);
        tour1Category3.setTextAlignment(TextAlignment.CENTER);

        tour1Category4 = new Label("Рок-хиты");
        tour1Category4.setLayoutX(0);
        tour1Category4.setLayoutY(Main.SCREEN_SIZE.height * 0.75);
        tour1Category4.setMaxSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category4.setMinSize(Main.SCREEN_SIZE.width * 0.3, Main.SCREEN_SIZE.height * 0.25);
        tour1Category4.setId("gameLabel");
        tour1Category4.setWrapText(true);
        tour1Category4.setLineSpacing(0);
        tour1Category4.setAlignment(Pos.CENTER);
        tour1Category4.setTextAlignment(TextAlignment.CENTER);

        tour1Scene = new Scene(tour1Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        tour1Scene.getStylesheets().add(Main.getResource("css/style.css"));
        tour1Pane.getChildren().addAll(/*tour1Background,*/tour1Category1, tour1Category2, tour1Category3, tour1Category4);
    }

    public Scene getTour1Scene() {
        return tour1Scene;
    }

}
