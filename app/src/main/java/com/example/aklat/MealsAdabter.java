package com.example.aklat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MealsAdabter extends RecyclerView.Adapter<MealsAdabter.ViewHolder> {
    Callbackdec callbackdec;
    List<Meal> mealarray;

    public MealsAdabter(List<Meal> mealarray,Callbackdec callbackdec) {
        this.mealarray = mealarray;
        this.callbackdec = callbackdec;
    }


    @NonNull
    @Override
    public MealsAdabter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.meal, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MealsAdabter.ViewHolder holder, int position) {
        Meal mealCategory = mealarray.get(position);

        holder.title.setText(mealarray.get(position).getStrMeal());
        Glide.with(holder.imag.getContext()).
                load(mealarray.get(position).getStrMealThumb()).into(holder.imag);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callbackdec.getdecName(mealCategory.idMeal);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mealarray.size();
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
