class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedList = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);
        for (int[] nextInterval : intervals) {
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                currentInterval = nextInterval;
                mergedList.add(currentInterval);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}