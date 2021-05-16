package com.org.arkp.admissionguidance;

import android.content.Intent;
import android.net.Uri;
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

public class Tab_Scholarship2 extends Fragment {

    ActionBar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_scholarship, container, false);

        toolbar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        toolbar.setTitle("Scholarship");

        return rootView;
    }

    public void onDTEMaharashtraWebsite(View rootView) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dtemaharashtra.gov.in/scholarships/"));
        startActivity(intent);

    }

    public void onMAHADBTWEBSITE(View rootView) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mahadbt.gov.in/DBT/#/"));
        startActivity(intent);

    }
}


