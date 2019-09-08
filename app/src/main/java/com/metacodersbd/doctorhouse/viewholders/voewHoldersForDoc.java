package com.metacodersbd.doctorhouse.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.metacodersbd.doctorhouse.R;

public class voewHoldersForDoc extends RecyclerView.ViewHolder {
        View mview ;
public TextView statusTv ;
public CardView cardView  ;


public voewHoldersForDoc(@NonNull View itemView) {

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
public   void setDataToView(Context context , String  namee , String categoryy , String hospitall ,String feee){

        TextView name = mview.findViewById(R.id.docName);
         TextView category = mview.findViewById(R.id.doc_Cat);
        TextView hospital = mview.findViewById(R.id.hospital);
        TextView fee  = mview.findViewById(R.id.Vfee);




        //     Picasso.get().load(link).into(imageView);



        name.setText(namee);
        category.setText(categoryy);
        hospital.setText(hospitall);
        fee.setText(feee);

        }

private  static  voewHoldersForDoc.Clicklistener mclicklistener ;



public   interface  Clicklistener {

    void onItemClick(View view , int postion );

}

    public  static  void  setOnClickListener (voewHoldersForDoc.Clicklistener clickListener ){


        mclicklistener = clickListener ;


    }
}
