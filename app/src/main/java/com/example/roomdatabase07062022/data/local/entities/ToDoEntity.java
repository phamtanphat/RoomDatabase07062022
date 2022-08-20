package com.example.roomdatabase07062022.data.local.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by pphat on 8/16/2022.
 */

@Entity(
        tableName = "to_do",
        foreignKeys = {@ForeignKey(entity = PriorityEntity.class,
                parentColumns = "id",
                childColumns = "id_priority",
                onDelete = ForeignKey.CASCADE)
        }
)
public class ToDoEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private long id;

    private String title;
    private String description;

    @ColumnInfo(name = "create_at")
    private long createAt;

    @ColumnInfo(name = "is_done", defaultValue = "0")
    private boolean isDone;

    @ColumnInfo(index = true, name = "id_priority")
    private long idPriority;

    public ToDoEntity(String title, String description, long createAt, long idPriority) {
        this.title = title;
        this.description = description;
        this.createAt = createAt;
        this.idPriority = idPriority;
    }

    @Ignore
    public ToDoEntity() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public long getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(long idPriority) {
        this.idPriority = idPriority;
    }

    @Override
    public String toString() {
        return "ToDoEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createAt=" + createAt +
                ", isDone=" + isDone +
                ", idPriority=" + idPriority +
                '}';
    }
}
