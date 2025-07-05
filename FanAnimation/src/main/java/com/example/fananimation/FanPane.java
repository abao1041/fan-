package com.example.fananimation;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FanPane extends BorderPane {
    private Circle circle;
    private Arc[] arcs;
    private double startAngle = 0;
    private double increment = -5;

    public FanPane() {
        circle = new Circle(200, 200, 150);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(heightProperty().divide(2));


        arcs = new Arc[3];
        for (int i = 0; i < 3; i++) {
            arcs[i] = new Arc();
            arcs[i].centerXProperty().bind(circle.centerXProperty());
            arcs[i].centerYProperty().bind(circle.centerYProperty());
            arcs[i].radiusXProperty().bind(circle.radiusProperty().divide(1.1));
            arcs[i].radiusYProperty().bind(circle.radiusProperty().divide(1.1));
            arcs[i].setStartAngle(90 + i * 120);
            arcs[i].setLength(60);
            arcs[i].setType(ArcType.ROUND);
            arcs[i].setFill(Color.RED);
        }

        setCenter(circle);
        getChildren().addAll(arcs);
    }

    public void move() {
        setStartAngle(startAngle + increment);
    }

    public void setStartAngle(double angle) {
        startAngle = angle % 360;  // 将角度限制在0到359之间
        for (int i = 0; i < 3; i++) {
            arcs[i].setStartAngle(startAngle + i * 120);
        }
    }

    private boolean clockwise = false;  // 默认为顺时针旋转
//向右转为正
    public void turn_right() {
        clockwise = true;
        if (increment<0) increment= -increment;
    }

    public void turn_left() {
        clockwise = false;
        if (increment>0) increment= -increment;
    }
    public void adjustSpeed(double speed) {
        if (clockwise) increment += speed;
        else increment -= speed;
    }
}