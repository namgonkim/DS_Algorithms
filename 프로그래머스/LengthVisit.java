package programmers.summerwinter;
/*
문제: 방문길이
유형: 구현, 좌표이동
날짜: 2021.06.30(수)
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("LULLLLLLU"));
    }
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][][] visited;

    public int solution(String dirs) {
        int answer = 0;
        visited = new boolean[11][11][11][11];

        int x=0,y=0;
        for(int i=0;i<dirs.length();i++){
            int nx = 0;
            int ny = 0;
            // 왼쪽
            if(dirs.charAt(i) == 'L'){
                nx = x + dx[2];
                ny = y + dy[2];
            }
            // 오른쪽
            else if(dirs.charAt(i) == 'R') {
                nx = x + dx[3];
                ny = y + dy[3];
            }
            // 아래
            else if(dirs.charAt(i) == 'D') {
                nx = x + dx[1];
                ny = y + dy[1];
            }
            // 위
            else {
                nx = x + dx[0];
                ny = y + dy[0];
            }
            if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5){
                if(visited[y+5][x+5][ny+5][nx+5] == false && visited[ny+5][nx+5][y+5][x+5] == false){
                    answer += 1;
                    visited[y+5][x+5][ny+5][nx+5] = true;
                    visited[ny+5][nx+5][y+5][x+5] = true;
                }
                x = nx;
                y = ny;
            }
        }
        return answer;
    }
}