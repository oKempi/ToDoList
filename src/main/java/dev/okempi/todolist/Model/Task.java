package dev.okempi.todolist.Model;

import java.time.LocalDate;
import java.util.UUID;

public class Task {
    public String text = "";
    public LocalDate date = null;
    private UUID uuid = UUID.randomUUID();

    public Task(String text){
        this.text = text;
    }

    public Task(String text, LocalDate date){
        this.text = text;
        this.date = date;
    }

    public String getUUID(){
        return uuid.toString();
    }

    @Override
    public String toString(){
        return "Date: " + date.toString() + " text: " + text;
    }

    public String toLine(){
        return date.toString() + "," + text;
    }

    public static Task fromLine(String line){
        String[] parts = line.split(",");
        if (parts.length == 2){
            return new Task(parts[0], LocalDate.parse(parts[1]));
        }
        else {
            System.out.println("Error");
            return null;
        }
    }
}
