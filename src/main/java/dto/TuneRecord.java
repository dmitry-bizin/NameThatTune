package dto;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TuneRecord {

    public TextField titleTextField;
    public TextField authorTextField;
    public Button playButton;
    public Button pauseButton;

    public TuneRecord(TextField titleTextField, TextField authorTextField, Button playButton, Button pauseButton) {
        this.titleTextField = titleTextField;
        this.authorTextField = authorTextField;
        this.playButton = playButton;
        this.pauseButton = pauseButton;
    }

}
