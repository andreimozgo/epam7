package by.mozgo.triangle.entity;

/**
 * @author Andrei Mozgo
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;
        if (obj.getClass() == this.getClass()) {
            Point point = (Point) obj;
            if (point.x == this.x && point.y == this.y)
                return true;
        }
        return false;
    }
}
