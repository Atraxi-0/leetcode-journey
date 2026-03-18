class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        if(heights.length == 0 ) return new int[]{0};
        Deque<Integer> stack = new ArrayDeque<>();
        int arr[] = new int[heights.length];
        arr[heights.length-1] = 0;
        stack.offerFirst(heights[heights.length-1]);
        for(int i=heights.length-2; i>=0; i--) {
            while(!stack.isEmpty() && heights[i]>stack.peek()) {
                stack.pop();
                arr[i]++;
            }
            if (!stack.isEmpty()) arr[i]++;
            stack.offerFirst(heights[i]);
        }
        return arr;
    }
}