package kakao.blind2018;

import java.util.*;

public class LZWSolution {
    static ArrayList<String> words;

    public static void main(String[] args) {
        LZWSolution so = new LZWSolution();
        // KAKAO	                [11, 1, 27, 15]
        // TOBEORNOTTOBEORTOBEORNOT	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        // ABABABABABABABAB	        [1, 2, 27, 29, 28, 31, 30]
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        int[] answer = so.solution(msg);
        for(int item : answer) {
            System.out.println(item);
        }
    }

    public void buildWords() {
        words.add("0");
        for(int i=0;i<26;i++) {
            String word = "" + (char)('A' + i);
            words.add(word);
        }
    }

    /*
    1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
    2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
    3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
    4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
    5. 단계 2로 돌아간다.
     */
    public int[] solution(String msg) {
        // 사전 생성 및 빌드
        words = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        buildWords();
        // 사전에서 입력한 문자열과 일치하는 가장 긴 문자열 w 찾기
        for(int i=msg.length();i >= 1;i--) {
            String w = msg.substring(0, i);
            int wIdx = -1; boolean findw = false;
            // w와 일치하는 문자열을 탐색
            for(int idx=1;idx<words.size();idx++) {
                if(w.equals(words.get(idx))) {
                    wIdx = idx;
                    findw = true;
                    break;
                }
            }
            // w와 일치하는 문자열을 찾았다면
            if(findw == true) {
                // w에 해당하는 사전의 색인 번호 출력
                result.add(wIdx);
                // 입력에서 w를 제거
                msg = msg.substring(i);
                // 입력에서 처리되지 않은 다음 글자 c가 남아있다면 w+c에 해당하는 단어를 사전에 추가
                if(msg.length() >= 1) {
                    w = w + msg.charAt(0);
                    words.add(w);
                }
                i = msg.length() + 1;
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
