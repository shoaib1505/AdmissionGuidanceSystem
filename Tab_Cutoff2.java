package com.org.arkp.admissionguidance;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by WAQAR on 24/01/2018.
 */

public class Tab_Cutoff2 extends Fragment {

    private WebView wv;
    String answer;
    ActionBar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cutoff_tab2, container, false);

        toolbar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
        toolbar.setTitle("Cutoff");

        wv = (WebView)rootView.findViewById(R.id.webcutoff2);
        wv.loadUrl("file:///android_asset/Directsecondyearcutoff.html");

        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);

        //make webview zoomable
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setDisplayZoomControls(true);

        // Enable Javascript
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String answer;
        answer = "Please wait loading Cutoff II...";
        Toast.makeText(getActivity(), answer, Toast.LENGTH_SHORT).show();

        // Force links and redirects to open in the WebView instead of in a browser
        wv.setWebViewClient(new WebViewClient());
        return rootView;
    }
}