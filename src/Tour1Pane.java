import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

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

    public Tour1Pane() {
        tour1Pane = new Pane();
        //tour1Background = new ImageView(new Image("file:res\\images\\1366x768_Music-note-wallpaper-free-desktop-background-image.jpg"));
        tour1Scene = new Scene(tour1Pane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        tour1Scene.getStylesheets().add(Main.getResource("css/style.css"));
        tour1Category1 = new Label("Категория 1");
        tour1Category2 = new Label("Категория 2");
        tour1Category3 = new Label("Категория 3");
        tour1Category4 = new Label("Категория 4");
        getTour1Category1().setLayoutX(0);
        getTour1Category1().setLayoutY(70);
        tour1Pane.getChildren().addAll(/*tour1Background,*/getTour1Category1());
    }

    public Scene getTour1Scene() {
        return tour1Scene;
    }

    public Label getTour1Category1() {
        return tour1Category1;
    }

    public Label getTour1Category2() {
        return tour1Category2;
    }

    public Label getTour1Category3() {
        return tour1Category3;
    }

    public Label getTour1Category4() {
        return tour1Category4;
    }
}
