import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 17.02.2016.
 */
public class GamePane {
    private Pane gamePane;
    private Label tour1Label;
    private Label tour2Label;
    private Label tour3Label;
    private Label superGameLabel;
    private Label backLabel;
    private Scene gameScene;
    private ImageView gameBackground;

    public GamePane() {
        gameBackground = new ImageView(new Image(Main.getResource("images/play.jpg")));
        gameBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        gameBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        gameBackground.setSmooth(true);//сглаживание
        gamePane = new Pane();
        tour1Label = new Label("1 тур");
        getTour1Label().setCursor(Cursor.HAND);
        tour2Label = new Label("2 тур");
        getTour2Label().setCursor(Cursor.HAND);
        tour3Label = new Label("3 тур");
        getTour3Label().setCursor(Cursor.HAND);
        superGameLabel = new Label("Супер-игра");
        getSuperGameLabel().setCursor(Cursor.HAND);
        backLabel = new Label("Назад");
        getBackLabel().setCursor(Cursor.HAND);
        getTour1Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        getTour1Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        getTour1Label().setId("gamePaneLabel");
        getTour2Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        getTour2Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.2);
        getTour2Label().setId("gamePaneLabel");
        getTour3Label().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        getTour3Label().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        getTour3Label().setId("gamePaneLabel");
        getSuperGameLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        getSuperGameLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
        getSuperGameLabel().setId("gamePaneLabel");
        getBackLabel().setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        getBackLabel().setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        getBackLabel().setId("gamePaneLabel");
        gameScene = new Scene(gamePane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        gameScene.getStylesheets().add(Main.getResource("css/style.css"));
        gamePane.getChildren().addAll(gameBackground, getTour1Label(), getTour2Label(), getTour3Label(), getSuperGameLabel(), getBackLabel());
    }

    public Label getTour1Label() {
        return tour1Label;
    }

    public Label getTour2Label() {
        return tour2Label;
    }

    public Label getTour3Label() {
        return tour3Label;
    }

    public Label getSuperGameLabel() {
        return superGameLabel;
    }

    public Label getBackLabel() {
        return backLabel;
    }

    public Scene getGameScene() {
        return gameScene;
    }

}
