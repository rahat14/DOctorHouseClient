package com.metacodersbd.doctorhouse;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.metacodersbd.doctorhouse.model.getuserProfilemodle;

public class Client_Ac_setupPage extends AppCompatActivity {

    EditText name,age;
    Button Submitbtn;
    RadioGroup genderGroup ;
    String  NAME , AGE  , GENDER  ;

    String uid ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client__ac_setup_page);

        uid = FirebaseAuth.getInstance().getUid() ;


        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        Submitbtn = (Button)findViewById(R.id.Submitbtn);
        genderGroup = findViewById(R.id.genderGroup) ;


        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NAME  = name.getText().toString() ;
                AGE = age. getText().toString() ;

                int id  = genderGroup.getCheckedRadioButtonId() ;
                RadioButton btn = findViewById(id) ;

                GENDER = btn.getText().toString() ;


                if(!TextUtils.isEmpty(NAME) || !TextUtils.isEmpty(AGE) )
                {

                    uploadToDatbase(NAME , AGE   , GENDER ) ;


                }



            }
        });









    }

    private void uploadToDatbase(String name, String age, String gender) {


        DatabaseReference mref = FirebaseDatabase.getInstance().getReference("userProfile").child(uid);

        getuserProfilemodle  model = new getuserProfilemodle(name , gender , age  , uid  );

        mref.setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Intent intent = new Intent(getApplicationContext()  , HomePage.class);
                startActivity(intent);
                finish();

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {


                        Toast.makeText(getApplicationContext() , e.getMessage(), Toast.LENGTH_LONG)
                                .show();


                    }
                }) ;







    }
}
