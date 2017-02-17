package by.mozgo.triangle.entity;

import by.mozgo.triangle.logic.TriangleLogic;
import by.mozgo.triangle.observer.OperationObserver;
import by.mozgo.triangle.observer.TrianglePerimeter;
import by.mozgo.triangle.observer.TriangleSquare;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Andrei Mozgo
 */
public class Triangle {
    private int id;
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private TrianglePerimeter perimeter = new TrianglePerimeter();
    private TriangleSquare square = new TriangleSquare();
    private ArrayList<OperationObserver> observerList = new ArrayList();

    public Triangle(int id, Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.id = id;
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        TriangleLogic.calculatePerimeter(this);
        TriangleLogic.calculateSquare(this);
    }

    public void addObserver(OperationObserver observer) {
        observerList.add(observer);
    }

    private void notifyObservers() {
        Iterator it = observerList.iterator();
        while (it.hasNext()) {
            ((OperationObserver) it.next()).valueChanged(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
        notifyObservers();
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
        notifyObservers();
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
        notifyObservers();
    }
}
