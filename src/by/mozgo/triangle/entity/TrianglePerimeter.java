package by.mozgo.triangle.entity;

import by.mozgo.triangle.logic.TriangleLogic;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;



/**
 * @author Andrei Mozgo
 */
public class TrianglePerimeter implements OperationObserver {
    private static TrianglePerimeter instance = null;
    private static final Logger logger = LogManager.getLogger();
    private ArrayList<Double> perimeters = new ArrayList<>();

    public static TrianglePerimeter getInstance() {
        if (instance == null) {
            instance = new TrianglePerimeter();
        }
        return instance;
    }

    public ArrayList<Double> getPerimeters() {
        return perimeters;
    }

    public void setPerimeters(ArrayList<Double> perimeters) {
        this.perimeters = perimeters;
    }

    @Override
    public void valueChanged(Triangle observed) {
        int id = observed.getId();
        logger.info("Old triangular perimeter= " + perimeters.get(id));
        double newPerimeter = TriangleLogic.calculatePerimeter(observed).getPerimeters().get(id);
        perimeters.set(observed.getId(), newPerimeter);
        logger.info("New triangular perimeter= " + perimeters.get(id));
    }
}
