package mytimeorganizer.controllers.timer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class TimerController implements Initializable {

    @FXML
    private Text textArea;

    private Timer timer;
    private DecimalFormat decimalFormat;
    private Font font;

    private int minutes;
    private int seconds;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCountdownTimer();
        decimalFormat = new DecimalFormat("00");
        minutes = 1;
        seconds = 0;
        font = new Font("Arial", 50);
    }

    public void setTimeAsText() {
        textArea.setText(
                decimalFormat.format(minutes) + ":" + decimalFormat.format(seconds)
        );
    }

    public void initCountdownTimer() {
        timer = new Timer(1000, e -> {
            setTimeAsText();
            if(seconds == -1) {
                seconds = 59;
                minutes--;
                setTimeAsText();
            }
            seconds--;
            if(minutes <= 0 && seconds <= 0) {
                setTimeAsText();
                timer.stop();
            }
        });
    }

    public void onStartTimerButton(javafx.event.ActionEvent actionEvent) {
        timer.start();
        textArea.setFont(font);
    }

    public void onStopTimerButton(javafx.event.ActionEvent actionEvent) {
        timer.stop();
    }

    public void onResetTimerButton(javafx.event.ActionEvent actionEvent) {
        timer.stop();
        minutes = 1;
        seconds = 0;
        setTimeAsText();
    }

    public void setTimerAtOneMinute(ActionEvent actionEvent) {
        minutes = 1;
        seconds = 0;
    }

    public void setTimerAtFiveMinute(ActionEvent actionEvent) {
        minutes = 5;
        seconds = 0;
    }

    public void setTimerAtTenMinutes(ActionEvent actionEvent) {
        minutes = 10;
        seconds = 0;
    }

    public void setTimerAtTwentyFiveMinutes(ActionEvent actionEvent) {
        minutes = 25;
        seconds = 0;
    }
}
