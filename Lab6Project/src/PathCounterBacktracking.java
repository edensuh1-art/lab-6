import java.util.Deque;

public class PathCounterBacktracking implements PathCounter {

	long[] numPathsFromSource;

	public void countAllPathsFrom(Digraph G, int source) {
		int numVertices = G.V();
		numPathsFromSource = new long[numVertices]; // all initialized to 0
		exploreAllPaths(G, source);
	}

    private void exploreAllPaths(Digraph G, int v) {
		boolean[] onPath = new boolean[G.V()];
		dfs(G, v, onPath);
	}

	private void dfs(Digraph G, int v, boolean[] onPath) {
		numPathsFromSource[v]++;
		onPath[v] = true;
		for (int w : G.adj(v)) {
			if (!onPath[w]) {
				dfs(G, w, onPath);
			}
		}
		onPath[v] = false;
	}

	public long getNumPaths(int destination) {
		return numPathsFromSource[destination];
	}

}