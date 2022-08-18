package com.example.roomdatabase07062022.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase07062022.data.local.ToDoDao;
import com.example.roomdatabase07062022.data.local.ToDoDatabase;
import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;

import java.util.List;

/**
 * Created by pphat on 8/18/2022.
 */
public class TodoRepository {
    private ToDoDao toDoDao;

    public TodoRepository(Context context){
        toDoDao = ToDoDatabase.getInstance(context).getTodoDao();
    }

    LiveData<List<ToDoEntity>> getToDoList() {
        return toDoDao.getTodoList();
    }

    LiveData<List<PriorityEntity>> getPriority() {
        return toDoDao.getPriority();
    }

    LiveData<Long> insertTodo(ToDoEntity toDoEntity) {
        return toDoDao.insertTodo(toDoEntity);
    }

    LiveData<Long> insertPriority(PriorityEntity priorityEntity) {
        return toDoDao.insertPriority(priorityEntity);
    }
}
