package service;
import com.src.model.Status;
import com.src.model.Task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ToDoServices {
    private Queue<Task> dueTask;
    private Stack<Task>  completedTask;

    public ToDoServices() {
        this.dueTask  = new LinkedList<Task>();;
        this.completedTask = new Stack<Task>();
    }

    public void addNewTask(Task task){
        dueTask.offer(task);
        System.out.println("Task Added Successfully");
    }
    public void processTasks(){
        while(!dueTask.isEmpty()){
            Task task=dueTask.poll();;
            task.setStatus(Status.Completed);
            completedTask.add(task);
            System.out.println(task+"  Processed Successfully!!");

        }
    }
    public void displayTasks(){
        System.out.println("The Completed Tasks Are");
        for(int i=0;i<completedTask.size();i++){
            System.out.println("Task "+(i+1)+" =" +completedTask.elementAt(i));
        }
    }
}
