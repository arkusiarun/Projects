package programs;

import java.util.Arrays;
import java.util.Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class MaxMeetings {

    static class Meeting {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int maxMeetings(Meeting[] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting.end));

        int count = 0;
        int lastEndTime = -1;

        for (Meeting meeting : meetings) {
            if (meeting.start > lastEndTime) {
                count++;
                lastEndTime = meeting.end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Meeting[] meetings = {
                new Meeting(1, 2),
                new Meeting(3, 4),
                new Meeting(0, 6),
                new Meeting(5, 7),
                new Meeting(8, 9),
                new Meeting(5, 9)
        };
        System.out.println("Maximum number of meetings: " + maxMeetings(meetings));
    }
}