package 백준.문자열;

import java.util.*;
import java.io.*;

public class 잃어버린_괄호_1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] strArray = str.split("\\+|-");
        char[] operators = new char[strArray.length - 1];
        int index = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '+' || str.charAt(i) == '-') operators[index++] = str.charAt(i);
        }

        int sum = Integer.parseInt(strArray[0]);

        boolean isMinus = false;
        int minusSum = 0;

        for(int i = 0; i < operators.length; i++){
            if(operators[i] == '-' && !isMinus){
                isMinus = true;
                minusSum += Integer.parseInt(strArray[i + 1]);
            } else if(operators[i] == '-' && isMinus){
                sum -= minusSum;
                minusSum = Integer.parseInt(strArray[i + 1]);
            } else if(operators[i] == '+' && !isMinus){
                sum += Integer.parseInt(strArray[i + 1]);
            } else if(operators[i] == '+' && isMinus){
                minusSum += Integer.parseInt(strArray[i + 1]);
            }
        }
        sum -= minusSum;

        System.out.println(sum);
    }
}
