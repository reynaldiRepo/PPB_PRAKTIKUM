package com.reynaldlancer.praktikumonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Modul5 extends AppCompatActivity {

    EditText inputTodo;
    Button SaveTodoBTN;
    RecyclerView RVtodo;
    ArrayList<ModelTodo> modelTodo;
    TodoProvider todoProvider;
    TodoRvAdapter todoRvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul5);
        inputTodo = findViewById(R.id.input_todo);
        SaveTodoBTN = findViewById(R.id.save_todo_btn);
        RVtodo = findViewById(R.id.todoRV);

        //init Model;
        todoProvider = new TodoProvider(this);
        modelTodo = todoProvider.getData();

        //init RV
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RVtodo.setLayoutManager(linearLayoutManager);
        RVtodo.setItemAnimator(new DefaultItemAnimator());
        todoRvAdapter = new TodoRvAdapter(modelTodo, this);
        RVtodo.setAdapter(todoRvAdapter);

        SaveTodoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputTodo.getText().toString() != ""){
                    insertData(inputTodo.getText().toString());
                }else{
                    Toast.makeText(Modul5.this, "Input Kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void insertData(String data){
        ModelTodo newData = todoProvider.insertData(data);
        todoRvAdapter.modelTodos.add(newData);
        todoRvAdapter.notifyItemInserted(todoRvAdapter.modelTodos.size());
    }
}
