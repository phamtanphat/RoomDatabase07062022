package com.example.roomdatabase07062022.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase07062022.data.local.ToDoDao;
import com.example.roomdatabase07062022.data.local.ToDoDatabase;
import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;
import com.example.roomdatabase07062022.data.local.entities.TodoAndPriorityEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * Created by pphat on 8/18/2022.
 */
public class TodoRepository {
    private ToDoDao toDoDao;

    public TodoRepository(Context context){
        toDoDao = ToDoDatabase.getInstance(context).getTodoDao();
    }

    public Observable<List<ToDoEntity>> getToDoList() {
        return toDoDao.getTodoList();
    }

    public Observable<List<PriorityEntity>> getPriority() {
        return toDoDao.getPriority();
    }

    public Single<Long> insertTodo(ToDoEntity toDoEntity) {
        return toDoDao.insertTodo(toDoEntity);
    }

    public Single<Long> insertPriority(PriorityEntity priorityEntity) {
        return toDoDao.insertPriority(priorityEntity);
    }
    public Observable<List<TodoAndPriorityEntity>> getTodoAndPriority() {
        return toDoDao.getTodoAndPriority();
    }
}
