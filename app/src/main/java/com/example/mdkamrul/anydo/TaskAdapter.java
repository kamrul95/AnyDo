package com.example.mdkamrul.anydo;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mdkamrul.anydo.Model.TaskEntry;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.mdkamrul.anydo.R.id.textViewTaskDetailes;

/**
 * Created by mdkamrul on 19-Feb-17.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
    List<TaskEntry> tasks;
    public TaskAdapter(List<TaskEntry> tasks) {
        this.tasks = tasks;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_card_view,parent,false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textViewTaskDetailes.setText(tasks.get(position).getTask());
        holder.textViewTaskToFinishDate.setText(tasks.get(position).getDateToFinish());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textViewTaskDetailes;
        TextView textViewTaskToFinishDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            textViewTaskDetailes = (TextView)itemView.findViewById(R.id.textViewTaskDetailes);
            textViewTaskToFinishDate = (TextView)itemView.findViewById(R.id.textViewTaskTofinishDate);
        }
    }
}
