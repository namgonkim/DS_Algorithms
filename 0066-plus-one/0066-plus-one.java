import java.util.*;
class Solution {
    public int[] plusOne(int[] digits) {
        // 뒤에서부터 순회하면서 1 더했을 때 10인지 검사 
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        // 여기까지 왔다는건 모든 값이 0으로 변경되었다는 것 
        digits = new int[n+1];
        Arrays.fill(digits, 0);
        digits[0] = 1;
        return digits;
    }
}