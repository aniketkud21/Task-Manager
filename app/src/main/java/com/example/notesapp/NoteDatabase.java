package com.example.notesapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// WHEN THERE WERE NO CURLY BRACES THERE WAS AN ERROR IN DAO THAT IT CANT RECOGNIZE THE notes_table,
// BUT AFTER ADDING THE BRACES IT STARTED RECOGNIZING

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract DAO dao();

    public static NoteDatabase INSTANCE;

    // TO NOT CREATE MULTIPLE INSTANCES OF ROOM

    public static NoteDatabase getDatabaseInstance(Context context)
    {
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,
                    "notes_table").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
