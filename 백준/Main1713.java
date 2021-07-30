package backjoon;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
문제: 후보 추천하기 (백준1713)
설명: 최종 후보가 누구인지 결정하는 프로그램
유형: 구현
날짜: 2021.07.30 (금)

추천받은 학생의 사진을 사진틀에 게시하고 추천받은 횟수를 표시하는 규칙은 다음과 같다.

1. 학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
2. 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
3. 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고, 그 자리에 새롭게 추천받은 학생의 사진을 게시한다.
    이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
4. 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
5. 사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.
 */

class Memo implements Comparable<Memo>{
    public int idx;
    public int student;
    public int counts;

    public Memo(int idx, int student, int counts) {
        this.idx = idx;
        this.student = student;
        this.counts = counts;
    }

    @Override
    public int compareTo(Memo m1) {
        // 추천 횟수가 같으면 먼저 들어온 순
        if(this.counts == m1.counts) {
            return Integer.compare(this.idx, m1.idx);
        }
        return Integer.compare(this.counts, m1.counts);
    }
}
public class Main1713 {

    public static int n; // 사진틀의 개수
    public static int r; // 전체 학생의 총 추천 회수
    public static int[] records; // 추천받은 학생을 나타내는 번호 배열
    public static int[] dp; // 추천 받은 학생의 추천 횟수를 기록하는 배열

    public void solution() {
        ArrayList<Memo> list = new ArrayList<>(); // 사진틀

        for(int i=0;i<records.length;i++) {
            // 추천 받은 적이 있는 사람일 경우
            if(dp[records[i]] != 0) {
                // 추천 횟수 기록 증가시키기
                dp[records[i]] += 1;
                // 사진틀 내 특정 학생 추천 횟수 증가
                for(int idx=0; idx<list.size(); idx++) {
                    Memo memo = list.get(idx);
                    if(memo.student == records[i]) {
                        list.get(idx).counts += 1;
                        break;
                    }
                }
            }
            // 추천 받은 적이 없는 사람일 경우
            else {
                // 추천 횟수 기록 증가
                dp[records[i]] += 1;
                // 사진틀 최대 제한 갯수 이상일 때
                if(list.size() >= n) {
                    // 정렬을 통해 사진틀에서 제거될 학생을 찾고 기록 초기화 및 사진틀에서 제거
                    Collections.sort(list);
                    dp[list.get(0).student] = 0;
                    list.remove(0);
                }
                // 사진틀에 추가
                list.add(new Memo(i, records[i], 1));
            }
        }

        // 사진틀을 학생 번호 순으로 결과값 가지기
        for(int i=0;i<dp.length;i++) {
            // 사진틀에 있는 경우
            if(dp[i] != 0) {
                System.out.print(i + " ");
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main1713 main = new Main1713();
        n = sc.nextInt();
        r = sc.nextInt();
        records = new int[r];
        dp = new int[r+1];
        for(int i=0;i<records.length;i++) {
            int p = sc.nextInt();
            records[i] = p;
        }
        main.solution();
    }
}
