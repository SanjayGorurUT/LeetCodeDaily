import java.util.*;

class CountNonMeetingDays {
    /**
     * This method counts the number of days without meetings given a total number of days
     * and a list of meeting intervals.
     *
     * @param days The total number of days.
     * @param meetings A 2D array where each sub-array represents a meeting interval [start, end].
     * @return The number of days without meetings.
     */
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0])); // sort by start time
        List<List<Integer>> exactIntervals = new ArrayList<>();
        int intervalIdx = 0;
        for(int[] interval: meetings) {
            int intervalStart = interval[0];
            int intervalEnd = interval[1];
            if(intervalIdx == 0) {
                // First meeting interval
                List<Integer> firstInterval = new ArrayList<>();
                firstInterval.add(intervalStart);
                firstInterval.add(intervalEnd);
                exactIntervals.add(firstInterval);
                intervalIdx++;
            } else {
                List<Integer> cmpInterval = exactIntervals.get(intervalIdx - 1);
                int endTime = cmpInterval.get(1);
                if(intervalStart > endTime) {
                    // Intervals do not overlap
                    List<Integer> nextInterval = new ArrayList<>();
                    nextInterval.add(intervalStart);
                    nextInterval.add(intervalEnd);
                    exactIntervals.add(nextInterval);
                    intervalIdx++;
                } else if(interval[1] > endTime) {
                    cmpInterval.set(1, intervalEnd); // extend the last interval
                }
            }
        }
        int daysWithoutMeetings = 0;
        int exactIntervalsSize = exactIntervals.size();
        for(int i = 0; i < exactIntervalsSize; i++) {
            int intervalStartTime = exactIntervals.get(i).get(0);
            if(i == 0) {
                daysWithoutMeetings += intervalStartTime - 1; // first meeting
            } else {
                int previousIntervalEndTime = exactIntervals.get(i - 1).get(1);
                daysWithoutMeetings += intervalStartTime - 
                    previousIntervalEndTime - 1; // gap between meetings
            }
        }
        daysWithoutMeetings += days - exactIntervals.get(exactIntervalsSize - 1).get(1); // last meeting
        return daysWithoutMeetings;
    }

    public static void main(String[] args) {
        CountNonMeetingDays countNonMeetingDays = new CountNonMeetingDays();
        int[][] meetings = {{2, 3}, {3, 5}, {8, 8}};
        System.out.println(countNonMeetingDays.countDays(8, meetings)); // Expected Output: 3
    }
}