package com.org.arkp.admissionguidance;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //check internet
        ConnectivityManager cm = (ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null == activeNetwork) {
            answer = "Please check internet connection!!";
            Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
        }
        else {
            answer = "Please wait loading college Location";
            Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
        }

    }

    // back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(MapsActivity.this, Home.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //kill Current activity on back button pressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MapsActivity.this, Home.class);
        startActivity(intent);
        finish();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng arkploc = new LatLng(19.0004, 73.1050);
        mMap.addMarker(new MarkerOptions().position(arkploc).title("AI-ARKP Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(arkploc));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);
        float zoomLevel = (float) 18.0;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arkploc, zoomLevel));
    }
}
