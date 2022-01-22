package com.example.notesapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesRepository {

    public DAO noteDao;
    public LiveData<List<Note>> getAllNote;

    public NotesRepository(Application application){

        NoteDatabase db = NoteDatabase.getDatabaseInstance(application);
        noteDao = db.dao();
        getAllNote = noteDao.getAllNotes();
    }

    public void insertNotes(Note note){
        noteDao.insertNotes(note);
    }

    public void deleteNotes(int id){
        noteDao.deleteNotes(id);
    }

    public void updateNotes(Note note){
        noteDao.updateNotes(note);
    }


}
