class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                color[i]=0;
                if(!dfs(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph,int node,int[] color){
        for(int j=0;j<graph[node].length;j++){
            int neighbor=graph[node][j];
            if(color[neighbor]==-1){
                color[neighbor]=1-color[node];
                if(!dfs(graph,neighbor,color)){
                    return false;
                }
            }else if(color[neighbor]==color[node]){
                    return false;
            }
        }
        return true;
    }
}