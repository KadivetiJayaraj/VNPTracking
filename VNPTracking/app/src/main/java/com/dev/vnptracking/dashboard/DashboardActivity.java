package com.dev.vnptracking.dashboard;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;

import com.dev.vnptracking.R;
import com.dev.vnptracking.utils.BottomFunctionality;
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
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE = 101;
    @BindView(R.id.sat_img)
    ImageView satImg;
    @BindView(R.id.normal_img)
    ImageView normalImg;
    @BindView(R.id.change_mode_Rel)
    RelativeLayout changeModeRel;
    @BindView(R.id.mainRel)
    RelativeLayout mainRel;
    @BindView(R.id.notificationLL)
    LinearLayout notificationLL;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.trafficLayout) LinearLayout trafficLayout;
    @BindView(R.id.ignitionLayout) LinearLayout ignitionLayout;
    @BindView(R.id.dailypathLayout) LinearLayout dailypathLayout;
    @BindView(R.id.showtrailLayout) LinearLayout showtrailLayout;
    @BindView(R.id.playbackLayout) LinearLayout playbackLayout;
    @BindView(R.id.vehicleLayout) LinearLayout vehicleLayout;
    @BindView(R.id.placesLayout) LinearLayout placesLayout;
    @BindView(R.id.trafficFab) FloatingActionButton trafficFab;
    @BindView(R.id.ignitionFab) FloatingActionButton ignitionFab;
    @BindView(R.id.dailypathFab) FloatingActionButton dailypathFab;
    @BindView(R.id.showtrailFab) FloatingActionButton showtrailFab;
    @BindView(R.id.playbackFab) FloatingActionButton playbackFab;
    @BindView(R.id.vehicleFab) FloatingActionButton vehicleFab;
    @BindView(R.id.placesFab) FloatingActionButton placesFab;
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
        setContentView(R.layout.activity_dashboard_actrivity);
        ButterKnife.bind(this);
        getAnimations();
        changeModeRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (satImg.getVisibility() == View.VISIBLE) {
                    satImg.setVisibility(View.GONE);
                    normalImg.setVisibility(View.VISIBLE);
                    type = "satelite";
                    onMapReady(gmap);
                } else {
                    satImg.setVisibility(View.VISIBLE);
                    normalImg.setVisibility(View.GONE);
                    gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    type = "normal";
                    onMapReady(gmap);
                }
            }
        });
        BottomFunctionality bottomFunctionality = new BottomFunctionality(DashboardActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();
        notificationLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,NotificationActivity.class));
            }
        });
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
//                    String cityName = null,pincode=null,state_st=null;
//                    Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
//                    List<Address> addresses;
//                    try {
//                        addresses = gcd.getFromLocation(location.getLatitude(),
//                                location.getLongitude(), 1);
//                        if (addresses.size() > 0) {
//                            System.out.println(addresses.get(0).getLocality());
//                            cityName = addresses.get(0).getAddressLine(0);
//                            pincode=addresses.get(0).getPostalCode();
//                            state_st=addresses.get(0).getAdminArea();
//                            et_emailId.setText(cityName);
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMap);
                    assert supportMapFragment != null;
                    supportMapFragment.getMapAsync(DashboardActivity.this);
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
        trafficLayout.startAnimation(fabOpenAnimation);
        ignitionLayout.startAnimation(fabOpenAnimation);
        dailypathLayout.startAnimation(fabOpenAnimation);
        showtrailLayout.startAnimation(fabOpenAnimation);
        playbackLayout.startAnimation(fabOpenAnimation);
        vehicleLayout.startAnimation(fabOpenAnimation);
        placesLayout.startAnimation(fabOpenAnimation);
        trafficFab.setClickable(true);
        ignitionFab.setClickable(true);
        dailypathFab.setClickable(true);
        showtrailFab.setClickable(true);
        playbackFab.setClickable(true);
        vehicleFab.setClickable(true);
        placesFab.setClickable(true);
        isFabMenuOpen = true;
    }

    private void collapseFabMenu() {
        ViewCompat.animate(fab).rotation(0.0F).withLayer().setDuration(300).setInterpolator(new OvershootInterpolator(10.0F)).start();
        trafficLayout.startAnimation(fabCloseAnimation);
        ignitionLayout.startAnimation(fabCloseAnimation);
        dailypathLayout.startAnimation(fabCloseAnimation);
        showtrailLayout.startAnimation(fabCloseAnimation);
        playbackLayout.startAnimation(fabCloseAnimation);
        vehicleLayout.startAnimation(fabCloseAnimation);
        placesLayout.startAnimation(fabCloseAnimation);
        trafficFab.setClickable(false);
        ignitionFab.setClickable(false);
        dailypathFab.setClickable(false);
        showtrailFab.setClickable(false);
        playbackFab.setClickable(false);
        vehicleFab.setClickable(false);
        placesFab.setClickable(false);
        isFabMenuOpen = false;
    }

     public void onBaseFabClick(View view) {
            if (isFabMenuOpen)
                collapseFabMenu();
            else
                expandFabMenu();
        }

        public void onTrafficFab(View view) {
            Toast.makeText(this, "Traffic tapped", Toast.LENGTH_SHORT).show();
        }

        public void onIgnitionFab(View view) {
            Toast.makeText(this, "Ignition Path tapped", Toast.LENGTH_SHORT).show();
        }

        public void onDailypathFab(View view) {
            Toast.makeText(this, "Daily Path tapped", Toast.LENGTH_SHORT).show();
        }

        public void onShowtrailFab(View view) {
            Toast.makeText(this, "Show Trail tapped", Toast.LENGTH_SHORT).show();
        }

        public void onPlaybackFab(View view) {
            Toast.makeText(this, "Playback tapped", Toast.LENGTH_SHORT).show();
        }

        public void onVehicleFab(View view) {
            Toast.makeText(this, "earby Vehicle tapped", Toast.LENGTH_SHORT).show();
        }

        public void onPlacesFab(View view) {
            Toast.makeText(this, "Nearby Places tapped", Toast.LENGTH_SHORT).show();
        }


    @Override
    public void onBackPressed() {
        UtilsClass.getOnBackPressed(DashboardActivity.this);
        if (isFabMenuOpen)
            collapseFabMenu();
        else
            super.onBackPressed();
    }
}
