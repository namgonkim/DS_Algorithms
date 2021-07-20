package kakao.intern2021;

import java.util.LinkedList;
/*
문제: 거리두기 확인하기
유형: bfs
날짜: 2021.07.20 (화)
 */
class Pair2 {
    public int x;
    public int y;
    public int dist;

    public Pair2(int y, int x, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class FalseCode {

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static boolean[][] visited;

    public static void main(String[] args) {
        // [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
        // ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
        // ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
        // ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
        // ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
        // [1, 0, 1, 1, 1]

        String[][] places = {
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},

                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        DistCheck so = new DistCheck();
        int[] answer = so.solution(places);
        for(int item : answer) {
            System.out.print(item + " ");
        }
    }

    public boolean bfs(int y, int x, String[] place) {
        LinkedList<Pair2> q = new LinkedList<>();
        visited[y][x] = true;
        q.offer(new Pair2(y,x,0));

        while(!q.isEmpty()) {
            Pair2 now = q.poll();
            int dist = now.dist;

            if(dist > 2) continue;

            for(int i=0;i<4;i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if((ny >= 0 && ny < 5 && nx >= 0 && nx < 5) && visited[ny][nx] == false) {
                    if(place[ny].charAt(nx) != 'X') {
                        int next = Math.abs(x - nx) + Math.abs(y - ny);
                        if(place[ny].charAt(nx) == 'P' && next <= 2){
                            return true;
                        }
                        q.offer(new Pair2(ny,nx,next));
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        return false;
    }

    public boolean checker(String[] place) {
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if (place[i].charAt(j) == 'P') {
                    boolean res = bfs(i,j,place);
                    if(res == true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // P: 응시자가 앉아있느 자리, O: 빈 테이블 , X: 파티션
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int idx=0;idx<places.length;idx++) {
            String[] place = places[idx];
            visited = new boolean[5][5];
            boolean res = checker(place);
            if(res == true) answer[idx] = 0;
            else answer[idx] = 1;
        }

        return answer;
    }
}