package test.by.mozgo.triangle.creator;

import by.mozgo.triangle.creator.TriangleCreator;
import by.mozgo.triangle.creator.exception.InputDataException;
import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Mozgo
 */
public class TriangleCreatorTest {
    @Test
    public void TestGenerateTriangles() throws InputDataException {
        List<String> lines = new ArrayList<>();
        lines.add("1 2 4 3 5 6");
        Triangle triangle = new Triangle(0, new Point(1, 2), new Point(4, 3), new Point(5, 6));
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(triangle);
        List<Triangle> generatedTriangles = null;
        generatedTriangles = TriangleCreator.generateTriangles(lines);
        Assert.assertEquals(triangles, generatedTriangles);
    }

    @Test(expected = InputDataException.class)
    public void TestGenerateTrianglesException() throws InputDataException {
        List<String> lines = new ArrayList<>();
        lines.add("1 2 w 3 5 6");
        TriangleCreator.generateTriangles(lines);
    }
}
