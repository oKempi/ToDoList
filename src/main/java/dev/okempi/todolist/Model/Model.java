package dev.okempi.todolist.Model;

import java.io.*;
import java.util.ArrayList;

public class Model {
    final public String database = "C:\\Users\\Venia\\Documents\\shits\\Programovani\\java\\learning\\app\\ToDoList\\src\\main\\resources\\dev\\okempi\\todolist\\dataBase.csv";

    public ArrayList<String> tasks = new ArrayList<>();
    public ArrayList<Integer> dates = new ArrayList<>();


// methods
    public void load_tasks(){
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(database))){
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                dates.add(Integer.parseInt(parts[0]));
                tasks.add(parts[1]);
            }
        }
        catch (IOException e){System.out.println(e);}
    }

    public void save_tasks(){  //void / int
        String line;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(database))){
            bw.write(dates.get(0) + "," + tasks.get(0));
            for (int i = 1; i < tasks.size(); i++){
                line = "\n" + dates.get(i) + "," + tasks.get(i);
                bw.write(line);
            }
        }
        catch (IOException e){System.out.println(e);}
    }

    public void remove_task(String task){
        int pos = tasks.indexOf(task);
        tasks.remove(tasks.get(pos));
        dates.remove(dates.get(pos));
    }

    public void add_task(int Date, String task){
        dates.add(Date);
        tasks.add(task);
        save_tasks();
    }

    public String fetch_task(String task){
        //I am truly sorry to whoever has to read this horrendous thing...
        return tasks.get(tasks.indexOf(task)) + "," + dates.get(dates.indexOf(tasks.indexOf(task)));
    }
}
