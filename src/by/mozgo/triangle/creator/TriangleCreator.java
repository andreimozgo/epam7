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
    private static List<Triangle> triangles = new ArrayList<>();

    public static List<Triangle> generateTriangles(ArrayList<String> inputLines) {
        for (int i =1; i <= inputLines.size();i++) {
            String line = inputLines.get(i-1);
            String[] points = line.split("\\s");
            if (points.length != MAX_NUMBER_OF_COORDINATES) {
                LOGGER.error("Incorrect input line");
            }
            Point firstPoint = new Point(Integer.valueOf(points[0]),Integer.valueOf(points[1]));
            Point secondPoint = new Point(Integer.valueOf(points[2]),Integer.valueOf(points[3]));
            Point thirdPoint = new Point(Integer.valueOf(points[4]),Integer.valueOf(points[5]));
            triangles.add(new Triangle(i,firstPoint,secondPoint,thirdPoint));
        }
        return triangles;
    }
}
