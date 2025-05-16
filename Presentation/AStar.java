package Presentation;

import java.util.*;

public class AStar {

    public List<Node> aStarSearch(Map<Node, List<Edge>> graph, Node start, Node goal, Map<Node, Double> heuristic) {
        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Double> gScore = new HashMap<>();
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(n -> gScore.get(n) + heuristic.getOrDefault(n, 0.0)));

        for (Node node : graph.keySet()) {
            gScore.put(node, Double.POSITIVE_INFINITY);
        }
        gScore.put(start, 0.0);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            for (Edge edge : graph.getOrDefault(current, List.of())) {
                double tentative = gScore.get(current) + edge.cost;
                if (tentative < gScore.get(edge.target)) {
                    gScore.put(edge.target, tentative);
                    cameFrom.put(edge.target, current);
                    openSet.add(edge.target);
                }
            }
        }

        return List.of();
    }

}
