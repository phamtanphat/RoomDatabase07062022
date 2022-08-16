package com.example.roomdatabase07062022.data.local.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by pphat on 8/16/2022.
 */

@Entity(tableName = "to_do")
public class ToDoEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;
    private String description;

    @ColumnInfo(name = "create_at")
    private long createAt;

    @ColumnInfo(name = "is_done")
    private boolean isDone;

}
