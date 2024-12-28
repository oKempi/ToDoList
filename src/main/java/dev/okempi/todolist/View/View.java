package dev.okempi.todolist.View;

import dev.okempi.todolist.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dev.okempi.todolist.Model.Model;
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
        /*
        Model model = new Model();
        model.load_tasks();
        model.add_task(LocalDate.now(), "Test task 1");
        model = null;
        model = new Model();
        model.load_tasks();
        model.add_task(LocalDate.now(), "Test task 2");
        for (int i = 0; i < model.tasks.size(); i++){
            System.out.println(model.tasks.get(i).toString());
        }
    */
    }
}