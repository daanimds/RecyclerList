package com.example.recyclerlist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ExampleViewHolder> {
    private ArrayList<Items>Mitems;
    Context context;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public CardView cardView;



        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageV);
            mTextView1=itemView.findViewById(R.id.tv_name);
            mTextView2=itemView.findViewById(R.id.tv_d);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }

    public Adapter(ArrayList<Items> itemsArrayList,Context c){
        Mitems=itemsArrayList;
        this.context =c;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardv,viewGroup,false);
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(v);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        Items items=Mitems.get(i);
        final int image=items.getMimage();
       final String name=items.getMtext1().toString();
       final String desc=items.getMtext2().toString();

        exampleViewHolder.mImageView.setImageResource(items.getMimage());
        exampleViewHolder.mTextView1.setText(items.getMtext1());
        exampleViewHolder.mTextView2.setText(items.getMtext2());
        exampleViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+name, Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context,Main2Activity.class);

                i.putExtra("name1",name);
                i.putExtra("desc",desc);
                i.putExtra("img",image);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Mitems.size();
    }
}
