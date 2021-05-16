package com.org.arkp.admissionguidance;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dell on 2/16/2018.
 */

public class Tab_Branches2 extends android.support.v4.app.Fragment {

        ActionBar toolbar;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_branches, container, false);

        toolbar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
        toolbar.setTitle("Branches");

        return rootView;
        }
        }