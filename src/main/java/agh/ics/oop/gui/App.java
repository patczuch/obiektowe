package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw().toArray(new String[0]));
        AbstractWorldMap map = new GrassField(10, 1);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        gridPane.add(new Label ("y/x"), 0, 0);

        for (int y = 0; y <= map.getUpperRight().subtract(map.getLowerLeft()).y; y++) {
            gridPane.getRowConstraints().add(new RowConstraints(20));
            Label label = new Label(Integer.toString(y+ map.getLowerLeft().y));
            gridPane.add(label, 0, map.getUpperRight().subtract(map.getLowerLeft()).y - y+1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int x = 1; x <= map.getUpperRight().subtract(map.getLowerLeft()).x+1; x++)
        {
            gridPane.getColumnConstraints().add(new ColumnConstraints(20));
            Label label = new Label(Integer.toString(x + map.getLowerLeft().x-1));
            gridPane.add(label, x, 0);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        gridPane.getColumnConstraints().add(new ColumnConstraints(20));

        for (int y = 0; y <= map.getUpperRight().subtract(map.getLowerLeft()).y; y++) {
            for (int x = 0; x <= map.getUpperRight().subtract(map.getLowerLeft()).x; x++) {
                Vector2d objPos = new Vector2d(x + map.getLowerLeft().x,y + map.getLowerLeft().y);
                String text = map.objectAt(objPos) == null ? "" : map.objectAt(objPos).toString();
                Label label = new Label(text);
                gridPane.add(label, x+1, map.getUpperRight().subtract(map.getLowerLeft()).y - y+1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
        Scene scene = new Scene(gridPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
