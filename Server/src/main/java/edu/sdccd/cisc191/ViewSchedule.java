package edu.sdccd.cisc191;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//class that will set up the GUI
public class ViewSchedule extends Application
{
    private ScheduleLabel topMessage;
    private GridPane scheduleGrid;
    private ScheduleLabel bottomMessage;
    private Canvas editCanvas;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //basic setting up process

        topMessage = new ScheduleLabel();
        scheduleGrid = new GridPane();
        bottomMessage = new ScheduleLabel();
        editCanvas = new Canvas();

        topMessage.setPadding(new Insets(20));
        bottomMessage.setPadding(new Insets(20));

        topMessage.setText("Hello, this is your schedule!");
        bottomMessage.setText("Use these buttons to edit your schedule");

        // Create the BorderPane, HBox, and VBox
        BorderPane root = new BorderPane();
        HBox header = new HBox(topMessage);
        HBox footer = new HBox(bottomMessage);
        HBox bottom = new HBox(editCanvas);

        // Add buttons onto the canvas
        // We want something the screen to look like this
        //      Hello, this is your schedule!
        // _______________________________________
        // | [Science][Math]   [Science][Math]   |
        // | []       [English][]       [English]|
        // |_____________________________________|

        //loop through a nested loop with the same dimensions as the timetable 2d array
        //for each element in the array, make a corresponding button.
        for (int row=0; row < 5; row++)
        {
            for (int col=0; col < 5; col++)
            {
                ScheduleButton button = new ScheduleButton(row, col);
                button.setOnAction(e ->
                {
                    button.handleClick();
                });
                scheduleGrid.add(button, col, row);
            }
        }

        // Set up the screen
        Scene scene = new Scene(root);
        stage.setTitle("Class Schedule");
        stage.setScene(scene);
        root.setTop(header);
        root.setCenter(scheduleGrid);
        root.setBottom(footer);
        root.setBottom(bottom);
        stage.show();
    }
}