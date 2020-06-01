package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class admin_login extends AppCompatActivity {
    String email;
    String passwrd;
    EditText admpass,admmail;
    Button btn;
    CheckBox checkbox;
    private static final String PREFS_NAME ="Prefsfile";
    SharedPreferences mPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        checkbox=(CheckBox)findViewById(R.id.checkBox);
        admmail= (EditText) findViewById(R.id.unAdm);
        getPrefrenceData();
        admpass= (EditText) findViewById(R.id.passAdm);
        btn= (Button)findViewById(R.id.admLi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = admmail.getText().toString();
                passwrd = admpass.getText().toString();
                if(checkbox.isChecked()){

                    Boolean boolchecked= checkbox.isChecked();
                    SharedPreferences.Editor editor= mPrefs.edit();
                    editor.putString("Pref_mail", admmail.getText().toString());
                    editor.putString("Pref_pass", admpass.getText().toString());
                    editor.putBoolean("pref_check",boolchecked);
                    editor.apply();


                }else {
                    mPrefs.edit().clear().apply();
                }

                if(){



                    Intent intent = new Intent(admin_login.this, adminhome.class);
                    startActivity(intent);
                }

            }
        });


    }
    private void getPrefrenceData(){

        SharedPreferences sp=getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        String u= sp.getString("Pref_mail", "not found");

        admmail.setText(u.toString());


        String p= sp.getString("Pref_pass", "not found");
        admpass.setText(p.toString());


        Boolean b = sp.getBoolean("Pref_check", true);
        checkbox.setChecked(b);



    }

}
