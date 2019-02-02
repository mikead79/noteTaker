package com.example.mihai.notetaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private boolean isInEditMode = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleText = findViewById(R.id.titleEditText);
                EditText noteText = findViewById(R.id.noteEditText);
                if(isInEditMode) {
                    isInEditMode = false;
                    saveButton.setText("Edit");
                    noteText.setEnabled(false);
                    titleText.setEnabled(false);
                    TextView dateText = findViewById(R.id.dateEditText);
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String noteDate = dateFormat.format(Calendar.getInstance().getTime());
                    dateText.setText(noteDate);
                }
                else {
                    isInEditMode = true;
                    saveButton.setText("Save");
                    noteText.setEnabled(true);
                    titleText.setEnabled(true);
                }
            }
        });
    }
}
