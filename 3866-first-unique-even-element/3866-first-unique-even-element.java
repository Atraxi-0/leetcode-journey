class Solution {
    public int firstUniqueEven(int[] nums) {
        int[] count = new int[100];
        for (int i : nums){
            count[i-1]++;
        }
        for (int i=0; i<nums.length; i++) {
            if(count[nums[i]-1] == 1 && nums[i]%2==0) return nums[i];
        }
        return -1;
    }
}