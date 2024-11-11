import java.util.*;

class Solution {
    public static List<Set<Integer>> answerList = new ArrayList<>();
    public int solution(int N, int number) {
        // answerList : N 숫자를 활용해 N을 사용한 갯수별 나올 수 있는 수들의 모음
        // N의 최대범위까지 초기화
        for(int i=0;i<=8;i++) {
            answerList.add(new HashSet<>());
        }
        // N이 1일때
        answerList.get(1).add(N);

        for(int i=2;i<=8;i++) {
            Set<Integer> now = answerList.get(i);
            for(int j=1;j<i;j++) {
                // 이전에 있던 값에서 +-*/ 사칙연산을 진행해 현재 값에 저장
                Set<Integer> prevSet = answerList.get(j);
                Set<Integer> postSet = answerList.get(i-j); // 2-1, 2-2

                for(int prev : prevSet) {
                    for(int post : postSet) {
                        now.add(prev+post);
                        now.add(prev-post);
                        now.add(prev*post);
                        if(post != 0) {
                            now.add(prev/post);
                        }
                    }
                }
            }
            // 마지막으로 N 끼리 조합할 수 있는 숫자 추가
            // repeat(x) -> x번만큼 String을 중첩하는 메소드
            now.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        // 정답을 찾아 나간다.
        for(Set<Integer> it : answerList) {
            if(it.contains(number)) {
                return answerList.indexOf(it);
            }
        }
        return -1;
    }
}