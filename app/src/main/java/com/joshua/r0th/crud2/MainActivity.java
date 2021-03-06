package com.joshua.r0th.crud2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String move = new LoginActivity().Email;
        Bundle b = new Bundle();
        move = b.getString("UserInput");

        Toast.makeText(getApplicationContext(),move,Toast.LENGTH_SHORT).show();

        //Untuk men set navigasi drawer yang ada di sebelah kiri dan list yaang di bawa ex nav_profile
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_profile,
                R.id.nav_home, R.id.nav_pantuan, R.id.nav_riwayat,
                R.id.nav_about, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //Untuk Memanggil profile user
    public void goProfile(View view) {
        setContentView(R.layout.fragment_profile);
    }

    public void goLogout(View view) {
        Intent goLog = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(goLog);
    }
    public void hide(View view){
        TextView textView = findViewById(R.id.pswrdd);

        //Toggle
        if (textView.getVisibility() == View.INVISIBLE)
            textView.setVisibility(View.VISIBLE);
        else if (textView.getVisibility() == View.VISIBLE)
            textView.setVisibility(View.INVISIBLE);
        else
            textView.setVisibility(View.VISIBLE);

        //If you want it only one time
        //txtView.setVisibility(View.VISIBLE);
    }

}