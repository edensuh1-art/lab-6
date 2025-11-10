public class DirectedCycleDetector {

    private final boolean[] marked;
    private final boolean[] onStack;
    private boolean hasCycle;

    public DirectedCycleDetector(Digraph G, int source) {
        int numVertices = G.V();
        marked = new boolean[numVertices]; // initialized to false
        onStack = new boolean[numVertices];
        hasCycle = false; // assume no cycle unless we find one
        dfs(G, source);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            } // TODO: add an else if clause to finish the cycle checking algorithm
//            else if ( SOMETHING  ) {
//                 SOMETHING
//            }
            if (hasCycle) { // if we know there's a cycle, no need to keep looking
                return;
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
