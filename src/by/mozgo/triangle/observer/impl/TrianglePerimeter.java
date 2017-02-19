package by.mozgo.triangle.observer.impl;

import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.logic.TriangleLogic;
import by.mozgo.triangle.observer.OperationObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Mozgo
 */
public class TrianglePerimeter implements OperationObserver {
    private static TrianglePerimeter instance = null;
    private static final Logger LOGGER = LogManager.getLogger();
    private List<Double> perimeters = new ArrayList<>();

    public static TrianglePerimeter getInstance() {
        if (instance == null) {
            instance = new TrianglePerimeter();
        }
        return instance;
    }

    public List<Double> getPerimeters() {
        return perimeters;
    }

    @Override
    public void valueChanged(Triangle observed) {
        int id = observed.getId();
        LOGGER.info("Old triangular perimeter= " + perimeters.get(id));
        double newPerimeter = TriangleLogic.calculatePerimeter(observed).getPerimeters().get(id);
        perimeters.set(observed.getId(), newPerimeter);
        LOGGER.info("New triangular perimeter= " + perimeters.get(id));
    }
}
