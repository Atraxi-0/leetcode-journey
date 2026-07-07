class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        String num = String.valueOf(n);
        for (int i=0; i<num.length(); i++) {
            if( num.charAt(i) != '0') {
                x= x*10 + (long)num.charAt(i)-'0';       
                sum += (long)num.charAt(i)-'0';
            }
        }
        return x * sum;
    }
}