package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        var canvas = new Canvas(300, 300);
        var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setLineWidth(5);

        var units = new ArrayList<Unit>();
        var a = 20;
        for (var i = 20; i <= 560; i += 60) {
            if (a <= 360) {
                units.add(new Unit(i, a, Color.color(0, 0, 0)));
                if (i == 560) {
                    i = -40;
                    a += 60;
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


    public static void main(String[] args) {
        launch(args);
    }
}
