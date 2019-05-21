package com.example.hw_222_appbar;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {

    private EditText mInputNote;
    private Button mButtonSaveNote;
    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        initViews();
        getDateFromSharedPref();
    }

    private void initViews() {
        mInputNote = findViewById(R.id.input_note);
        mButtonSaveNote = findViewById(R.id.button_save_note);

        myNoteSharedPref = getSharedPreferences("My Note", MODE_PRIVATE);

        mButtonSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                String noteText = mInputNote.getText().toString();
                myEditor.putString(NOTE_TEXT, noteText);
                myEditor.apply();

                Toast.makeText(NotesActivity.this, "Заметка сохранена", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getDateFromSharedPref() {
        String noteText = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteText);
    }
}
