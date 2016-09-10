package com.example.androidstudio.midtermactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        final EditText editTextUser = (EditText) findViewById(R.id.editTextUName);
        final EditText editTextPass = (EditText) findViewById(R.id.editTextPWord);
        final Button btnOk = (Button) findViewById(R.id.buttonLogIn);


        btnOk.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (!validateUser(editTextUser.getText().toString())) {
                    Toast.makeText(NewActivity.this, "Wrong Username.", Toast.LENGTH_SHORT).show();
                } else if (!validatePassword(editTextPass.getText().toString())) {
                    Toast.makeText(NewActivity.this, "Wrong Password.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent myIntent = new Intent(v.getContext(), TouchListenerActivity.class);
                    startActivityForResult(myIntent, 0);
                }
            }

        });

    }

    //Return true if password is valid and false if password is invalid 
    protected boolean validatePassword(String password) {
        if (password!=null && password.equals("test")){
            return true;
        } else {
            return false;
        }
    }

    protected boolean validateUser(String username) {
        if (username!=null && username.equals("admin")) {
       // if (username!=null){
            return true;
        }else{
            return false;
        }
    }

 protected void onPause(){
    super.onPause();
    finish();
}
}