package com.mapbox.mapboxsdk.annotations;


import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions extends MultiPointOptions {

    public PolygonOptions() {
        annotation = new Polygon();
    }

    public PolygonOptions add(LatLng point) {
        ((MultiPoint) annotation).addPoint(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        for (LatLng point : points) {
            add(point);
        }
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng point : points) {
            add(point);
        }
        return this;
    }

    /**
     * Sets the color of the polygon.
     *
     * @param color - the color in ARGB format
     * @return PolygonOptions - the options object
     */
    public PolygonOptions fillColor(int color) {
        ((Polygon) annotation).setFillColor(color);
        return this;
    }

    public int getFillColor() {
        return ((Polygon) annotation).getFillColor();
    }

    /**
     * Do not use this method. Used internally by the SDK.
     */
    public Polygon getPolygon() {
        return ((Polygon) annotation);
    }

    public int getStrokeColor() {
        return ((Polygon) annotation).getStrokeColor();
    }

    /**
     * Sets the color of the stroke of the polygon.
     *
     * @param color - the color in ARGB format
     * @return PolygonOptions - the options object
     */
    public PolygonOptions strokeColor(int color) {
        ((Polygon) annotation).setStrokeColor(color);
        return this;
    }

    /*public PolygonOptions visible(boolean visible) {
        annotation.setVisible(visible);
        return this;
    }*/

    public PolygonOptions alpha(float alpha) {
        ((MultiPoint) annotation).setAlpha(alpha);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PolygonOptions polygon = (PolygonOptions) o;

        if (getFillColor() != polygon.getFillColor()) return false;
        return getStrokeColor() == polygon.getStrokeColor();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getFillColor();
        result = 31 * result + getStrokeColor();
        return result;
    }

}
