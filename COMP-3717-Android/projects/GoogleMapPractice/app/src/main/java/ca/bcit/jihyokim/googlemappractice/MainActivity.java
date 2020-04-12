package ca.bcit.jihyokim.googlemappractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, TextView.OnEditorActionListener {

    private GoogleMap mMap;
    private EditText mSearchEditText;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mSearchEditText = findViewById(R.id.search_edit_text);
        mSearchEditText.setOnEditorActionListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (v.getId() == R.id.search_edit_text) {
            moveMapByString(v.getText().toString());
        }
        return false;
    }

    private void moveMapByString(String location) {
        Geocoder geocoder = new Geocoder(this);
        List<Address> addressList = new ArrayList<>();

        try {
            addressList = geocoder.getFromLocationName(location, 1);
        } catch (IOException e) {
            String errorMessage = e.getMessage();
            if (errorMessage != null) {
                Log.e(TAG, errorMessage);
            }
        }

        if (addressList.size() > 0) {
            Address targetAddress = addressList.get(0);
            Log.d(TAG, "found a location: " + targetAddress.toString());
            LatLng addressLatLng = new LatLng(targetAddress.getLatitude(), targetAddress.getLongitude());
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(addressLatLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(addressLatLng, 15f));
        }
    }
}
