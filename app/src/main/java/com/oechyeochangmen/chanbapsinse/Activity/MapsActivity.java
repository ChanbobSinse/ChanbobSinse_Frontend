package com.oechyeochangmen.chanbapsinse.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.oechyeochangmen.chanbapsinse.GpsInfo;
import com.oechyeochangmen.chanbapsinse.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public static final int MY_FINE_LOCATION = 100;
    private GoogleMap mMap;
    private GpsInfo gpsInfo;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        gpsInfo = new GpsInfo(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(5);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            setLocation();

        } else {
            ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission_group.LOCATION);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission_group.LOCATION}, MY_FINE_LOCATION);
            mMap.setMyLocationEnabled(true);
            setLocation();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_FINE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setLocation();
                    return;
                } else {
                    Toast.makeText(getApplicationContext(), "사용 권한이 없습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }

                break;
            default:
                finish();
        }
    }

    @Override
    protected void onDestroy() {
        gpsInfo.stopUsingGPS();
        super.onDestroy();
    }

    void setLocation() {
        if (!gpsInfo.isGetLocation()) {
            gpsInfo.showSettingsAlert();
        } else {
            location = gpsInfo.getLocation();
            LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 13));
        }
        if (!gpsInfo.isGetLocation()) {
            Toast.makeText(getApplicationContext(), "GPS연결에 실패했습니다.\n다시 시도해주세요", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            location = gpsInfo.getLocation();
            LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 13));
        }
    }
}
