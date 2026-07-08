class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long MOD = 1_000_000_007;
        
        long[] P = new long[n + 1];
        long[] sum = new long[n + 1];
        int[] count = new int[n + 1];
        long[] p10 = new long[n + 1];
        
        p10[0] = 1;
        
        for (int i = 0; i < n; i++) {
            p10[i + 1] = (p10[i] * 10) % MOD;
            int digit = s.charAt(i) - '0';
            
            if (digit != 0) {
                P[i + 1] = (P[i] * 10 + digit) % MOD;
                sum[i + 1] = sum[i] + digit;
                count[i + 1] = count[i] + 1;
            } else {
                P[i + 1] = P[i];
                sum[i + 1] = sum[i];
                count[i + 1] = count[i];
            }
        }
        
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];
            
            int C = count[R + 1] - count[L];
            long leftPrefix = (P[L] * p10[C]) % MOD;
            long valX = (P[R + 1] - leftPrefix + MOD) % MOD;
            long valSum = sum[R + 1] - sum[L];
            
            result[i] = (int) ((valX * valSum) % MOD);
        }
        
        return result;
    }
}