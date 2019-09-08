package com.metacodersbd.doctorhouse;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.metacodersbd.doctorhouse.model.getHospitalmodel;
import com.metacodersbd.doctorhouse.viewholders.viewHolderForHospitalList;

public class hospital_ListActivity extends AppCompatActivity {
    RecyclerView mrecyclerview  ;
    LinearLayoutManager linearLayoutManager ;
    DatabaseReference mref;

    FirebaseRecyclerOptions<getHospitalmodel> options ;
    FirebaseRecyclerAdapter<getHospitalmodel, viewHolderForHospitalList> firebaseRecyclerAdapter ;

    View view  ;
    String uid = "TEST" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital__list);
        mref = FirebaseDatabase.getInstance().getReference("hospitalList"); // db link


        mrecyclerview =findViewById(R.id.recyverViewHospitalList) ;

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());


        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);

        mrecyclerview.setLayoutManager(linearLayoutManager) ;
        mrecyclerview.setHasFixedSize(true);

        mref.keepSynced(true);

        loadDataToFireBase()  ;

    }
    private void loadDataToFireBase() {

        options = new FirebaseRecyclerOptions.Builder<getHospitalmodel>().setQuery(mref , getHospitalmodel.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<getHospitalmodel, viewHolderForHospitalList>(options) {
            @Override
            protected void onBindViewHolder(@NonNull viewHolderForHospitalList viewholdersForCurrentTrip, final int i, @NonNull getHospitalmodel model) {


                viewholdersForCurrentTrip.setDataToView(getApplicationContext() , model.getName() , model.getImageLink() );








            }

            @NonNull
            @Override
            public viewHolderForHospitalList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View iteamVIew = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row__hospital, parent, false);
                final viewHolderForHospitalList viewholders = new viewHolderForHospitalList(iteamVIew);



                viewHolderForHospitalList.setOnClickListener(new viewHolderForHospitalList.Clicklistener() {
                    @Override
                    public void onItemClick(View view, final  int postion) {

                        final String PostID = getItem(postion).getId() ;



                       Intent io = new Intent(getApplicationContext() , categoryList.class) ;

                       io.putExtra("postid", PostID);

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
