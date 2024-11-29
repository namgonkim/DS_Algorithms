class Solution {
    // 주어진 배열의 데이터 내에서 타겟 값의 인덱스를 리턴하는데, 타겟 값이 배열에 없다면 배열 안에 들어가야 할 곳에 넣는다.
    // 배열의 길이는 1만이며 이분탐색을 통해 O(logN)으로 찾도록 한다.
    public int searchInsert(int[] nums, int target) {
        int answer = nums.length;
        int left = 0;
        int right = answer-1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            // 타겟보다 작다면 
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            // 타겟보다 크다면 
            else {
                right = mid - 1;
            }
        }
        // 값을 못찾았다면 left
        return left;
    }
}