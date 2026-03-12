class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        int[] arr = new int[n];
        for(int i=0; i<n; i++) 
            if(i==0) {
                arr[i] = 0;
            } else if (sorted[i-1]==sorted[i]) {
                arr[i] = arr[i-1];
            } 
            else arr[i] = i;
        for(int i=0; i<n; i++) {
            int index = Arrays.binarySearch(sorted, nums[i]);
            nums[i] = arr[index];
        }
        return nums;
    }
}