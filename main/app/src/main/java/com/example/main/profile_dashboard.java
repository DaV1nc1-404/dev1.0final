package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.Map;

public class profile_dashboard extends AppCompatActivity {
    EditText uname, umail, udesg, umob, uid, ipass;
    String unamet, umailt, udesgt, umobt, uidt, upasst,Userid;
    FirebaseUser user;
    Button regbtn;
    ProgressBar pgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dashboard);
        uname = (EditText) findViewById(R.id.pUn);
        umail = (EditText) findViewById(R.id.pMail);
        udesg = (EditText) findViewById(R.id.PDes);
        umob = (EditText) findViewById(R.id.pMob);
        uid = (EditText) findViewById(R.id.pId);
        ipass = (EditText) findViewById(R.id.pPass);
        pgbar=(ProgressBar)findViewById(R.id.progressBar);
        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        user=FirebaseAuth.getInstance().getCurrentUser();
        Userid=user.getUid();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("user");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               pgbar.setVisibility(View.VISIBLE);
               unamet=dataSnapshot.child(Userid).child("username").getValue(String.class);
                umailt=dataSnapshot.child(Userid).child("email").getValue(String.class);
                uidt=dataSnapshot.child(Userid).child("idno").getValue(String.class);
                udesgt=dataSnapshot.child(Userid).child("designation").getValue(String.class);
                umobt=dataSnapshot.child(Userid).child("mobileno").getValue(String.class);
                upasst=dataSnapshot.child(Userid).child("password").getValue(String.class);
                update();










            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(profile_dashboard.this, "Failed Retrieving Data", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void update() {
        pgbar.setVisibility(View.INVISIBLE);
        uname.setText(unamet);
        umail.setText(umailt);
        udesg.setText(udesgt);
        umob.setText(umobt);
        uid.setText(uidt);
        ipass.setText(upasst);



    }
}
