package 백준.자료구조;

import java.util.*;
import java.io.*;

public class 스택_10828 {
    static int[] stack = new int[10001];
    static int sp = 0;

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int command_num = Integer.parseInt(br.readLine());

        for(int i = 0; i < command_num; i++){
            String command = br.readLine();

            if(command.contains("push")){
                String[] str = command.split(" ");
                push(Integer.parseInt(str[1]));
            }else if(command.equals("pop")){
                System.out.println(pop());
            }else if(command.equals("size")){
                System.out.println(size());
            }else if(command.equals("empty")){
                System.out.println(empty());
            }else if(command.equals("top")){
                System.out.println(top());
            }
        }
    }

    public static void push(int data){
        stack[sp++] = data;
    }

    public static int pop(){
        return empty() == 1 ? -1 : stack[--sp];
    }

    public static int size(){
        return sp;
    }

    public static int top(){
        return empty() == 1 ? -1 : stack[sp - 1];
    }

    public static int empty(){
        return sp == 0 ? 1 : 0;
    }
}
