package com.example.rishab.managmentsystem.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishab.managmentsystem.Model.Studentinfo;
import com.example.rishab.managmentsystem.R;

import java.util.ArrayList;

/**
 * Created by Rishab on 05-04-2017.
 */

public class AdapterStudent extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Studentinfo> mstudentInfoArrayList;
    private Context mContext;

    public AdapterStudent(Context context, ArrayList<Studentinfo> al)
    {
        this.mstudentInfoArrayList = al;
        this.mContext = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(mContext).inflate(R.layout.activity_adapterstudent, parent, false);
        // Return a new holder instance
        //ViewHolder viewHolder = new ViewHolder(contactView);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Studentinfo objinfo;
        objinfo = getItem(holder.getAdapterPosition());

        ((ViewHolder)holder).nameTextView.setText(objinfo.getName());
        ((ViewHolder)holder).rollnoTextView.setText(objinfo.getRollno());
    }

    private Studentinfo getItem(int position){
        return mstudentInfoArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return mstudentInfoArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView rollnoTextView;


        public ViewHolder(View itemView) {

            super(itemView);

            rollnoTextView = (TextView) itemView.findViewById(R.id.tvrollno);
            nameTextView = (TextView) itemView.findViewById(R.id.tvname);



        }
    }

}
