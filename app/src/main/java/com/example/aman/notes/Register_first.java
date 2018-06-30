package com.example.aman.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register_first extends AppCompatActivity {

    EditText rname,remail,rphone,rpass;
    Button register;
    Prefrences prefrences;
    SQLoperations sqLoperations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_first);
        rname = (EditText) findViewById(R.id.editText);
        remail = (EditText) findViewById(R.id.editText3);
        rphone = (EditText) findViewById(R.id.editText4);
        rpass = (EditText) findViewById(R.id.editText6);
        register = (Button) findViewById(R.id.button2);
        prefrences = Prefrences.getInstance(getApplicationContext());
        sqLoperations = SQLoperations.getInstance(getApplicationContext());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefrences.createUser(rname.getText().toString(),rpass.getText().toString());
                if(!sqLoperations.checkTable(rname.getText().toString())){
                    sqLoperations.createTable(rname.getText().toString());
                }
                Intent intent = new Intent(Register_first.this,NotesListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
