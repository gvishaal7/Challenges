/*
question link : https://leetcode.com/problems/guess-number-higher-or-lower/description/

application of binary search
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

package com.challenges.leetcode;

public class guessNumber extends GuessGame {
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        while(l<=r) {
            int mid = l + (r - l)/2;
            if(guess(mid)==0) {
                return mid;
            }
            if(guess(mid) == 1) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
