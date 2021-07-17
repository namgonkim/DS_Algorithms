package unionfind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    public int nodeA;
    public int nodeB;
    public int cost;

    public Edge(int nodeA, int nodeB, int cost) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.cost = cost;
    }

    // 비용 순 오름차순
    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.cost, edge.cost);
    }
}

public class Kruskal {

    public static int v,e; // 노드 개수 v, 간선 개수 e
    public static int[] parent; // 부모 테이블
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    // 특정 원소가 속한 집합 찾기
    public static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블 생성 및 자기 자신으로 초기화
        parent = new int[v+1];
        for(int i=1;i<=v;i++){
            parent[i]=i;
        }
        // 간선에 대한 정보 입력받기
        for(int i=0;i<e;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a,b,c)); // a-b 의 비용 c

        }
        // 간선을 비용 순으로 정렬
        Collections.sort(edges);

        // 간선을 하나씩 확인
        for(Edge item : edges) {
            int a = item.nodeA;
            int b = item.nodeB;
            int cost = item.cost;
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if(findParent(a) != findParent(b)) {
                unionParent(a, b);
                // 최소 신장 트리 합
                result += cost;
            }
        }

        System.out.println(result);
    }

}
