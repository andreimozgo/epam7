package test.by.mozgo.triangle.logic;

import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.logic.TriangleLogic;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andrei Mozgo
 */
public class TriangleTest {
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
    public void testIsTriangle() {
        Assert.assertTrue("Triangle doesn't exist" , TriangleLogic.isTriangle(triangle));
    }

    @Test
    public void testIsTriangleRectangular() {
        Assert.assertTrue("Triangle isn't rectangular" , TriangleLogic.isTriangleRectangular(triangle));
    }
}
