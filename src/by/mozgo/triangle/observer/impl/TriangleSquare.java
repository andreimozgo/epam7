package by.mozgo.triangle.observer.impl;

import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.logic.TriangleLogic;
import by.mozgo.triangle.observer.OperationObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * @author Andrei Mozgo
 */
public class TriangleSquare implements OperationObserver {
    private static TriangleSquare instance = null;
    private static final Logger LOGGER = LogManager.getLogger();
    private ArrayList<Double> squares = new ArrayList<>();

    public static TriangleSquare getInstance() {
        if (instance == null) {
            instance = new TriangleSquare();
        }
        return instance;
    }

    public ArrayList<Double> getSquares() {
        return squares;
    }

    @Override
    public void valueChanged(Triangle observed) {
        int id = observed.getId();
        LOGGER.info("Old triangular square= " + squares.get(id));
        double newSquare = TriangleLogic.calculateSquare(observed).getSquares().get(id);
        squares.set(observed.getId(), newSquare);
        LOGGER.info("New triangular square= " + squares.get(id));
    }
}
