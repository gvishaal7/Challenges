/*
question link : https://leetcode.com/problems/product-of-array-except-self/description/

*/

class product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftArray = new int[length];
        leftArray[0] = 1;
        int[] rightArray = new int[length];
        rightArray[length-1] = 1;
        int[] outputArray = new int[length];
        for(int i=1;i<length;i++) {
            leftArray[i] = leftArray[i-1] * nums[i-1];
        }
        for(int i=length-2;i>=0;i--) {
            rightArray[i] = rightArray[i+1] * nums[i+1];
        }
        for(int i=0;i<length;i++) {
            outputArray[i] = leftArray[i] * rightArray[i];
        }
        return outputArray;
    }
}
