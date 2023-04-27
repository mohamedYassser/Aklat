package com.example.aklat;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.aklat.databinding.FragmentHomeBinding;
import com.example.aklat.homeFragmentDirections.ActionHomeFragmentToMealFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class    homeFragment extends Fragment {
    FragmentHomeBinding binding;

    Categoryinterface categoryinterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryinterface = ApiController.apiinterface;
        Call<Root> rootCall = categoryinterface.getCategories();
        rootCall.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
               try {
                   binding.rec.setLayoutManager(new GridLayoutManager(requireContext(), 2));
                   binding.rec.setAdapter(new categoryadabter(response.body().categories, new com.example.aklat.Callback() {
                       @Override
                       public void getCategoryName(String catName) {
                           ActionHomeFragmentToMealFragment action = homeFragmentDirections.actionHomeFragmentToMealFragment(catName);
                           Navigation.findNavController(view).navigate(action);
                       }
                   }
                   ));

               } catch(Exception e) {

                   

                   Toast.makeText(getContext() , "api faild " ,  Toast.LENGTH_LONG).show();

                }
            }


            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.e("response", t.getMessage());

            }
        });


    }


}


