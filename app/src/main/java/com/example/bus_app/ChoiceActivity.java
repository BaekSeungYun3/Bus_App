package com.example.bus_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity {

    Button ch_teacher, ch_parents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        ch_teacher = findViewById(R.id.ch_teacher);
        ch_parents = findViewById(R.id.ch_parents);

        // 선생님 로그인 화면 전환
        ch_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TLoginActivity.class);
                startActivity(intent);
            }
        });

        // 부모 로그인 화면 전환
        ch_parents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}