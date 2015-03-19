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

	private Random rand = null;
	private boolean done = false;
	private ArrayList<Point> walk = null;

    public RandomWalk(int size, long seed) {
        rand = new Random(seed);
        walk = new ArrayList<Point>();
        walk.add(new Point(size, size));
        //target
    }

    public RandomWalk(int size) {
        rand = new Random(0);
        walk = new ArrayList<Point>();
        walk.add(new Point(size, size));
        //target
    }

	private boolean checkSolution() {
		Point p = walk.get(0);
		return (p.x == 0 && p.y == 0);
	}

	public void step() {
		this.done = checkSolution();
		if (!done) {
			int choice = rand.nextInt(2);
			Point p = walk.get(0);
			System.out.println("Choice=" + choice);
			if (choice == 0) {
				// go up
				walk.add(new Point(p.x, p.y - 1));
			} else {
				// go left
				walk.add(new Point(p.x - 1, p.y));
			}
		}
	}

	public void createWalk() {
		while (!done) {
			step();
		}
	}

	public boolean isDone() {
		return done;
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

	public static void main(String foo[]) {
		RandomWalk w = new RandomWalk(4);
		w.createWalk();
		System.out.println(w);
	}

}
