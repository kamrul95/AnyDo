package com.example.mdkamrul.anydo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mdkamrul.anydo.Database.DatabaseHelper;
import com.example.mdkamrul.anydo.Model.TaskEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    ListView listViewTask;
    ArrayList<TaskEntry> arrayListTask;
    TaskAdapter adapter;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        db = new DatabaseHelper(MainActivity.this);
        arrayListTask = db.getAllTasks();
        adapter = new TaskAdapter(arrayListTask);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.fabAddTask);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addWorkActivity = new Intent(MainActivity.this,AddWorkActivity.class);
                startActivity(addWorkActivity);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.taskcomplete);
        actionBar.setDisplayUseLogoEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_appber,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
