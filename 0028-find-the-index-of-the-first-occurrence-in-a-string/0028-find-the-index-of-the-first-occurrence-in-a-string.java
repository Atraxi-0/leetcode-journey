class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        int index = 0;
        int j,k = 0;
        for (int i=0; i<=haystack.length()-needle.length(); i++) {
            j=i;
            while(haystack.charAt(j)==needle.charAt(k)) {
                if(k == needle.length()-1) return i;
                j++; k++; 
            }
            k=0;
        }
        return -1;
    }
}