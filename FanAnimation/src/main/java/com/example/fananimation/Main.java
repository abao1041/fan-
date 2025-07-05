package com.example.fananimation;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        FanPane fan = new FanPane();
        FanAnimation fanAnimation=new FanAnimation(fan);
        TimePane timePane = new TimePane();
        BorderPane buttonsPane = new BorderPane();
        buttonsPane.setCenter(fanAnimation);

        BorderPane pane = new BorderPane();
        pane.setTop(timePane);
        pane.setCenter(fan);
        pane.setBottom(buttonsPane);

        Scene scene = new Scene(pane, 800, 800);
        scene.getRoot().requestFocus();
        primaryStage.setTitle("Fan Animation");
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(30), e -> fan.move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    fan.adjustSpeed(10);
                    break;
                case DOWN:
                    fan.adjustSpeed(-10);
                    break;
                case ENTER:
                    if (fanAnimation.animation.getStatus() == Animation.Status.RUNNING) {
                        fanAnimation.animation.pause();
                        fanAnimation.btStartPause.setText("▶");
                    } else {
                        fanAnimation.animation.play();
                        fanAnimation.btStartPause.setText("||");
                    }
                    break;
                default:
                    break;
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}