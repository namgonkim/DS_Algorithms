import java.util.*;
class Solution {
    public static Map<String, List<Integer>> infoMap = new HashMap<>();

    // query [개발언어 and 직군 and 경력 and 소울푸드 점수]
    // 조건을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇명인가?
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Arrays.fill(answer, 0);
        // 점수를 제외한 info의 문자열을 key로 등록 -> value에 점수 지정
        for(String data : info) {
            String[] s = data.split(" ");
            // info가 포함될 수 있는 모든 key를 만든다
            makeInfoKey(s, "", 0);
        }

        // 각 info의 점수를 정렬
        for(List<Integer> values : infoMap.values()) {
            Collections.sort(values);
        }

        // 쿼리 탐색
        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replace(" and ", "");
            // s[0] = key / s[1] = 평가할 점수 (이 점수보다 높거나 같아야 함)
            String[] s = query[i].split(" ");
            if(infoMap.containsKey(s[0])) {
                List<Integer> values = infoMap.get(s[0]);
                int eval = Integer.parseInt(s[1]);
                // 이분탐색을 통한 접근
                int left = 0;
                int right = values.size() - 1;
                while(left <= right) {
                    int mid = (left + right) / 2;
                    if(values.get(mid) >= eval) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                // 전체 점수 리스트 사이즈에서 평가 점수보다 같거나 큰 점수의 최소 인덱스(left)를 빼면 남은 건 모두 평가 점수보다 이상인 값들
                answer[i] = values.size() - left;
            }
            else answer[i] = 0;
        }
        return answer;
    }

    // 와일드카드를 포함해 모든 info의 key를 재귀적으로 구한다.
    public void makeInfoKey(String[] query, String key, int cnt) {
        // 종료 조건
        if(cnt == 4) {
            // 첫 키일 땐 점수 문자열 생성 후 저장
            if(!infoMap.containsKey(key)) {
                List<Integer> values = new ArrayList<>();
                infoMap.put(key, values);
            }
            infoMap.get(key).add(Integer.parseInt(query[4]));
            return;
        }
        // 와일드카드 또는 일반 항목 별 info 제작
        makeInfoKey(query, key + "-", cnt+1);
        makeInfoKey(query, key + query[cnt], cnt+1);
    }
}