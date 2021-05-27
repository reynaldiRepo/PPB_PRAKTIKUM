package com.reynaldlancer.praktikumonline;

public class ModelTodo {

    public  Integer ID;
    public String todo;

    public ModelTodo(Integer ID, String todo) {
        this.ID = ID;
        this.todo = todo;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
