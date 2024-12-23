package dev.okempi.todolist.Model;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Model {
    final public String database = "C:\\Users\\Venia\\Documents\\shits\\Programovani\\java\\learning\\app\\ToDoList\\src\\main\\resources\\dev\\okempi\\todolist\\dataBase.csv";

    public ArrayList<String> tasks = new ArrayList<>();
    public ArrayList<Integer> dates = new ArrayList<>();


    public int save_tasks(int Date, String task){
        String line;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(database))){
            bw.write(dates.get(0) + "," + tasks.get(0));
            for (int i = 1; i < tasks.size(); i++){
                line = dates.get(i) + "," + tasks.get(i);
                bw.write(line);
            }
            return 1;
        }
        catch (FileNotFoundException e) {return 2;}
        catch (IOException e){return 0;}
    }
}
