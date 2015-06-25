package hu.cegnev.todolistapp;

import hu.cegnev.todolistapp.business.TodoLogic;
import hu.cegnev.todolistapp.model.Todo;
import org.joda.time.DateTime;

public class Main {
    public static void main(String args[]){
        TodoLogic todoLogic = new TodoLogic();
        todoLogic.add(new Todo(1,"","",new DateTime()));
        todoLogic.editTodo(new Todo(1,"title", "description", new DateTime()));
        System.out.println(todoLogic.getTodoById(1).toString());
    }
}
