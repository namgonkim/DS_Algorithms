import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int start = 0;
        int end = 0;
        // want 배열을 길게만들기 
        ArrayList<String> wants = new ArrayList<>();
        for(int i=0;i<want.length;i++){
            // number[i] 갯수만큼 wants에 want[i]를 붙이기
            for(int j=0;j<number[i];j++){
                wants.add(want[i]);
            }
            end += number[i];
        }
        Collections.sort(wants);
        // discount 배열에서 wants 리스트의 길이만큼 조사한다.
        boolean cans = false;
        while(end <= discount.length) {
            // System.out.println("start: " + start + ",end: " + end);
            ArrayList<String> dis = new ArrayList<>();
            for(int i=start; i<end; i++) {
                dis.add(discount[i]);
            }
            Collections.sort(dis);
            boolean isBuy = true;
            for(int i=0;i<dis.size();i++) {
                if(!wants.get(i).equals(dis.get(i))) {
                    isBuy = false;
                    break;
                }
            }
            // 구매 가능하면 
            if(isBuy) {
                // System.out.println("buy!");
                answer++;
            }
            start++;
            end++;
        }
        return answer;
    }
}