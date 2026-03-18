class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        List<List<Integer>> list = new ArrayList<>();
        int courses = 0;
        
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] i : prerequisites) {
            indegree[i[0]]++;
            list.get(i[1]).add(i[0]); 
        }

        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offerLast(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.pollFirst();
            courses++;
            
            for (int i : list.get(curr)) {
                
                indegree[i]--; 
                if (indegree[i] == 0) queue.offerLast(i); 
            }
        }
        
        return courses == numCourses;
    }
}