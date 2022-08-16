package com.example.roomdatabase07062022.data.local.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.roomdatabase07062022.data.model.PriorityEnum;

/**
 * Created by pphat on 8/16/2022.
 */
@Entity(tableName = "priority")
public class PriorityEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @TypeConverters(PriorityConverter.class)
    @ColumnInfo(name = "priority")
    private PriorityEnum priorityEnum;
}

