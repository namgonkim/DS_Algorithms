package programmers.example;

import java.util.Arrays;

/*
문제: 땅따먹기
유형: 그리디, DP
날짜: 2021.06.29
실패: 탐색을 활용해서 그리디 식으로 문제를 풀려고 했는데, 테스트 케이스에서 모두 틀렸음
시간 초과의 이유도 있고 반례 케이스도 있음.
따라서 현재 상황에서 최대한을 만족하는 그리디로 문제를 풀면 틀린 것.
DP를 이용해 문제를 풀어야 한다.
 */
public class LandGet {

    public static void main(String[] args) {
        // [[1,2,3,5],[5,6,7,8],[4,3,2,1]]	16
        int[][] land = {
                {1,2,3,5},
                {5,6,7,8},
                {4,3,2,1}
        };
        int answer = solution(land);
        System.out.println(answer);

    }
    static int solution(int[][] land) {
        int answer = 0;
        // 각 행의 열마다 이전까지의 최대 값을 찾아 더해나간다.
        // i번째 행의 값들에 i-1번째 행의 값들 중 최대값을 찾는다.
        for(int i=1;i<land.length;i++){
            // land[i][0] = max(land[i-1][1], max(land[i-1][2],land[i-1][3]));
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][2]));
        }

        // 마지막 줄에는 최대 값이 저장되어 있다.
        int[] res = land[land.length-1];
        // 정렬 및 최대값 뽑기
        Arrays.sort(res);
        answer = res[res.length-1];
        return answer;
    }
}