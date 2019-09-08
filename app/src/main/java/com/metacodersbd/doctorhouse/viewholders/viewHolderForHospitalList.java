package com.metacodersbd.doctorhouse.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.metacodersbd.doctorhouse.R;
import com.squareup.picasso.Picasso;


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
public   void setDataToView(Context context , String  name , String link   ){

        TextView hosname = mview.findViewById(R.id.hosName);
        ImageView imageView = mview.findViewById(R.id.imageVIew) ;



       //     Picasso.get().load(link).into(imageView);



        hosname
                .setText(name);

        }

private  static  viewHolderForHospitalList.Clicklistener mclicklistener ;



public   interface  Clicklistener {

    void onItemClick(View view , int postion );

}

    public  static  void  setOnClickListener (viewHolderForHospitalList.Clicklistener clickListener ){


        mclicklistener = clickListener ;


    }
}
