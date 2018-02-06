public int maxSubArray(int[] nums) {
    int currSum = nums[0];
    int maxSum = nums[0];
    for(int i=1;i<nums.length;i++) {
        currSum = max(nums[i],currSum+nums[i]);
        if(currSum > maxSum) {
            maxSum = currSum;
        }    
    }
    return maxSum;
}

public int max(int a,int b) {
    return (a > b ? a : b);
}
