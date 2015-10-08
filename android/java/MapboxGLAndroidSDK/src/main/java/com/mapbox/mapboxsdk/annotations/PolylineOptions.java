package com.mapbox.mapboxsdk.annotations;

import com.mapbox.mapboxsdk.geometry.LatLng;

public final class PolylineOptions extends MultiPointOptions {

    public PolylineOptions() {
        annotation = new Polyline();
    }

    public PolylineOptions add(LatLng point) {
        ((MultiPoint) annotation).addPoint(point);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        for (LatLng point : points) {
            add(point);
        }
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        for (LatLng point : points) {
            add(point);
        }
        return this;
    }

    /**
     * Sets the color of the polyline.
     *
     * @param color - the color in ARGB format
     */
    public PolylineOptions color(int color) {
        ((Polyline) annotation).setColor(color);
        return this;
    }

    public int getColor() {
        return ((Polyline) annotation).getColor();
    }

    /**
     * Do not use this method. Used internally by the SDK.
     */
    public Polyline getPolyline() {
        return ((Polyline) annotation);
    }

    public float getWidth() {
        return ((Polyline) annotation).getWidth();
    }

    /*public PolylineOptions visible(boolean visible) {
        annotation.setVisible(visible);
        return this;
    }*/

    /**
     * Sets the width of the polyline.
     *
     * @param width in pixels
     * @return a new PolylineOptions
     */
    public PolylineOptions width(float width) {
        ((Polyline) annotation).setWidth(width);
        return this;
    }

    public PolylineOptions alpha(float alpha) {
        ((MultiPoint) annotation).setAlpha(alpha);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PolylineOptions polyline = (PolylineOptions) o;

        if (getColor() != polyline.getColor()) return false;
        return Float.compare(polyline.getWidth(), getWidth()) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getColor();
        result = 31 * result + (getWidth() != +0.0f ? Float.floatToIntBits(getWidth()) : 0);
        return result;
    }
}
