package dev.okempi.todolist.Model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Model {
    final public String database = "src/main/java/dev/okempi/todolist/Model/dataBase.csv";

    public ArrayList<Task> tasks = new ArrayList<>();

    public void save_tasks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(database))) {
            for (int i = 0; i < tasks.size(); i++) {
                bw.write(tasks.get(i).toLine() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void load_tasks() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            while ((line = br.readLine()) != null) {
                tasks.add(Task.fromLine(line));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void add_task(LocalDate date, String text) {
        tasks.add(new Task(text, date));
        save_tasks();
    }

    public void remove_task(String text) {
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).toLine().equals(text)){
                tasks.remove(tasks.get(i));
                save_tasks();
            }
        }
    }

    public String fetch_task(String uuid){
        for (int i = 0; i < tasks.size(); i++){
            String task_uuid = tasks.get(i).getUUID();
            if (task_uuid == uuid){
                return tasks.get(i).toLine();
            }
        }
        return "null";
    }

    public String fetch_task(int pos){
        if (tasks.get(pos) != null){
            return tasks.get(pos).toLine();
        }
        return null;
    }

    public int task_amount(){
        return tasks.size();
    }
}