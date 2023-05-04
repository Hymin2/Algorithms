package 백준.자료구조;

import java.util.*;
import java.io.*;

public class 큐_10845 {
    static int[] queue;
    static int front = 0, rear = 0;
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        queue = new int[N];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(str.contains("push")){
                String[] strings = str.split(" ");
                push(Integer.parseInt(strings[1]));
            }else if(str.equals("pop")){
                sb.append(pop() + "\n");
            }else if(str.equals("size")){
                sb.append(size() + "\n");
            }else if(str.equals("empty")){
                sb.append(empty() + "\n");
            }else if(str.equals("front")){
                sb.append(front() + "\n");
            }else if(str.equals("back")){
                sb.append(back() + "\n");
            }
        }

        System.out.println(sb);
    }

    public static void push(int data){
        queue[rear++] = data;
    }

    public static int pop(){
        return empty() == 1 ? -1 : queue[front++];
    }

    public static int size(){
        return rear - front;
    }

    public static int empty(){
        return rear == front ? 1 : 0;
    }

    public static int front(){
        return empty() == 1 ? -1 : queue[front];
    }

    public static int back(){
        return empty() == 1 ? -1 : queue[rear - 1];
    }
}
