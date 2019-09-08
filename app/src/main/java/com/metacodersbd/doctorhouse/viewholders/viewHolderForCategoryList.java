package com.metacodersbd.doctorhouse.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.metacodersbd.doctorhouse.R;

public class viewHolderForCategoryList extends RecyclerView.ViewHolder {
    View mview ;



    public viewHolderForCategoryList(@NonNull View itemView) {

        super(itemView);

        mview = itemView ;


        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mclicklistener.onItemClick(v , getAdapterPosition());

            }
        });

    }
    public   void setDataToView(Context context , String  name  ){

        TextView hosname = mview.findViewById(R.id.hosName);




        //     Picasso.get().load(link).into(imageView);


    name = name.toUpperCase() ;

        hosname
                .setText(name);

    }

    private  static  viewHolderForCategoryList.Clicklistener mclicklistener ;



    public   interface  Clicklistener {

        void onItemClick(View view , int postion );

    }

    public  static  void  setOnClickListener (viewHolderForCategoryList.Clicklistener clickListener ){


        mclicklistener = clickListener ;


    }
}
