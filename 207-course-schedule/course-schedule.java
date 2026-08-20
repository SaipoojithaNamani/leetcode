import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree of each course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int pre = prerequisite[1];

            graph.get(pre).add(course);

            indegree[course]++;
        }

        // Queue courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        // BFS / Topological Sort
        while (!queue.isEmpty()) {

            int course = queue.poll();

            completed++;

            for (int nextCourse : graph.get(course)) {

                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return completed == numCourses;
    }
}