package com.example.bus_app;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ParentsMenuActivity extends AppCompatActivity {

    CardView p_noteCard;
    CardView P_quesCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_menu);

        p_noteCard = findViewById(R.id.p_noteCard);
        P_quesCard = findViewById(R.id.P_quesCard);

        p_noteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParentsMenuActivity.this, NoteCheckActivity.class);
                startActivity(intent);
            }
        });

        P_quesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParentsMenuActivity.this, RequestActivity.class);
                startActivity(intent);
            }
        });

    }
}