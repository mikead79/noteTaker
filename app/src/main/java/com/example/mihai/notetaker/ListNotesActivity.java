package com.example.mihai.notetaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListNotesActivity extends AppCompatActivity {
    private List<Note> notes = new ArrayList<Note>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);
        notes.add(new Note("First Note", "The text of the note 1", new Date()));
        notes.add(new Note("Second Note", "The text of the note 2", new Date()));
        notes.add(new Note("Third Note", "The text of the note 3", new Date()));
        notes.add(new Note("Fourth Note", "The text of the note 4", new Date()));
        notes.add(new Note("Fifth Note", "The text of the note 5", new Date()));

        ListView notesListView = findViewById(R.id.notesListView);

        List<String> values = new ArrayList<String>();
        for(Note note : notes){
            values.add(note.getTitle());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        notesListView.setAdapter(adapter);
    }
}
