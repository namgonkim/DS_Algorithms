package programmers.example;
/*
문제: 두 배열의 원소끼리 곱한 값을 더한 값이 최소값이 되도록 하기
유형: 정렬
날짜: 2021.06.28 (월)
 */

import java.util.Arrays;
import java.util.Collections;

public class LeastValue {
    public static void main(String[] args) {

    }
    public static int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] arrB = new Integer[B.length];
        for(int i=0;i<B.length;i++){
            arrB[i] = B[i];
        }
        // A는 오름차순, B는 내림차순
        Arrays.sort(A);
        Arrays.sort(arrB, Collections.reverseOrder());

        // 배열 순회하며 곱셈 후 덧셈 진행
        for(int i=0;i<A.length;i++){
            answer = answer + (A[i] * arrB[i]);
        }

        return answer;
    }
}
