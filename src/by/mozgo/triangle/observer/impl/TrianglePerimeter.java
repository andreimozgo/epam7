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
public class TrianglePerimeter implements OperationObserver {
    private static final Logger LOGGER = LogManager.getLogger();
    private static TrianglePerimeter instance = null;
    private List<Double> perimeters = new ArrayList<>();

    public static TrianglePerimeter getInstance() {
        if (instance == null) {
            instance = new TrianglePerimeter();
        }
        return instance;
    }

    public double getPerimeter(int id){
        return perimeters.get(id);
    }

    public void addPerimeter(int id, double perimeter){
        perimeters.add(id,perimeter);
    }

    @Override
    public void valueChanged(TriangleChangeEvent event) {
        Triangle newTriangle = event.getNewTriangle();
        int id = newTriangle.getId();
        LOGGER.log(Level.INFO, "Old triangular perimeter= {}", perimeters.get(id));
        double newPerimeter = TriangleLogic.calculatePerimeter(newTriangle).getPerimeter(id);
        perimeters.set(newTriangle.getId(), newPerimeter);
        LOGGER.log(Level.INFO, "New triangular perimeter= {}", perimeters.get(id));
    }
}
