import java.util.*;

public class Graph {
    private int numVertices; // número de vértices
    private LinkedList<Integer>[] adjList; // lista de adyacencia

    // Constructor del grafo
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Método para agregar una arista
    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source); // Si el grafo es no dirigido
    }

    // DFS iterativo usando pila
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        System.out.print("DFS: ");
        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + " ");
                
                // Agrega todos los vértices adyacentes
                for (int adj : adjList[vertex]) {
                    if (!visited[adj]) {
                        stack.push(adj);
                    }
                }
            }
        }
        System.out.println();
    }

    // BFS usando cola
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            // Agrega todos los vértices adyacentes
            for (int adj : adjList[vertex]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.dfs(0); // Realiza DFS desde el nodo 0
        graph.bfs(0); // Realiza BFS desde el nodo 0
    }
}
