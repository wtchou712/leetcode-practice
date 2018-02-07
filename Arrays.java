/* Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.

https://leetcode.com/problems/merge-sorted-array
*/
public void merge(int[] nums1, int m, int[] nums2, int n) {
    //process like a zipper from end of arrays
    //pick the largest on whichever array and add to end of nums1
    while(m>0 && n>0){
        if (nums1[m-1] > nums2[n-1]){
            nums1[m+n-1]=nums1[m-1];
            m--;
        }
        else {
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }
    //if m==0, then copy rest of 2nd array to nums1
    //if n==0, then you are done since rest of 1st array already in correct place
    while(n>0){
        nums1[n-1]=nums2[n-1]; 
        n--;
    }
}