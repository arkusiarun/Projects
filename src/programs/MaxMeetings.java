package programs;

import java.util.Arrays;
import java.util.Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class MaxMeetings {

    // A class to store start and end times of meetings
    static class Meeting {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Function to find the maximum number of meetings that can happen in the boardroom
    public static int maxMeetings(Meeting[] meetings) {
        // Sort meetings by their end time
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting.end));

        int count = 0;
        int lastEndTime = -1;

        // Iterate through the meetings
        for (Meeting meeting : meetings) {
            // If the meeting starts after the last selected meeting ends
            if (meeting.start > lastEndTime) {
                count++;  // select this meeting
                lastEndTime = meeting.end;  // update the end time of the last selected meeting
            }
        }

        return count;  // return the maximum number of meetings
    }

    public static void main(String[] args) {
        // Example: Meetings with start and end times
        Meeting[] meetings = {
                new Meeting(1, 2),
                new Meeting(3, 4),
                new Meeting(0, 6),
                new Meeting(5, 7),
                new Meeting(8, 9),
                new Meeting(5, 9)
        };

        // Find and print the maximum number of meetings
        System.out.println("Maximum number of meetings: " + maxMeetings(meetings));
    }
}