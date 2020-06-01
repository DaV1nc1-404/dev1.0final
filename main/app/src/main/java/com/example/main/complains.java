package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class complains extends AppCompatActivity {
    EditText type,description;
    Button raise;
    String ctype,cdesc;
    FirebaseAuth mAuth;
    FirebaseFirestore fstore;


DatabaseReference databaserefrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complains);
        raise=(Button)findViewById(R.id.comSub);
        type=(EditText)findViewById(R.id.comType);
        description=(EditText)findViewById(R.id.comDes);
        mAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        databaserefrence=FirebaseDatabase.getInstance().getReference("complaints");
        mAuth=FirebaseAuth.getInstance();
        raise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
    }

    private void send() {
        String id= databaserefrence.push().getKey();
        String ctype= type.getText().toString();
        String cdesc= description.getText().toString();
        if(!TextUtils.isEmpty(cdesc) || !TextUtils.isEmpty(ctype)){
            complaint complain=new complaint(ctype, cdesc);
           databaserefrence.child(id).setValue(complain);
            Toast.makeText(this, "Thankyou! Your Complaint has been registerd", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(complains.this,home.class);
            startActivity(intent);

        }
        if(TextUtils.isEmpty(cdesc) ||TextUtils.isEmpty(ctype) ){
            Toast.makeText(this, "please fill all the fields", Toast.LENGTH_SHORT).show();
        }



    }
}

