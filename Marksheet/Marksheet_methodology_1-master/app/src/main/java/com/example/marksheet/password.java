package com.example.marksheet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class password extends AppCompatActivity {

    EditText pass;
    Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        pass = (EditText) findViewById(R.id.pass);

        verify = (Button) findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Check();

            }
        });
}

    public void Check() {
        if (pass.getText().toString().equals("123")) {

            Toast.makeText(this, "Correct Password", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(password.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();

        }
    }
}