package 백준.자료구조;

import java.util.*;
import java.io.*;

public class 괄호_9012 {
    public static void solution() throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_case; i++){
            String bracket = br.readLine();
            char[] stack = new char[51];
            int sp = 0;

            for(int k = 0; k < bracket.length(); k++){
                if(bracket.charAt(k) == '(') stack[sp++] = '(';
                else{
                    if(sp == 0){
                        sp = -1;
                        break;
                    }
                    sp--;
                }
            }
            if(sp == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
