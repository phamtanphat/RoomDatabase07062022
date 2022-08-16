package com.example.roomdatabase07062022.data.local.entities;

import androidx.room.TypeConverter;

import com.example.roomdatabase07062022.data.model.PriorityEnum;

public class PriorityConverter {
    @TypeConverter
    public static String fromPriority(PriorityEnum priorityColorEnum) {
        return priorityColorEnum.name();
    }

    @TypeConverter
    public static PriorityEnum toPriority(String color) {
        return PriorityEnum.valueOf(color);
    }
}
