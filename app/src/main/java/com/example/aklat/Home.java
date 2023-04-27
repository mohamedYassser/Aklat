package com.example.aklat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Switch;

import com.example.aklat.databinding.ActivityHomeBinding;

public class
Home extends AppCompatActivity {
    ActivityHomeBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot());
        NavHostFragment navHostFragment  = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);
//binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()){
//                case  R.id.Favorite:
//                    replaceFragment(new FavFragment());
//                    break;
//                case R.id.Profile:
//                    replaceFragment(new ProfileFragment());
//                    break;
//                case R.id.Search:
//                    replaceFragment(new SearchFragment());
//                    break;
//                case R.id.Home:
//                    replaceFragment(new homeFragment());
//                    break;
//            }
//            return true;
//}
//);





    }

}