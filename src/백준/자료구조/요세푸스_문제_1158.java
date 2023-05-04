package 백준.자료구조;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 요세푸스_문제_1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = IntStream.rangeClosed(1, NK[0]).boxed().collect(Collectors.toList());
        int[] queue = new int[NK[0]];
        int front = 0, rear = 0, index = -1;

        while(rear != NK[0]){
            index = (index + NK[1]) % list.size();

            queue[rear++] = list.get(index);
            list.remove(index--);
        }

        System.out.print("<");
        for(int i = 0; i < NK[0]; i++){
            if(i == NK[0] - 1) System.out.print(queue[i] + ">");
            else System.out.print(queue[i] + ", ");
        }
    }
}
