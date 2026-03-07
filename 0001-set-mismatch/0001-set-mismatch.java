class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        int[] result = new int[2];
        for(int num : nums) {
            arr[num-1] *= 2;
        }
        for(int i=0; i<arr.length; i++) {
            if (arr[i]==1) result[1] = i+1;
            if (arr[i]==4) result[0] = i+1;
        }
        return result;
    }
}