package com.example.rishab.managmentsystem.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishab.managmentsystem.CreateStudent;
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

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nameTextView;
        public TextView rollnoTextView;


        public ViewHolder(final View itemView) {

            super(itemView);

            rollnoTextView = (TextView) itemView.findViewById(R.id.tvrollno);
            nameTextView = (TextView) itemView.findViewById(R.id.tvname);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            final int pos = getAdapterPosition();



            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setTitle("Start");
            builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(final DialogInterface dialog, final int id) {
                    Intent intent = new Intent(mContext, CreateStudent.class);
                    Studentinfo obj = mstudentInfoArrayList.get(pos);
                    intent.putExtra("key", "view");
                    intent.putExtra("object", obj);
                    mContext.startActivity(intent);
                }
            });
            builder.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(final DialogInterface dialog, final int id) {
                    Intent intent = new Intent(mContext, CreateStudent.class);
                    Studentinfo obj = mstudentInfoArrayList.get(pos);
                    intent.putExtra("object", obj);
                    intent.putExtra("position", pos);
                    ((Activity) mContext).startActivityForResult(intent, 2);
                }
            });
            builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(final DialogInterface dialog, final int id) {
                    mstudentInfoArrayList.remove(pos);
                    notifyDataSetChanged();
                }
            });
            builder.create();
            builder.show();


        }
    }

}
