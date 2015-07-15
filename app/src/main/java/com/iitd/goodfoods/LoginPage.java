package com.iitd.goodfoods;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;


public class LoginPage extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private GoogleApiClient mGoogleApiClient;

    private static final int RC_SIGN_IN = 0;

    //Button sign;


    /*Is there a ConnectionResult resolution in progress? */
    private boolean mIsResolving = false;

    /* Should we automatically resolve ConnectionResults when possible? */
    private boolean mShouldResolve = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        findViewById(R.id.sign_in_button).setOnClickListener(this);

        findViewById(R.id.sign_in_button).setOnClickListener(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN)
                .addScope(Plus.SCOPE_PLUS_PROFILE)
                .build();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_page, menu);
        return true;

    }


    public void onClick(View v) {
        if (v.getId() == R.id.sign_in_button) {
            mShouldResolve=true;
            mGoogleApiClient.connect();
        }
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
    public void onConnected(Bundle bundle) {
// onConnected indicates that an account was selected on the device, that the selected
        // account has granted any requested permissions to our app and that we were able to
        // establish a service connection to Google Play services.
        Log.d("tag", "onConnected:" + bundle);
        mShouldResolve = false;

//        userinfo user = new userinfo();
//        if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null) {
//            user.currentperson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
//            user.name = user.currentperson.getDisplayName();
//            user.emailid = Plus.AccountApi.getAccountName(mGoogleApiClient);
//            //String personPhoto = currentPerson.getImage();
//            user.personGooglePlusProfile = user.currentperson.getUrl();
//
//            Log.d("tag",user.name+"  "+user.emailid);
//
//            // Show the signed-in UI
//            showSignedInUI();
//        }

    }


    @Override
    public void onConnectionSuspended(int i) {
        Log.d("tag", "bullshit" + i);
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("tag", "onActivityResult:" + requestCode + ":" + resultCode + ":" + data);

        if (requestCode == RC_SIGN_IN) {
            // If the error resolution was not successful we should not resolve further.
            if (resultCode != RESULT_OK) {
            }
            else {
                mShouldResolve = true;
                mGoogleApiClient.connect();
            }
            Log.d("tag","in activity result");

        }
    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // Could not connect to Google Play Services.  The user needs to select an account,
        // grant permissions or resolve an error in order to sign in. Refer to the javadoc for
        // ConnectionResult to see possible error codes.
        Log.d("tag", "onConnectionFailed:" + connectionResult);

        if (!mIsResolving && mShouldResolve) {
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this, RC_SIGN_IN);
                    mIsResolving = true;
                } catch (IntentSender.SendIntentException e) {
                    Log.d("tag", "Could not resolve ConnectionResult.", e);
                    //mIsResolving = false;
                    // mGoogleApiClient.connect();
                }
            } else {
                // Could not resolve the connection result, show the user an
                // error dialog.
                //showErrorDialog(connectionResult);
            }
        } else {
            // Show the signed-out UI
            showSignedOutUI();
        }
    }

    public void showSignedOutUI(){
        Log.d("tag", "successfully signed out");
//        Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
//        mGoogleApiClient.disconnect();

    }

    public void showSignedInUI(){
        Log.d("tag", "Successful");
        //Intent intent=new Intent(this,MainActivity.class);
        Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
        mGoogleApiClient.disconnect();
        Log.d("tag", "Successful");

    }

}