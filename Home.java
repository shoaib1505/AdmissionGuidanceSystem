package com.org.arkp.admissionguidance;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {


    public TextView t1;
    public FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        Window w = this.getWindow();
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //w.setStatusBarColor(Color.parseColor("#FFFA635E"));




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        /*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/
        t1 = (TextView)header.findViewById(R.id.headerusergmail);


        //News Running
        TextView tv = (TextView) this.findViewById(R.id.News);
        tv.setSelected(true);





    }


    //Cutoff Intent
    public void oncutoff(View v)
    {

        Intent intent =new Intent(this,CutoffActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }
    //Predictor Intent
    public void gotopredict(View v)
    {

        Intent intent =new Intent(this,PredictmarksActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //College Info Intent
    public void oncollegeinfo(View v)
    {
        Intent intent =new Intent(this,CollegeInfoActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //Branches Intent
    public void onBranches(View v)
    {
        Intent intent =new Intent(this,BranchesActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //AdmissionSteps Intent
    public void onAdmissionSteps(View v)
    {
        Intent intent =new Intent(this,AdmissionStepsActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //KeyDates Intent
    public void onKeyDates(View v)
    {
        Intent intent =new Intent(this,KeyDatesActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //WebSites Intent
    public void onWebsite(View v)
    {
        Intent intent =new Intent(this,WebsitesActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }


    //Scholarship Intent
    public void onScholarship(View v)
    {
        Intent intent =new Intent(this,ScholarshipActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }


    //Live Chat Intent
    public void onLC(View v)
    {
        Intent intent =new Intent(this,ChatbotAIListnerActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }


    //College Location Intent
    public void onCL(View v)
    {
        Intent intent =new Intent(this,MapsActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }


    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        builder.setMessage("Are you sure you want to Exit ?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialogLayout = builder.create();
        alertDialogLayout.show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_myaccount) {
            Intent i =new Intent(this, MyAccountActivity.class);
            startActivity(i);
            finish();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }else if (id == R.id.nav_notification) {

        } else if (id == R.id.nav_upgradeapp) {

        } else if (id == R.id.nav_faq) {
            Intent i =new Intent(this, FaqActivity.class);
            startActivity(i);
            finish();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        } else if (id == R.id.nav_share) {
            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plain");
            String shareBody ="Your Body Here";
            String shareSub ="Your Subject Here";
            myintent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
            myintent.putExtra(Intent.EXTRA_TEXT,shareBody);
            startActivity(Intent.createChooser(myintent,"Share Using"));

        } else if (id == R.id.nav_feedback) {
            Intent i =new Intent(this, FeedbackActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        } else if (id == R.id.nav_aboutus) {
            Intent i =new Intent(this, AboutusActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        }
        else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));



        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
