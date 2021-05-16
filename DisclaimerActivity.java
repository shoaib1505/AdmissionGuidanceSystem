package com.org.arkp.admissionguidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class DisclaimerActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_disclaimer);
        getSupportActionBar().hide();
        Window w = this.getWindow();
        //set task bar translucent & also color
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        webView=(WebView)findViewById(R.id.webViewDis);

        String myHtmlString = "<html><body>" +
                "<h5>1.All the document is as per rule of DTE & College.</h5>\n" +
                "<h5>2.All the websites mentioned in app is official</h5>\n" +
                "<h5>3.This app is only for Admission Guidance.</h5>\n" +
                "<h5>4.Any failure in admission progress of Candidate we will not be responsible</h5>\n" +
                "<h5>5.Stay connected with internet for latest news. </h5>\n" +
                "<h5>6.After Confirmation of Admission then pay fees</h5>\n" +
                "</body></html>";
        webView.loadData(myHtmlString, "text/html", null);



    }



    public void btnLoginPage(View v)
    {
        Intent intent =new Intent(this,LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        finish();
    }
}
