package com.metacodersbd.doctorhouse;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class HomePage extends AppCompatActivity {


CardView serchHospital , doctorList  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //a@gmail.com password

        serchHospital = findViewById(R.id.SrcHosptal) ;
        doctorList = findViewById(R.id.SrcDoctor) ;






        serchHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent io = new Intent(getApplicationContext() , hospital_ListActivity.class) ;
                startActivity(io);


            }
        });


        doctorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent io = new Intent(getApplicationContext() , doctorListLPage.class) ;
                io.putExtra("postid", "allDoc");
                io.putExtra("hosName" , "null") ;
                startActivity(io);


            }
        });

    }
}
