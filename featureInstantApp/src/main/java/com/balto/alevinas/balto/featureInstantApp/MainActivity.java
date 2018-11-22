package com.balto.alevinas.balto.featureInstantApp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements MapFragment.OnFragmentInteractionListener, NotificationsFragment.OnFragmentInteractionListener, ReportFragment.OnFragmentInteractionListener, ReportsMenuFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener, StatusFragment.OnFragmentInteractionListener {

    private ActionBar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                toolbar.setTitle("Lucky");
                fragment = new StatusFragment();
                loadFragment(fragment);
                return true;
            } else if (id == R.id.navigation_dashboard) {
                toolbar.setTitle("Reportes");
                fragment = new ReportsMenuFragment();
                loadFragment(fragment);
                return true;
            } else if (id == R.id.navigation_configuration) {
                toolbar.setTitle("Configuración");
                fragment = new SettingsFragment();
                loadFragment(fragment);
                return true;
            } else if (id == R.id.navigation_notifications) {
                toolbar.setTitle("Notificaciones");
                fragment = new NotificationsFragment();
                loadFragment(fragment);
                return true;
            }
            return false;
        }
    };


    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Fragment fragment = new ReportFragment();
        loadFragment(fragment);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void loadWaterReport(View view) {
        ImageView iv = findViewById(R.id.reportImageView);
        iv.setImageResource(R.drawable.rep_agua);
    }

    public void loadFoodReport(View view) {
        ImageView iv = findViewById(R.id.reportImageView);
        iv.setImageResource(R.drawable.rep_comida);
    }

    public void loadTempReport(View view) {
        ImageView iv = findViewById(R.id.reportImageView);
        iv.setImageResource(R.drawable.rep_temp);
    }

    public void loadMap(View view) {
        Fragment fragment = new MapFragment();
        loadFragment(fragment);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Lucky");
        Fragment fragment = new StatusFragment();
        loadFragment(fragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
