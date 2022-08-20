package com.example.roomdatabase07062022.data.local.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

/**
 * Created by pphat on 8/18/2022.
 */
public class TodoAndPriorityEntity {
    @Embedded
    public PriorityEntity priorityEntity;

    @Relation(
            parentColumn = "id",
            entityColumn = "id_priority"
    )
    public ToDoEntity toDoEntity;

    @Override
    public String toString() {
        return "TodoAndPriorityEntity{" +
                "priorityEntity=" + priorityEntity +
                ", toDoEntity=" + toDoEntity +
                '}';
    }
}
