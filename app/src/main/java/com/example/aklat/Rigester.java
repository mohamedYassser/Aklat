package com.example.aklat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Rigester extends AppCompatActivity {
    private static final String KEY_Name = "name";
    private static final String KEY_EMAIL= "email";
EditText nameText , phoneText , emailText , passwordText ;
Button register ;
FirebaseAuth mAuth;
SharedPreferences prfs ;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(getApplicationContext() , Home.class));
            finish();

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigester);
        prfs = getSharedPreferences("myPref" , MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();
nameText = findViewById(R.id.name);
        phoneText = findViewById(R.id.phone);
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);
        register=findViewById(R.id.registerbtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name , email , password;
                name = String.valueOf(nameText.getText());
                email = String.valueOf(emailText.getText());
                password = String.valueOf(passwordText.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Rigester.this, "Enter email" , Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(Rigester.this, "Enter name" , Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Rigester.this, "Enter password" , Toast.LENGTH_LONG).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Rigester.this, "Account created",
                                            Toast.LENGTH_SHORT).show();
                                    SharedPreferences.Editor editor = prfs.edit();
                                    editor.putString(KEY_Name, nameText.getText().toString());
                                    editor.putString(KEY_EMAIL, emailText.getText().toString());
                                    editor.apply();
                                    startActivity(new Intent(Rigester.this , MainActivity.class));
                                } else {

                                }
                            }
                        });
//






            }
        });



    }
}