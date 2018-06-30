package com.example.aman.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText name,password;
    Button login;
    Prefrences prefrences;
    SQLoperations sqLoperations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        name = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        login = findViewById(R.id.button);
        prefrences = Prefrences.getInstance(getApplicationContext());
        sqLoperations = SQLoperations.getInstance(getApplicationContext());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prefrences.createUser(name.getText().toString(),password.getText().toString());
                //Open new Activity
                if(!sqLoperations.checkTable(name.getText().toString())){
                    sqLoperations.createTable(name.getText().toString());
                }

                Intent intent = new Intent(LoginActivity.this,NotesListActivity.class);
                startActivity(intent);
                finish();


            }
        });




    }
}
