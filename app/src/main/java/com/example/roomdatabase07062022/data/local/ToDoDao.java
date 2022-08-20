package com.example.roomdatabase07062022.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomdatabase07062022.data.local.entities.PriorityConverter;
import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;
import com.example.roomdatabase07062022.data.local.entities.TodoAndPriorityEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * Created by pphat on 8/18/2022.
 */

@Dao
public interface ToDoDao {

    @Query("Select * from to_do")
    Observable<List<ToDoEntity>> getTodoList();

    @Query("Select * from priority")
    Observable<List<PriorityEntity>> getPriority();

    @Transaction
    @Query("SELECT * FROM to_do")
    Observable<List<TodoAndPriorityEntity>> getTodoAndPriority();

    @Insert(entity = ToDoEntity.class, onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insertTodo(ToDoEntity toDoEntity);

    @Insert(entity = PriorityEntity.class, onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insertPriority(PriorityEntity priorityEntity);
}
