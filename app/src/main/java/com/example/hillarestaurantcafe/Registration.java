package com.example.hillarestaurantcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    private Button btnalreadyhaveaccount,back;

    EditText username,usermail,userpasswd,useradd1,useradd2,usercity,userpincod,userphone;
    Button gotologin,signin;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //  removing actionbar in this activity
        getSupportActionBar().hide();


        username = (EditText) findViewById(R.id.uname);
        usermail = (EditText) findViewById(R.id.uemail);
        userpasswd = (EditText) findViewById(R.id.upasswd);
        useradd1 = (EditText) findViewById(R.id.uadd1);
        useradd2 = (EditText) findViewById(R.id.uadd2);
        usercity = (EditText) findViewById(R.id.ucity);
        userpincod = (EditText) findViewById(R.id.upincode);
        userphone = (EditText) findViewById(R.id.uphone);
        signin = (Button) findViewById(R.id.extended_fab);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();








// moving from registration to login   onclicklistner class
        gotologin = (Button) findViewById(R.id.btnalreadyhaveaccount);
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,Login.class));
            }
        });



        back = (Button) findViewById(R.id.btnback);

        // back button onclicklistner for going to previous  activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,Login.class));
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreforAuth();

            }
        });
    }

    private void PreforAuth() {

        String  email = usermail.getText().toString();
        String  pass = userpasswd.getText().toString();




        if(email.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "enter email and passwored", Toast.LENGTH_SHORT).show();
        }
        else{
mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){

            sendusertonextActivity();
   Toast.makeText(Registration.this,"Registration Sucessfull",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(Registration.this, "Registration unsucess", Toast.LENGTH_SHORT).show();
        }
    }
});
        }
    }

    private void sendusertonextActivity() {

        Intent intent = new Intent(Registration.this,Login.class);
        startActivity(intent);
    }
}