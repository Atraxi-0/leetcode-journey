class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        Boolean[] result = new Boolean[candies.length];
        int max = Integer.MIN_VALUE;
        for(int i : candies) {
            max = Math.max(max, i);
        }
        for(int i=0; i<candies.length; i++) {
            result[i] = candies[i]+extraCandies>=max ? true : false;
        }
        return Arrays.asList(result);
    }
}