package com.example.bus_app;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class TeacherMenuActivity extends AppCompatActivity {

    CardView t_note;
    CardView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_menu);

        t_note = findViewById(R.id.t_note);
        question = findViewById(R.id.question);


        t_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherMenuActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherMenuActivity.this, RequestCheckActivity.class);
                startActivity(intent);
            }
        });

    }
}