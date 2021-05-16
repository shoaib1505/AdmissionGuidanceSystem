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
/**
 * Created by Waqar on 1/31/2018.
 */

public class E_R_Tab_Eligibility_Criteria2 extends Fragment {

    WebView wv;
    ActionBar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.e_r_tab_eligibilty_criteria2, container, false);

        toolbar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
        toolbar.setTitle("Eligibility/Rules");

        wv = (WebView) rootView.findViewById(R.id.webc2);
        wv.loadUrl("file:///android_asset/DirectsecondyearEC.html");

        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);

        //make webview zoomable
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setDisplayZoomControls(true);

        // Enable Javascript
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        wv.setWebViewClient(new WebViewClient());

        return rootView;
    }
}
