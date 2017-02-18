package com.example.mdkamrul.anydo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import com.example.mdkamrul.anydo.Database.DatabaseHelper;
import com.example.mdkamrul.anydo.Model.TaskEntry;

public class AddWorkActivity extends AppCompatActivity {

    EditText editTextTask;
    EditText edtiTextDate;
    DatabaseHelper db;


    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.action_done:
                String taskDescription = editTextTask.getText().toString();
                String dateToFinishTask = edtiTextDate.getText().toString();

                TaskEntry taskEntry = new TaskEntry();
                taskEntry.setTask(taskDescription);
                taskEntry.setDateToFinish(dateToFinishTask);
                db.addTask(taskEntry);
                Intent intent = new Intent(AddWorkActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            case android.R.id.home:
                Intent intentMainActivity = new Intent(AddWorkActivity.this,MainActivity.class);
                startActivity(intentMainActivity);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);
        datePickerWork();
        editTextTask = (EditText)findViewById(R.id.editTextTask);
        edtiTextDate = (EditText)findViewById(R.id.editTextDate);
        db = new DatabaseHelper(AddWorkActivity.this);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }



    public void datePickerWork(){
        final java.util.Calendar calendar = java.util.Calendar.getInstance();
        final int year = calendar.get(java.util.Calendar.YEAR);
        final int month = calendar.get(java.util.Calendar.MONTH);
        final int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);

        final EditText editTextDate = (EditText) findViewById(R.id.editTextDate);


        editTextDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog datePicker = new DatePickerDialog(AddWorkActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editTextDate.setText(year+"-"+ month +"-"+dayOfMonth);
                    }
                },year,month,day);
                datePicker.setTitle("Select a Date");
                datePicker.show();
            }
        });
    }
}
