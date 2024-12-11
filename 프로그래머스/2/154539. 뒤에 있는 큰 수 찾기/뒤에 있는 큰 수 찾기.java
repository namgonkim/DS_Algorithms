import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        int idx = numbers.length - 1;
        answer[idx--] = -1;
        // 뒤에서부터 진행해서 뒷 번호가 더 크면 스택에 저장 
        for(int i=numbers.length-2;i>=0;i--) {
            // 내 숫자보다 뒤의 숫자가 더 크면 
            if(numbers[i] < numbers[i+1]) {
                answer[idx--] = numbers[i+1];
                stack.push(numbers[i+1]);
                continue;
            }
            else {
                // 작거나 같으면 기존의 스택에서 꺼내 쓴다.
                boolean isBigger = false;
                while(!stack.isEmpty()) {
                    int now = stack.peek();
                    if(now > numbers[i]) {
                        answer[idx--] = now;
                        isBigger = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                // 다 끝나고도 큰수 못찾았으면 -1 
                if(!isBigger) {
                    answer[idx--] = -1;
                }
            }
        }
        return answer;
    }
}