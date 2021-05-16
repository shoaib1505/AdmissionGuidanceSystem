package com.org.arkp.admissionguidance;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

/**
 * Created by Dell on 2/16/2018.
 */

public class Tab2_AdmissionSteps extends Fragment implements View.OnClickListener {
    WebView wv;
    ActionBar toolbar;

   Button b1,b2,b3,b4,b5,b6;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admissionsteps_tab2, container, false);
        getActivity().getActionBar();
        toolbar =  ((AppCompatActivity)getActivity()).getSupportActionBar();

       b1 = (Button) view.findViewById(R.id.admissionformfilling);
        b2 = (Button) view.findViewById(R.id.documentrequirement);
        b3 = (Button) view.findViewById(R.id.adguide);
        b4 =(Button) view.findViewById(R.id.scdates);
        b5 = (Button) view.findViewById(R.id.feeApproved);
        b6 = (Button) view.findViewById(R.id.feeStruct);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        return view;


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.admissionformfilling:
                Intent i1 =new Intent(getActivity(),AddmissionformFActivity.class);
                startActivity(i1);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                break;


            case R.id.documentrequirement:
                Intent i2 =new Intent(getActivity(),DocumentRequirementActivity.class);
                startActivity(i2);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                break;


            case R.id.scdates:
                Intent i3 =new Intent(getActivity(),AdmmScheduleDatesActivity.class);
                startActivity(i3);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                break;


            case R.id.adguide:
                Intent i4 =new Intent(getActivity(),AdmissionGuidelinesActivity.class);
                startActivity(i4);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                break;


            case R.id.feeApproved:
                Intent i5 =new Intent(getActivity(),FeesStructureApprovedActivity.class);
                startActivity(i5);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                break;


            case R.id.feeStruct:
                Intent i6 =new Intent(getActivity(),FeesStructureActivity.class);
                startActivity(i6);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                break;

        }

    }
}
