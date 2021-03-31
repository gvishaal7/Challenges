/*
 * question: https://leetcode.com/problems/first-bad-version/
 */

package com.challenges.leetcode;

public class First_Bad_Version extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0;
        int r = n;
        int mid = l +((r-l)/2);
        while(l != r) {
            mid = l +((r-l)/2);
            if(isBadVersion(mid)) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        } 
        if(l != n && isBadVersion(l)) return l;
        else return mid + 1;
    }
}
