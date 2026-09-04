class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum =0;
        int left =0;
        int min_length = Integer.MAX_VALUE;


        for(int right =0 ; right<n ; right++){
            sum += nums[right];
            while(sum>=target){
                if((right-left+1)<min_length){
                    min_length = right - left + 1;
                }
                sum -= nums[left];
                left++;

            }
        }
        if(min_length == Integer.MAX_VALUE){
            return 0;
        }
        else {
            return min_length;
        }
    }
}