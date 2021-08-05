package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
문제: 트리 (백준 1068)
유형: 트리, bfs
날짜: 2021.08.05 (목)

입력으로 주어진 트리에서 주어진 노드를 지웠을 때, 리프 노드의 개수를 구하라
 */

public class Main1068 {

    public static int n; // 트리 노드의 개수
    public static int[] parents; // 0번 부터 n-1번 노드까지 각 노드의 부모가 담긴 배열
    public static int del; // 지울 노드의 번호
    public static int counts = 0;


    // -1은 루트 노드를 의미
    public static int solution(int root) {
        int answer = 0;
        // root노드를 지운다면 0을 바로 리턴
        if(del == root) return 0;
        // 해당 노드부터 자식노드 제거(제거는 -2로 변환)
        Queue<Integer> q = new LinkedList<>();
        parents[del] = -2;
        q.add(del);
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i=0;i<n;i++) {
                if(parents[i] != -2 && parents[i] == node) {
                    parents[i] = -2;
                    q.add(i);
                }
            }
        }
        // 리프 노드 탐색
        q.add(root);
        while(!q.isEmpty()) {
            int node = q.poll();
            int flag = 0;
            for(int i=0;i<n;i++) {
                if(parents[i] != -2){
                    if(node == parents[i]) {
                        q.add(i);
                        flag = 1;
                    }
                }
            }
            if(flag == 0) {
                counts += 1;
            }
        }

        answer = counts;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        parents = new int[n];
        int root = 0;
        for(int i=0;i<n;i++) {
            int node = sc.nextInt();
            parents[i] = node;
            if(node == -1) root = i;
        }
        del = sc.nextInt();

        int answer = solution(root);
        System.out.println(answer);
    }
}
