package com.example.fananimation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FanAnimation extends BorderPane {
    private FanPane fan;
    public Button btStartPause;
    private Button btLeft;
    private Button btRight;
    private Button btSpeedUp;
    private Button btSpeedDown;
    public Timeline animation;
    private Scene scene;

    public FanAnimation(FanPane fanpane) {
        fan = fanpane;
        //define the font of start and pause button

        btStartPause = new Button("▶");
        btStartPause.setPrefWidth(200);
        btStartPause.setPrefHeight(80);
        btStartPause.setStyle(
                "-fx-background-color: transparent;"+
                "-fx-text-fill: #000000; " +
                "-fx-font-family: 'Arial'; " +
                "-fx-font-size: 40px;"+
                "-fx-border-color: black; -fx-border-width: 2px;"
        );
        btStartPause.setOnMouseEntered(event -> {
            btStartPause.setStyle(
                    "-fx-cursor: hand;"+
                    "-fx-background-color: transparent;"+
                    "-fx-text-fill: #000000; " +
                    "-fx-font-family: 'Arial'; " +
                    "-fx-font-size: 20px;"+
                    "-fx-border-color: black; -fx-border-width: 2px;");
        });

        //define the font of left button
        btLeft = new Button("⬅");
        btLeft.setPrefWidth(200);
        btLeft.setPrefHeight(80);
        btLeft.setStyle(
                "-fx-background-color: transparent;"+
                "-fx-text-fill: #000000; " +
                "-fx-font-family: 'Arial'; " +
                "-fx-font-size: 20px;"
        );
        btLeft.setOnMouseEntered(event -> {
            btLeft.setStyle(
                    "-fx-background-color: transparent;"+
                    "-fx-text-fill: #000000; " +
                    "-fx-font-family: 'Arial'; " +
                    "-fx-font-size: 20px;");
        });

        btRight = new Button("➡");
        btRight.setPrefWidth(200);
        btRight.setPrefHeight(80);
        btRight.setStyle(
                "-fx-background-color: transparent;"+
                "-fx-text-fill: #000000; " +
                "-fx-font-family: 'Arial'; " +
                "-fx-font-size: 20px;"
        ); // 设置按钮的样式属性
        btRight.setOnMouseEntered(event -> {
            btRight.setStyle(
                    "-fx-background-color: transparent;"+
                    "-fx-text-fill: #000000; " +
                    "-fx-font-family: 'Arial'; " +
                    "-fx-font-size: 20px;");
        });

        btSpeedUp = new Button("⬆");
        btSpeedUp.setPrefWidth(200);
        btSpeedUp.setPrefHeight(50);
        btSpeedUp.setStyle(
                "-fx-background-color: transparent;"+
                "-fx-text-fill: #000000; " +
                "-fx-font-family: 'Arial'; " +
                "-fx-font-size: 20px;"
        );
        btSpeedUp.setOnMouseEntered(event -> {
            btSpeedUp.setStyle(
                    "-fx-background-color: transparent;"+
                    "-fx-text-fill: #000000; " +
                    "-fx-font-family: 'Arial'; " +
                    "-fx-font-size: 20px;");
        });

        btSpeedDown = new Button("⬇");
        btSpeedDown.setPrefWidth(200);
        btSpeedDown.setPrefHeight(50);
        btSpeedDown.setStyle(
                "-fx-background-color: transparent;"+
                "-fx-text-fill: #000000; " +
                "-fx-font-family: 'Arial'; " +
                "-fx-font-size: 20px;"
        );

        btStartPause.setOnAction(e -> {
            change();
        });
        fan.setOnMouseClicked(event -> {
            change();
        });
        btLeft.setOnAction(e -> {
            fan.turn_left();
        });

        btRight.setOnAction(e -> {
            fan.turn_right();
        });
        btSpeedUp.setOnAction(e -> {
            fan.adjustSpeed(10);
        });

        btSpeedDown.setOnAction(e -> {
            fan.adjustSpeed(-10);
        });
        BorderPane buttonsPane = new BorderPane();
        buttonsPane.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        buttonsPane.setCenter(btStartPause);
        buttonsPane.setLeft(btLeft);
        buttonsPane.setRight(btRight);
        buttonsPane.setTop(btSpeedUp);
        BorderPane.setAlignment(btSpeedUp, javafx.geometry.Pos.CENTER);
        buttonsPane.setBottom(btSpeedDown);
        BorderPane.setAlignment(btSpeedDown, javafx.geometry.Pos.CENTER);
        setBottom(buttonsPane);
        setCenter(fan);

        animation = new Timeline(new KeyFrame(Duration.millis(30), e -> fan.move()));
        animation.setCycleCount(Timeline.INDEFINITE);
    }
    private void change(){
        if (animation.getStatus() == Animation.Status.RUNNING) {
            animation.pause();
            btStartPause.setText("▶");
        } else {
            animation.play();
            btStartPause.setText("||");
        }
    }
}
