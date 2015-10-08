package com.mapbox.mapboxsdk.annotations;

import com.mapbox.mapboxsdk.views.MapView;

public abstract class Annotation implements Comparable<Annotation> {

    /**
     * The annotation id
     * <p/>
     * Internal C++ id is stored as unsigned int.
     */
    protected long id = -1; // -1 unless added to a MapView
    protected MapView mapView;

    // TODO: Not acutally implemented!
    //private boolean visible = true;

    protected Annotation() {
    }

    public long getId() {
        return id;
    }

    /*public boolean isVisible() {
        return visible;
    }*/

    public void remove() {
        if (mapView == null) return;
        mapView.removeAnnotation(this);
    }

    /**
     * Do not use this method. Used internally by the SDK.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Do not use this method. Used internally by the SDK.
     */
    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

    /*void setVisible(boolean visible) {
        this.visible = visible;
    }*/

    @Override
    public int compareTo(Annotation annotation) {

        if (annotation == null) {
            return -1;
        }

        if (id < annotation.getId()) {
            return 1;
        } else if (id > annotation.getId()) {
            return -1;
        }

        // Equal
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Annotation that = (Annotation) o;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
