package com.example.marksheet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class options extends AppCompatActivity {

    Button button_teachers;
    Button button_students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        button_teachers = findViewById(R.id.button_teachers);
        button_teachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(options.this, password.class);
                startActivity(intent);
            }
        });
        button_students = findViewById(R.id.button_students);
        button_students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(options.this, showActivity.class);
                startActivity(intent);
            }
        });
    }
}