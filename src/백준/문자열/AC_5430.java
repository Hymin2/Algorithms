package 백준.문자열;

import java.util.*;
import java.io.*;

public class AC_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder[] result = new StringBuilder[testCase];

        for(int i = 0; i < testCase; i++){
            String command = br.readLine();
            int arrNum = Integer.parseInt(br.readLine());
            int[] arr = new int[arrNum];


            StringBuilder sb = new StringBuilder(br.readLine());
            sb = sb.deleteCharAt(sb.length() - 1).deleteCharAt(0);

            StringTokenizer st = new StringTokenizer(sb.toString(), ",");

            for(int k = 0; k < arrNum; k++)
                arr[k] = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = arrNum - 1;
            boolean isReverse = false;
            result[i] = new StringBuilder();

            int j;
            for(j = 0; j < command.length(); j++){
                if(command.charAt(j) == 'R') isReverse = !isReverse;
                else if(isReverse) end--;
                else start++;

                if(end + 2 == start){
                    result[i].append("error");
                    break;
                }
            }

            if(j == command.length()){
                result[i].append("[");
                if(isReverse){
                    for(int k = end; k >= start; k--){
                        if(k == start) result[i].append(arr[k]);
                        else result[i].append(arr[k] + ",");
                    }
                } else{
                    for(int k = start; k <= end; k++){
                        if(k == end) result[i].append(arr[k]);
                        else result[i].append(arr[k] + ",");
                    }
                }
                result[i].append("]");
            }
        }

        for(int i = 0; i < testCase; i++)
            System.out.println(result[i]);
    }
}
