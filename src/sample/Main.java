package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        var color = -1;
        var canvas = new Canvas(600, 600);
        var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setLineWidth(5);

        var units = new ArrayList<Unit>();
        var distanceFromTop = 20;
        for (var distanceFromLeft = 20; distanceFromLeft <= 560; distanceFromLeft += 60) {
            if (distanceFromTop <= 560) {
                color += 1;
                var unitColor = getColor(color);

                units.add(new Unit(distanceFromLeft, distanceFromTop, unitColor));
                if (distanceFromLeft == 560) {
                    distanceFromLeft = -40;
                    distanceFromTop += 60;
                    color = -1;
                }
            }
        }

        for (var unit: units) {
            gc.setStroke(unit.getColor());
            gc.strokeRect(unit.getX(), unit.getY(), 20, 20);
        }

        var root = new Group();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    private Color getColor(int index) {
        var blue = 0.0;
        var green = 0.0;
        var red = 0.0;
        if (index == 0){
            red = 1;
            green = 1;
            blue = 1;
        }
        if (index == 1){
            red = 1;
            green = 0;
            blue = 0;
        }
        if (index == 2){
            red = 0;
            green = 1;
            blue = 0;
        }
        if (index == 3){
            red = 0;
            green = 0;
            blue = 1;
        }
        if (index == 4){
            red = 0;
            green = 0;
            blue = 0;
        }
        if (index == 5){
            red = 0.5;
            green = 1;
            blue = 0.04;
        }
        if (index == 6){
            red = 0.07;
            green = 1;
            blue = 0.35;
        }
        if (index == 7){
            red = 0;
            green = 0.41;
            blue = 0.72;
        }
        if (index == 8){
            red = 1;
            green = 0.28;
            blue = 0.5;
        }
        if (index == 9){
            red = 0;
            green = 0.51;
            blue = 0.76;
        }

        Color unitColor = Color.color(red, green, blue);
        return unitColor;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
