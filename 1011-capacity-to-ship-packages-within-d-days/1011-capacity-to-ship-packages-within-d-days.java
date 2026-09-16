class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low =0 ;
        int high = 0;
        for(int w : weights){
            low = Math.max(low ,w);
            high += w;
        }
        while(low<high){
                int currload =0 ;
            int req_day = 1;
            int mid = low + (high - low) /2;
            for(int w : weights){
                
                if(currload + w > mid){
                    req_day++;
                    currload =0;
                }
                currload += w;
            }
            if(req_day <=days ){
                high = mid;
            }
            else{
                low = mid+ 1;
            }
        }
        
        return low;
    }
}