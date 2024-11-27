class Solution {
    public static int result = 0;
    public int solution(int k, int[][] dungeons) {
        // 모든 던전에 방문했는지를 백트래킹하는 visited
        boolean[] visited = new boolean[dungeons.length];
        // 재귀탐색을 통해 던전을 모두 찾아나가는 경우로 
        dfs(0, k, visited, dungeons);
        
        return result;
    }
    
    public void dfs(int depth, int k, boolean[] visited, int[][] dungeons) {
        // 모든 던전을 다 들어가본다
        for(int i=0; i<dungeons.length; i++) {
            // 이미 방문한적이 있거나 현재 피로도가 최소 피로도보다 작으면 진행 x
            if(visited[i] || k < dungeons[i][0]) continue;
            // 방문 시작 
            visited[i] = true;
            dfs(depth+1, k - dungeons[i][1], visited, dungeons);
            // 다른 노드에서 방문할 수 있으니 끈다.
            visited[i] = false;
        }
        
        result = Math.max(depth, result);
    }
}