package test.by.mozgo.triangle.logic;

import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.logic.TriangleLogic;
import by.mozgo.triangle.observer.impl.TrianglePerimeter;
import by.mozgo.triangle.observer.impl.TriangleSquare;
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
        Assert.assertEquals(3.4142, trianglePerimeter.getPerimeter(id), 0.0001);
    }

    @Test
    public void testCalculateSquare() {
        TriangleSquare triangleSquare = TriangleLogic.calculateSquare(triangle);
        Assert.assertEquals(0.5, triangleSquare.getSquare(id), 0.0001);
    }

    @Test
    public void testIsTriangleTrue() {
        Assert.assertTrue("Triangle doesn't exist", TriangleLogic.isTriangle(triangle));
    }

    @Test
    public void testIsTriangleFalse() {
        triangle.setSecondPoint(firstPoint);
        triangle.setThirdPoint(firstPoint);
        Assert.assertFalse("Triangle exist", TriangleLogic.isTriangle(triangle));
    }

    @Test
    public void testIsTriangleRectangularTrue() {
        Assert.assertTrue("Triangle isn't rectangular", TriangleLogic.isTriangleRectangular(triangle));
    }

    @Test
    public void testIsTriangleRectangularFalse() {
        triangle.setSecondPoint(new Point(-1, -1));
        Assert.assertFalse("Triangle is rectangular", TriangleLogic.isTriangleRectangular(triangle));
    }
}
