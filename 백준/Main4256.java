package backjoon;
/*
문제: 트리 (백준 4256)
유형: 트리, 재귀, 분할정복
날짜: 2021.08.03 (화)
 */

import java.util.Scanner;

public class Main4256 {

    public static int t, n; // 테스트 케이스 개수, 노드의 개수
    public static int[] preorder;
    public static int[] inorder;
    public static int[] postorder;

    // 전위와 중위 순회를 이용해 후위 순회를 구하는 프로그램 작성 //
    public void solution(int start, int end, int root) {
        for(int i=start; i<end; i++) {
            if(inorder[i] == preorder[root]) {
                solution(start, i, root+1);
                solution(i+1, end, root+i-start+1);
                System.out.print(preorder[root] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Main4256 main = new Main4256();
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        // test case loop
        for(int i=0;i<t;i++) {
            n = sc.nextInt();
            preorder = new int[n];
            inorder = new int[n];
            postorder = new int[n];
            // preorder case loop
            for(int j=0;j<n;j++) {
                int node = sc.nextInt();
                preorder[j] = node;
            }
            // inorder case loop
            for(int j=0;j<n;j++) {
                int node = sc.nextInt();
                inorder[j] = node;
            }
            // solution
            main.solution(0,n, 0);
            System.out.println();
        }
    }
}
