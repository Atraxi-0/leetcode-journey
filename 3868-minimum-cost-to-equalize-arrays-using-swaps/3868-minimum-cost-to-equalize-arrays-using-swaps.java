class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0; i<nums1.length; i++) {
            if(map1.containsKey(nums1[i])) {
                int temp = map1.get(nums1[i]);
                map1.put(nums1[i], temp+1);
            } else {
                map1.put(nums1[i], 1);
            }
            if(map2.containsKey(nums2[i])) {
                int temp = map2.get(nums2[i]);
                map2.put(nums2[i], temp+1);
            } else {
                map2.put(nums2[i], 1);
            }
        }
        int swapA = 0, swapB = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            Integer value1 = entry.getValue();
            Integer value2 = map2.containsKey(key) ? map2.get(key) : 0;
            if((value1 + value2) % 2 != 0) return -1;
            int diff = (value1 - value2);
            if(diff > 0) swapA += diff/2;
        }
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            Integer key = entry.getKey();
            Integer value1 = entry.getValue();
            Integer value2 = map1.containsKey(key) ? map1.get(key) : 0;
            if((value1 + value2) % 2 != 0) return -1;
            int diff = (value1 - value2);
            if(diff > 0) swapB += diff/2;
        }
        if (swapA == swapB) return swapA;
        else return -1;
    }
}