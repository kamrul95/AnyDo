package com.example.mdkamrul.anydo.Database;

/**
 * Created by mdkamrul on 16-Jan-17.
 */

public class TableAttributes {
    public static final String TASKTABLENAME="addTask";
    public static final String TASK ="taskToDo";
    public static final String DATETOFINISHTASK="dateToFinishTask";

    public String createTaskTableQuery(){
        return "Create Table "+TASKTABLENAME+" (task_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
        TASK+" TEXT," +
                DATETOFINISHTASK+" TEXT)  ";
    }
}
