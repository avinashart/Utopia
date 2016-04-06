package com.justmailtoavi.avinashk.utopia;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        Fragment fragment;
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        fragment = new container();
        ft.replace(R.id.main,fragment,null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (doubleBackToExitPressedOnce) {
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
            finish();
        }
        doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "double tap BACK to exit app!", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 1200);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.rules) {
            Intent intent = new Intent(MainActivity.this,rules.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.about_dev){
            Intent intent = new Intent(MainActivity.this,about_dev.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment;
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        int id = item.getItemId();
        if (id == R.id.events_list) {

            fragment = new events_list_fragment();
            ft.replace(R.id.main,fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();

        } else if (id == R.id.team_info) {

            Intent intent = new Intent(MainActivity.this,teams_info.class);
            startActivity(intent);

        } else if (id == R.id.winner) {

            Intent intent = new Intent(MainActivity.this,winner_list.class);
            startActivity(intent);

        } else if (id == R.id.event_coordinator) {


        } else if (id == R.id.feedback) {

            Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "justmailtoavi@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Utopia Feedback System");
            startActivity(intent);

        } else if (id == R.id.t_shirt) {

            Intent intent = new Intent(MainActivity.this,t_shirt.class);
            startActivity(intent);

        }else if( id == R.id.core_team){


        }else if (id == R.id.gallery){
            Intent intent = new Intent(MainActivity.this,gallery.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
