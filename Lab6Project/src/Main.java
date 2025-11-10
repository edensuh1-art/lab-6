import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		PathCounter pathCounter = new PathCounterBacktracking();
//		PathCounter pathCounter = new PathCounterBFS();
//		PathCounter pathCounter = new PathCounterTopological();

		String[] filenames = {"small_lattice.txt"};
		//String[] filenames = {"small_lattice.txt", "exponential64.txt", "order_matters.txt", "non_dag.txt"};

		for (String filename : filenames) {
			System.out.println("Counting paths in graph " + filename + " from vertex 0");
			Digraph dag = new Digraph(new Scanner(new File(filename)));

			pathCounter.countAllPathsFrom(dag, 0);

			for (int i = 1; i < dag.V(); i++) {
				System.out.println("  # of paths from 0 to " + i + ": " + pathCounter.getNumPaths(i));
			}
			System.out.println();
		}


	}

}
