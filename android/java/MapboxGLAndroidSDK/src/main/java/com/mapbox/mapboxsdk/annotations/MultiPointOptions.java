package com.mapbox.mapboxsdk.annotations;

import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.List;

public abstract class MultiPointOptions extends AnnotationOptions {

    protected MultiPointOptions() {
    }

    public List<LatLng> getPoints() {
        // the getter gives us a copy, which is the safe thing to do...
        return ((MultiPoint) annotation).getPoints();
    }

    public float getAlpha() {
        return ((MultiPoint) annotation).getAlpha();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MultiPoint that = (MultiPoint) o;

        if (Float.compare(that.getAlpha(), getAlpha()) != 0) return false;
        return !(getPoints() != null ? !getPoints().equals(that.getPoints()) : that.getPoints() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPoints() != null ? getPoints().hashCode() : 0);
        result = 31 * result + (getAlpha() != +0.0f ? Float.floatToIntBits(getAlpha()) : 0);
        return result;
    }
}
