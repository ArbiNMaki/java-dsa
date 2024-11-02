package com.dsa.java.searching;

import java.util.*;

public class BreadthFirstSearch2 {
    // Membuat adjacency list untuk menyimpan graf
    private final Map<String, List<String>> adjList;

    // Konstruktor untuk inisialisasi adjacency list
    public BreadthFirstSearch2() {
        adjList = new HashMap<>();
    }

    // Menambahkan edge (sisi) antara dua node dalam graf
    public void addEdge(String from, String to) {
        // Jika node 'from' atau 'to' belum ada dalam adjacency list, tambahkan
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());

        // Tambahkan 'to' sebagai tetangga dari 'from' dan sebaliknya karena graf tidak berarah
        adjList.get(from).add(to);
        adjList.get(to).add(from);
    }

    // Implementasi algoritma BFS untuk mencari jalur terpendek
    public Map<String, String> bfs(String start, String end) {
        // Menyimpan node predecessor untuk melacak jalur
        Map<String, String> predecessor = new HashMap<>();
        // Queue untuk BFS
        Queue<String> queue = new LinkedList<>();
        // Set untuk melacak node yang sudah dikunjungi
        Set<String> visited = new HashSet<>();

        // Memulai BFS dari node 'start'
        queue.add(start);
        visited.add(start);
        predecessor.put(start, null); // 'start' tidak memiliki predecessor

        // Lakukan iterasi selama queue tidak kosong
        while (!queue.isEmpty()) {
            // Ambil dan hapus elemen dari antrian
            String node = queue.poll();

            // Jika node yang dicari ditemukan, kembalikan map predecessor
            if (node.equals(end)) {
                return predecessor;
            }

            // Iterasi melalui semua tetangga dari node saat ini
            for (String neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
                // Jika tetangga belum dikunjungi, tambahkan ke antrian dan tandai sebagai dikunjungi
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    predecessor.put(neighbor, node); // Simpan node saat ini sebagai predecessor dari tetangga
                }
            }
        }

        // Kembalikan map predecessor, meskipun mungkin tidak ada jalur dari 'start' ke 'end'
        return predecessor;
    }

    // Mengembalikan jalur terpendek dari 'start' ke 'end'
    public List<String> getShortestPath(String start, String end) {
        // Dapatkan map predecessor dari BFS
        Map<String, String> predecessor = bfs(start, end);
        // List untuk menyimpan jalur
        List<String> path = new ArrayList<>();

        // Lacak jalur dari 'end' ke 'start' menggunakan map predecessor
        for (String at = end; at != null; at = predecessor.get(at)) {
            path.add(at);
        }
        // Balikkan urutan list agar jalur dimulai dari 'start'
        Collections.reverse(path);

        // Jika jalur hanya memiliki satu node dan bukan 'start', berarti tidak ada jalur valid
        return path.size() == 1 && !path.get(0).equals(start) ? Collections.emptyList() : path;
    }

    // Metode main untuk menguji algoritma BFS
    public static void main(String[] args) {
        BreadthFirstSearch2 graph = new BreadthFirstSearch2();

        // Tambahkan sisi ke dalam graf
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("C", "G");
        graph.addEdge("D", "H");
        graph.addEdge("E", "H");
        graph.addEdge("F", "I");
        graph.addEdge("G", "I");
        graph.addEdge("H", "I");
        graph.addEdge("H", "J");
        graph.addEdge("I", "J");

        // Cari jalur terpendek dari A ke J dan cetak hasilnya
        List<String> path = graph.getShortestPath("A", "J");
        System.out.println("Shortest path from A to J: " + path);
    }
}
