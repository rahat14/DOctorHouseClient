package com.metacodersbd.doctorhouse;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.metacodersbd.doctorhouse.model.getdoctorProfileModel;
import com.metacodersbd.doctorhouse.viewholders.voewHoldersForDoc;


public class doctorListLPage extends AppCompatActivity {

    RecyclerView mrecyclerview  ;
    LinearLayoutManager linearLayoutManager ;
    DatabaseReference mref;

    FirebaseRecyclerOptions<getdoctorProfileModel> options ;
    FirebaseRecyclerAdapter<getdoctorProfileModel, voewHoldersForDoc> firebaseRecyclerAdapter ;

    View view  ;
    String uid = "TEST" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list_lpage);

        Intent  o = getIntent();

                String db = o.getStringExtra("postid") ;
                String hos = o.getStringExtra("hosName") ;


                if (db.contains("allDoc")){

                    mref = FirebaseDatabase.getInstance().getReference("doctorProfile"); // db link
                }
                else {

                    mref = FirebaseDatabase.getInstance().getReference("hospitalList").child(hos).child("doctorCategory").child(db)
                    .child("doctorList");

                }





        mrecyclerview =findViewById(R.id.recyverViewDOCList) ;

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());


        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);

        mrecyclerview.setLayoutManager(linearLayoutManager) ;
        mrecyclerview.setHasFixedSize(true);

        mref.keepSynced(true);

        loadDataToFireBase()  ;
    }



    private void loadDataToFireBase() {

        options = new FirebaseRecyclerOptions.Builder<getdoctorProfileModel>().setQuery(mref , getdoctorProfileModel.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<getdoctorProfileModel, voewHoldersForDoc>(options) {
            @Override
            protected void onBindViewHolder(@NonNull  voewHoldersForDoc voewHoldersForDoc, final int i, @NonNull getdoctorProfileModel model) {


                voewHoldersForDoc.setDataToView(getApplicationContext() , model.getName() , model.getCategory() ,model.getHospital()
                 , model.getFee());








            }

            @NonNull
            @Override
            public voewHoldersForDoc onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View iteamVIew = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_doctor, parent, false);
                final voewHoldersForDoc viewholders = new voewHoldersForDoc(iteamVIew);



                voewHoldersForDoc.setOnClickListener(new voewHoldersForDoc.Clicklistener() {
                    @Override
                    public void onItemClick(View view, final  int postion) {


                        String uid = getItem(postion).getUid() ;
                        String dname = getItem(postion).getName() ;
                        String dcat =  getItem(postion).getCategory() ;
                        String dloc =  getItem(postion).getHospital() ;
                        String fee = getItem(postion).getFee() ;


                        Intent io = new Intent(getApplicationContext() , Add_Appointment.class) ;

                        io.putExtra("id", uid);
                        io.putExtra("name", dname);
                        io.putExtra("cat", dcat);
                        io.putExtra("loc", dloc);
                        io.putExtra("feee", fee);




                            startActivity(io);







                    }
                });


                return viewholders;
            }
        };
        mrecyclerview.setLayoutManager(linearLayoutManager) ;
        firebaseRecyclerAdapter.startListening();
        mrecyclerview.setAdapter(firebaseRecyclerAdapter);






    }
}
