package com.example.android_navigation_bottomnavbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, 0, systemBars.right, 0);
            return insets;
        });

        Toolbar tb = findViewById(R.id.tool_bar);
        setSupportActionBar(tb);

        NavController ctrl = Navigation.findNavController(findViewById(R.id.nav_host_frag));

        BottomNavigationView bottom_nav = findViewById(R.id.bottm_nav_bar);
        NavigationUI.setupWithNavController(bottom_nav, ctrl);

        AppBarConfiguration app_bar_conf = new AppBarConfiguration.Builder(ctrl.getGraph()).build();
        NavigationUI.setupWithNavController(tb, ctrl, app_bar_conf);

    }
}