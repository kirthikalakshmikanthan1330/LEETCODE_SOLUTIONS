class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int course=prerequisites[i][0];
            int prequisite=prerequisites[i][1];
            graph.get(prequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int[] order=new int[numCourses];
        int index=0;
        //int count=0;
        while(!queue.isEmpty()){
            int course=queue.poll();
            //count++;
            order[index]=course;
            index++;
            for(int i=0;i<graph.get(course).size();i++){
                int nextCourse=graph.get(course).get(i);
                indegree[nextCourse]--;
                if(indegree[nextCourse]==0){
                    queue.add(nextCourse);
                }
            }
        }
        if(index==numCourses){
            return order;
        }
        return new int[0];
    }
}