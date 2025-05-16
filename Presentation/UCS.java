package Presentation;

import java.util.*;

public class UCS {

    public List<Node> uniformCostSearch(Map<Node, List<Edge>> graph, Node start, Node goal) {
        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Double> costs = new HashMap<>();
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(costs::get));

        for (Node node : graph.keySet()) {
            costs.put(node, Double.POSITIVE_INFINITY);
        }
        costs.put(start, 0.0);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            for (Edge edge : graph.getOrDefault(current, List.of())) {
                double newCost = costs.get(current) + edge.cost;
                if (newCost < costs.get(edge.target)) {
                    costs.put(edge.target, newCost);
                    cameFrom.put(edge.target, current);
                    openSet.add(edge.target);
                }
            }
        }

        return List.of(); // No path
    }

}
