package by.mozgo.triangle.observer;

import by.mozgo.triangle.entity.Triangle;

/**
 * @author Andrei Mozgo
 */
public interface OperationObserver {
    void valueChanged(Triangle observed);
}
