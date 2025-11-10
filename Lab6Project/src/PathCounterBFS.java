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

		// start with one way to reach the source (the empty path)
		numPathsFromSource[source] = 1;

		while (!queue.isEmpty()) {
			int v = queue.removeFirst();

			// propagate the number of paths from v to each of its neighbors
			for (int w : G.adj(v)) {
				numPathsFromSource[w] += numPathsFromSource[v];
				if (!marked[w]) {
					marked[w] = true;
					queue.add(w);
				}
			}

		}

    }
    
    public long getNumPaths(int destination) {
		return numPathsFromSource[destination];
    }

}
