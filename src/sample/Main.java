package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas canvas = new Canvas(300, 300);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setLineWidth(5);

        ArrayList<Unit> units = new ArrayList<>();
        int a = 20;
        for (int i = 20; i <= 560; i += 60) {
            if (a <= 360) {
                units.add(new Unit(i, a, Color.color(0, 0, 0)));
                if (i == 560) {
                    i = -40;
                    a += 60;
                }
            }
        }

        for (Unit unit: units) {
            gc.setStroke(unit.getColor());
            gc.strokeRect(unit.getX(), unit.getY(), 20, 20);
        }

        Group root = new Group();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
