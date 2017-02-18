package com.example.mdkamrul.anydo.Database;

import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mdkamrul.anydo.Model.TaskEntry;

import java.util.ArrayList;

import static android.R.attr.theme;
import static android.R.attr.version;

/**
 * Created by mdkamrul on 16-Jan-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DatabaseName = "anyDo.db";
    public DatabaseHelper(Context context) {
        super(context, DatabaseName, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        TableAttributes tableAttributes = new TableAttributes();
        String addTaskQuery = tableAttributes.createTaskTableQuery();
        try {
            db.execSQL(addTaskQuery);
            Log.i("Create: ","Task Table Created");
        }catch (SQLiteException e){
            Log.i("Error table create : ",e.toString());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<TaskEntry> getAllTasks(){
        ArrayList<TaskEntry> taskList = new ArrayList<TaskEntry>();
        SQLiteDatabase fetchAllTask = this.getReadableDatabase();
        String allTask="";
        try {
            allTask = "Select * From " +TableAttributes.TASKTABLENAME;
            Log.i("Get_Task: ","Task Found");
        }catch (Exception e){
            Log.i("Task_error: ",e.toString());
        }

        Cursor cursor = fetchAllTask.rawQuery(allTask,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            TaskEntry task = new TaskEntry();
            task.setTask(cursor.getString(cursor.getColumnIndex(TableAttributes.TASK)));
            task.setDateToFinish(cursor.getString(cursor.getColumnIndex(TableAttributes.DATETOFINISHTASK)));
            taskList.add(task);
            cursor.moveToNext();
        }
        return taskList;
    }

    public void addTask (TaskEntry task){
        SQLiteDatabase insertTask = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableAttributes.TASK,task.getTask());
        values.put(TableAttributes.DATETOFINISHTASK,task.getDateToFinish());
        try {
            insertTask.insert(TableAttributes.TASKTABLENAME,null,values);
            Log.i("Insert task: ","Task Inserted");
        }catch (SQLiteException e){
            Log.i("Error Insert: ",e.toString());
        }

    }

}
