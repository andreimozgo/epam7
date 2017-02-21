package by.mozgo.triangle.observer;

/**
 * @author Andrei Mozgo
 */
public interface OperationObserver {
    void valueChanged(TriangleChangeEvent event);
}
