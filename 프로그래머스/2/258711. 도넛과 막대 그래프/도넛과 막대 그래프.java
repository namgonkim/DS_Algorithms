import java.util.*;
class Solution {
    // in: 나한테 들어온 정점 edge 1
    // out: 내가 나간 정점 edge 0
    public static Map<Integer, Integer> in = new HashMap<>();
    public static Map<Integer, Integer> out = new HashMap<>();

        // answer: [생성한 정점의 번호, 정점을 생성하기 전 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수]
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        // 간선에 대한 in,out 필요
        for(int[] edge : edges) {
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
        }
        // 정점 찾기: 내가 나간게 2개 이상인데 나한테 들어온게 없으면
        for(int vertex : out.keySet()) {
            if(out.get(vertex) >= 2) {
                // 이러면 정점
                if(!in.containsKey(vertex)) {
                    answer[0] = vertex;
                }
                // 나간것도 있는데 들어온것도 있다? 8자
                else {
                    answer[3] += 1;
                }
            }
        }
        // 막대: 마지막 정점이 나간게 없으면 막대로 하면 된다
        for(int vertex : in.keySet()) {
            if(!out.containsKey(vertex)) {
                answer[2] += 1;
            }
        }
        // 도넛: 정점의 나가는 간선 갯수 - 막대 - 8자
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}