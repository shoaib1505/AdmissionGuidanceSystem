package com.org.arkp.admissionguidance;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class WebsitesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        Window w = this.getWindow();
        //set task bar translucent & also color
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        setTitle("Important Websites");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(WebsitesActivity.this, Home.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(WebsitesActivity.this, Home.class);
        startActivity(intent);
        finish();
    }

    public void onOfficialARKPWebsite(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://aiarkp.org/"));
        startActivity(intent);

    }

    public void onOfficialMSBTEWebsite(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://msbte.org.in/"));
        startActivity(intent);

    }

    public void onOfficialDTEWebsite(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dtemaharashtra.gov.in/"));
        startActivity(intent);

    }
}

