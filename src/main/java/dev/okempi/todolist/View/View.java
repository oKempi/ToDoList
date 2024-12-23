package dev.okempi.todolist.View;

import dev.okempi.todolist.Controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class View extends Application {
    public final Controller controller;

    public View(){
        this.controller = new Controller();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    public static void main(String[] args){
        launch();
    }
}