import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+1];
        Arrays.fill(student, 0);
        // 0: 딱 한벌있는 사람 1: 아예 없는사람 2: 여분 가진 사람
        // 교복 잃어버린사람 1
        for(int l : lost) {
            student[l] = 1;
        }
        // 여분 가진 사람 2
        for(int r : reserve) {
            // 잃어버린 사람이면 교복을 빌려줄 여유가 없어 0
            if(student[r] == 1) student[r] = 0;
            else student[r] = 2;
        }
        for(int i=1;i<=n;i++) {
            if(student[i] == 1) {
                if(i-1 >=1 && student[i-1] == 2) {
                    student[i] = 0;
                    student[i-1] = 0;
                }
                else if(i+1 <= n && student[i+1] == 2) {
                    student[i] = 0;
                    student[i+1] = 0;
                }
            }
        }
        for(int i=1;i<=n;i++) {
            if(student[i] != 1) answer += 1;
        }
        return answer;
    }
}