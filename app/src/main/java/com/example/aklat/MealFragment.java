package com.example.aklat;

import static com.example.aklat.MealFragmentDirections.*;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aklat.MealFragmentDirections;
import com.example.aklat.databinding.FragmentMealBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealFragment extends Fragment {
    private FragmentMealBinding binding;
    private Categoryinterface categoryinterface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMealBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryinterface = ApiController.apiinterface;

        String Category = MealFragmentArgs.fromBundle(getArguments()).getCat();
        Call<Rootmeal> rootmealCall = categoryinterface.getMealByCategory(Category);

        rootmealCall.enqueue(new Callback<Rootmeal>() {
            @Override
            public void onResponse(Call<Rootmeal> call, Response<Rootmeal> response) {


                binding.recmeal.setLayoutManager(new GridLayoutManager(requireContext(), 2));
                binding.recmeal.setAdapter(new MealsAdabter(response.body().meals, new  com.example.aklat.Callbackdec() {
                    @Override
                    public void getdecName(String decName) {

                        ActionMealFragmentToDecFragment action = MealFragmentDirections.actionMealFragmentToDecFragment(decName);
                        Navigation.findNavController(view).navigate(action);
                    }
                }));

            }

            @Override
            public void onFailure(Call<Rootmeal> call, Throwable t) {

            }
        });


    }


}
