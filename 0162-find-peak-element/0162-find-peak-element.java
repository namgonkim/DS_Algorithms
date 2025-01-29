class Solution {
    // 양 옆의 원소들 보다 큰 원소를 찾는다. 
    // 그냥 가장 큰 수 찾는거 아님? 
    public int findPeakElement(int[] nums) {
        // O(log n) 안에 찾아야 함
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < nums[mid+1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }

        }
        return right;
    }
}