class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        
        for (int[] interval : intervals) {
            // Get the end of last interval in merged list
            int currentEnd = currentInterval[1];
            
            // If current interval overlaps with the last interval in merged list
            if (interval[0] <= currentEnd) {
                // Update the end of current interval if necessary
                currentInterval[1] = Math.max(currentEnd, interval[1]);
            } else {
                // No overlap, add new interval to merged list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}