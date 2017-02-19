package test.by.mozgo.triangle.logic;

import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.logic.TriangleLogic;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Andrei Mozgo
 */
public class TriangleTest {

    @Test
    public void testTriangleExist() {
        int id = 1;
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 0);
        Point thirdPoint = new Point(0, 1);
        Triangle triangle = new Triangle(id, firstPoint, secondPoint, thirdPoint);
        double square = TriangleLogic.calculateSquare(triangle).getSquares().get(id);
        Assert.assertFalse("Triangle doesn't exist!", 0 == square);
    }

    @Test
    public void testTriangleRectangular() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 0);
        Point thirdPoint = new Point(0, 1);
        double firstSide = TriangleLogic.calculateSide(firstPoint, secondPoint);
        double secondSide = TriangleLogic.calculateSide(secondPoint, thirdPoint);
        double thirdSide = TriangleLogic.calculateSide(thirdPoint, firstPoint);
        Assert.assertNotEquals("Triangle is rectangular", Math.pow(thirdSide, 2), Math.pow(firstSide, 2) + Math.pow(secondSide, 2), 0.0001);
        Assert.assertNotEquals("Triangle is rectangular", Math.pow(firstSide, 2), Math.pow(secondSide, 2) + Math.pow(thirdSide, 2), 0.0001);
        Assert.assertNotEquals("Triangle is rectangular", Math.pow(secondSide, 2), Math.pow(thirdSide, 2) + Math.pow(firstSide, 2), 0.0001);
    }
}
