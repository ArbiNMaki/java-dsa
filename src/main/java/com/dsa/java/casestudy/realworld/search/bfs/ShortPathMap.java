package com.dsa.java.casestudy.realworld.search.bfs;

import java.util.*;

public class ShortPathMap {

    private final Map<String, List<String>> adjList;

    public ShortPathMap() {
        adjList = new HashMap<>();
    }

    public void addEdge(String from, String to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);
        adjList.get(to).add(from);
    }

    public Map<String, String> bfs(String start, String end) {
        Map<String, String> predecessor = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        predecessor.put(start, null);

        while (!queue.isEmpty()) {
            String node = queue.poll();

            if (node.equals(end)) {
                return predecessor;
            }

            for (String neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    predecessor.put(neighbor, node);
                }
            }
        }

        return predecessor;
    }

    public List<String> getShortedPath(String start, String end) {
        Map<String, String> predecessor = bfs(start, end);
        List<String> path = new ArrayList<>();

        for (String at = end; at != null; at = predecessor.get(at)) {
            path.add(at);
        }

        Collections.reverse(path);

        return path.size() == 1 && !path.get(0).equals(start) ? Collections.emptyList() : path;
    }

    public static void main(String[] args) {
        ShortPathMap graphData  = new ShortPathMap();

        graphData.addEdge("A", "B");
        graphData.addEdge("A", "C");
        graphData.addEdge("B", "D");
        graphData.addEdge("B", "E");
        graphData.addEdge("C", "F");
        graphData.addEdge("E", "F");

        List<String> path = graphData.getShortedPath("A", "F");
        System.out.println("Shortest path from A to F: " + path);
    }
}
