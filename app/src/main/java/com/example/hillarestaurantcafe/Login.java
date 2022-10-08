package com.example.hillarestaurantcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    //private Button btndonthaveaccount, btnsignin;

    EditText usermail,userpasswd;
    Button gotoregister,btnsignin;
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // installed splashscreen in this activity

        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //  removing actionbar in this activity
        getSupportActionBar().hide();




        usermail = (EditText) findViewById(R.id.usermail);
        userpasswd = (EditText) findViewById(R.id.userpassword);
        gotoregister = (Button) findViewById(R.id.btnsignin);
        btnsignin = (Button) findViewById(R.id.btnsignin);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();







        //  creating onclicklistener for dont have an account button


        gotoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registration.class));
            }
        });

        //  creating onclicklistener for sign in button

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        performLogin();
            }
        });
    }

    private void performLogin() {

        String  uemail = usermail.getText().toString();
        String  upass = userpasswd.getText().toString();




        if(uemail.isEmpty() || upass.isEmpty()){
            Toast.makeText(this, "enter email and passwored", Toast.LENGTH_SHORT).show();
        }
        else{
           mAuth.signInWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()){
                  sendusertonextActivity();
                  Toast.makeText(Login.this,"login Sucessfull",Toast.LENGTH_SHORT).show();
              }
              else{
                  Toast.makeText(Login.this, "Login unsucess", Toast.LENGTH_SHORT).show();

              }
               }
           });
    }

}

    private void sendusertonextActivity() {
        Intent intent = new Intent(Login.this,MainActivity.class);
        startActivity(intent);
    }
}