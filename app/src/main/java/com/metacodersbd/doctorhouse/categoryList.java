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
import com.metacodersbd.doctorhouse.model.categoryModel;
import com.metacodersbd.doctorhouse.viewholders.viewHolderForCategoryList;


public class categoryList extends AppCompatActivity {
    String DB  ;

    RecyclerView mrecyclerview  ;
    LinearLayoutManager linearLayoutManager ;
    DatabaseReference mref;

    FirebaseRecyclerOptions<categoryModel> options ;
    FirebaseRecyclerAdapter<categoryModel, viewHolderForCategoryList> firebaseRecyclerAdapter ;

    View view  ;
    String uid = "TEST" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

         Intent o = getIntent();

        DB =  o.getStringExtra("postid") ;
        mref = FirebaseDatabase.getInstance().getReference("hospitalList").child(DB).child("doctorCategory"); // db link


        mrecyclerview =findViewById(R.id.recyclerViewONcategoryList) ;

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());


        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);

        mrecyclerview.setLayoutManager(linearLayoutManager) ;
        mrecyclerview.setHasFixedSize(true);

        mref.keepSynced(true);

        loadDataToFireBase()  ;

    }

    private void loadDataToFireBase() {

        options = new FirebaseRecyclerOptions.Builder<categoryModel>().setQuery(mref , categoryModel.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<categoryModel, viewHolderForCategoryList>(options) {
            @Override
            protected void onBindViewHolder(@NonNull viewHolderForCategoryList viewholdersForCurrentTrip, final int i, @NonNull categoryModel model) {


                viewholdersForCurrentTrip.setDataToView(getApplicationContext() ,model.getName()  );



            }

            @NonNull
            @Override
            public viewHolderForCategoryList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View iteamVIew = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_d_category, parent, false);
                final viewHolderForCategoryList viewholders = new viewHolderForCategoryList(iteamVIew);



                viewHolderForCategoryList.setOnClickListener(new viewHolderForCategoryList.Clicklistener() {
                    @Override
                    public void onItemClick(View view, final  int postion) {

                        final String PostID = getItem(postion).getName() ;



                        Intent io = new Intent(getApplicationContext() , doctorListLPage.class) ;

                        io.putExtra("postid", PostID);
                        io.putExtra("hosName" , DB) ;



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
