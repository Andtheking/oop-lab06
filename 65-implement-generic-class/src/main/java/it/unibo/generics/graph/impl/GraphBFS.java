package it.unibo.generics.graph.impl;

import java.util.LinkedList;
import java.util.List;

public class GraphBFS<N> extends GraphBase<N> {
    @Override
    protected List<N> visitStrategy(N source, N target) {
        List<N> path = new LinkedList<>();
        List<N> toVisit = new LinkedList<>(List.of(source));
        List<N> visited = new LinkedList<>();
        boolean targetFound = false;
        while (!toVisit.isEmpty() && !targetFound) {
            N currentNode = toVisit.removeFirst();
            for (N adjacentNode : this.linkedNodes(currentNode)) {
                if (!visited.contains(adjacentNode) && !toVisit.contains(adjacentNode)) {
                    toVisit.addLast(adjacentNode);
                }
            }
            visited.add(currentNode);
            if (currentNode.equals(target)) {
                targetFound = true;
            }
        }
        if (!visited.contains(target)) {
            return new LinkedList<>();
        }
        /*
         * Resolve path
         */
        path.addLast(target);
        for (N n : visited.reversed()) {
            if (linkedNodes(n).contains(path.getFirst())) {
                path.addFirst(n);
            }
        }
        return path;
    }
}
