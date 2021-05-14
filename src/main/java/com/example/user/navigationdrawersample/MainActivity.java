package com.example.user.navigationdrawersample;

import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        toggleDrawer();
        initializeDefaultFragment(savedInstanceState,0);
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar_id);
        toolbar.setTitle(R.string.toolbar_title);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout_id);
        frameLayout = findViewById(R.id.framelayout_id);
        navigationView = findViewById(R.id.navigationview_id);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initializeDefaultFragment(Bundle savedInstanceState, int itemIndex){
        if (savedInstanceState == null){
            MenuItem menuItem = navigationView.getMenu().getItem(itemIndex).setChecked(true);
            onNavigationItemSelected(menuItem);
        }
    }

    private void toggleDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        switch (menuItem.getItemId()){
            case R.id.nav_darshan_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new KhatuDarshanFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_saadhna_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new KhatuSaadhnaFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_chalisa_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new ShyamChalisaFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_bank_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new ShyamBankFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_mahima_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new HelpFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_feedback_id:
                bundle.putString("url", "https://www.facebook.com/androidhungerAH");
//                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new FacebookFragment())
//                        .commit();
                fragment = new FacebookFragment();
                fragment.setArguments(bundle);
                closeDrawer();
                break;
            case R.id.nav_help_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new HelpFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_facebook_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new FacebookFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_twitter_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new TwitterFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_insta_idd:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new InstagramFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_utube_idd:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new YoutubeFragment())
                        .commit();
                closeDrawer();
                break;
//
        }
        return true;
    }

    private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

}
