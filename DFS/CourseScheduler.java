package DFS;

// =====================================================
// 210. Course Schedule II
// =====================================================

import java.util.*;


public class CourseScheduler {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, graph, visited, result)) {
                    return new int[0]; // cycle detected
                }
            }
        }

        Collections.reverse(result);

        // Convert List to array
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = result.get(i);
        }

        return order;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] visited, List<Integer> result) {
        if (visited[course] == 1) {
            return false; // cycle detected
        }

        if (visited[course] == 2) {
            return true; // already processed
        }

        visited[course] = 1; // mark as visiting

        for (int neighbor : graph.get(course)) {
            if (!dfs(neighbor, graph, visited, result)) {
                return false;
            }
        }

        visited[course] = 2; // mark as visited
        result.add(course); // add course to result list after visiting neighbors

        return true;
    }
}
