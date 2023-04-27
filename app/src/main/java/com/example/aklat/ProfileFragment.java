package com.example.aklat;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aklat.databinding.FragmentMealBinding;
import com.example.aklat.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class ProfileFragment extends Fragment {

    SharedPreferences shearprf;
    FragmentProfileBinding binding;
    String name_text, email_text;

    private FirebaseAuth mAuth ;
    private static final String KEY_Name = "name";
    private static final String KEY_EMAIL= "email";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(getLayoutInflater());
mAuth = FirebaseAuth.getInstance();
            return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shearprf = getContext().getSharedPreferences("myPref",MODE_PRIVATE);
        String name = shearprf.getString(KEY_Name,"");
        String email = shearprf.getString(KEY_EMAIL,"");
            binding.name.setText("My Name :"+name);
            binding.emailset.setText("My Email :"+email);
            binding.logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAuth.signOut();
                    Intent intent = new Intent(getActivity() , MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });

    }
}