package coordinates;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by azee on 20.09.17.
 */

//Find 10 closest points to K
public class TopClosestPoints {
    public class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

    }

    public List<Point> findKClosest(Point[] p, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>(10, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return (b.x * b.x + b.y * b.y) - (a.x * a.x + a.y * a.y);
            }
        });

        List<Point> result = new ArrayList();
        while (!pq.isEmpty())
            result.add(pq.poll());

        return result;
    }
}
