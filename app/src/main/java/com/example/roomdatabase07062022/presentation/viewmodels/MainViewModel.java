package com.example.roomdatabase07062022.presentation.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;
import com.example.roomdatabase07062022.data.repositories.TodoRepository;

import java.util.List;

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
        todoListMutable.setValue(todoRepository.getToDoList().getValue());
    }

    public void queryPriorityList() {
        priorityListMutable.setValue(todoRepository.getPriority().getValue());
    }
}
