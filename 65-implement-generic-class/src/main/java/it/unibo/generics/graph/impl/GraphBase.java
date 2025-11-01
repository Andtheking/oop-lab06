package it.unibo.generics.graph.impl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

import it.unibo.generics.graph.api.Graph;

public abstract class GraphBase<N> implements Graph<N> {
    private Map<N, Set<N>> nodeEdges;
    
    public GraphBase() {
        nodeEdges = new HashMap<>();
    }

    @Override
    public void addNode(N node) {
        if (node == null) {
            return;
        }

        nodeEdges.putIfAbsent(node, new HashSet<>());
    }

    @Override
    public void addEdge(N source, N target) {
        if (source == null || target == null) {
            return;
        }
        
        nodeEdges.get(source).add(target);
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(nodeEdges.keySet());
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return new HashSet<>(nodeEdges.get(node));
    }

    @Override
    public List<N> getPath(N source, N target) {
        return visitStrategy(source, target);
    }

    protected abstract List<N> visitStrategy(N source, N target);


}
