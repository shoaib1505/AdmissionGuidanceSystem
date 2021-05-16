package com.org.arkp.admissionguidance;

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

import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

/**
 * Created by Dell on 2/16/2018.
 */

public class Tab1_AdmissionSteps extends Fragment  {

    WebView wv;
    ActionBar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admissionsteps_tab1, container, false);
        toolbar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
        toolbar.setTitle("Admission Steps");

        wv = (WebView)rootView.findViewById(R.id.webadmstep);
        wv.loadUrl("file:///android_asset/Admissionoverviewsteps.html");

        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);

        //make webview zoomable
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setDisplayZoomControls(true);

        // Enable Javascript
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String answer;
        answer = "Please wait loading Admission Steps...";
        Toast.makeText(getActivity(), answer, Toast.LENGTH_SHORT).show();

        // Force links and redirects to open in the WebView instead of in a browser
        wv.setWebViewClient(new WebViewClient());

        return rootView;
    }

}
