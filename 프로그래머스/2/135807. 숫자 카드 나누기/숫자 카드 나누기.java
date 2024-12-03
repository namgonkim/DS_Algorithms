import java.util.*;
class Solution {
    // A의 최대 공약수가 B의 모든 원소와 나누어 떨어지지 않는다 or
    // B의 최대 공약수가 A의 모든 원소와 나누어 떨어지지 않는다
    public int solution(int[] arrayA, int[] arrayB) {
        // 각 배열 별 최대 공약수
        int a = gcdArr(arrayA);
        int b = gcdArr(arrayB);
        
        // a 최대 공약수가 배열 B 원소들 모두 나누어 떨어지지 않아야 함
        boolean flagA = false;
        if(a != 1) {
            flagA = Arrays.stream(arrayB).allMatch(i -> i % a != 0);
        }
        // b 가 A 원소들 모두 나누어 떨어지지 않아야 함
        boolean flagB = false;
        if(b != 1) {
            flagB = Arrays.stream(arrayA).allMatch(i -> i % b != 0);
        }
        
        int answer = 0;
        // 둘 다 만족했을 때는 더 큰수 구하면 된다
        if(flagA && flagB) answer = Math.max(a,b);
        else if(flagA) answer = a;
        else if(flagB) answer = b;
        return answer;
    }
    
    // 배열을 받아서 배열 내 모든 원소의 최대공약수를 구한다.
    public int gcdArr(int[] arr) {
        int res = arr[0];
        for(int i=1;i<arr.length;i++) {
            res = gcd(res, arr[i]);
            if(res == 1) {
                break;
            }
        }
        return res;
    }
    
    public int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}