package com.metacodersbd.doctorhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.metacodersbd.doctorhouse.model.getuserProfilemodle;

import java.util.Calendar;
import java.util.HashMap;

public class Add_Appointment extends AppCompatActivity {

    TextView datepicker  ;
    Button  submit  ;
    DatePickerDialog  datePickerDialog ;
    String uid , name , age  , doc , loc , fee , cate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__appointment);

        Intent intent =  getIntent();
        final String docId = intent.getStringExtra("id")  ;
        doc = intent.getStringExtra("name") ;
        loc = intent.getStringExtra("loc") ;
        fee = intent.getStringExtra("feee");
        cate = intent.getStringExtra("cat");




            submit = findViewById(R.id.submitBtn);


        datepicker = findViewById(R.id.datepicker) ;


        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar c = Calendar.getInstance();

                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(Add_Appointment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        datepicker.setText(dayOfMonth + "/"+(month+1)+"/"+year);

                    }
                } ,year , month , day);

                datePickerDialog.show();


            }
        });

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String date   = datepicker.getText().toString() ;

                    DatabaseReference mref = FirebaseDatabase.getInstance().getReference("REQDB");

                    String postID = mref.push().getKey() ;

                    HashMap map  = new HashMap() ;

                    map.put("postid", postID) ;
                    map.put("pname", name) ;
                    map.put("page", age) ;
                    map.put("adate", date);
                    map.put("docID", docId) ;
                    map.put("docName",doc ) ;
                    map.put("docloc",loc ) ;
                    map.put("docTime", null);
                    map.put ("stats" , "pending") ;
                    map.put("docCat",cate );
                    map.put("charge" , fee) ;



                    mref.child(postID).setValue(map)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    Intent i = new Intent( getApplicationContext() , HomePage.class);
                                    startActivity(i);
                                    finish();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    }) ;






                }
            });

    }

    public  void  dwldUsrData(String uid  ){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("userProfile").child(uid);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                getuserProfilemodle model = dataSnapshot.getValue(getuserProfilemodle.class) ;

                name = model.getName();
                age = model.getAge();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    @Override
    protected void onStart() {

        super.onStart();
        uid = FirebaseAuth.getInstance().getUid() ;
        dwldUsrData(uid);

    }
}
