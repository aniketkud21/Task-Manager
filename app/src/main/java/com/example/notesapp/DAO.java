package com.example.notesapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {

    //Used LiveData

    @Query("SELECT * FROM notes_table")
    LiveData<List<Note>> getAllNotes();

    @Insert
    void insertNotes(Note note);

    @Query("DELETE FROM notes_table WHERE ID=:id")
    void deleteNotes(int id);

    @Update
    void updateNotes(Note note);

}
