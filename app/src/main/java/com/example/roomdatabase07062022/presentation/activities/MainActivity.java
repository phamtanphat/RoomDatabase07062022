package com.example.roomdatabase07062022.presentation.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.roomdatabase07062022.R;
import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;
import com.example.roomdatabase07062022.data.model.PriorityEnum;
import com.example.roomdatabase07062022.data.repositories.TodoRepository;
import com.example.roomdatabase07062022.presentation.viewmodels.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(MainActivity.this);
            }
        }).get(MainViewModel.class);

        mainViewModel.getPriorityEntityListLiveData().observe(this, new Observer<List<PriorityEntity>>() {
            @Override
            public void onChanged(List<PriorityEntity> priorityEntities) {
                if (priorityEntities != null && priorityEntities.size() > 0) {
                    for (PriorityEntity element: priorityEntities) {
                        Log.d("BBB", element.toString());
                    }
                }
            }
        });

        mainViewModel.getTodoListLiveData().observe(this, new Observer<List<ToDoEntity>>() {
            @Override
            public void onChanged(List<ToDoEntity> toDoEntities) {
                if (toDoEntities != null && toDoEntities.size() > 0) {
                    for (ToDoEntity element: toDoEntities) {
                        Log.d("BBB", element.toString());
                    }
                }
            }
        });

        mainViewModel.queryTodoList();
        mainViewModel.queryPriorityList();

        mainViewModel.insertPriority(new PriorityEntity(PriorityEnum.HIGH));
    }
}
