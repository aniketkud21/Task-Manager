package com.example.notesapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;

import com.example.notesapp.Note;
import com.example.notesapp.NoteViewModel;
import com.example.notesapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;

public class InsertNoteActivity extends AppCompatActivity {

    EditText Title,SubTitle,Note;
    FloatingActionButton doneBTN;
    NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_note);

        Title = findViewById(R.id.Title);
        SubTitle = findViewById(R.id.subTitle);
        Note = findViewById(R.id.note);
        doneBTN = findViewById(R.id.doneBtnInsert);

        //method to access view Model

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = Title.getText().toString();
                String subTitle = SubTitle.getText().toString();
                String note = Note.getText().toString();

                CreateNotes(title, subTitle, note);
            }
        });

    }

    private void CreateNotes(String title, String subTitle, String note) {

        Date date = new Date();
        CharSequence sequence = DateFormat.format("dd MMMM yyyy" , date.getTime());

        com.example.notesapp.Note note1 = new Note();
        note1.title = title;
        note1.subTitle = subTitle;
        note1.note = note;
        note1.Date = sequence.toString();

        noteViewModel.insertNotes(note1);

        // Ends the current activity and takes us back to previous activity

        // It basically kills the current activity

        finish();
    }
}