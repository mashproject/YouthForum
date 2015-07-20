package com.benutzer.unescoyouthforum15;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Map;


public class BaseDrawerActivity extends ActionBarActivity {
    public DrawerLayout drawerLayout;
    public ListView drawerList;
    private ActionBarDrawerToggle actionBarDrawerToggle;
   // private Map map;
    private Toolbar toolbar;

    //@Override
    protected void onCreateDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = new Toolbar(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle((Activity) this, drawerLayout, toolbar, 0, 0) {
            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(R.string.app_name);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(R.string.menu);
            }
        };
        toolbar.setNavigationIcon(R.mipmap.ic_drawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerList.setAdapter(new DrawerAdapter(this, getResources().getStringArray(R.array.drawerOption)));

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switchActivities(position);
            }
        });

    }

    private void switchActivities(int pos) {
        switch (pos) {
            case 1: {
                Intent intent = new Intent(this, AboutPage.class);
                startActivity(intent);
                break;
            }
            case 5: {
                Intent intent = new Intent(this, BrowseEvents.class);
                startActivity(intent);
                break;
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
