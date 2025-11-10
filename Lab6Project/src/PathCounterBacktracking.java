import java.util.Deque;

public class PathCounterBacktracking implements PathCounter {

	long[] numPathsFromSource;

	public void countAllPathsFrom(Digraph G, int source) {
		int numVertices = G.V();
		numPathsFromSource = new long[numVertices]; // all initialized to 0
		exploreAllPaths(G, source);
	}

    private void exploreAllPaths(Digraph G, int v) {

		// TODO: since each call to this function represents a unique path to v
		//       you should first add ONE to our count of the # of ways to reach v.

		// TODO: keep exploring recursively, trying each path that extends to each vertex w adjacent to v

		// TODO: If you have time, for 1 pt (out of 20), ensure your algorithm returns the correct number
		//        of "simple paths" for any directed graph, even if it contains cycles (e.g. non_dag.txt),
		//        instead crashing with a StackOverflowError.
    }
    
    public long getNumPaths(int destination) {
		//TODO: change this to simply return the appropriate value from the array that we calculated during the exploration
		return 1;
    }

}
