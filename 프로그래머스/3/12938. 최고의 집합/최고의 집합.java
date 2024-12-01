import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n > s) {
            return new int[]{-1};
        }
        // 2, 9  -> 9/2 = 4(몫) + 1 나머지
        // 4, 15 -> 15/4 = 3(몫) + 3(나머지)
        // 1. s를 n으로 나눈 몫에 대해 배열에 전부 저장한다.
        int a = s / n;
        int b = s % n;
        for(int i=0;i<n;i++) {
            answer[i] = a;
        }
        // 2. 나머지 값을 1씩 빼며 배열의 위부터 채운다.
        for(int i=n-1;i>=0;i--) {
            if(b == 0) {
                break;
            }
            b--;
            answer[i] = answer[i] + 1;
        }
        
        return answer;
    }
}

// s=9, n=2 -> [a,b]의 합=9, 
// s=9, n=3 -> [a,b,c]의 합=9

// 1,2,6] [1,3,5] ...