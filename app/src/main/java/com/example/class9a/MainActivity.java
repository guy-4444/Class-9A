package com.example.class9a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list_LST_notes;
    private Adapter_NoteModel adapter_noteModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_LST_notes = findViewById(R.id.list_LST_notes);
        initList();
    }

    private void initList() {
        ArrayList<Note> notes = getNotes();
        adapter_noteModel = new Adapter_NoteModel(this, notes);
        list_LST_notes.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list_LST_notes.setLayoutManager(layoutManager);
        list_LST_notes.setAdapter(adapter_noteModel);

        adapter_noteModel.SetOnItemClickListener(new Adapter_NoteModel.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Note note) {
                openNote(note);
            }
        });
    }

    private void openNote(Note note) {
        Toast.makeText(this, note.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private ArrayList<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        Note note1 = new Note("Guy");
        notes.add(note1);
        Note note2 = new Note("Avi");
        notes.add(note2);
        Note note3 = new Note("Ran");
        notes.add(note3);

        return notes;
    }


}
