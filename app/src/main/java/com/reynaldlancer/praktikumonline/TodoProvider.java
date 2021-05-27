package com.reynaldlancer.praktikumonline;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TodoProvider {
    Context ctx;
    SqlHelper sqlHelper ;

    public TodoProvider(Context ctx) {
        this.ctx = ctx;
        sqlHelper = new SqlHelper(ctx);
    }

    public ModelTodo insertData (String data){
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        db.execSQL("insert into todo values (NULL, '"+data+"')");
        db.close();
        SQLiteDatabase getDb = sqlHelper.getReadableDatabase();
        Cursor cursor = getDb.rawQuery("select * from todo", null);
        cursor.moveToLast();
        if (cursor.getCount()  >= 1){
            getDb.close();
            return new ModelTodo(cursor.getInt(0), cursor.getString(1));
        }else{
            getDb.close();
            return null;
        }

    }

    public ArrayList<ModelTodo> getData(){
        ArrayList<ModelTodo> modelTodos = new ArrayList<ModelTodo>();
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from todo", null);
        if (cursor.moveToFirst()){
            do {
                modelTodos.add(new ModelTodo(cursor.getInt(0), cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return  modelTodos;
    }

    public void deleteData(Integer ID){
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        db.execSQL("delete from todo where ID = '"+ID.toString()+"'");
        db.close();
    }

    public  void updataData(Integer ID, String data){
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        db.execSQL("update todo set todo = '"+data+"' where ID = '"+ID.toString()+"'");
        db.close();
    }

}
