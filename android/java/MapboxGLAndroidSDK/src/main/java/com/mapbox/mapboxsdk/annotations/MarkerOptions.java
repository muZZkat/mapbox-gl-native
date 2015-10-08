package com.mapbox.mapboxsdk.annotations;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mapbox.mapboxsdk.geometry.LatLng;

public final class MarkerOptions extends AnnotationOptions {

    public MarkerOptions() {
        annotation = new Marker();
    }

    public MarkerOptions anchor(int u, int v) {
        ((Marker)annotation).setAnchor(u, v);
        return this;
    }

    public int getAnchorU() {
        return ((Marker)annotation).getAnchorU();
    }

    public int getAnchorV() {
        return ((Marker)annotation).getAnchorV();
    }

    /**
     * Do not use this method. Used internally by the SDK.
     */
    public Marker getMarker() {
        return (Marker)annotation;
    }

    public LatLng getPosition() {
        return ((Marker)annotation).getPosition();
    }

    public String getSnippet() {
        return ((Marker)annotation).getSnippet();
    }

    public String getTitle() {
        return ((Marker)annotation).getTitle();
    }

    public String getSprite() {
        return ((Marker)annotation).getSprite();
    }

    public MarkerOptions position(LatLng position) {
        ((Marker)annotation).setPosition(position);
        return this;
    }

    public MarkerOptions snippet(String snippet) {
        ((Marker)annotation).setSnippet(snippet);
        return this;
    }

    public MarkerOptions sprite(@Nullable String sprite) {
        if (!TextUtils.isEmpty(sprite)) {
            ((Marker)annotation).setSprite(sprite);
        }
        return this;
    }

    public MarkerOptions title(String title) {
        ((Marker)annotation).setTitle(title);
        return this;
    }

    /*public MarkerOptions visible(boolean visible) {
        annotation.setVisible(visible);
        return this;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MarkerOptions marker = (MarkerOptions) o;

        if (getAnchorU() != marker.getAnchorU()) return false;
        if (getAnchorV() != marker.getAnchorV()) return false;
        if (getPosition() != null ? !getPosition().equals(marker.getPosition()) : marker.getPosition() != null)
            return false;
        if (getSnippet() != null ? !getSnippet().equals(marker.getSnippet()) : marker.getSnippet() != null)
            return false;
        if (getSprite() != null ? !getSprite().equals(marker.getSprite()) : marker.getSprite() != null)
            return false;
        return !(getTitle() != null ? !getTitle().equals(marker.getTitle()) : marker.getTitle() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getAnchorU();
        result = 31 * result + getAnchorV();
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (getSnippet() != null ? getSnippet().hashCode() : 0);
        result = 31 * result + (getSprite() != null ? getSprite().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        return result;
    }
}
