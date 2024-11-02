package com.dsa.java.casestudy.realworld.search.dfs;

/*
root
|-- home
|   |-- user1
|   |   |-- file1
|   |   |-- file2
|   |-- user2
|       |-- file3
|-- etc
|   |-- config1
|-- var
    |-- log1
*/

import java.util.*;

public class FileDirectory {

    private final Map<String, List<String>> adjList;

    public FileDirectory() {
        adjList = new HashMap<>();
    }

    public void addEdge(String source, String destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void DFS(String start) {
        Set<String> visited = new HashSet<>();
        DFSRecursive(start, visited);
    }

    private void DFSRecursive(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (String neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                DFSRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        FileDirectory graph = new FileDirectory();

        /*
root
|-- home
|   |-- user1
|   |   |-- file1
|   |   |-- file2
|   |-- user2
|       |-- file3
|-- etc
|   |-- config1
|-- var
    |-- log1
*/

        graph.addEdge("ROOT", "HOME");
        graph.addEdge("ROOT", "ETC");
        graph.addEdge("ROOT", "VAR");
        graph.addEdge("HOME", "USER1");
        graph.addEdge("HOME", "USER2");
        graph.addEdge("USER1", "FILE1");
        graph.addEdge("USER1", "FILE2");
        graph.addEdge("USER2", "FILE3");
        graph.addEdge("ETC", "CONFIG1");
        graph.addEdge("VAR", "LOG1");

        System.out.println("NETWORK COMPUTER starting from vertex ROOT :");
        graph.DFS("ROOT");
    }
}
