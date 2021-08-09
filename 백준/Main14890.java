package backjoon;

import java.util.*;
/*
문제: 경사로 (백준 14890)
유형: 구현
날짜: 2021.08.09(월)
 */
public class Main14890 {

    public static int n, l; // 크기가 n x n 인 지도, 경사로의 가로 길이 l, 세로길이는 항상 1
    public static int[][] map; // n x n 인 지도판

    public static boolean loadCheck(int y, int x, int xyflag) {
        boolean answer = true;
        boolean[] visited = new boolean[n];
        int[] height = new int[n];
        // 가로줄 혹은 세로줄 분류 -> 1차원 배열에 저장
        for(int i=0;i<n;i++){
            if(xyflag == 0) {
                height[i] = map[i][x];
            }
            else{
                height[i] = map[y][i];
            }
        }
        // 지나갈 수 있는 길 파악하기
        for(int i=0;i<n-1;i++) {
            // 앞 == 뒤
            if(height[i] == height[i+1]) continue;
            // 앞 - 뒤 = 1? 내리막 길을 위한 경사로 설치 일 때
            else if(height[i] - height[i+1] == 1) {
                // 경사로 길이(l)을 포용할 수 있으면 true
                for(int j=i+1;j<(i+1)+l;j++) {
                    // 중간에 하나라도 다른 높이가 있거나, 설치된 경사로가 있다면
                    if(j >= n || height[i+1] != height[j] || visited[j]==true ){
                        return false;
                    }
                    visited[j] = true;
                }
            }
            // 뒤 - 앞 = 1? 오르막 길
            else if(height[i+1] - height[i] == 1) {
                // 경사로 길이를 포용할 수 있으면 true
                for(int j=i;j>i-l;j--) {
                    // 중간에 하나라도 다른 높이가 있거나, 설치된 경사로가 있다면
                    if(j < 0 || height[i] != height[j] || visited[j] == true) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
            // 그 외 높이 차가 2이상이면
            else{
                return false;
            }
        }

        return answer;
    }

    public static int solution() {
        int answer = 0;
        for(int i=0;i<n;i++) {
            boolean isCan = loadCheck(0,i,0); // x축 증가 하며 경사로 찾기 -> 세로줄
            if(isCan == true) answer += 1;
            isCan = loadCheck(i,0,1); // y축 증가하며 경사로 찾기 -> 가로줄
            if(isCan == true) answer += 1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        map = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int data = sc.nextInt();
                map[i][j] = data;
            }
        }
        int answer = solution();
        System.out.println(answer);

    }
}
