import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class SquareCheck {

    static int distSq(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) +
               (a.y - b.y) * (a.y - b.y);
    }

    static boolean isSquare(Point p1, Point p2, Point p3, Point p4) {

        int[] d = new int[6];

        d[0] = distSq(p1, p2);
        d[1] = distSq(p1, p3);
        d[2] = distSq(p1, p4);
        d[3] = distSq(p2, p3);
        d[4] = distSq(p2, p4);
        d[5] = distSq(p3, p4);

        Arrays.sort(d);

        return d[0] > 0 &&
               d[0] == d[1] &&
               d[1] == d[2] &&
               d[2] == d[3] &&
               d[4] == d[5];
    }

    public static void main(String[] args) {

        Point p1 = new Point(20, 10);
        Point p2 = new Point(10, 20);
        Point p3 = new Point(20, 20);
        Point p4 = new Point(10, 10);

        if (isSquare(p1, p2, p3, p4))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
