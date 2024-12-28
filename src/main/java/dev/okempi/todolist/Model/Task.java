package dev.okempi.todolist.Model;

import java.time.LocalDate;
import java.util.UUID;

public class Task {
    public String text = "";
    public LocalDate date = null;
    private String uuid = UUID.randomUUID().toString();

    public Task(LocalDate date, String text) {
        this.date = date;   
        this.text = text;
    }

    public Task(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Date: "+date.toString()+" Task:"+text;
    }

    public String toLine() {
        return date.toString()+","+text;
    }

    public static Task fromLine(String line){
        String[] parts = line.split(",");
        if (parts.length == 2){
            return new Task(LocalDate.parse(parts[0]),parts[1]);
        } else {
            System.out.println("Chyba nacitani ze souboru");                        
            return null;
        }
    }

    public String getUUID(){
        return uuid; 
    }
}
