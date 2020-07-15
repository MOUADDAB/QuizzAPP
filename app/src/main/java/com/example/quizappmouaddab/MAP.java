package com.example.quizappmouaddab;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MAP  extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_a_p);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng emsi = new LatLng(33.541747, -7.673215);
        mMap.addMarker(new MarkerOptions().position(emsi).title("M nabil in Emsi").snippet("OK!!!!").icon(BitmapDescriptorFactory.fromResource(R.drawable.nabil1)));
        Circle circlet =mMap.addCircle( new CircleOptions() .center(emsi) .radius(100) .fillColor(Color.GREEN) .strokeColor(Color.GREEN));

        // add Toto Position near Emsi

        LatLng Toto = new LatLng(33.545447, -7.673215);
        mMap.addMarker(new MarkerOptions().position(Toto).title("M TOTO in Emsi").snippet("OK!!!!").icon(BitmapDescriptorFactory.fromResource(R.drawable.toto)));
        Circle circlet1 =mMap.addCircle( new CircleOptions() .center(Toto) .radius(100) .fillColor(Color.RED) .strokeColor(Color.RED));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(emsi,16));
    }
}
