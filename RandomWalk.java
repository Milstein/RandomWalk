import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;

/**
 * Example RandomWalk created in 5 march lecture
 *
 * @author Ian Truslow
 *
 */

public class RandomWalk {

	private Random rand;
	private ArrayList<Point> walk;
    private Point last;

    public RandomWalk(int size, long seed) {
        rand = new Random(seed);
        walk = new ArrayList<Point>();
        last = new Point(size, size);
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
			if (choice == 0) {                      // go up
				last = new Point(last.x, last.y - 1);
			} else {                                // go left
                last = new Point(last.x - 1, last.y);
			}
            walk.add(last);
		}
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
