package com.dsa.java.casestudy.realworld.search.dfs;

import java.util.*;

public class NetworkComputer {

    private final Map<Character, List<Character>> adjList;

    public NetworkComputer() {
        adjList = new HashMap<>();
    }

    public void addEdge(char source, char destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void DFS(char start) {
        Set<Character> visited = new HashSet<>();
        DFSRecursive(start, visited);
    }

    private void DFSRecursive(char vertex, Set<Character> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (char neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                DFSRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        NetworkComputer graph = new NetworkComputer();

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'G');
        graph.addEdge('C', 'H');
        graph.addEdge('D', 'F');
        graph.addEdge('G', 'I');
        graph.addEdge('G', 'J');
        graph.addEdge('H', 'K');

        System.out.println("NETWORK COMPUTER starting from vertex A :");
        graph.DFS('A');
    }
}
