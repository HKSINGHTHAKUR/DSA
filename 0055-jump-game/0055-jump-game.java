class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int steps = 0;

        for(int i =0 ; i<n ;i++){

            if( i > steps){
                return false;
            }
            steps = Math.max(steps , i+ nums[i]);
            if(steps == n-1){
                return true;
            }
        }
        return true;
        
    }
}