package by.mozgo.triangle.observer.impl;

import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.logic.TriangleLogic;
import by.mozgo.triangle.observer.OperationObserver;
import by.mozgo.triangle.observer.TriangleChangeEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Mozgo
 */
public class TriangleSquare implements OperationObserver {
    private static final Logger LOGGER = LogManager.getLogger();
    private static TriangleSquare instance = null;
    private List<Double> squares = new ArrayList<>();

    public static TriangleSquare getInstance() {
        if (instance == null) {
            instance = new TriangleSquare();
        }
        return instance;
    }

    public double getSquare(int id) {
        return squares.get(id);
    }

    public void addSquare(int id, double square) {
        squares.add(id, square);
    }

    @Override
    public void valueChanged(TriangleChangeEvent event) {
        Triangle newTriangle = event.getNewTriangle();
        int id = newTriangle.getId();
        LOGGER.log(Level.INFO, "Old triangular square= {}", squares.get(id));
        double newSquare = TriangleLogic.calculateSquare(newTriangle).getSquare(id);
        squares.set(id, newSquare);
        LOGGER.log(Level.INFO, "New triangular square= {}", squares.get(id));
    }
}
