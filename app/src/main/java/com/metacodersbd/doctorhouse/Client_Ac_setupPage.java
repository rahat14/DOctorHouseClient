package com.metacodersbd.doctorhouse;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Client_Ac_setupPage extends AppCompatActivity {

    EditText name,age;
    Button Submitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client__ac_setup_page);

        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        Submitbtn = (Button)findViewById(R.id.Submitbtn);
    }
}
