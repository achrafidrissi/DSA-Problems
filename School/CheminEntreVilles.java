package School;

import java.util.*;

public class CheminEntreVilles {
    public static List<String> trouverChemin(Map<String, List<String>> graphe, String depart, String arrivee) {
        Map<String, String> parents = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(depart);
        visited.add(depart);

        while (!queue.isEmpty()) {
            String ville = queue.poll();
            if (ville.equals(arrivee)) {
                break;
            }

            for (String voisine : graphe.getOrDefault(ville, new ArrayList<>())) {
                if (!visited.contains(voisine)) {
                    visited.add(voisine);
                    parents.put(voisine, ville); // Pour reconstituer le chemin
                    queue.add(voisine);
                }
            }
        }

        if (!parents.containsKey(arrivee)) {
            System.out.println("Aucun chemin trouvé entre " + depart + " et " + arrivee);
            return Collections.emptyList();
        }

        // Reconstituer le chemin
        List<String> chemin = new LinkedList<>();
        String current = arrivee;
        while (current != null) {
            chemin.add(0, current);
            current = parents.get(current);
        }

        return chemin;
    }

    public static void main(String[] args) {
        // Graphe des villes
        Map<String, List<String>> villes = new HashMap<>();
        villes.put("Paris", Arrays.asList("Lyon", "Nantes"));
        villes.put("Lyon", Arrays.asList("Marseille"));
        villes.put("Nantes", Arrays.asList("Bordeaux"));
        villes.put("Marseille", new ArrayList<>());
        villes.put("Bordeaux", new ArrayList<>());

        String depart = "Paris";
        String arrivee = "Bordeaux";

        List<String> chemin = trouverChemin(villes, depart, arrivee);
        if (!chemin.isEmpty()) {
            System.out.println("Chemin trouvé : " + String.join(" -> ", chemin));
        }
    }
}
