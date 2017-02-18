package com.example.mdkamrul.anydo.Model;

/**
 * Created by mdkamrul on 16-Jan-17.
 */

public class TaskEntry {


    @Override
    public String toString() {
        return
                task + "\n" +
                dateToFinish + "\n";
    }

    private String task;
    private String dateToFinish;

    public String getDateToFinish() {
        return dateToFinish;
    }

    public void setDateToFinish(String dateToFinish) {
        this.dateToFinish = dateToFinish;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }



}
