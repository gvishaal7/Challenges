/*
question link : https://leetcode.com/problems/increasing-triplet-subsequence/description/

*/

class increasing_triplet_subsequence {
    public boolean increasingTriplet(int[] nums) {
        boolean output = false;
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;
        if(nums.length >2) {
            for(int i=0;i<nums.length;i++) {
                if(nums[i] < one) {
                    one = nums[i];
                }
                if(nums[i] < two && nums[i] > one) {
                    two = nums[i];
                }
                if(nums[i] < three && nums[i] > two) {
                    three = nums[i];
                }
            }
            if(one < two && two < three && one!=Integer.MAX_VALUE && two!=Integer.MAX_VALUE && three != Integer.MAX_VALUE) {
                output = true;
            }
        }
        return output;
    }
}
