//Java Solution

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        
        Arrays.sort(end, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        
        int startP = 0;
        int endP = 0;
        int result = 0;
        
        while (startP < intervals.length) {
            if (start[startP] >= end[endP]) {
                result--;
                endP++;
            }
            result++;
            startP++;
        }
        
        return result;
    }
}