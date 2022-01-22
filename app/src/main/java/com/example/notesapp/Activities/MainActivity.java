package com.example.notesapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.notesapp.Note;
import com.example.notesapp.NoteViewModel;
import com.example.notesapp.NotesRVAdapter;
import com.example.notesapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements NotesRVAdapter.OnNoteClick{

    RecyclerView recyclerView;
    FloatingActionButton addBTN;
    NoteViewModel noteViewModel;
    NotesRVAdapter notesRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        addBTN = findViewById(R.id.addButton);

        // LIVE DATA observes the data
        // Without lambda way dont know

        noteViewModel.getAllNotes.observe(this, notes -> {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            notesRVAdapter = new NotesRVAdapter(notes, this);
            recyclerView.setAdapter(notesRVAdapter);
        });

        // Intent to go to Insert Note Activity

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    // Intent to go to Update Note Activity

    @Override
    public void OnClick(Note note) {
        Intent intent = new Intent(MainActivity.this, UpdateNoteActivity.class);
        intent.putExtra("id", note.id);
        intent.putExtra("title", note.title);
        intent.putExtra("subtitle", note.subTitle);
        intent.putExtra("note", note.note);

        startActivity(intent);
    }
}