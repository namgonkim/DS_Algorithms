import java.util.*;
class Solution {
    public static boolean[] visited;
    static class Node {
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            // 노드의 문자가 타겟과 같다면 종료
            if(now.word.equals(target)) {
                return now.count;
            }

            for(int i = 0; i < words.length; i++) {
                String word = words[i];
                int cnt = 0;
                for(int j = 0; j < word.length(); j++) {
                    if(word.charAt(j) != now.word.charAt(j)) {
                        cnt++;
                    }
                }
                // 단어 변환이 가능하면서 방문하지 않은 단어면 큐에 저장 
                if(cnt == 1 && !visited[i]) {
                    visited[i] = true;
                    Node next = new Node(words[i], now.count+1);
                    q.offer(next);
                    
                }
            }
        }
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        Arrays.fill(visited, false);
        int answer = bfs(begin, target, words);
        return answer;
    }
}