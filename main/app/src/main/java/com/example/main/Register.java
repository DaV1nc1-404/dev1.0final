package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import io.grpc.InternalWithLogId;

public class Register extends AppCompatActivity {
  FirebaseAuth mAuth;
    ImageView ImgUserPhoto;
    EditText username;
    EditText email;
    EditText designation;
    EditText idno;
    EditText mobileno;
    EditText password;
     public String username1;
    String email1;
    String designation1;
    String idno1;
    String mobileno1;
    String password1;
    FirebaseFirestore fstore;
    String userid;
    private Button regbtn;
    ProgressBar pgbar;
    String orders;


String usernam="sundeepsanju29@gmail.com";
    String userna="password";


    static int PReqCode = 1;
    static int REQUESCODE = 1;
    Uri pickedImgUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.unReg);
        email = (EditText) findViewById(R.id.emReg);
        designation = (EditText) findViewById(R.id.desReg);
        idno = (EditText) findViewById(R.id.idReg);
        pgbar=(ProgressBar)findViewById(R.id.progressBar);
        mobileno = (EditText) findViewById(R.id.mobReg);
        password = (EditText) findViewById(R.id.passReg);
        regbtn = (Button) findViewById(R.id.hReg);
        mAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        DatabaseReference databaseReference;



        databaseReference=FirebaseDatabase.getInstance().getReference("user");
        mAuth=FirebaseAuth.getInstance();
        regbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                username1 = username.getText().toString();
                email1 = email.getText().toString();
                designation1 = designation.getText().toString();
                idno1 = idno.getText().toString();
                mobileno1 = mobileno.getText().toString();
                password1 = password.getText().toString();
                orders="";


                if(TextUtils.isEmpty(email1)){
                    Toast.makeText(Register.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password1)){
                    Toast.makeText(Register.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(designation1)){
                    Toast.makeText(Register.this, "Please Enter whether you're Staff or Student", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(idno1)){
                    Toast.makeText(Register.this, "Please Enter your id no", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(mobileno1)) {
                    Toast.makeText(Register.this, "Please Enter your mobile number", Toast.LENGTH_SHORT).show();
                }


                    mAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(Register.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                user info=new user(username1,designation1,idno1,mobileno1,password1,email1, orders);

                                FirebaseDatabase.getInstance().getReference("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(Register.this, "Registration complete! Please Login to get access", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                    }
                                });
                            }
                            else{
                                Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });



            }
        });


        ImgUserPhoto = (ImageView) findViewById(R.id.regImg);

        ImgUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= 22) {

                    checkAndRequestForPermission();


                } else {
                    openGallery();
                }


            }
        });


    }




    private void openGallery(){


        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, REQUESCODE);
    }



    private void checkAndRequestForPermission() {


        if (ContextCompat.checkSelfPermission(Register.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(Register.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(Register.this, "Please accept for required permission", Toast.LENGTH_SHORT).show();

            } else {

                ActivityCompat.requestPermissions(Register.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PReqCode);
            }
        }
            else{
                Toast.makeText(this, "Select Image", Toast.LENGTH_SHORT).show();
                openGallery();
            }

        }
    




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null) {

            pickedImgUri = data.getData();
            ImgUserPhoto.setImageURI(pickedImgUri);


        }


    }

}