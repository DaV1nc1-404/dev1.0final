package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class eventshow extends AppCompatActivity {
    TextView eventname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventshow);
        eventname=(TextView) findViewById(R.id.eveName);

        eventname.setText(getIntent().getStringExtra("name"));
        Toast.makeText(this, "event is "+ eventname.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
