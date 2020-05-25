package graph;

import java.util.*;
import java.util.stream.Collectors;

public class AdjacencyGraph {
    private int v;
    private boolean isDirected;
    private LinkedList<Integer>[] adjList;

    public AdjacencyGraph(int v) {
        this(v, false);
    }

    public AdjacencyGraph(int v, boolean isDirected) {
        this.v = v;
        this.isDirected = isDirected;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void add(int src, int dest) {
        adjList[src].add(dest);
        if (!isDirected)
            adjList[dest].add(src);
    }

    public void print() {
        for (int i = 0; i < v; i++) {
            if (adjList[i].size() > 0)
                System.out.println(i + "-> " + adjList[i].stream().map(Object::toString).collect(Collectors.joining("-> ")));
            else
                System.out.println(i);
        }
    }

    public List<Integer> traverseBFS(int src) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();
        List<Integer> bfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[v];
        queue.add(src);
        while (!queue.isEmpty()) {
            tempQueue.clear();
            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                visited[vertex] = true;
                bfsTraversal.add(vertex);
                adjList[vertex].stream().filter(ver -> !visited[ver]).forEach(item -> {
                    visited[item] = true;
                    tempQueue.add(item);
                });
            }
            queue.addAll(tempQueue);
        }
        return bfsTraversal;
    }

    public void setDirected(boolean isDirected) {
        this.isDirected = isDirected;
    }
}