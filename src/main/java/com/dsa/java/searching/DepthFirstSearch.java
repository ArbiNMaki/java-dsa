package com.dsa.java.searching;

import java.util.*; // Mengimpor semua kelas dalam paket java.util

public class DepthFirstSearch { // Mendefinisikan kelas DepthFirstSearch
    private final Map<Character, List<Character>> adjacencyList; // Deklarasi adjacencyList untuk menyimpan daftar adjacency

    public DepthFirstSearch() { // Konstruktor untuk inisialisasi objek DepthFirstSearch
        adjacencyList = new HashMap<>(); // Membuat objek HashMap baru untuk adjacencyList
    }

    public void addEdge(char source, char destination) { // Metode untuk menambahkan edge ke graf
        adjacencyList.putIfAbsent(source, new ArrayList<>()); // Jika source tidak ada di adjacencyList, tambahkan dengan nilai kosong
        adjacencyList.putIfAbsent(destination, new ArrayList<>()); // Jika destination tidak ada di adjacencyList, tambahkan dengan nilai kosong
        adjacencyList.get(source).add(destination); // Tambahkan destination ke daftar adjacency dari source
        adjacencyList.get(destination).add(source); // Tambahkan source ke daftar adjacency dari destination
    }

    public void DFS(char start) { // Metode untuk memulai DFS dari node tertentu
        Set<Character> visited = new HashSet<>(); // Membuat set untuk melacak node yang sudah dikunjungi
        DFSRecursive(start, visited); // Memanggil metode rekursif DFS
    }

    private void DFSRecursive(char vertex, Set<Character> visited) { // Metode rekursif untuk DFS
        visited.add(vertex); // Tandai vertex sebagai dikunjungi
        System.out.print(vertex + " "); // Cetak vertex

        for (char neighbor : adjacencyList.getOrDefault(vertex, new ArrayList<>())) { // Untuk setiap tetangga dari vertex
            if (!visited.contains(neighbor)) { // Jika tetangga belum dikunjungi
                DFSRecursive(neighbor, visited); // Lakukan DFS rekursif pada tetangga tersebut
            }
        }
    }

    public static void main(String[] args) { // Metode main untuk menjalankan program
        DepthFirstSearch graph = new DepthFirstSearch(); // Membuat objek DepthFirstSearch baru
        graph.addEdge('A', 'B'); // Menambahkan edge dari A ke B
        graph.addEdge('A', 'C'); // Menambahkan edge dari A ke C
        graph.addEdge('B', 'D'); // Menambahkan edge dari B ke D
        graph.addEdge('B', 'E'); // Menambahkan edge dari B ke E
        graph.addEdge('C', 'F'); // Menambahkan edge dari C ke F

        System.out.println("Depth First Search starting from vertex A:"); // Cetak pesan
        graph.DFS('A'); // Memulai DFS dari vertex A
    }
}