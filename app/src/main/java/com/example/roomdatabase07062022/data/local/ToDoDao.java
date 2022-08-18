package com.example.roomdatabase07062022.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase07062022.data.local.entities.PriorityConverter;
import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;

import java.util.List;

/**
 * Created by pphat on 8/18/2022.
 */

@Dao
public interface ToDoDao {

    @Query("Select * from to_do")
    LiveData<List<ToDoEntity>> getTodoList();

    @Query("Select * from priority")
    LiveData<List<PriorityEntity>> getPriority();

    @Insert(entity = ToDoEntity.class)
    LiveData<Long> insertTodo(ToDoEntity toDoEntity);

    @Insert(entity = PriorityEntity.class)
    LiveData<Long> insertPriority(PriorityEntity priorityEntity);
}
