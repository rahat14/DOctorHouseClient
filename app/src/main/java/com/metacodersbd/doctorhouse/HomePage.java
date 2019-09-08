package com.metacodersbd.doctorhouse;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class HomePage extends AppCompatActivity {


CardView serchHospital ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //a@gmail.com password

        serchHospital = findViewById(R.id.SrcHosptal) ;





        serchHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent io = new Intent(getApplicationContext() , hospital_ListActivity.class) ;
                startActivity(io);


            }
        });


    }
}
