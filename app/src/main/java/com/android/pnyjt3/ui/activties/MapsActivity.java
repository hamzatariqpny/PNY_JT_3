package com.android.pnyjt3.ui.activties;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.pnyjt3.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Button Bzoomin , Bzoomout , Btype ,Bsearch;
    EditText TFaddress;

    private static final int REQUEST_PERMISSIONS_LOCATION = 120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bzoomin = findViewById(R.id.Bzoomin);
        Bzoomout = findViewById(R.id.Bzoomout);
        Btype = findViewById(R.id.Btype);
        Bsearch = findViewById(R.id.Bsearch);
        TFaddress = findViewById(R.id.TFaddress);

        Bzoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });

        Bzoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });

        Btype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }else if(mMap.getMapType() == GoogleMap.MAP_TYPE_SATELLITE) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }else if(mMap.getMapType() == GoogleMap.MAP_TYPE_HYBRID) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                } else{
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }

            }
        });


        Bsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String  address=  TFaddress.getText().toString();
                List<Address> addressList = null;
                if(address.isEmpty()){
                    Toast.makeText(MapsActivity.this, "Please enter some value", Toast.LENGTH_SHORT).show();
                }else {

                    Geocoder geocoder = new Geocoder(MapsActivity.this);

                    try {
                        addressList = geocoder.getFromLocationName(address,1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(addressList !=null){
                        if(addressList.size()>0){

                            Address address1 = addressList.get(0);

                            LatLng latLng = new LatLng(address1.getLatitude(),address1.getLongitude());

                            mMap.addMarker(new MarkerOptions().position(latLng).title(address));
                            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                        }
                    }else {
                        Toast.makeText(MapsActivity.this, "NO data found", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
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

        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
         if(permission == PackageManager.PERMISSION_GRANTED){

             mMap.getUiSettings().setMyLocationButtonEnabled(true);
             mMap.setMyLocationEnabled(true);

         }else {
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                 requestPermissions(new String[]{
                         Manifest.permission.ACCESS_FINE_LOCATION
                 },REQUEST_PERMISSIONS_LOCATION);
             }
         }



    }
}