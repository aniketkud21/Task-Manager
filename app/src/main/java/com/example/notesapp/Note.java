package com.example.notesapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "note_title")
    public String title;

    @ColumnInfo(name = "note_subTitle")
    public String subTitle;

    @ColumnInfo(name = "note")
    public String note;

    @ColumnInfo(name = "note_date")
    public String Date;

    @ColumnInfo(name = "note_priority")
    public String priority;
}
