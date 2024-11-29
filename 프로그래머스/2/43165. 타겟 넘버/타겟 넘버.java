class Solution {
    public int answer = 0;
    // 배열에 있는 값들을 모두 더하거나 빼서 target을 만들어야 한다.
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int[] numbers, int idx, int value, int target) {
        // dfs 종료 조건 
        if(idx == numbers.length) {
            // 만약 target과 같은 값이라면 answer ++
            if(value == target) {
                answer++;
            }
            return;
        } 
        
        // 더하기
        dfs(numbers, idx+1, value+numbers[idx], target);
        // 빼기
        dfs(numbers, idx+1, value-numbers[idx], target);
    }
}