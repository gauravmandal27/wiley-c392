package main;

import com.src.model.Task;
import com.src.service.ToDoServices;

public class ToDo {
    public static void main(String[] args) {
        ToDoServices service = new ToDoServices();

        //Add sample Tasks
        service.addNewTask(new Task("Clean Room",12));
        service.addNewTask(new Task("Clean Bike",11));
        service.addNewTask(new Task("Buy Groceries",2));
        service.addNewTask(new Task("Make Food",1));
        service.addNewTask(new Task("Sleep",2));

        //process Tasks
        service.processTasks();

        //display completed tasks
        service.displayTasks();
    }
}