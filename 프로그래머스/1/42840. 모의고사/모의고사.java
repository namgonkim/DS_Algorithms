import java.util.*;

class Solution {
    // 3명의 수포자 중 누가 많은 문제를 맞췄는지 
    // 1. 수포자 별 문제 맞춘 횟수를 카운팅하는 배열 
    // 2. 수포자가 문제를 찍는 방식 
    public static int[] spA = {1,2,3,4,5};
    public static int[] spB = {2,1,2,3,2,4,2,5};
    public static int[] spC = {3,3,1,1,2,2,4,4,5,5};
    public static int[] solution(int[] answers) {
        int[] spCnt = new int[3];
        Arrays.fill(spCnt, 0);
        int a=0, b=0, c=0;
        // 정답을 완전탐색하면서 
        for(int ans : answers) {
            // 각 수포자 별로 문제를 맞추고 있는지 확인한다.
            if(ans == spA[a]) spCnt[0]++;
            if(ans == spB[b]) spCnt[1]++;
            if(ans == spC[c]) spCnt[2]++;
            // 그 과정에서 수포자가 찍는 방식의 배열 인덱스 위치를 조절할 수 있도록 한다. 
            a++;
            if(a >= spA.length) a=0;
            b++;
            if(b >= spB.length) b=0;
            c++;
            if(c >= spC.length) c=0;
        }
        int max = 0;
        for(int i=0;i<3;i++) {
            max = Math.max(max, spCnt[i]);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<3;i++) {
            if(spCnt[i] == max) result.add(i+1);
        }
        Collections.sort(result);
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}