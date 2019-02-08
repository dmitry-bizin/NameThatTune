package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class SuperGameController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private Label timerLabel;

    private Timeline timeline;
    private double seconds = 30d;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void click(MouseEvent mouseEvent) {
        if (timeline != null) {
            if (timeline.getStatus().equals(Animation.Status.RUNNING)) {
                timeline.pause();
            } else if (timeline.getStatus().equals(Animation.Status.PAUSED)) {
                timeline.play();
            }
        } else {
            timerLabel.setText(String.format(Locale.ENGLISH, "%.1f", seconds));
            timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(100),
                            event -> {
                                seconds -= 0.1;
                                timerLabel.setText(String.format(Locale.ENGLISH, "%.1f", Math.abs(seconds)));
                                if (Math.abs(seconds - 0) <= 1e-6) {
                                    timeline.stop();
                                }
                            }));
            timeline.playFromStart();
        }
    }

}
