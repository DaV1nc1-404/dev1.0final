package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class admin_event_show extends AppCompatActivity {
    EditText eventname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_event_show);
        eventname=(EditText) findViewById(R.id.eveName);
        eventname.setText(getIntent().getStringExtra("name"));

    }
}
