package test.by.mozgo.triangle;

import by.mozgo.triangle.creator.TriangleCreator;
import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.exception.TriangleCreatorException;
import by.mozgo.triangle.exception.TriangleReaderException;
import by.mozgo.triangle.reader.TriangleReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Mozgo
 */
public class MainTest {
    @Test
    public void testProgram() throws TriangleReaderException, TriangleCreatorException {
        String filename = "data/input.txt";
        int firstId = 0;
        int secondId = 1;
        Point firstPoint = new Point(1, 2);
        Point secondPoint = new Point(4, 3);
        Point thirdPoint = new Point(5, 6);
        Point fouthPoint = new Point(7, 8);
        Point fifthPoint = new Point(10, 9);
        Point sixthPoint = new Point(11, 12);
        Triangle firstTriangle = new Triangle(firstId, firstPoint, secondPoint, thirdPoint);
        Triangle secondTriangle = new Triangle(secondId, fouthPoint, fifthPoint, sixthPoint);
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(firstTriangle);
        triangles.add(secondTriangle);
        List<String> readLines = TriangleReader.readData(filename);
        List<Triangle> generatedTriangles = TriangleCreator.generateTriangles(readLines);
        Assert.assertEquals(triangles, generatedTriangles);
    }
}
