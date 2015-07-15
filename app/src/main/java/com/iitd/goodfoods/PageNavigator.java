package com.iitd.goodfoods;

import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class PageNavigator extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_navigator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_navigator, menu);
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

    public void GoToWelcome(View view) {
        Intent bleh = new Intent(this,WelcomePage.class);
        startActivity(bleh);
    }

    public void GoToFAQ(View view) {
        Intent bleh = new Intent(this,FaqPage.class);
        startActivity(bleh);
    }

    public void GoToProduct(View view) {
        Intent bleh = new Intent(this,ProductInfoPage.class);
        startActivity(bleh);
    }

    public void GoToExit(View view) {
        Intent bleh = new Intent(this, CheckoutPage.class);
        startActivity(bleh);
    }

    public void GoToStore(View view) {
        Intent bleh = new Intent(this,LocalityPage.class);
        startActivity(bleh);
    }

    public void GoToLogin(View view) {
        Intent bleh = new Intent(this,LoginPage.class);
        startActivity(bleh);
    }

    public void GoToFbLogin(View view) {
        Intent bleh = new Intent(this,FbLoginPage.class);
        startActivity(bleh);
    }
}
