package 백준.그리디;

import java.util.*;
import java.io.*;

public class 회의실_배정_1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Conference[] conferenceArray = new Conference[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            conferenceArray[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(conferenceArray);

        Conference prev = conferenceArray[0];

        int sum = 1;

        for(int i = 1; i < N; i++){
            if(prev.end < conferenceArray[i].end && prev.end <conferenceArray[i].start){
                sum++;
                prev = conferenceArray[i];
            }
        }

        System.out.println(sum);
    }

    static class Conference implements Comparable<Conference>{
        int start;
        int end;

        Conference(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            if(this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }
}
