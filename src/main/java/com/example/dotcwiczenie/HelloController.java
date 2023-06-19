package com.example.dotcwiczenie;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HelloController  {
    public Label lbX;
    public Label lbY;
    public Pane pnArea;

    private boolean dragged = false;
    public EventHandler<MouseEvent> myClickHandler;

    Rectangle rectangle;

//    public void handleMouseClicked(MouseEvent event) {
//        lbX.setText("!" + event.getX());
//        lbY.setText("!" + event.getY());
//    }

    public void handleMouse(MouseEvent event, boolean aClick) {
//        System.out.println("dragged: " + dragged);
//        String prefix = aClick ? "!" : "";
        String prefix = dragged ? (aClick ? "" : "@") : (aClick ? "!" : "*");
        lbX.setText(prefix + event.getX());
        lbY.setText(prefix + event.getY());
    }

    public void initialize() {
        pnArea.setOnMouseClicked(event -> handleMouse(event, true));
        pnArea.setOnMouseMoved(event -> handleMouse(event, false));

        pnArea.setOnDragDetected(event -> dragged = true);
        pnArea.setOnMouseDragged(event -> handleDrag(event));
//        pnArea.setOnKeyPressed(event -> handleKeyPressed(event));
        pnArea.setOnMouseReleased(event -> dragged = false);

        rectangle = new Rectangle(10, 10, Color.ALICEBLUE);
        pnArea.getChildren().add(rectangle);
        rectangle.setRotate(45);
        rectangle.setWidth(50);
        rectangle.setHeight(50);
    }

    public void stageResized(){
        pnArea.setClip(new Rectangle(pnArea.getWidth(), pnArea.getHeight()));
    }


    public void handleDrag(MouseEvent event) {
        lbX.setText("@" + event.getX());
        lbY.setText("@" + event.getY());
        rectangle.setX(event.getX());
        rectangle.setY(event.getY());
    }

    public void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) rectangle.setY(rectangle.getY() - 5);
        else if (event.getCode() == KeyCode.DOWN) rectangle.setY(rectangle.getY() + 5);
        else if (event.getCode() == KeyCode.LEFT) rectangle.setX(rectangle.getX() - 5);
        else if (event.getCode() == KeyCode.RIGHT) rectangle.setX(rectangle.getX() + 5);
    }
}


//        pnArea.setOnMouseClicked(event -> {
//            lbX.setText("#" + event.getX());
//            lbY.setText("#" + event.getY());
//        });

//    double w = pnArea.getWidth();
//    double h = pnArea.getHeight();