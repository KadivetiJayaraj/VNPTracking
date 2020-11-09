package com.dev.vnptracking.geofence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dev.vnptracking.R;
import com.dev.vnptracking.dashboard.DashboardActivity;
import com.dev.vnptracking.utils.UtilsClass;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddGeofenceActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE = 101;

    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.circleLayout) LinearLayout circleLayout;
    @BindView(R.id.polygonLayout) LinearLayout polygonLayout;
    @BindView(R.id.polylineLayout) LinearLayout polylineLayout;
    @BindView(R.id.circleFab) FloatingActionButton circleFab;
    @BindView(R.id.polygonFab) FloatingActionButton polygonFab;
    @BindView(R.id.polylineFab) FloatingActionButton polylineFab;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Location currentLocation;
    private GoogleMap gmap;
    private MarkerOptions markerOptions3;
    private String type = "normal";
    private Animation fabOpenAnimation;
    private Animation fabCloseAnimation;
    private boolean isFabMenuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_geofence);
        ButterKnife.bind(this);
        getAnimations();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();
    }

    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMap);
                    assert supportMapFragment != null;
                    supportMapFragment.getMapAsync(AddGeofenceActivity.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        Log.e("whjdcbhjacbhjac", "" + latLng.latitude + "\n" + latLng.longitude);
        markerOptions3 = new MarkerOptions().position(latLng).title("I am here!");
        googleMap.addMarker(markerOptions3);
        if (type.equalsIgnoreCase("normal"))
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        else
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation();
                }
                break;
        }
    }


    private void getAnimations() {
        fabOpenAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabCloseAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_close);
    }

    private void expandFabMenu() {
        ViewCompat.animate(fab).rotation(45.0F).withLayer().setDuration(300).setInterpolator(new OvershootInterpolator(10.0F)).start();

        circleLayout.startAnimation(fabOpenAnimation);
        polygonLayout.startAnimation(fabOpenAnimation);
        polylineLayout.startAnimation(fabOpenAnimation);
        circleFab.setClickable(true);
        polygonFab.setClickable(true);
        polylineFab.setClickable(true);
        isFabMenuOpen = true;
    }

    private void collapseFabMenu() {
        ViewCompat.animate(fab).rotation(0.0F).withLayer().setDuration(300).setInterpolator(new OvershootInterpolator(10.0F)).start();
        circleLayout.startAnimation(fabCloseAnimation);
        polygonLayout.startAnimation(fabCloseAnimation);
        polylineLayout.startAnimation(fabCloseAnimation);
        circleFab.setClickable(false);
        polygonFab.setClickable(false);
        polylineFab.setClickable(false);
        isFabMenuOpen = false;
    }

    public void onBaseFabClick(View view) {
        if (isFabMenuOpen)
            collapseFabMenu();
        else
            expandFabMenu();
    }

    public void onCircleFab(View view) {
        Toast.makeText(this, "Circle tapped", Toast.LENGTH_SHORT).show();
    }

    public void onPolygonFab(View view) {
        Toast.makeText(this, "Polygon tapped", Toast.LENGTH_SHORT).show();
    }

    public void onPolylineFab(View view) {
        Toast.makeText(this, "Polyline tapped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        UtilsClass.getOnBackPressed(AddGeofenceActivity.this);
        if (isFabMenuOpen)
            collapseFabMenu();
        else
            super.onBackPressed();
    }
}