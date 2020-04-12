package ca.bcit.todoapp;

import java.util.Date;

public class ToDo {

    String taskId;
    String task;
    String who;
    Date dueDate;
    Boolean done;

    public ToDo() {
    }

    public ToDo(String taskId, String task, String who, Date dueDate, Boolean done) {
        this.taskId = taskId;
        this.task = task;
        this.who = who;
        this.dueDate = dueDate;
        this.done = done;
    }


    public String getTaskId() { return taskId; }

    public String getTask() {
        return task;
    }

    public String getWho() {
        return who;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setTaskId(String taskId) { this.taskId = taskId;}

    public void setTask(String task) { this.task = task; }

    public void setWho(String who) {
        this.who = who;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
