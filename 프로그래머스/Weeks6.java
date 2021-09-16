package programmers.weekly;

import java.util.*;

/*
문제: 위클리 6주차 - 복서 정렬하기
유형: 정렬, 클래스
날짜: 2021 09 16 (목)
 */

class Boxer implements Comparable<Boxer> {
    double rate;
    int count;
    int weight;
    int number;

    public Boxer(double rate, int count, int weight, int number) {
        this.rate = rate;
        this.count = count;
        this.weight = weight;
        this.number = number;
    }

    @Override
    public int compareTo(Boxer b1) {
        if(b1.rate == this.rate && b1.count == this.count && b1.weight == this.weight) {
            return this.number - b1.number;
        }
        if(b1.rate == this.rate && b1.count == this.count) {
            return b1.weight - this.weight;
        }
        if(b1.rate == this.rate) {
            return b1.count - this.count;
        }
        // 수정: double 비교에 관한 문제, 0.1과 0.2 비교시 0과 0비교로 되니 차라리 비교 후 1과 -1을 리턴
        return b1.rate - this.rate > 0 ? 1: -1;
    }
}

public class Weeks6 {
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        ArrayList<Boxer> list = new ArrayList<>();
        for(int i = 0;i < head2head.length; i++) {
            int cnt = 0;
            int bigCnt = 0;
            int nCnt = 0;
            for(int j=0;j< head2head[i].length();j++) {
                // 이긴 횟수 파악
                if(head2head[i].charAt(j) == 'W') {
                    cnt += 1;
                    // 이긴 사람 중에서 자기보다 무거운 경우도 파악
                    if(weights[i] < weights[j]){
                        bigCnt += 1;
                    }
                }
                else if(head2head[i].charAt(j) == 'N') {
                    nCnt += 1;
                }
            }
            // 수정: 0 / 0 div by zero 로 인한 NaN값 저장
            double rate = 0.00;
            if (cnt == 0 || head2head[i].length() - nCnt <= 0){
                rate = 0.00;
            }
            else
                rate = (double) cnt / (double) (head2head[i].length() - nCnt);
            rate *= 100;
            list.add(new Boxer(rate, bigCnt, weights[i], i+1));
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i).number;
        }
        return answer;
    }

    /*
    N L W L
    W N L L
    L W N W
    W W L N
     */
    public static void main(String[] args) {
        int[] weights = {60, 70, 60};
        String[] head2head = {"NNN", "NNN", "NNN"};
        Weeks6 so = new Weeks6();
        int[] result = so.solution(weights, head2head);
        for(int i : result)
            System.out.println(i);
    }
}
