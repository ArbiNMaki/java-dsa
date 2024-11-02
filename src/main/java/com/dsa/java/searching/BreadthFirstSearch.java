package com.dsa.java.searching;

import java.util.*;

public class BreadthFirstSearch {
    private final Map<String, Map<String, Integer>> adjList;

    // Konstruktor untuk menginisialisasi adjacency list
    public BreadthFirstSearch() {
        adjList = new HashMap<>();
    }

    // Menambahkan edge antara dua node
    public void addEdge(String from, String to, int weight) {
        adjList.putIfAbsent(from, new HashMap<>());
        adjList.putIfAbsent(to, new HashMap<>());
        adjList.get(from).put(to, weight);
        adjList.get(to).put(from, weight); // Karena graf tidak berarah
    }

    // Implementasi algoritma BFS
    public Map<String, String> bfs(String start, String end) {
        Map<String, String> predecessor = new HashMap<>(); // Untuk melacak jalur terpendek
        Queue<String> queue = new LinkedList<>(); // Antrian untuk traversal BFS
        Set<String> visited = new HashSet<>(); // Set untuk melacak node yang sudah dikunjungi

        queue.add(start); // Menambahkan node awal ke antrian
        visited.add(start); // Menandai node awal sebagai dikunjungi
        predecessor.put(start, null); // Node awal tidak memiliki predecessor

        // Proses BFS
        while (!queue.isEmpty()) {
            String node = queue.poll(); // Ambil node dari depan antrian

            if (node.equals(end)) { // Jika node yang diambil adalah node tujuan
                return predecessor; // Kembalikan map predecessor
            }

            // Kunjungi semua tetangga dari node yang diambil
            for (Map.Entry<String, Integer> entry : adjList.getOrDefault(node, Collections.emptyMap()).entrySet()) {
                String neighbor = entry.getKey();
                if (!visited.contains(neighbor)) { // Jika tetangga belum dikunjungi
                    visited.add(neighbor); // Tandai tetangga sebagai dikunjungi
                    queue.add(neighbor); // Tambahkan tetangga ke antrian
                    predecessor.put(neighbor, node); // Catat predecessor dari tetangga
                }
            }
        }

        return predecessor; // Kembalikan map predecessor jika node tujuan tidak ditemukan
    }

    // Mendapatkan jalur terpendek dari start ke end
    public List<String> getShortestPath(String start, String end) {
        Map<String, String> predecessor = bfs(start, end); // Jalankan BFS untuk mendapatkan predecessor
        List<String> path = new ArrayList<>(); // List untuk menyimpan jalur terpendek

        // Membaca jalur terpendek dari node end ke node start
        for (String at = end; at != null; at = predecessor.get(at)) {
            path.add(at); // Tambahkan node ke jalur
        }
        Collections.reverse(path); // Balikkan jalur untuk mendapatkan urutan dari start ke end

        // Jika jalur hanya berisi satu node dan bukan node start, artinya jalur tidak ditemukan
        return path.size() == 1 && !path.getFirst().equals(start) ? Collections.emptyList() : path;
    }

    public int calculatePathWeight(List<String> path) {
        int totalWeight = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            String from = path.get(i);
            String to = path.get(i + 1);
            totalWeight += adjList.getOrDefault(from, Collections.emptyMap()).getOrDefault(to, 0);
        }

        return totalWeight;
    }

    // Fungsi utama untuk menjalankan program
    public static void main(String[] args) {
        BreadthFirstSearch graph = new BreadthFirstSearch();

        // Menambahkan edges ke graf berdasarkan data yang diberikan
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 8);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 2);
        graph.addEdge("B", "E", 4);
        graph.addEdge("C", "F", 7);
        graph.addEdge("C", "G", 6);
        graph.addEdge("D", "H", 1);
        graph.addEdge("E", "H", 3);
        graph.addEdge("F", "I", 8);
        graph.addEdge("G", "I", 9);
        graph.addEdge("H", "I", 2);
        graph.addEdge("H", "J", 6);
        graph.addEdge("I", "J", 5);

        // Mendapatkan jalur terpendek dari A ke J
        List<String> shortestPath = graph.getShortestPath("A", "J");
        int shortestPathWeight = graph.calculatePathWeight(shortestPath);
        System.out.println("Shortest path from A to J: " + shortestPath);
        System.out.println("Total weight of the shortest path: " + shortestPathWeight);
    }
}
