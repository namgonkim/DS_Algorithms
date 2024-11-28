import java.util.*;
class Solution {
    public static String[] alpha = {"A", "E", "I", "O", "U"};
    public static List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        // 문자를 차례대로 앞글자에 시작하게끔 설정
        for(int i=0;i<5;i++) {
            dfs(1, alpha[i]);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++) {
            if(list.get(i).equals(word)) {
                answer = i+1;
                break;
            }
        }
        return answer;
    }
    // 글자를 만드는 dfs 
    public void dfs(int depth, String resource) {
        // 단어 저장
        list.add(resource);

        if(depth == 5) {
            return;
        }
        // 다음 글자에 올 문자 추가 
        for(int i=0; i<5; i++) {
            dfs(depth+1, resource+alpha[i]);
        }
    }
}