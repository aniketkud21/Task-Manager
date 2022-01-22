package com.example.notesapp;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    NotesRepository repository;
    public LiveData<List<Note>> getAllNotes;

    public NoteViewModel(Application application) {
        super(application);

        repository = new NotesRepository(application);
        getAllNotes = repository.getAllNote;
    }

    // IF ERROR THEN USE DIFFERENT NAME FROM REPOSITORY METHODS

    public void insertNotes(Note note)
    {
        repository.insertNotes(note);
    }

    public void deleteNotes(int id)
    {
        repository.deleteNotes(id);
    }

    public void updateNotes(Note note)
    {
        repository.updateNotes(note);
    }
}
