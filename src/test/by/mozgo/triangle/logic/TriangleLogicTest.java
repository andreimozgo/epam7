package test.by.mozgo.triangle.logic;

import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.logic.TriangleLogic;
import by.mozgo.triangle.observer.impl.TrianglePerimeter;
import by.mozgo.triangle.observer.impl.TriangleSquare;
import org.junit.*;

/**
 * @author Andrei Mozgo
 */
public class TriangleLogicTest {
    private static int id;
    private static Point firstPoint;
    private static Point secondPoint;
    private static Point thirdPoint;
    private static Triangle triangle;

    @BeforeClass
    public static void initTriangle() {
        id = 0;
        firstPoint = new Point(0, 0);
        secondPoint = new Point(1, 0);
        thirdPoint = new Point(0, 1);
        triangle = new Triangle(id, firstPoint, secondPoint, thirdPoint);
    }

    @AfterClass
    public static void destroyTriangle() {
        triangle = null;
    }

    @Test
    public void testCalculatePerimeter() {
        TrianglePerimeter trianglePerimeter = TriangleLogic.calculatePerimeter(triangle);
        double perimeter = trianglePerimeter.getPerimeter(id);
        Assert.assertEquals(3.4142, perimeter, 0.0001);
    }

    @Test
    public void testCalculateSquare() {
        TriangleSquare triangleSquare = TriangleLogic.calculateSquare(triangle);
        double square = triangleSquare.getSquare(id);
        Assert.assertEquals(0.5, square, 0.0001);
    }

    @Test
    public void testIsTriangleTrue() {
        boolean isTriangle = TriangleLogic.isTriangle(triangle);
        Assert.assertTrue("Triangle doesn't exist", isTriangle);
    }

    @Test
    public void testIsTriangleFalse() {
        triangle.setSecondPoint(firstPoint);
        triangle.setThirdPoint(firstPoint);
        boolean isTriangle = TriangleLogic.isTriangle(triangle);
        Assert.assertFalse("Triangle exist", isTriangle);
        triangle.setSecondPoint(secondPoint);
        triangle.setThirdPoint(thirdPoint);
    }

    @Test
    public void testIsTriangleRectangularTrue() {
        boolean isTriangleRectangular = TriangleLogic.isTriangleRectangular(triangle);
        Assert.assertTrue("Triangle isn't rectangular", isTriangleRectangular);
    }

    @Test
    public void testIsTriangleRectangularFalse() {
        triangle.setSecondPoint(new Point(-1, -1));
        boolean isTriangleRectangular = TriangleLogic.isTriangleRectangular(triangle);
        Assert.assertFalse("Triangle is rectangular", isTriangleRectangular);
        triangle.setSecondPoint(secondPoint);
    }
}
