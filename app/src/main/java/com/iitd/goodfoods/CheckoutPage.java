package com.iitd.goodfoods;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CheckoutPage extends Activity {
    private TextView txt_help_gest;
    private LinearLayout l1;
    private Button first;
    private Button personal;
    private Button offrs;
    private Button deliveryop;
    private Button address;
    private Button order;
    private Button offers;
    private Button paymentop;

    private LinearLayout personallayout;
    private LinearLayout addresslayout;
    private LinearLayout deliveryoplay;
    private RadioButton paymentoplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);

        personallayout = (LinearLayout) findViewById(R.id.personalinform);
        addresslayout = (LinearLayout) findViewById(R.id.addressfill);
        deliveryoplay = (LinearLayout) findViewById(R.id.deliveryoplayout);
        paymentoplay = (RadioButton) findViewById(R.id.cashondelivery);
        personallayout.setVisibility(View.GONE);
        addresslayout.setVisibility(View.GONE);
        deliveryoplay.setVisibility(View.GONE);
        paymentoplay.setVisibility(View.GONE);
//        l1 = (LinearLayout) findViewById(R.id.linid);
//        txt_help_gest = (TextView) findViewById(R.id.txt_help_gest);
//        first = (Button) findViewById(R.id.button1);
        // hide until its title is clicked
//        txt_help_gest.setVisibility(View.GONE);

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

    //    public void changevisibiity(View view) {
//    }
    public static void slide_down(Context ctx, View v){
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }
    public static void slide_up(Context ctx, View v){
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }


//    public void toggle_contents(View view) {
//
//        txt_help_gest.setVisibility( txt_help_gest.isShown()
//                        ? View.GONE
//                        : View.VISIBLE );
//    }

    public void toggle_contents(View v){
        if(l1.isShown()){
            l1.setVisibility(View.GONE);
//            slide_up(this, txt_help_gest);
//            slide_up(this, first);


        }
        else{
            l1.setVisibility(View.VISIBLE);
            slide_down(this, l1);
//            slide_down(this, first);
        }
    }

    public void personalinfo(View view) {
        if(personallayout.isShown()){
            personallayout.setVisibility(View.GONE);
        }
        else{
            personallayout.setVisibility(View.VISIBLE);
            slide_down(this,personallayout);
        }
    }

    public void addressfill(View view) {
        if(addresslayout.isShown()){
            addresslayout.setVisibility((View.GONE));
        }
        else{
            addresslayout.setVisibility(View.VISIBLE);
            slide_down(this,addresslayout);
        }
    }

    public void deliveryoptions(View view) {
        if(deliveryoplay.isShown()){
            deliveryoplay.setVisibility((View.GONE));
        }
        else{
            deliveryoplay.setVisibility(View.VISIBLE);
            slide_down(this,deliveryoplay);
        }
    }

    public void offers(View view) {
    }

    public void paymentoption(View view) {
        if(paymentoplay.isShown()){
            paymentoplay.setVisibility((View.GONE));
        }
        else{
            paymentoplay.setVisibility(View.VISIBLE);
            slide_down(this,paymentoplay);
        }
    }

    public void order(View view) {
    }

}
