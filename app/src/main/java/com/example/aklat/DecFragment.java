package com.example.aklat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.aklat.databinding.FragmentDecBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DecFragment extends Fragment {

    FragmentDecBinding binding;
    Categoryinterface categoryinterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDecBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryinterface = ApiController.apiinterface;
        String Meals = DecFragmentArgs.fromBundle(getArguments()).getDec();
        Call<Rootdec> rootdecCall = categoryinterface.getdecbyMeal(Meals);
        rootdecCall.enqueue(new Callback<Rootdec>() {
            @Override
            public void onResponse(Call<Rootdec> call, Response<Rootdec> response) {

                binding.text.setText(response.body().meals.get(0).getStrMeal());
                Glide.with(getContext()).
                        load(response.body().meals.get(0).getStrMealThumb()).into(binding.productImage
                        );

                binding.Instructions.setText(response.body().meals.get(0).getStrInstructions());
                binding.Category.setText(response.body().meals.get(0).getStrCategory());
                binding.Ingredient1.setText(response.body().meals.get(0).getStrIngredient1());
                binding.Ingredient2.setText(response.body().meals.get(0).getStrIngredient2());
                binding.Ingredient3.setText(response.body().meals.get(0).getStrIngredient3());
                binding.Ingredient4.setText(response.body().meals.get(0).getStrIngredient4());
                binding.Ingredient5.setText(response.body().meals.get(0).getStrIngredient5());
                binding.Ingredient6.setText(response.body().meals.get(0).getStrIngredient6());
                binding.Measure1.setText(response.body().meals.get(0).getStrMeasure1());
                binding.Measure2.setText(response.body().meals.get(0).getStrMeasure2());
                binding.Measure3.setText(response.body().meals.get(0).getStrMeasure3());
                binding.Measure4.setText(response.body().meals.get(0).getStrMeasure4());
                binding.Measure5.setText(response.body().meals.get(0).getStrMeasure5());
                binding.Measure6.setText(response.body().meals.get(0).getStrMeasure6());



            }

            @Override
            public void onFailure(Call<Rootdec> call, Throwable t) {


            }
        });
    }
}