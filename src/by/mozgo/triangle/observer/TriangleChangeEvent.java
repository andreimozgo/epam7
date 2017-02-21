package by.mozgo.triangle.observer;

import by.mozgo.triangle.entity.Triangle;

/**
 * @author Andrei Mozgo
 */
public class TriangleChangeEvent {
    Triangle newTriangle;

    public TriangleChangeEvent(Triangle newTriangle) {
        this.newTriangle = newTriangle;
    }

    public Triangle getNewTriangle() {
        return newTriangle;
    }
}
