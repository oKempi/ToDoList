package dev.okempi.todolist.View;

import dev.okempi.todolist.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

        //root.getChildren().addAll();

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