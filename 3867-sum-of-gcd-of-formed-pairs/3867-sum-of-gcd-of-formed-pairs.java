class Solution {
        int gcd(int x, int y) {
            while(y!=0) {
                int temp = y;
                y = x%y; 
                x = temp;
            }
            return x;
        }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        long sum = 0;

        for (int i=1; i<n; i++) {
            prefix[i] = Math.max(prefix[i-1], nums[i]);
        }
        for(int i=0; i<n; i++) {
            prefix[i] = gcd(nums[i], prefix[i]);
        }
        Arrays.sort(prefix);
        
        int left = 0; int right = n-1;
        while(left<right) {
            sum += gcd(prefix[left++], prefix[right--]);
            
        }
        return sum;
    }
}