package dev.okempi.todolist.Controller;

import dev.okempi.todolist.Model.Model;

import java.io.*;
import java.time.LocalDate;

public class Controller {
    final private Model model;
    final public String log = "dataBase.csv";


    public Controller(){
        this.model = new Model();
    }

    public void remove_task(int date, String task){
        return;
    }

    public void load_tasks(){ //there is not much more to do here...
        model.load_tasks();
    }

    public int task_amount(){
        return model.task_amount();
    }

    public void add_task(LocalDate date, String content){
        if (content == null){
            return;
        }
        model.add_task(date, content);
    }

}
