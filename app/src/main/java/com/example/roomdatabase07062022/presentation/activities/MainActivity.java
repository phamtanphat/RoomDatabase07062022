package com.example.roomdatabase07062022.presentation.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.roomdatabase07062022.R;
import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;
import com.example.roomdatabase07062022.data.local.entities.TodoAndPriorityEntity;
import com.example.roomdatabase07062022.data.model.PriorityEnum;
import com.example.roomdatabase07062022.data.repositories.TodoRepository;
import com.example.roomdatabase07062022.presentation.viewmodels.MainViewModel;
import com.example.roomdatabase07062022.utils.JavaCsvHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(MainActivity.this);
            }
        }).get(MainViewModel.class);

//        mainViewModel.getPriorityEntityListLiveData().observe(this, new Observer<List<PriorityEntity>>() {
//            @Override
//            public void onChanged(List<PriorityEntity> priorityEntities) {
//                if (priorityEntities != null && priorityEntities.size() > 0) {
//                    for (PriorityEntity element: priorityEntities) {
//                        Log.d("BBB", element.toString());
//                    }
//                }
//            }
//        });

        mainViewModel.getTodoListLiveData().observe(this, new Observer<List<ToDoEntity>>() {
            @Override
            public void onChanged(List<ToDoEntity> toDoEntities) {
                if (toDoEntities != null && toDoEntities.size() > 0) {
                    String filePath = getFilesDir().toString();
                    JavaCsvHelper csvHelper = new JavaCsvHelper(filePath);
                    List<String[]> strings = new ArrayList<>();
                    strings.add(new String[]{"id", "title", "description", "createAt", "isDone", "idPriority"});
                    for (ToDoEntity element: toDoEntities) {
                        strings.add(new String[]{String.valueOf(element.getId()), element.getTitle(), element.getDescription(), String.valueOf(element.getCreateAt()), String.valueOf(element.isDone()), String.valueOf(element.getIdPriority())});
                    }
                    csvHelper.writeData("demo.csv", strings);
                }
            }
        });

//        mainViewModel.getTodoAndPriorityLiveData().observe(this, new Observer<List<TodoAndPriorityEntity>>() {
//            @Override
//            public void onChanged(List<TodoAndPriorityEntity> todoAndPriorityEntities) {
//                if (todoAndPriorityEntities != null && todoAndPriorityEntities.size() > 0) {
//                    for (TodoAndPriorityEntity element: todoAndPriorityEntities) {
//                        Log.d("BBB", element.toString());
//                    }
//                }
//            }
//        });
//

        mainViewModel.queryTodoList();
//        mainViewModel.queryPriorityList();
//        mainViewModel.queryTodoAndPriority();
//        mainViewModel.disposeData();

//         mainViewModel.insertPriority(new PriorityEntity(PriorityEnum.MEDIUM));
//        mainViewModel.insertTodo(new ToDoEntity("Todo 1","Do something 1", System.currentTimeMillis(), 1));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
