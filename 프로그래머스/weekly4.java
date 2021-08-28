import java.util.*;

/*
문제 : 직업군 추천하기. 위클리 4주차
유형 : 구현, 탐색
날짜 ; 2021.08.28 토
*/

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        String[] jobs = new String[5];
        int[] scores = new int[5];
        int max_value = 0;
        ArrayList<String> words = new ArrayList<>();
        // 테이블 탐색
        for(int idx=0; idx < table.length; idx++) {
            // [직업, 점수~] 로 분리
            String[] params = table[idx].split(" ");
            jobs[idx] = params[0];
            // 각 직업에 대한 점수 계산
            for(int i=1;i<params.length;i++) {
                for(int j=0;j<languages.length;j++) {
                    // 직업 내 선호 언어 조사
                    if(params[i].equals(languages[j])){
                        // 점수 계산 (언어 선호도 * 직업군 언어 점수)
                        scores[idx] += ( (6-i) * preference[j]);
                        if(max_value < scores[idx]){
                            max_value = scores[idx];
                        }
                    }
                }
            }
        }

        // 같은 최고대 점수의 직업군이 있는지 조사
        for(int i=0;i<scores.length;i++) {
            // 있으면 적립
            if(max_value == scores[i]){
                words.add(jobs[i]);
            }
        }
        // 직업군 사전 순 정렬(오름차순)
        Collections.sort(words);
        // 결과 반환
        answer = words.get(0);
        return answer;
    }
}