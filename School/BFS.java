package School;

import java.util.*;

public class BFS {
    public static void bfs(Map<String, List<String>> graph, String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.println("Visiting: " + node);

            for (String neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) {
        // Création d'un graphe simple
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C","A"));
        graph.put("B", Arrays.asList("D", "E"));
        graph.put("C", Arrays.asList("F"));
        graph.put("D", Collections.emptyList());
        graph.put("E", Collections.emptyList());
        graph.put("F", Collections.emptyList());

        // Lancer le School.BFS à partir du sommet "A"
        bfs(graph, "A");
    }
}
