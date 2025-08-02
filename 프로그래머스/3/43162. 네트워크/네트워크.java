class Solution {
    boolean[] visited;
    int n,answer;
    int[][] computers;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        this.n = n;
        this.computers = computers;
        answer = 0;
        
        for(int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int k){
        visited[k] = true;
        
        for (int i = 0; i < n; i++){
            if(!visited[i] && computers[k][i] == 1){
                dfs(i);
            }
        }

    }
}