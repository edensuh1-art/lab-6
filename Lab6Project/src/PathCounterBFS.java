import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.Scanner;

public class PathCounterBFS implements PathCounter {

	boolean[] marked;
	long[] numPathsFromSource;

	public void countAllPathsFrom(Digraph G, int source) {
		int numVertices = G.V();
		marked = new boolean[numVertices];
		numPathsFromSource = new long[numVertices];
		bfsCountPaths(G, source);
	}

    private void bfsCountPaths(Digraph G, int source) {
		Deque<Integer> queue = new java.util.LinkedList<>();
		queue.add(source);
		marked[source] = true;

		//TODO: finish this code using a breadth-first search / dynamic programming approach
		//numPathsFromSource[source] = SOMETHING;

		while (!queue.isEmpty()) {
			int v = queue.removeFirst();

			// TODO: At this point, we've already found numPathsFromSource[v] distinct paths to v,
			//       so we want to add this number of paths to w's count, for each w adjacent to v.
			//       (we also want to schedule w for later exploration, if we haven't already done so)

		}

    }
    
    public long getNumPaths(int destination) {
		return numPathsFromSource[destination];
    }

}
