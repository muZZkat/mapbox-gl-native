package com.mapbox.mapboxsdk.annotations;

import android.graphics.Point;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.mapbox.mapboxsdk.R;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;

public final class Marker extends Annotation {

    private int anchorU;
    private int anchorV;
    private LatLng position;
    private String snippet;
    private String sprite = "default_marker";
    private String title;
    private InfoWindow infoWindow = null;
    private boolean infoWindowShown = false;
    private int topOffsetPixels;

    /**
     * Constructor
     */
    Marker() {
        super();
    }

    public int getAnchorU() {
        return anchorU;
    }

    public int getAnchorV() {
        return anchorV;
    }

    public LatLng getPosition() {
        return position;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getTitle() {
        return title;
    }
    public void hideInfoWindow() {
        if (infoWindow != null) {
            infoWindow.close();
        }
        infoWindowShown = false;
    }

    public boolean isInfoWindowShown() {
        return infoWindowShown;
    }

    void setAnchor(int u, int v) {
        this.anchorU = u;
        this.anchorV = v;
    }

    void setPosition(LatLng position) {
        this.position = position;
    }

    void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    /**
     * You can specify the name of a sprite to get a marker other than the default marker.
     * This name can be found in the sprite json file:
     * <p/>
     * https://github.com/mapbox/mapbox-gl-styles/blob/mb-pages/sprites/mapbox-streets.json
     * <p/>
     * If null you will get the default marker.
     *
     * @param sprite The name of the sprite.
     */
    void setSprite(@Nullable String sprite) {
        if (!TextUtils.isEmpty(sprite)) {
            this.sprite = sprite;
        }
    }

    public String getSprite() {
        return sprite;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public void showInfoWindow() {
        //if (!isVisible() || mapView == null) {
        if (mapView == null) {
            return;
        }

        MapView.InfoWindowAdapter infoWindowAdapter = mapView.getInfoWindowAdapter();
        if (infoWindowAdapter != null) {
            // end developer is using a custom InfoWindowAdapter
            View content = infoWindowAdapter.getInfoWindow(this);
            if (content != null) {
                infoWindow = new InfoWindow(content, mapView);
                showInfoWindow(infoWindow);
                return;
            }
        }

        getInfoWindow().adaptDefaultMarker(this);
        showInfoWindow(getInfoWindow());
    }

    private void showInfoWindow(View view) {
    }

    private void showInfoWindow(InfoWindow iw) {
        iw.open(this, getPosition(), anchorU, anchorV + topOffsetPixels);
        iw.setBoundMarker(this);
        infoWindowShown = true;
    }

    private InfoWindow getInfoWindow() {
        if (infoWindow == null) {
            infoWindow = new InfoWindow(R.layout.infowindow_view, mapView);
        }
        return infoWindow;
    }

    /*
    @Override
    void setVisible(boolean visible) {
        super.setVisible(visible);
        if (!visible && infoWindowShown) {
            hideInfoWindow();
        }
    }
    */

    /**
     * Do not use this method. Used internally by the SDK.
     */
    public void setTopOffsetPixels(int topOffsetPixels) {
        this.topOffsetPixels = topOffsetPixels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Marker marker = (Marker) o;

        return !(getPosition() != null ? !getPosition().equals(marker.getPosition()) : marker.getPosition() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        return result;
    }
}
