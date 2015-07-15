package com.iitd.goodfoods;

//import android.support.v7.app.ActionBarActivity;
//import android.app.Fragment;
//import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
//import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class WelcomePage extends FragmentActivity  {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 3;


    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        Button b1= (Button) findViewById(R.id.buttongoon);
        b1.setVisibility(View.INVISIBLE);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Log.d("randomtag", "changed to  " + position);

                if (position==2)
                {
                    Button b1= (Button) findViewById(R.id.buttongoon);
                    b1.setVisibility(View.VISIBLE);
                    // Put an on click on b1
                }
                else
                {
                    Button b1= (Button) findViewById(R.id.buttongoon);
                    b1.setVisibility(View.INVISIBLE);
                }

                // When changing pages, reset the action bar actions since they are dependent
                // on which page is currently active. An alternative approach is to have each
                // fragment expose actions itself (rather than the activity exposing actions),
                // but for simplicity, the activity provides the actions in this sample.
                invalidateOptionsMenu();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_page, menu);
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

    public void goon(View view)
    {
//        Intent bleh = new Intent(this,FaqPage.class);
//        startActivity(bleh);
    }

    /**
     * A simple pager adapter that represents 5 {@link WelcomePageSliderFragment} objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return WelcomePageSliderFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    /*@Override
    public void onClick(View view){
        if(view.getId()==R.id.buttongoon)
        {
//            Intent bleh = new Intent(this,WelcomePage.class);
            Intent bleh = new Intent(this,LoginPage.class);
            startActivity(bleh);
        }
    }*/
}
