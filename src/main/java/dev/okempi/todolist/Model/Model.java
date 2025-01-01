package dev.okempi.todolist.Model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Model {
    final public String database = "java/dev/okempi/todolist/Model/dataBase.csv";

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

    // through UUID?
    public void remove_task(Task task) {
        tasks.remove(task);
        save_tasks();
    }

    public Task fetch_task(String uuid){
        for (int i = 0; i < tasks.size(); i++){
            String task_uuid = tasks.get(i).getUUID();
            if (task_uuid == uuid){
                return tasks.get(i);
            }
        }
        return null;
    }

    public int task_amount(){
        return tasks.size();
    }
}