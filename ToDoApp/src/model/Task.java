package model;

public class Task {
    private String taskDescription;
    private int duration;
    private Status status=Status.Pending;

    public Task(String taskDescription,int duration) {
        this.duration = duration;
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskDescription='" + taskDescription + '\'' +
                ", duration=" + duration +
                ", status=" + status +
                '}';
    }
}
