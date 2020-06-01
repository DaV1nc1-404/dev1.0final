package com.example.main;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class paymentsuccess extends AppCompatActivity {
    int baseprice;
    String itemname;
    int quantity;
    TextView total;

    String uniqueid= UUID.randomUUID().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentsuccess);
        itemname= getIntent().getStringExtra("name");
        baseprice=(getIntent().getIntExtra("price",0));
    }
}
