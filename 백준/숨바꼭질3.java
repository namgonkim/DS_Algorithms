import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
문제: 숨바꼭질3(백준)
설명: 수빈이와 동생의 위치가 n,k로 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하라
유형: DFS/BFS
날짜: 2021.07.05 (월)
 */
class Pair {
    private int x;
    private int time;

    public Pair(int x, int time) {
        this.x = x;
        this.time = time;
    }

    public int first() {
        return this.x;
    }
    public int second() {
        return this.time;
    }
}

public class Main {

    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        // n = 수빈이의 위치, k = 동생의 위치
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(main.solution(n,k));
    }

    public int bfs(int n, int k) {
        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(n,0);
        q.add(pair);
        visited[n] = true;
        while(!q.isEmpty()){
            Pair tops = q.poll();
            int x = tops.first();
            int now = tops.second();

            if(x == k){
                return now;
            }


            if(x*2 >= 0 && x*2 <= 100000 && visited[x*2] == false){
                // 0초 후 x*2로 이동
                visited[x*2] = true;
                q.add(new Pair(x*2,now));
            }
            // 1초 후 x-1 또는 x+1로 이동
            if(x-1 >=0 && x-1 <= 100000 && visited[x-1] == false) {
                visited[x-1] = true;
                q.add(new Pair(x - 1, now + 1));
            }
            if(x+1 >=0 && x+1 <= 100000 && visited[x+1] == false) {
                visited[x+1] = true;
                q.add(new Pair(x + 1, now + 1));
            }
        }
        return 0;
    }
    public int solution(int n, int k) {
        int answer = 0;

        answer = bfs(n, k);

        return answer;
    }
}
