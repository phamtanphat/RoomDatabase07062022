package com.example.roomdatabase07062022.data.local.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
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

    public PriorityEntity(PriorityEnum priorityEnum) {
        this.priorityEnum = priorityEnum;
    }

    @Ignore
    public PriorityEntity() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PriorityEnum getPriorityEnum() {
        return priorityEnum;
    }

    public void setPriorityEnum(PriorityEnum priorityEnum) {
        this.priorityEnum = priorityEnum;
    }

    @Override
    public String toString() {
        return "PriorityEntity{" +
                "id=" + id +
                ", priorityEnum=" + priorityEnum +
                '}';
    }
}

