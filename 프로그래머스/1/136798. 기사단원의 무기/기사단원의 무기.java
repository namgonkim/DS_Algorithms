class Solution {
    public int solution(int number, int limit, int power) {
        int[] arr = new int[number+1];
        // 제곱근으로 시간 단축 
        for(int j=1;j<=number;j++) {
            int yaksuCnt = 0;
            for(int i=1; i*i <= j; i++) {
                if(i*i == j) yaksuCnt++;
                else if(j%i==0) yaksuCnt+=2;
            }
            arr[j] = yaksuCnt;
        }
        int answer = 0;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > limit) {
                answer += power;
            }
            else {
                answer += arr[i];
            }
        }
        
        
        return answer;
    }
}