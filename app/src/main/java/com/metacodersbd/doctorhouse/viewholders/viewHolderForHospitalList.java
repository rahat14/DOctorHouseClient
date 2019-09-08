package com.metacodersbd.doctorhouse.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



public class viewHolderForHospitalList extends RecyclerView.ViewHolder {
        View mview ;
public TextView statusTv ;
public CardView cardView  ;


public viewHolderForHospitalList(@NonNull View itemView) {

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

        TextView hosname = mview.findViewById(R.id.dateOfRows);






        statusTv.setText(status);

        }

private  static  viewHolderForHospitalList.Clicklistener mclicklistener ;



public   interface  Clicklistener {

    void onItemClick(View view , int postion );

}

    public  static  void  setOnClickListener (viewHolderForHospitalList.Clicklistener clickListener ){


        mclicklistener = clickListener ;


    }
}
