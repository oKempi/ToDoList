package dev.okempi.todolist.View;

import dev.okempi.todolist.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class View extends Application {
    public final Controller controller;

    public View(){
        this.controller = new Controller();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //initialization
        controller.load_tasks();

        //graphic part
        VBox root = new VBox(20);
        HBox funcs = new HBox(20);

        Label label = new Label("You have " + controller.task_amount() + " tasks");

        TextField txtField = new TextField();
        txtField.setPromptText("Your task");
        DatePicker date = new DatePicker();
        Button addTask = new Button("Add task!");


        // logic
        addTask.setOnAction(actionEvent -> {
            String content = txtField.getText();
            if (content != null){
                controller.add_task(date.getValue(), content);
                label.setText("You have " + controller.task_amount() + " tasks");
            }
        });


        funcs.getChildren().addAll(txtField, date, addTask);
        root.getChildren().addAll(label, funcs);

        //some part
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("To-Do list");
        stage.setScene(scene);
        stage.show();
    }

    //launch
    public static void main(String[] args){
        launch();
    }
}