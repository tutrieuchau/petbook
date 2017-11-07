package com.tutrieuchau.petbook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.tutrieuchau.petbook.Fragment.CategoryFragment;
import com.tutrieuchau.petbook.Fragment.DoctorFragment;
import com.tutrieuchau.petbook.Fragment.SettingFragment;
import com.tutrieuchau.petbook.R;
import com.tutrieuchau.petbook.Utils.Utils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    private int navItemIndex;
    private String CURRENT_TAG;
    // tags used to attach the fragments
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_DOCTOR = "doctor";
    private static final String TAG_ANALYSE = "analyse";
    private static final String TAG_REWARD = "reward";
    private static final String TAG_HISTORY = "history";
    private static final String TAG_SETTING = "setting";
    private static final String TAG_LOVE = "love";
    private static final String TAG_HELP = "help";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null){
            navItemIndex = 0;
            CURRENT_TAG = TAG_CATEGORY;
            loadHomeFragment();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id){
            case R.id.nav_home:
                navItemIndex = 0;
                CURRENT_TAG = TAG_CATEGORY;
                break;
            case R.id.nav_doctor:
                navItemIndex = 1;
                CURRENT_TAG = TAG_DOCTOR;
                break;
            case R.id.nav_upgrade:
                navItemIndex = 0;
                CURRENT_TAG = TAG_CATEGORY;
                Intent upgradeIntent = new Intent(this,UpgradeActivity.class);
                startActivity(upgradeIntent);
                break;
            case R.id.nav_setting:
                navItemIndex = 0;
                CURRENT_TAG = TAG_CATEGORY;
                Intent settingIntent = new Intent(this,SettingActivity.class);
                startActivity(settingIntent);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        loadHomeFragment();
        return true;
    }

    private Fragment getHomeFragment(){
        switch (navItemIndex) {
            case 0:
                CategoryFragment categoryFragment = new CategoryFragment();
                return categoryFragment;
            case 1:
                DoctorFragment doctorFragment = new DoctorFragment();
                return doctorFragment;
            default:
                return new CategoryFragment();

        }
    }

    /**
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment(){
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        // show Fragment with fade Animation
        Handler handler = new Handler();
        handler.post(mPendingRunnable);

        // refresh toolbar menu
        invalidateOptionsMenu();
        setToolbarTitle();

    }
    private void setToolbarTitle() {
        getSupportActionBar().setTitle(getResources().getStringArray(R.array.fragment_titles)[navItemIndex]);
    }

    @Override
    public void onClick(View v) {

    }

}
