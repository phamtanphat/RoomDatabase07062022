package com.example.roomdatabase07062022.presentation.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;
import com.example.roomdatabase07062022.data.repositories.TodoRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by pphat on 8/18/2022.
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<List<ToDoEntity>> todoListMutable = new MutableLiveData<>();
    private MutableLiveData<List<PriorityEntity>> priorityListMutable = new MutableLiveData<>();
    private TodoRepository todoRepository;

    public MainViewModel(Context context) {
        todoRepository = new TodoRepository(context);
    }

    public LiveData<List<ToDoEntity>> getTodoListLiveData() {
        return todoListMutable;
    }

    public LiveData<List<PriorityEntity>> getPriorityEntityListLiveData() {
        return priorityListMutable;
    }

    public void queryTodoList() {
        todoRepository
                .getToDoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(toDoEntities -> todoListMutable.setValue(toDoEntities));

    }

    public void queryPriorityList() {
        todoRepository
                .getPriority()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(priorityEntities -> priorityListMutable.setValue(priorityEntities));
    }

    public void insertPriority(PriorityEntity priorityEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                todoRepository.insertPriority(priorityEntity);
            }
        }).start();
    }
}
