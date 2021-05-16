package com.org.arkp.admissionguidance;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class BranchesActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branches);
        setTitle("Branches");

        Window w = this.getWindow();

        //set task bar translucent & also color
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // w.setStatusBarColor(Color.parseColor("#FFFA635E"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new BranchesActivity.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    //First shift Mechanical Branch Intent
    public void onME(View v)
    {
        Intent intent =new Intent(this,First_MeActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //Firsst shift computet Branch Intent
    public void onCO(View v)
    {
        Intent intent =new Intent(this,First_CoActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }


    //First shift Civil Branch Intent
    public void onCI(View v)
    {
        Intent intent =new Intent(this,First_CIActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //First shift Electrical Branch Intent
    public void onEL(View v)
    {
        Intent intent =new Intent(this,First_ElActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //First shift Electrical & telecomm Branch Intent
    public void onET(View v)
    {
        Intent intent =new Intent(this,First_ETActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //First shift Humanity & science Branch Intent
    public void onHS(View v)
    {
        Intent intent =new Intent(this,First_HSActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //Second shift mechanical Branch Intent
    public void onME2(View v)
    {
        Intent intent =new Intent(this,Second_MeActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //Second shift Computer Branch Intent
    public void onCO2(View v)
    {
        Intent intent =new Intent(this,Second_CoActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    //Second shift Civil Branch Intent
    public void onCI2(View v)
    {
        Intent intent =new Intent(this,Second_CIActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }


    //Second shift Humanity & Science Branch Intent
    public void onHS2(View v)
    {
        Intent intent =new Intent(this,Second_MeActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(BranchesActivity.this, Home.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //kill Current College info activity on bacl button pressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BranchesActivity.this, Home.class);
        startActivity(intent);
        finish();
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    Tab_Branches1 tab_branches1 = new Tab_Branches1();
                    return tab_branches1;
                case 1:
                    Tab_Branches2 tab_branches2 = new Tab_Branches2();
                    return tab_branches2;
                default:
                    return null;

            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "First Shift";
                case 1:
                    return "Second Shift";
            }
            return null;
        }
    }

}
