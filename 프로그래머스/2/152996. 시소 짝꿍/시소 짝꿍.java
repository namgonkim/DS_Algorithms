import java.util.*;

class Solution {
    public static Map<Double, Integer> map = new HashMap<>();
    // 탑승한 사람의 무게 X 좌석간의 거리가 양쪽 다 같다면 시소 짝궁 
    // 시소는 중심으로부터 2,3,4 거리의 지점에 하나씩 있다. 
    // 무게=w1, w2일때 ex 2*w1=3*w2 인 경우를 찾는 문제 
    public long solution(int[] weights) {
        long answer = 0;
        int n = weights.length;
        // weights 정렬
        Arrays.sort(weights);
        for(int i=0; i<n; i++) {
            // 기존의 map에서 4종류의 거리*무게와 비교하기 위한 변수
            double num1 = (double) weights[i] * 1.0;
            double num2 = (double) (weights[i] * 1.0) / 2.0;
            double num3 = (double) (weights[i] * 2.0) / 3.0;
            double num4 = (double) (weights[i] * 3.0) / 4.0;
            // map에서 확인해있다면 answer 카운트
            if(map.containsKey(num1)) answer = answer + map.get(num1);
            if(map.containsKey(num2)) answer = answer + map.get(num2);
            if(map.containsKey(num3)) answer = answer + map.get(num3);
            if(map.containsKey(num4)) answer = answer + map.get(num4);
            
            // map에 무게 저장 
            map.put(weights[i]*1.0, map.getOrDefault(weights[i]*1.0, 0) + 1);
        }
        
        
        // for(int i=0;i<n;i++) {
        //     for(int j=i+1; j<n;j++) {
        //         // 정렬을 한 상태에서 오른쪽이 더 크기 때문에 곱은 오른쪽을 더 적게 한다.
        //         // 곱을 하는 기준은 1*1, 2*1, 3*2, 4*3으로 확인한다
        //         if(weights[i] == weights[j]) {
        //             answer++;
        //         } else if(2*weights[i] == weights[j]) {
        //             answer++;
        //         } else if(3*weights[i] == 2*weights[j]) {
        //             answer++;
        //         } else if(4*weights[i] == 3*weights[j]) {
        //             answer++;
        //         }
        //     }
        // }
        
        return answer;
    }
}