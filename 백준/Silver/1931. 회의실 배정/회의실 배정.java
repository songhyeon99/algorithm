import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, count = 0;
    static List<Schedule> schedules;
    static List<Schedule> setSchedules;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        schedules = new ArrayList<>();
        setSchedules = new ArrayList<>();
        N = sc.nextInt();
        for(int i=0; i<N; i++){
            schedules.add(new Schedule(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(schedules, new Comparator<Schedule>() {
            @Override
            public int compare(Schedule s1, Schedule s2) {
                if(s1.end != s2.end){
                    return s1.end - s2.end;
                }
                return s1.start - s2.start;
            }
        });

        int lastEnd = 0;
        for(Schedule schedule : schedules){
            if(schedule.start >= lastEnd) {
                lastEnd = schedule.end;
                count++;
            }
        }
        System.out.println(count);
    }

    static class Schedule{
        int start, end;

        Schedule(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
