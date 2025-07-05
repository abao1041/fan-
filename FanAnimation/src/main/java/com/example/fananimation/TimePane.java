package com.example.fananimation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimePane extends StackPane {
    private Label timeLabel;
    private Timeline timeline;

    public TimePane() {
        createClock();
        startClock();
    }

    private void createClock() {
        Ellipse ellipse = new Ellipse(200, 50);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);

        timeLabel = new Label();
        timeLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 24));

        StackPane.setAlignment(timeLabel, Pos.CENTER); // 设置时间标签在椭圆的中央

        getChildren().addAll(ellipse, timeLabel);
    }

    private void startClock() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalDateTime currentTime = LocalDateTime.now();
            String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            timeLabel.setText(formattedTime);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void stopClock() {
        timeline.stop();
    }
}
