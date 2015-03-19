import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;

/**
 * Example RandomWalk created in 5 march lecture
 *
 * @author Ian Truslow
 */

public class RandomWalk {

    private Random rand;
    private ArrayList<Point> walk;
    private Point last;

    public RandomWalk(int size, long seed) {
        rand = new Random(seed);
        walk = new ArrayList<Point>();
        last = new Point(size - 1, size - 1);
        walk.add(last);
    }

    public RandomWalk(int size) {
        this(size, 0);
    }

    public boolean isDone() {
        Point p = last;
        return (p.x == 0 && p.y == 0);
    }

    public void step() {
        if (!this.isDone()) {
            int choice = rand.nextInt(2);
            //System.out.println("Choice = " + choice);
            if (choice == 0 && last.y > 0) {                      // go up
                last = new Point(last.x, last.y - 1);
            } else if (choice == 1 && last.x > 0) {                                // go left
                last = new Point(last.x - 1, last.y);
            } else if (choice == 0 && last.y == 0) {
                last = new Point(last.x - 1, last.y);
            } else if (choice == 1 && last.x == 0) {
                last = new Point(last.x, last.y - 1);
            }
            walk.add(last);
        }
        System.out.println(this.toString());
    }

    public ArrayList<Point> getPath() {
        return walk;
    }

    public String toString() {
        String rVal = "";
        for (Point p : walk) {
            rVal += "[" + p.x + "," + p.y + "] ";
        }
        return rVal;
    }
}
