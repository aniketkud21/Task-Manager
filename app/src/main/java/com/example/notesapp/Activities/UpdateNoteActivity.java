package com.example.notesapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.notesapp.Note;
import com.example.notesapp.NoteViewModel;
import com.example.notesapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;

public class UpdateNoteActivity extends AppCompatActivity {

    EditText Title,SubTitle,Note;
    FloatingActionButton doneBTN;
    NoteViewModel noteViewModel;
    String stitle, ssubTitle, snote;
    int iid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);

        Title = findViewById(R.id.TitleUpdate);
        SubTitle = findViewById(R.id.SubTitleUpdate);
        Note = findViewById(R.id.NoteUpdate);
        doneBTN = findViewById(R.id.DoneBtnUpdate);

        iid = getIntent().getIntExtra("id", 0);
        stitle = getIntent().getStringExtra("title");
        ssubTitle= getIntent().getStringExtra("subtitle");
        snote = getIntent().getStringExtra("note");

        Title.setText(stitle);
        SubTitle.setText(ssubTitle);
        Note.setText(snote);


        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = Title.getText().toString();
                String subTitle = SubTitle.getText().toString();
                String note = Note.getText().toString();

                UpdateNotes(title, subTitle, note);
            }
        });

    }

    private void UpdateNotes(String title, String subTitle, String note) {

        Date date = new Date();
        CharSequence sequence = DateFormat.format("MMMM DD YYYY" , date.getTime());

        com.example.notesapp.Note upNote = new Note();
        upNote.id = iid;
        upNote.title = title;
        upNote.subTitle = subTitle;
        upNote.note = note;
        upNote.Date = sequence.toString();

        noteViewModel.updateNotes(upNote);

        // Ends the current activity and takes us back to previous activity

        // It basically kills the current activity

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.ic_delete){
            noteViewModel.deleteNotes(iid);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}