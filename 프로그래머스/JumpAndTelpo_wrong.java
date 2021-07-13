package programmers.summerwinter;

import java.util.*;

class Pair {
    private int dist;
    private int cost;

    public Pair(int dist, int cost) {
        this.dist = dist;
        this.cost = cost;
    }

    public int first() {
        return dist;
    }
    public int second() {
        return cost;
    }
}

class Solution1 {
    public static void main(String[] args) {
        //N	result
        //5	2
        //6	2
        //5000	5
        Solution1 so = new Solution1();
        System.out.println(so.solution(5000));
    }

    public ArrayList<Integer> bfs(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(0, 0));
        while(!q.isEmpty()) {
            Pair now = q.poll();

            int dist = now.first();
            int cost = now.second();

            if(dist == n) {
                result.add(cost);
            }
            if(dist * 2 <= n && dist != 0) {
                q.add(new Pair(dist*2, cost));
            }
            if(dist + 1 <= n) {
                q.add(new Pair(dist+1, cost+1));
            }

        }
        Collections.sort(result);
        return result;
    }

    public int solution(int n) {
        int ans = 0;
        ArrayList<Integer> list = bfs(n);
        return list.get(0);
    }
}