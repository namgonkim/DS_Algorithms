class Solution {
    public static int[][] graph;
    public int solution(int n, int[][] results) {
        // 그래프 초기화 
        graph = new int [n+1][n+1];
        for(int i=0;i<results.length; i++) {
            // player 0이 1을 이김
            int[] player = results[i];
            graph[player[0]][player[1]] = 1;
        }
        // 플로이드-워셜 알고리즘으로 선수들의 경기 결과를 수집한다.
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    // i가 k를 이기고 k가 j를 이기는 경로가 있다면 i가 j를 이길 수 있으니 1로 변경 
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        // System.out.println("i: " + i + ",j: " + j);
                    }
                }
            }
        }
        
        // 확신할 수 있는 순위를 찾는다 나를 기준으로 나머지 n-1명의 결과를 알 수 있으면 순위 확인할 수 있음
        int answer = 0;
        for(int i=1;i<=n;i++) {
            int play = 0;
            for(int j=1;j<=n;j++) {
                // 내가 누군가에게 졌거나 반대로 누구에게 이겼는지 알면 ++ 
                if(graph[i][j] == 1 || graph[j][i] == 1) {
                    play++;
                }
            }
            // 전체 합산이 n-1이면 게임 승리 
            if(play == n-1) {
                answer++;
            }
        }
        return answer;
    }
}