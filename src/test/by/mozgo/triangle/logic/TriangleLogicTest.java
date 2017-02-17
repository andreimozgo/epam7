package test.by.mozgo.triangle.logic;

import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.entity.TrianglePerimeter;
import by.mozgo.triangle.entity.TriangleSquare;
import by.mozgo.triangle.logic.TriangleLogic;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andrei Mozgo
 */
public class TriangleLogicTest {
    private int id;
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Triangle triangle;

    @Before
    public void initTriangle(){
        id = 0;
        firstPoint = new Point(0, 0);
        secondPoint = new Point(1, 0);
        thirdPoint = new Point(0, 1);
        triangle = new Triangle(id, firstPoint, secondPoint, thirdPoint);
    }

    @After
    public void destroyTriangle(){
        triangle = null;
    }

    @Test
    public void testCalculatePerimeter() {
        TrianglePerimeter trianglePerimeter = TriangleLogic.calculatePerimeter(triangle);
        Assert.assertEquals(3.4142, trianglePerimeter.getPerimeters().get(id), 0.0001);
    }

    @Test
    public void testCalculateSquare() {
        TriangleSquare triangleSquare = TriangleLogic.calculateSquare(triangle);
        Assert.assertEquals(0.5, triangleSquare.getSquares().get(id), 0.0001);
    }

    @Test
    public void testNotifyObservers() {
        TrianglePerimeter trianglePerimeter = TrianglePerimeter.getInstance();
        TriangleSquare triangleSquare = TriangleSquare.getInstance();
        triangle.addObserver(trianglePerimeter);
        triangle.addObserver(triangleSquare);
        Point newFirstPoint = new Point(-1,-1);
        triangle.setFirstPoint(newFirstPoint);
    }
}
