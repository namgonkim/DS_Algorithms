import java.util.*;

class Solution {
    public static String START = "ICN";
    public static List<String> airline;
    public static boolean[] visited;

    public void dfs(String now, String path, String[][] tickets, int cnt) {
        if(cnt == tickets.length) {
            // 항공 노선이 정해진 path를 넣고 종료
            airline.add(path);
            return;
        }

        for(int i=0;i<tickets.length;i++) {
            // 출발편이 now와 같으면서 도착점을 방문하지 않았을 때
            if(!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                String next = tickets[i][1];
                dfs(next, path + "," + next, tickets, cnt+1);
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        airline = new ArrayList<>();
        visited = new boolean[tickets.length];
        Arrays.fill(visited, false);
        dfs(START, START, tickets, 0);

        // airline에 수많은 항공기 노선들이 있음, 알파벳 순 오름차순 정렬
        Collections.sort(airline);
        String[] result = airline.get(0).split(",");
        return result;
    }
}