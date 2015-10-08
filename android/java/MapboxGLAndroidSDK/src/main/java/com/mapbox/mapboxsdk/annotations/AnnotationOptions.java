package com.mapbox.mapboxsdk.annotations;

public abstract class AnnotationOptions {

    protected Annotation annotation;

    protected AnnotationOptions() {
    }

    /*public boolean isVisible() {
        return annotation.isVisible();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnnotationOptions that = (AnnotationOptions) o;

        //return isVisible() == that.isVisible();
        return true;
    }

    @Override
    public int hashCode() {
        //return (isVisible() ? 1 : 0);
        return 0;
    }
}
