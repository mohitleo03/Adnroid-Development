package com.kanika.sehrawat.bakeryapp.Activity.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.kanika.sehrawat.bakeryapp.Activity.ShowDetailsActivity;
import com.kanika.sehrawat.bakeryapp.Activity.model.FoodDomain;
import com.kanika.sehrawat.bakeryapp.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<FoodDomain> foodDomains;

    public PopularAdapter(ArrayList<FoodDomain> foodDomains) {
        this.foodDomains = foodDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull  PopularAdapter.ViewHolder holder, int position) {
        holder.title.setText(foodDomains.get(position).getTitle());
        holder.price.setText(String.valueOf(foodDomains.get(position).getPrice()));
        holder.pic.setImageResource(foodDomains.get(position).getPic());
/*
        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailsActivity.class);
                intent.putExtra("object",foodDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });*/

        holder.categoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailsActivity.class);
                intent.putExtra("object",foodDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, price, add_btn;
        ImageView pic;
        ConstraintLayout categoryLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.popular_title);
            price = itemView.findViewById(R.id.popular_cost);
            pic = itemView.findViewById(R.id.popular_pic);
            add_btn= itemView.findViewById(R.id.add_btn);
            categoryLayout = itemView.findViewById(R.id.popular_layout);
        }
    }

    public void filterList(ArrayList<FoodDomain> filteredList){
        foodDomains = filteredList;
        notifyDataSetChanged();
    }
}
