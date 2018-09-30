package es.luissachaarancibiabazan.boda3;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final LatLng REDONDA = new LatLng(42.466777, -2.445575);
    private static final LatLng EGUREN = new LatLng(42.569949, -2.613809);
    private static final LatLng AUTOBUSIDA  = new LatLng(42.465275, -2.445770);
    private static final LatLng AUTOBUSVUELTA  = new LatLng(22,22);
    private static final LatLng LOGROÑO  = new LatLng(42.464849, -2.445185);

    private Marker mRedonda;
    private Marker mEguren;
    private Marker mAutobusIda;
    private Marker mAutobusVuelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mRedonda = mMap.addMarker(new MarkerOptions()
            .position(REDONDA)
            .title("Catedral de la Redonda"));
        mRedonda.setTag(0);

        mEguren = mMap.addMarker(new MarkerOptions()
            .position(EGUREN)
            .title("Eguren Ugarte"));
        mEguren.setTag(0);

        mAutobusIda = mMap.addMarker(new MarkerOptions()
            .position(AUTOBUSIDA)
            .title("Salida Autobus"));
        mAutobusIda.setTag(0);

        mAutobusVuelta = mMap.addMarker(new MarkerOptions()
            .position(REDONDA)
            .title("Parada Autobus"));
        mAutobusVuelta.setTag(0);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(LOGROÑO));

    }
}
