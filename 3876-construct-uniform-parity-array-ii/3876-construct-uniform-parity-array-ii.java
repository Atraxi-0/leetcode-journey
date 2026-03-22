class Solution {
    public boolean uniformArray(int[] nums1) {
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        int even = 0;
        for(int i=0; i<nums1.length; i++) {
            if(nums1[i]%2==0 ){
                even++;
                if(nums1[i]<minEven) minEven = nums1[i];  
            } 
            else if (nums1[i]%2!=0 && nums1[i]<minOdd) minOdd = nums1[i];
        }
        if (even!=0 && even!= nums1.length && minEven < minOdd) return false; 
        return true;
    }
}