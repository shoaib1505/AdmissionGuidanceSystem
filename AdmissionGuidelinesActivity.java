package com.org.arkp.admissionguidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;

public class AdmissionGuidelinesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_guidelines);

        setTitle("Admission Guidelines");
        Window w = this.getWindow();

        //set task bar translucent & also color

        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //w.setStatusBarColor(Color.parseColor("#FFFA635E"));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        WebView wv;

        wv = (WebView) findViewById(R.id.Webgui);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.loadUrl("file:///android_asset/Ams.html");

        //make webview zoomable
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setDisplayZoomControls(false);

        String answer;
        answer = "Please wait loading Admission Guidelines...";
        Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
    }

    // back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(AdmissionGuidelinesActivity.this, AdmissionStepsActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //kill Current College info activity on back button pressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AdmissionGuidelinesActivity.this, AdmissionStepsActivity.class);
        startActivity(intent);
        finish();
    }

}
