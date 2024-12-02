import java.util.*;
class Solution {
    // n보다 큰 자연수이면서 n은 2진수로 변환했을 때 1의 갯수가 같다. 
    // n의 다음 큰 숫자는 조건 1,2를 만족하는 수 중 가장 작은 수이다. 
    // 78 = 1001110 -> 4
    // 83 = 1010011 -> 4
    public int solution(int n) {
        int answer = 0;
        int temp = n;
        // n의 2진수 값에서 1 갯수가 같으면서 바로 다음으로 큰 수
        // 15 1111 
        // 23 10111
        // n보다 큰 수를 2진수로 뒤집고 1의 갯수를 세었을 때 같은 숫자가 나오면 종료
        int bins = 0;
        while(n > 0) {
            if(n % 2 != 0) {
                bins++;
            }
            n = n / 2;
        }
        int count = 1;
        while(true) {
            int differ = temp + count;
            int cnt = 0;
            while(differ > 0) {
                if(differ % 2 != 0) cnt++;
                differ /= 2;
            }
            
            if(bins == cnt) {
                answer = temp + count;
                break;
            }
            // System.out.println(cnt);
            count++;
        }
        return answer;
    }
}