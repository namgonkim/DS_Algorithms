package backjoon;

import java.util.Scanner;
/*
문제: 플로이드(11404번)
유형: 플로이드-워셜
날짜: 2021.07.22 (목)
 */

public class Main11404 {

    public static int[][] map;
    public static final int INF = (int)1e9;

    public void solution(int n, int m, int[][] map) {
        // floyd algorithms : i->j 가는 거리가 i->k-j 로 가는 거리보다 크면 i->j거리를 i->k->j로 변경
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main11404 main = new Main11404();

        // n : 도시 개수, b : 버스 개수
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 초기화 및 INF로 세팅(자기자신은 0으로 초기화)
        map = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i != j){
                    map[i][j] = INF;
                }
            }
        }

        // 도시에서 도시 가는 비용 입력
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a->b 로 가는 비용 c
            // 버스 정보 중에 a->b 로 가는 같은 버스가 있을 떄, 적은 비용으로 가는 버스 노선을 선택
            map[a][b] = Math.min(map[a][b], c);
        }

        // 알고리즘 수행
        main.solution(n, m, map);

        // 결과 출력
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(map[i][j] == INF){
                    map[i][j] = 0;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
