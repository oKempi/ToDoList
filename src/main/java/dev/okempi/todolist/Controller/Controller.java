package dev.okempi.todolist.Controller;

import dev.okempi.todolist.Model.Model;

public class Controller {
    final private Model model;
    final public String log = "C:\\Users\\Venia\\Documents\\shits\\Programovani\\java\\learning\\app\\ToDoList\\src\\main\\resources\\dev\\okempi\\todolist\\log.txt";

    public Controller(){
        this.model = new Model();
    }

    /*
    public String[] fetch(String task){
        String values = model.fetch_task(task);
        String[] test = values.split(",");
        if (test.length < 1 || test.length > 2){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(log, true))){
                bw.write("Values might be corrupted as the list holding them was either smaller than 1 or bigger than 2 (wanted length is 2)!");
            }
            catch (IOException e) {System.out.println(e);}
            System.exit(1);
            return new String[]{"none", "none"};
        }
        else {return test;}
    }

     */

    public void remove_task(int date, String task){
        return;
    }

    public void load_tasks(){ //there is not much more to do here...
        model.load_tasks();
    }

}
