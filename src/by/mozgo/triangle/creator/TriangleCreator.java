package by.mozgo.triangle.creator;

import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Mozgo
 */
public class TriangleCreator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int MAX_NUMBER_OF_COORDINATES = 6;

    public static List<Triangle> generateTriangles(List<String> inputLines) {
        List<Triangle> triangles = new ArrayList<>();
        int triangleId = 0;
        for (int i = 0; i < inputLines.size(); i++) {
            String line = inputLines.get(i);
            String[] coordinates = line.split("\\s");
            if (coordinates.length != MAX_NUMBER_OF_COORDINATES) {
                LOGGER.error("Incorrect input line");
            }
            try {
                Point firstPoint = new Point(Integer.valueOf(coordinates[0]), Integer.valueOf(coordinates[1]));
                Point secondPoint = new Point(Integer.valueOf(coordinates[2]), Integer.valueOf(coordinates[3]));
                Point thirdPoint = new Point(Integer.valueOf(coordinates[4]), Integer.valueOf(coordinates[5]));
                triangles.add(new Triangle(triangleId, firstPoint, secondPoint, thirdPoint));
                triangleId++;
            } catch (NumberFormatException e) {
                LOGGER.error("Incorrect input line", e);
            }
        }
        return triangles;
    }
}