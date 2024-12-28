package dev.okempi.todolist.Model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Model {
    final public String database = "C:\\Users\\Venia\\Documents\\shits\\Programovani\\java\\learning\\app\\ToDoList\\src\\main\\resources\\dev\\okempi\\todolist\\dataBase.csv";

    // public ArrayList<String> tasks = new ArrayList<>();
    // public ArrayList<Integer> dates = new ArrayList<>();

    public ArrayList<Task> tasks = new ArrayList<>();

// methods
    public void load_tasks(){
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(database))){
            while ((line = br.readLine()) != null){
                tasks.add(Task.fromLine(line));
            }
        }
        catch (IOException e){System.out.println(e);}
    }

    public void save_tasks(){  //void / int
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(database))){
            for (int i = 0; i < tasks.size(); i++){
                bw.write(tasks.get(i).toLine()+"\n");
            }
        }
        catch (IOException e){System.out.println(e);}
    }

    public void remove_task(String uuid){
        for (int i=0;i<tasks.size();i++){
            if (tasks.get(i).getUUID()==uuid){
                tasks.remove(i);
                break;
            }
        }
    }

    public void add_task(LocalDate date, String text){
        tasks.add(new Task(date,text));
        save_tasks();
    }

    /* 
        public String fetch_task(String task){
            //I am truly sorry to whoever has to read this horrendous thing...
            return tasks.get(tasks.indexOf(task)) + "," + dates.get(dates.indexOf(tasks.indexOf(task)));
        }
    */
}
