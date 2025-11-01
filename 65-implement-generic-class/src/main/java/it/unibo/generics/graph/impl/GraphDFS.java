package it.unibo.generics.graph.impl;

import java.util.LinkedList;
import java.util.List;

public class GraphDFS<N> extends GraphBase<N> {

    @Override
    protected List<N> visitStrategy(N source, N target) {
        List<N> path = new LinkedList<>();
        List<N> visited = new LinkedList<>();
        List<N> toVisit = new LinkedList<>(List.of(source));
        dfs(source, target, toVisit, visited, path);
        return path.reversed();
    }
 
    private boolean dfs(N source, N target, List<N> toVisit, List<N> visited, List<N> path) {
        if (source.equals(target)) {
            path.add(source);
            return true;
        }
        for (N currentNode : this.linkedNodes(source)) {
            if (!toVisit.contains(currentNode) && !visited.contains(currentNode)) {
                toVisit.add(currentNode);
                if (dfs(currentNode, target, toVisit, visited, path)) {
                    path.add(source);
                    return true;
                }
            }
        }
        visited.add(source);
        return false;
    }

}
