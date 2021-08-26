package backjoon;

import java.util.*;
/*
문제: 백준 14503 로봇 청소기
유형: 시뮬레이션 좌표이동
날짜: 2021 08 26 목
 */

public class Main14503 {
    public static int n, m; // n: 세로, m: 가로
    public static int[] dx = {0, 1, 0, -1}; // 북, 동, 남, 서
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static int[][] visited;

    // 왼쪽(반시계 방향)으로 회전
    public static int turnLeft(int dir) {
        int direction = dir - 1;
        if(direction == -1)
            direction = 3;
        return direction;
    }

    public static int solution(int y, int x, int dir) {
        int counts = 1;
        int fullTime = 0;
        // 1. 현재 위치 청소
        visited[y][x] = 1;
        // 2. 탐색 시작
        while(true) {
            // 현재 방향을 기준으로 왼쪽 방향부터 인접한 칸 탐색
            dir = turnLeft(dir);

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            // a 왼쪽 방향에 청소하지 않은 공간이 존재한다면, 그 방향으로 이동 후 청소
            if(map[ny][nx] == 0 && visited[ny][nx] == 0){
                visited[ny][nx] = 1; // 청소
                x = nx;
                y = ny;
                counts += 1;
                // 4방향 초기화
                fullTime = 0;
            }
            // b 왼쪽 방향에 청소할 공간이 없다면
            else {
                fullTime += 1;
            }
            // c 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로
            if(fullTime == 4) {
                nx = x - dx[dir];
                ny = y - dy[dir];
                // d 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                if(map[ny][nx] == 1){
                    break;
                }
                else{
                    x = nx;
                    y = ny;
                }
                fullTime = 0;
            }

        }
        return counts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();
        int dir = sc.nextInt();

        map = new int[n][m];
        visited = new int[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(r,c, dir));
    }

}
