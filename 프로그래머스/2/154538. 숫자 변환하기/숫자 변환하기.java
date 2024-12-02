import java.util.*;

class Solution {
    // x-> y
    // 1. x += n
    // 2. x *= 2
    // 3. x *= 3
    public int solution(int x, int y, int n) {
        int answer = -1;
        // x-> y로 가는 경로에 카운트를 해 최단거리 찾기
        Queue<int[]> q = new ArrayDeque<>();
        // 시간초과를 챙기는 법 방문한 값은 재방문하지 않는다. 
        boolean[] visited = new boolean[1000001];
        int[] start = new int[]{x, 0};
        q.offer(start);
        while(!q.isEmpty()) {
            int[] now = q.poll();
            visited[now[0]] = true;
            if(now[0] == y) {
                answer = now[1];
                break;
            }
            
            // 2. x*2
            if(now[0] * 2 <= y && !visited[now[0] * 2]) {
                q.add(new int[]{now[0] * 2, now[1] + 1});
            }
            // 3. x*3
            if(now[0] * 3 <= y && !visited[now[0] * 3]) {
                q.add(new int[]{now[0] * 3, now[1] + 1});
            }
            // 1. x+n
            if(now[0] + n <= y && !visited[now[0] + n]) {
                q.add(new int[]{now[0] + n, now[1] + 1});
            }
        }
        return answer;
    }
}