import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathCounterTopological implements PathCounter {

	boolean[] marked;
	long[] numPathsFromSource;

	public void countAllPathsFrom(Digraph G, int source) {
		if (new DirectedCycleDetector(G, source).hasCycle()) {
			throw new IllegalArgumentException("Graph contains a cycle, so topological sort is impossible, and path/trail/walk counting will not be reliable");
		}
		int numVertices = G.V();
		marked = new boolean[numVertices];
		// first, find the post-order DFS traversal of the graph
		List<Integer> dfsPostOrder = findPostOrderDFSTraversal(G, source);
		// then reverse it, to get a "topological sort" order.
		Collections.reverse(dfsPostOrder);

		numPathsFromSource = new long[numVertices];
		numPathsFromSource[source] = 1;
		// now use "bottom up" dynamic programming to fill in values for the
		// numPathsFromSource array starting from the source vertex and
		// progressing in topological order.
		for (int v : dfsPostOrder) {
			// propagate the number of paths from v to each of its neighbors
			for (int w : G.adj(v)) {
				numPathsFromSource[w] += numPathsFromSource[v];
			}
		}
		// TODO: then use "bottom up" dynamic programming to fill in values for the numPathsFromSource array
		//   starting from the source vertex and progressing in topological order.
	}

	private List<Integer> findPostOrderDFSTraversal(Digraph G, int source) {
		List<Integer> postOrder = new LinkedList<>(); // create a list to store the post-order traversal
		dfsPostOrder(G, source, postOrder); // pass it to the recursive DFS helper function
		return postOrder;
	}

	private void dfsPostOrder(Digraph G, int source, List<Integer> postOrder) {
		//TODO: after running this function, the postOrder list should contain
		// the reachable vertices of the graph in "post-order" DFS traversal order.
		// Add a single postOrder.add(...) line of code somewhere to accomplish this!
		marked[source] = true;
		for (int w : G.adj(source)) {
			if (!marked[w]) {
				dfsPostOrder(G, w, postOrder);
			}
		}
		postOrder.add(source);
	}

    public long getNumPaths(int destination) {
		return numPathsFromSource[destination];
    }

}
