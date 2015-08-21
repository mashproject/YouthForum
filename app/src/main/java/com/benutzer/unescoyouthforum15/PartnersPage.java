package com.benutzer.unescoyouthforum15;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;


public class PartnersPage extends BaseDrawerActivity {
    ListView listView;
    ListAdapter listAdapter;
    String[] partnersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners_page);
        super.onCreateDrawer();
        listView = (ListView) findViewById(R.id.partnerListViewId);

        loadPartnersDetail();
        //In handler function
        displayPartnersDetail();
    }

    private void loadPartnersDetail(){
        /*
        loading contetn from server
         */
        partnersList = new String[]{"1","2","3","4"};
    }

    private void displayPartnersDetail(){
        listAdapter = new PartnersAdapter(this, partnersList);
        listView.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_partners_page, menu);
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

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
