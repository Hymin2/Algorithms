package 프로그래머스.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 셔틀버스 {
    public static void main(String[] args) throws IOException {
        String answer = solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"});

        System.out.println(answer);
    }

    public static String solution(int n, int t, int m, String[] timetable){
        Arrays.sort(timetable);

        int cnt = 0;
        int departureTime = 60 * 9;
        int lastTime;

        for(String time : timetable){
            int timeInt = timeToInt(time);

            if(timeInt <= departureTime){
                cnt++;

                if(n == 1 && cnt == m) return timeToString(timeInt - 1);
                else if(cnt == m){
                    n--;
                    cnt = 0;
                    departureTime += t;
                }

            } else {
                while(true){
                    n--;
                    if(n == 0) break;
                    departureTime += t;
                    if(timeInt <= departureTime) break;
                }

                if(n == 0) break;
            }
        }

        return timeToString(departureTime);
    }

    public static String timeToString(int time){
        StringBuilder hour = new StringBuilder(String.valueOf(time / 60));
        StringBuilder minute = new StringBuilder(String.valueOf(time % 60));

        if(hour.length() == 1) hour.insert(0, 0);
        if(minute.length() == 1) minute.insert(0, 0);

        return hour + ":" + minute;
    }
    public static int timeToInt(String time){
        String[] hhmm = time.split(":");

        return toInt(hhmm[0]) * 60 + toInt(hhmm[1]);
    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }
}
