package com.example.android_navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavController ctrl = Navigation.findNavController(findViewById(R.id.nav_host_frag));
        Button home_b = findViewById(R.id.home_btn);
        home_b.setOnClickListener((View v)->{
            ctrl.popBackStack();
        });
        Button about_b = findViewById(R.id.about_btn);
        about_b.setOnClickListener((View v)->{
            ctrl.navigate(R.id.action_homeFragment_to_aboutFragment);
        });
        Button profile_b = findViewById(R.id.profile_btn);
        profile_b.setOnClickListener((View v)->{
            ctrl.navigate(R.id.action_homeFragment_to_profileFragment);
        });

    }
}