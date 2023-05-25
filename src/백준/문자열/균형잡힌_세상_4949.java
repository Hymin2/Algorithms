package 백준.문자열;

import java.util.*;
import java.io.*;

public class 균형잡힌_세상_4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Stack<Character> stack = new Stack<>();

        while (!(str = br.readLine()).equals(".")){
            int i;
            for(i = 0; i < str.length(); i++){
                char c = str.charAt(i);

                if(c == '(' || c == '[') stack.push(c);
                else if(c == ')'){
                    if(stack.isEmpty()) break;
                    char open = stack.pop();
                    if(open != '(') break;
                } else if(c == ']'){
                    if(stack.isEmpty()) break;
                    char open = stack.pop();
                    if(open != '[') break;
                }
            }

            if(i == str.length() && stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");

            stack.clear();
        }
    }
}
