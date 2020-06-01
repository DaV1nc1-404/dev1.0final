package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


   FirebaseAuth mAutn;
    private EditText unLI;
    private EditText pwLI;
    private TextView regst;
    private Button admli;
    FirebaseAuth mfirebaseauth;
    private Button li;
    String email;
    String passwrd;
    private FirebaseAuth.AuthStateListener mAuthStateListner;
    CheckBox checkbox;
    SharedPreferences mPrefs;
    private static final String PREFS_NAME ="Prefsfile";

    private int  c=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unLI= (EditText) findViewById(R.id.unLI);
        pwLI= (EditText) findViewById(R.id.pwLI);
        admli =(Button) findViewById(R.id.adminLi);
        checkbox=(CheckBox)findViewById(R.id.checkBox);
        mPrefs=getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        getPrefrenceData();
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    SharedPreferences prefrences= getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor= prefrences.edit();
                    editor.putString("remember", "true");
                    editor.apply();

                }
                else {
                    SharedPreferences prefrences= getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor= prefrences.edit();
                    editor.putString("remember", "false");
                    editor.apply();

                }
                }

        });

        mAutn=FirebaseAuth.getInstance();
        regst=(TextView)findViewById(R.id.texttRegister);
        regst.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent regact = new Intent(MainActivity.this, Register.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(unLI, "username");
                pairs[1] = new Pair<View, String>(pwLI, "password");
                pairs[2] = new Pair<View, String>(li, "button");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(regact, options.toBundle());
                }

            }
        });


        li= (Button) findViewById(R.id.mLi);

         li.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {




                 email = unLI.getText().toString();
                 passwrd = pwLI.getText().toString();
               if(checkbox.isChecked()){

                   Boolean boolchecked= checkbox.isChecked();
                   SharedPreferences.Editor editor= mPrefs.edit();
                   editor.putString("Pref_mail", unLI.getText().toString());
                   editor.putString("Pref_pass", pwLI.getText().toString());
                   editor.putBoolean("pref_check",boolchecked);
                   editor.apply();


               }else {
                   mPrefs.edit().clear().apply();
               }
                mAutn.signInWithEmailAndPassword(email, passwrd)
                         .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 if (task.isSuccessful()) {

                                     Intent inetnt=new Intent(MainActivity.this, home.class);
                                     startActivity(inetnt);
                                     unLI.getText().clear();
                                     pwLI.getText().clear();

                                     Toast.makeText(MainActivity.this, "Signin Success!", Toast.LENGTH_SHORT).show();
                                     FirebaseUser user = mAutn.getCurrentUser();


                                 } else {


                                     Toast.makeText(MainActivity.this, "Authentication failed.",
                                             Toast.LENGTH_SHORT).show();

                                 }

                                 // ...
                             }
                         });


             }
         });





     admli.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent admli =new Intent(MainActivity.this, admin_login.class);
             Pair[] pairs=new Pair[3];
             pairs[0]=new Pair<View,String>(unLI,"username");
             pairs[1]=new Pair<View,String>(pwLI,"password");
             pairs[2]=new Pair<View,String>(li,"button");
             if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                 ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                 startActivity(admli, options.toBundle());
             }

         }
     });



    }
    private void getPrefrenceData(){

        SharedPreferences sp=getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

            String u= sp.getString("Pref_mail", "not found");

            unLI.setText(u.toString());


            String p= sp.getString("Pref_pass", "not found");
            pwLI.setText(p.toString());


            Boolean b = sp.getBoolean("Pref_check", true);
            checkbox.setChecked(b);



    }


}
