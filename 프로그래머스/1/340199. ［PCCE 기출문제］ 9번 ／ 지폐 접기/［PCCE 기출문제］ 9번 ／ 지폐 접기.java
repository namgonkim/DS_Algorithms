class Solution {
    public int solution(int[] wallet, int[] bill) {
        // 지폐를 접은 횟수를 저장할 변수 
        int answer = 0;
        while(true) {
            int billMin = Math.min(bill[0], bill[1]);
            int walletMin = Math.min(wallet[0], wallet[1]);
            int billMax = Math.max(bill[0], bill[1]);
            int walletMax = Math.max(wallet[0], wallet[1]);
            // 빌의 작은 값이 월렛의 작은값보다 작거나 같거나, 빌의 큰 값이 월렛의 큰 값도가 작거나 같으면 종료
            if(billMin <= walletMin && billMax <= walletMax) {
                break;
            }
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
}