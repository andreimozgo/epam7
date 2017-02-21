package test.by.mozgo.triangle.observer;

import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.observer.impl.TrianglePerimeter;
import by.mozgo.triangle.observer.impl.TriangleSquare;
import org.junit.*;

/**
 * @author Andrei Mozgo
 */
public class OperationObserverTest {
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
    public void testValueChangedPerimeter() {
        TrianglePerimeter trianglePerimeter = TrianglePerimeter.getInstance();
        double perimeter = trianglePerimeter.getPerimeter(id);
        triangle.addObserver(trianglePerimeter);
        Point newFirstPoint = new Point(-1, -1);
        triangle.setFirstPoint(newFirstPoint);
        double changedPerimeter = trianglePerimeter.getPerimeter(id);
        Assert.assertNotEquals(perimeter,changedPerimeter);
    }

    @Test
    public void testValueChangedSquare() {
        TriangleSquare triangleSquare = TriangleSquare.getInstance();
        double square = triangleSquare.getSquare(id);
        triangle.addObserver(triangleSquare);
        Point newFirstPoint = new Point(-2, -2);
        triangle.setFirstPoint(newFirstPoint);
        double changedSquare = triangleSquare.getSquare(id);
        Assert.assertNotEquals(square,changedSquare);
    }
}
