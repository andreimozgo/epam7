package test.by.mozgo.triangle.logic;

import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.observer.impl.TrianglePerimeter;
import by.mozgo.triangle.observer.impl.TriangleSquare;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andrei Mozgo
 */
public class OperationObserverTest {
    private int id;
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Triangle triangle;

    @Before
    public void initTriangle() {
        id = 0;
        firstPoint = new Point(0, 0);
        secondPoint = new Point(1, 0);
        thirdPoint = new Point(0, 1);
        triangle = new Triangle(id, firstPoint, secondPoint, thirdPoint);
    }

    @After
    public void destroyTriangle() {
        triangle = null;
    }

    @Test
    public void testValueChangedPerimeter() {
        TrianglePerimeter trianglePerimeter = TrianglePerimeter.getInstance();
        double perimeter = trianglePerimeter.getPerimeters().get(id);
        triangle.addObserver(trianglePerimeter);
        Point newFirstPoint = new Point(-1, -1);
        triangle.setFirstPoint(newFirstPoint);
        double changedPerimeter = trianglePerimeter.getPerimeters().get(id);
        Assert.assertNotEquals(perimeter,changedPerimeter);
    }

    @Test
    public void testValueChangedSquare() {
        TriangleSquare triangleSquare = TriangleSquare.getInstance();
        double square = triangleSquare.getSquares().get(id);
        triangle.addObserver(triangleSquare);
        Point newFirstPoint = new Point(-1, -1);
        triangle.setFirstPoint(newFirstPoint);
        double changedSquare = triangleSquare.getSquares().get(id);
        Assert.assertNotEquals(square,changedSquare);
    }
}
