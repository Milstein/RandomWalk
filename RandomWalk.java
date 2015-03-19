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
    private int size;

    public RandomWalk(int size, long seed) {
        rand = new Random(seed);
        walk = new ArrayList<Point>();
        last = new Point(0, 0);
        this.size = size - 1;
        walk.add(last);
    }

    public RandomWalk(int size) {
        this(size, 0);
    }

    public boolean isDone() {
        Point p = last;
        return (p.x == size && p.y == size);
    }

    public void step() {
        if (!this.isDone()) {
            int choice = rand.nextInt(2);
            //System.out.println("Choice = " + choice);
            if (choice == 0 && last.y < size) {                      // go up
                last = new Point(last.x, last.y + 1);
            } else if (choice == 1 && last.x < size) {                                // go left
                last = new Point(last.x + 1, last.y);
            } else if (choice == 0 && last.y == size) {
                last = new Point(last.x + 1, last.y);
            } else if (choice == 1 && last.x == size) {
                last = new Point(last.x, last.y + 1);
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
