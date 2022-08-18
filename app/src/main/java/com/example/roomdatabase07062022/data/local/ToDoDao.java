package com.example.roomdatabase07062022.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase07062022.data.local.entities.PriorityConverter;
import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by pphat on 8/18/2022.
 */

@Dao
public interface ToDoDao {

    @Query("Select * from to_do")
    Observable<List<ToDoEntity>> getTodoList();

    @Query("Select * from priority")
    Observable<List<PriorityEntity>> getPriority();

    @Insert(entity = ToDoEntity.class)
    void insertTodo(ToDoEntity toDoEntity);

    @Insert(entity = PriorityEntity.class)
    void insertPriority(PriorityEntity priorityEntity);
}
