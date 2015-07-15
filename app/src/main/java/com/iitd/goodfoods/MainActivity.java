package com.iitd.goodfoods;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (IfFirstTime())
        {
            TextView t1= (TextView) findViewById(R.id.toptitle);
            t1.setText("first time app opened");
            Intent bleh = new Intent(this,PageNavigator.class);
            startActivity(bleh);
        }
        else{
            TextView t1= (TextView) findViewById(R.id.toptitle);
            t1.setText("app opened previously");
            Intent bleh = new Intent(this,PageNavigator.class);
//            Intent bleh = new Intent(this,LoginPage.class);
            startActivity(bleh);

        }
    }

    public boolean IfFirstTime()
    {
        File file = new File(getFilesDir(), "firsttime.txt");
        if (file.exists())
        {
            return false;
        }
        else
        {
            Log.d("randomtag", "need to createfile");
            FileOutputStream outputStream;
            try {
                outputStream = openFileOutput("firsttime.txt", Context.MODE_PRIVATE);
                outputStream.write("hello".getBytes());
                outputStream.close();
            } catch (Exception e) {
                Log.d("randomtag","In catch");
                e.printStackTrace();
            }
        }
        return true;
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
}