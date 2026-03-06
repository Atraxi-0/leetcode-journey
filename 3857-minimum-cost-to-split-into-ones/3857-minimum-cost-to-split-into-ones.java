class Solution {
    public int minCost(int n) {
        int a, b = 0;
        a = n/2; b = n-a;
        if (a==0 || b==0) return 0;
        if (a == 1 && b == 1) return 1;
        return a*b + minCost(a) + minCost(b);
    }
}