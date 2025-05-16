package Presentation;

import java.util.*;

public class Greedy {

    public List<Node> greedySearch(Map<Node, List<Edge>> graph, Node start, Node goal, Map<Node, Double> heuristic) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(heuristic::get));
        Map<Node, Node> cameFrom = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            visited.add(current);

            for (Edge edge : graph.getOrDefault(current, List.of())) {
                if (!visited.contains(edge.target)) {
                    cameFrom.put(edge.target, current);
                    openSet.add(edge.target);
                }
            }
        }

        return List.of();
    }

}
