package com.example.administrator.toolsbar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.CollapsingToolbarLayout.Collasp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lb on 2017-04-26.
 */

public class FruitAdapter extends RecyclerView.Adapter <FruitAdapter.FruitHolder>{

    private Context context;
    private List<Friut> friutList = new ArrayList<>();

    public FruitAdapter(Context context, List<Friut> list){
        this.context = context;
        friutList = list;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public FruitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fruit_item , null);
        final  FruitHolder holder = new FruitHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Friut friut = friutList.get(position);
                Intent intent = new Intent(context , Collasp.class);
                intent.putExtra(Collasp.Friut_NAME , friut.getFriutName());
                intent.putExtra(Collasp.Friut_Image_id , friut.getImageId());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(FruitHolder holder, int position) {
        Friut friut = friutList.get(position);
        holder.fruitName.setText(friut.getFriutName());
        Glide.with(context).load(friut.getImageId()).into(holder.fruitImg);
    }

    @Override
    public int getItemCount() {
        return friutList.size();
    }

    class FruitHolder extends RecyclerView.ViewHolder{
        ImageView fruitImg;
        TextView fruitName;
        CardView cardView;

        public FruitHolder(View view){
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            fruitImg = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }

    }
}
