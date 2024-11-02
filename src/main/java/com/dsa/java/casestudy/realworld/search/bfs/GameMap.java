package com.dsa.java.casestudy.realworld.search.bfs;

import java.util.*;

public class GameMap {

    private final Map<String, List<String>> adjList;

    public GameMap() {
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
        GameMap graphData  = new GameMap();

        graphData.addEdge("Start", "Point1");
        graphData.addEdge("Start", "Point2");
        graphData.addEdge("Point1", "Point3");
        graphData.addEdge("Point2", "Point4");
        graphData.addEdge("Point3", "Destination");
        graphData.addEdge("Point4", "Destination");

        List<String> path = graphData.getShortedPath("Start", "Destination");
        System.out.println("Shortest path from Start to Destination: " + path);
    }
}
