package com.iitd.goodfoods;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class LocalityPage extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locality_page);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayList<String> entries = new ArrayList<>(Arrays.asList("IIT Delhi","Hauz Khas"));

        adapter=  new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, entries);

//        adapter = ArrayAdapter.createFromResource(this,R.array.info,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Netaji Nagar");
        adapter.add("R.K.Puram");
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
//        String label = parent.getItemAtPosition(pos).toString();
////        Toast.makeText(getBaseContext(), (CharSequence) parent.getItemAtPosition(pos), Toast.LENGTH_LONG).show();
//        Log.d("farantttt", label);
//        TextView tt = (TextView)findViewById(R.id.textView);
//        tt.setText(label);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void GoToStorePage(View view) {
        Intent bleh = new Intent(this,PageNavigator.class);
        startActivity(bleh);
    }
}
