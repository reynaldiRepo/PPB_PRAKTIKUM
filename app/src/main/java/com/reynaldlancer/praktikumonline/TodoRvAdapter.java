package com.reynaldlancer.praktikumonline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoRvAdapter extends RecyclerView.Adapter<TodoRvAdapter.ViewHolder> {
    ArrayList<ModelTodo> modelTodos;
    Context ctx;


    public TodoRvAdapter(ArrayList<ModelTodo> modelTodos, Context ctx) {
        this.modelTodos = modelTodos;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public TodoRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.todo_rv, parent, false);
        return new TodoRvAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final TodoRvAdapter.ViewHolder holder, final int position) {
        final TodoProvider todoProvider = new TodoProvider(ctx);
        final ModelTodo modelTodo = modelTodos.get(position);
        holder.ID = modelTodo.getID();
        holder.data_todo.setText(modelTodo.getTodo());
        holder.delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoProvider.deleteData(holder.ID);
                Toast.makeText(ctx, "Data Deleted", Toast.LENGTH_SHORT).show();
                modelTodos.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(ctx, "Data Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        holder.update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoProvider.updataData(holder.ID, holder.data_todo.getText().toString());
                Toast.makeText(ctx, "Data Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelTodos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Integer ID;
        EditText data_todo;
        Button update_btn, delete_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            data_todo = itemView.findViewById(R.id.data_todo_ET);
            update_btn = itemView.findViewById(R.id.update_todo);
            delete_btn = itemView.findViewById(R.id.delete_todo);
            ID = null;
        }
    }
}
