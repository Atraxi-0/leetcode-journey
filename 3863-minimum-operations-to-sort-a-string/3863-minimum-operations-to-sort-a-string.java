class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if(n==1) return 0;
        if(n==2)
            if(s.charAt(0) > s.charAt(1)) 
                return -1;
        boolean flag = true;
        char small = 'z'; char large = 'a';
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch<small) small = ch;
            if(ch>large) large = ch;
            if(i<n-1 && ch > s.charAt(i+1)) flag = false;
        }
        if(flag) return 0;
        if(s.charAt(0)==small || s.charAt(n-1)==large) return 1;
        if(s.charAt(0) == large && s.charAt(n-1)==small) {
            for(int i=1; i<=n-2; i++) {
                if(s.charAt(i)==small ||s.charAt(i) == large) return 2;
            }
            return 3;
        }
        return 2;
    }
}