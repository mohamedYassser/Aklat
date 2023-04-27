package com.example.aklat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class categoryadabter extends RecyclerView.Adapter<categoryadabter.ViewHolder> {
    List<Category> data;
    private Callback callback;

    public categoryadabter(List<Category> data, Callback callback) {
        this.data = data;
        this.callback = callback;
    }


    @NonNull
    @Override
    public categoryadabter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.food, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category currentCategory = data.get(position);
        holder.title.setText(data.get(position).getStrCategory());
        Glide.with(holder.imag.getContext()).
                load(data.get(position).getStrCategoryThumb()).into(holder.imag);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.getCategoryName(currentCategory.strCategory);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        CircleImageView imag;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            imag = itemView.findViewById(R.id.productImage);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }
}
