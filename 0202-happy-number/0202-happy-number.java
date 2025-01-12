import java.util.*;

class Solution {
    // happy가 아니면 값이 반복된다는 사실을 알아내야 함ㅠㅠ 
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            n = getSquareDigits(n);
            if(n == 1) {
                return true;
            }
        }
        return false;
    }

    public int getSquareDigits(int num) {
        int result = 0;
        while(num > 0) {
            int rem = num % 10;
            result += rem * rem;
            num /= 10;
        }
        return result;
    }
}