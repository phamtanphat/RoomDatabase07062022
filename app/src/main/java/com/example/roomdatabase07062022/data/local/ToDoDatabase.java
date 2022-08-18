package com.example.roomdatabase07062022.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;

/**
 * Created by pphat on 8/16/2022.
 */
@Database(entities = {ToDoEntity.class, PriorityEntity.class}, version = 1)
public abstract class ToDoDatabase extends RoomDatabase {
    private static ToDoDatabase instance;

    public abstract ToDoDao getTodoDao();

    public static ToDoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context,
                    ToDoDatabase.class,
                    "database-todo"
            )
                    .build();
        }
        return instance;
    }
}
