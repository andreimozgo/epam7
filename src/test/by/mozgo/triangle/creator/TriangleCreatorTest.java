package test.by.mozgo.triangle.creator;

import by.mozgo.triangle.creator.TriangleCreator;
import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.exception.TriangleCreatorException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Mozgo
 */
public class TriangleCreatorTest {
    @Test
    public void testGenerateTriangles() throws TriangleCreatorException {
        List<String> lines = new ArrayList<>();
        lines.add("1 2 4 3 5 6");
        Triangle triangle = new Triangle(0, new Point(1, 2), new Point(4, 3), new Point(5, 6));
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(triangle);
        List<Triangle> generatedTriangles = TriangleCreator.generateTriangles(lines);
        Assert.assertEquals(triangles, generatedTriangles);
    }

    @Test(expected = TriangleCreatorException.class)
    public void testGenerateTrianglesException() throws TriangleCreatorException {
        List<String> lines = new ArrayList<>();
        lines.add("1 2 w 3 5 6");
        TriangleCreator.generateTriangles(lines);
    }
}
