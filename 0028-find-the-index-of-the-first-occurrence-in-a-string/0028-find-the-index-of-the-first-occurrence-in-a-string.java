class Solution {
    public int strStr(String haystack, String needle) {
        int m,n =  haystack.length(),needle.length();
        if(m<n) return -1;
        int index = 0;
        int j,k = 0;
        for (int i=0; i<=m-n; i++) {
            j=i;
            while(haystack.charAt(j)==needle.charAt(k)) {
                if(k == n-1) return i;
                j++; k++; 
            }
            k=0;
        }
        return -1;
    }
}